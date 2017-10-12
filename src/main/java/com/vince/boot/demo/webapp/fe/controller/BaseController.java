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
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.maps.GeoApiContext;
import com.vince.boot.demo.webapp.be.service.BaseEntityToDtoRepository;
import com.vince.boot.demo.webapp.beAndFe.dto.BaseDto;
import com.vince.boot.demo.webapp.beAndFe.dto.BlobStoreDto;
import com.vince.boot.demo.webapp.beAndFe.dto.ClientAppDto;
import com.vince.boot.demo.webapp.beAndFe.dto.RoleUserDto;
import com.vince.boot.demo.webapp.fe.fto.BaseFto;
import com.vince.boot.demo.webapp.fe.fto.BlobStoreFto;

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
	BaseEntityToDtoRepository baseEntityToDtoRepository;

	protected String getCurrentUsername(){
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
	protected Authentication getCurrentAuth(){
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
    protected Map<String, String> getAllRoles() {
		Collection<BaseDto> rolesByDB = baseEntityToDtoRepository.findAllDto(new RoleUserDto());
		
		Map<String,String> rolesMap = new LinkedHashMap<String,String>();
		rolesMap.put("", "");
		for (BaseDto each : rolesByDB) {
			RoleUserDto dto = (RoleUserDto) each;
			rolesMap.put(""+dto.getId(), dto.getRoleDescription());			
		}
		
		return rolesMap;
    }
    
    protected Map<String, String> getAllClients() {
    	Collection<BaseDto> clientsByDB = baseEntityToDtoRepository.findAllDto(new ClientAppDto());

    	Map<String,String> clientsMap = new LinkedHashMap<String,String>();
    	clientsMap.put("", "");
		for (BaseDto each : clientsByDB) {
			ClientAppDto dto = (ClientAppDto) each;
			clientsMap.put(""+dto.getId(), dto.getName());			
		}
    	return clientsMap;
    }
    
    protected void addEmptyBlob(BaseFto baseDto) {
    	boolean canAdd = true;
    	for (BlobStoreFto each : baseDto.getFileDocuments()) {
			if(each.getId()==null) {
				canAdd = false;
				break;
			}
		}
    	if(canAdd) {
    		baseDto.getFileDocuments().add(new BlobStoreFto());    		
    	}
    }
        
    
    /********************************************
     * MANAGE FILE
     ********************************************/
    
    public abstract String getRequest(ModelMap model, BaseFto baseFE, Map<String, String> mappa);
    
	public String deleteDocument(@ModelAttribute("baseFE") BaseFto baseFE, BindingResult result, ModelMap model, 
			@RequestParam("Delete") String valueDelete) throws IOException{

		Long id = new Long(valueDelete.substring(valueDelete.lastIndexOf("_")+1, valueDelete.length()));
		BlobStoreDto dto = new BlobStoreDto(id);
		dto = (BlobStoreDto) baseEntityToDtoRepository.findOneDto(dto);
		dto.setFlagActive('0');
		
		dto = (BlobStoreDto) baseEntityToDtoRepository.saveDto(dto, getCurrentUsername());		
		baseFE.getFileDocuments().remove(dto);
		return getRequest(model, baseFE, new HashMap<String, String>());
	}

	public String downloadDocument(@ModelAttribute("baseFE") BaseFto baseFE, BindingResult result, ModelMap model, 
			@RequestParam("Download") String valueDownload, HttpServletResponse response) throws IOException{

		Long id = new Long(valueDownload.substring(valueDownload.lastIndexOf("_")+1, valueDownload.length()));
		BlobStoreDto dto = new BlobStoreDto(id);
		dto = (BlobStoreDto) baseEntityToDtoRepository.findOneDto(dto);
		response.setContentType("application/pdf");
        response.setContentLength(dto.getBlobData().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + dto.getFilename() +"\"");
 
        FileCopyUtils.copy(dto.getBlobData(), response.getOutputStream()); 
 		return null;
	}

	public String uploadDocument(@ModelAttribute("baseFE") BaseFto baseFE, BindingResult result, 
			ModelMap model, HttpServletRequest request) throws IOException{
	
		int posix = baseFE.getFileDocuments().size()-1;
		MultipartFile multipartFile = baseFE.getFileDocuments().get(posix).getFile();

		if(multipartFile.isEmpty()) {
			result.rejectValue("fileDocuments["+posix+"].file", "required", null, "required");
		}else{
			System.out.println(multipartFile.getSize());
			if(multipartFile.getSize()>10485760){
				result.rejectValue("fileDocuments["+posix+"].file", "required", null, "required");
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

		baseEntityToDtoRepository.saveDocument(BaseFto.createDtoFromFto(baseFE), getCurrentUsername());
		return getRequest(model, baseFE, new HashMap<String, String>());
	}

}
