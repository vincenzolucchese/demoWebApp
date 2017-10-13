package com.vince.boot.demo.webapp.fe.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.vince.boot.demo.webapp.be.service.CommonDtoRepository;
import com.vince.boot.demo.webapp.be.utility.ArraysUtils;
import com.vince.boot.demo.webapp.beAndFe.dto.BaseDto;
import com.vince.boot.demo.webapp.beAndFe.dto.BlobStoreDto;
import com.vince.boot.demo.webapp.beAndFe.dto.ClientAppDto;
import com.vince.boot.demo.webapp.beAndFe.dto.RoleUserDto;

public abstract class BaseController {
	
	/** The logger. */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	public static final String PREFIX_CLIENTS = "Manage_Clients/";
	public static final String PREFIX_ORDERS = "Manage_Orders/";
	public static final String PREFIX_USERS = "Manage_Users/";
	
	public static final String SUFFIX_SEARCH = "Search";
	public static final String SUFFIX_CRUD = "InsertUpdateViewDelete";
	
	@Autowired
	GeoApiContext context;
	
	@Autowired
	protected CommonDtoRepository commonDtoRepository;
	
	protected String getCurrentUsername(){
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
	protected Authentication getCurrentAuth(){
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
    protected Map<String, String> getAllRoles() {
		Collection<RoleUserDto> rolesByDB = commonDtoRepository.findAllDto(new RoleUserDto());
		
		Map<String,String> rolesMap = new LinkedHashMap<String,String>();
		rolesMap.put("", "");
		for (RoleUserDto each : rolesByDB) {
			rolesMap.put(""+each.getId(), each.getRoleDescription());			
		}
		
		return rolesMap;
    }
    
    protected Map<String, String> getAllClients() {
    	Collection<ClientAppDto> clientsByDB = commonDtoRepository.findAllDto(new ClientAppDto());

    	Map<String,String> clientsMap = new LinkedHashMap<String,String>();
    	clientsMap.put("", "");
    	for (ClientAppDto each : clientsByDB) {
    		clientsMap.put(""+each.getId(), each.getName());			
    	}

    	GeocodingResult[] results;
		try {
			results = GeocodingApi.geocode(context,
					"via chimenti 127,alcamo").await();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			System.out.println(gson.toJson(results[0].addressComponents)); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

    	return clientsMap;
    }
    
    protected void addEmptyBlob(BaseDto baseFE) {
    	boolean canAdd = true;
    	for (BlobStoreDto each : baseFE.getListBlobs()) {
			if(each.getId()==null) {
				canAdd = false;
				break;
			}
		}
    	if(canAdd) {
    		baseFE.getListBlobs().add(0, new BlobStoreDto());    		
    	}
    }
        
    
    /********************************************
     * MANAGE FILE
     ********************************************/
    
    public abstract String getRequest(ModelMap model, BaseDto baseFE, Map<String, String> mappa);
    
	public String deleteDocument(@ModelAttribute("baseFE") BaseDto baseFE, BindingResult result, ModelMap model, 
			@RequestParam("Delete") String valueDelete) throws IOException{

		Long id = new Long(valueDelete.substring(valueDelete.lastIndexOf("_")+1, valueDelete.length()));
		BlobStoreDto temp = new BlobStoreDto(id);
		commonDtoRepository.deleteDto(temp);	
		
		baseFE.setListBlobs(ArraysUtils.removeObject(baseFE.getListBlobs(), temp));
		return getRequest(model, baseFE, new HashMap<String, String>());
	}

	public String downloadDocument(@ModelAttribute("baseFE") BaseDto baseFE, BindingResult result, ModelMap model, 
			@RequestParam("Download") String valueDownload, HttpServletResponse response) throws IOException{

		Long id = new Long(valueDownload.substring(valueDownload.lastIndexOf("_")+1, valueDownload.length()));
		BlobStoreDto document = commonDtoRepository.findOneBlobStoreDto(id);
		response.setContentType("application/pdf");
        response.setContentLength(document.getBlobData().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + document.getFilename() +"\"");
 
        FileCopyUtils.copy(document.getBlobData(), response.getOutputStream()); 
 		return null;
	}

	public String uploadDocument(@ModelAttribute("baseFE") BaseDto baseFE, BindingResult result, 
			ModelMap model, HttpServletRequest request) throws IOException{
	
//		int posix = baseFE.getListBlobs().size()-1;
		int posix = 0;
		MultipartFile multipartFile = baseFE.getListBlobs().get(posix).getMultipartFile();

		if(multipartFile.isEmpty()) {
			result.rejectValue("listBlobs["+posix+"].file", "required", null, "required");
		}else{
			System.out.println(multipartFile.getSize());
			if(multipartFile.getSize()>10485760){
				result.rejectValue("listBlobs["+posix+"].file", "required", null, "required");
			}
		}
		
		if(result.hasErrors()){
			model.addAttribute("allErrors", result.getAllErrors());
			model.addAttribute("baseFE", baseFE);
			model.addAttribute("clients", getAllClients());
			return "";
		} else {

 			System.out.println("Fetching file");
			getCurrentAuth().getName();

		}
		BlobStoreDto blob = commonDtoRepository.saveBlobStoreDto(baseFE.getListBlobs().get(posix), getCurrentUsername());
		baseFE.getListBlobs().add(blob);
		return getRequest(model, baseFE, new HashMap<String, String>());
	}

}
