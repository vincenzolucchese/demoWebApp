package com.vince.boot.demo.webapp.fe.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vince.boot.demo.webapp.beAndFe.dto.BaseDto;
import com.vince.boot.demo.webapp.beAndFe.dto.UserAppDto;
import com.vince.boot.demo.webapp.fe.fto.BaseFto;
import com.vince.boot.demo.webapp.fe.fto.ClientAppFto;
import com.vince.boot.demo.webapp.fe.fto.UserAppFto;



@Controller
public class UsersController extends BaseController {
	
	@RequestMapping(value = {PREFIX_USERS+SUFFIX_SEARCH, PREFIX_USERS+SUFFIX_SEARCH + "/{msg}" }, method = {RequestMethod.GET, RequestMethod.POST})
	public String effettuaRicercaAvanzata(
			@PathVariable Map<String, String> pathVariablesMap, 
			final @RequestParam(required = false) String page,
			@RequestParam(required = false) String sort,
			@RequestParam(required = false) String dir,
			@RequestParam(required = false, name = "ricercaAvanzata", defaultValue = "false") Boolean ricercaAvanzataFlag,
			ModelMap model,
			@ModelAttribute("searchForm") UserAppFto searchBean,
			Principal principal,
			HttpServletRequest request) {

		String sortLocale = sort;
		String dirLocale = dir;
		
		PagedListHolder<BaseDto> listBeanTable = null;		
		String type = pathVariablesMap.get("type");
		String msg = pathVariablesMap.get("msg");
		
		if("msgOK".equals(msg)) {
			model.addAttribute("msgOK", msg);
		}
		
		listBeanTable = baseEntityToDtoRepository.findDtoPagedByCriteria(UserAppFto.createDtoFromFto(searchBean), 0, 10, "timeInsert", false);

		request.getSession().setAttribute("listBeanTable",  listBeanTable);
		
		return PREFIX_USERS+SUFFIX_SEARCH;
	}
	
//	@RequestMapping(value = {"PREFIX_USERS/SUFFIX_SEARCH/{type}","PREFIX_USERS/SUFFIX_SEARCH"}, method = RequestMethod.GET)
    public ModelAndView all(
            @PathVariable Map<String, String> pathVariablesMap, 
            HttpServletRequest req) {
        
        PagedListHolder<BaseDto> productList = null;
        
        String type = pathVariablesMap.get("type");
        
        if(null == type) {
            // First Request, Return first set of list
        	UserAppDto dto = new UserAppDto();
            List<BaseDto> phonesList = baseEntityToDtoRepository.findAllDto(dto);
            
            productList = new PagedListHolder<BaseDto>();
            productList.setSource(phonesList);
            
            req.getSession().setAttribute("phonesList",  productList);

            
        } else if("next".equals(type)) {
            // Return next set of list
            productList = (PagedListHolder<BaseDto>) req.getSession()
                                .getAttribute("phonesList");
            
            productList.nextPage();

            
        } else if("prev".equals(type)) {
            // Return previous set of list
            productList = (PagedListHolder<BaseDto>) req.getSession()
                                .getAttribute("phonesList");
            
            productList.previousPage();

            
        } else {
            // Return specific index set of list
            System.out.println("type:" + type);
            
            productList = (PagedListHolder<BaseDto>) req.getSession()
                                .getAttribute("phonesList");
            
            int pageNum = Integer.parseInt(type);
            
            productList.setPage(pageNum);
        }
                    
        ModelAndView mv = new ModelAndView(PREFIX_USERS+SUFFIX_SEARCH);
        
        return  mv;
    }

	
//	@GetMapping("/PREFIX_USERS/SUFFIX_SEARCH")
//	public String searchUtenteGetRequest(Model model, Pageable pageable) {
//		
//
//		return "PREFIX_USERS/SUFFIX_SEARCH";
//	}

	@GetMapping(value = {PREFIX_USERS+SUFFIX_CRUD, PREFIX_USERS+SUFFIX_CRUD + "/{ids}/{type}"})
	public String getRequest(ModelMap model, BaseFto baseFE, @PathVariable Map<String, String> pathVariablesMap) {
		String state = baseFE.getState();
		Long id = null;
		
		String type = pathVariablesMap.get("type");
		String ids = pathVariablesMap.get("ids");
		
		if(!StringUtils.isEmpty(ids)){
			id = new Long(ids);
			baseFE = UserAppFto.createFtoFromDto((UserAppDto) baseEntityToDtoRepository.findOneDto(new UserAppDto(id)));
		}else {
//			baseFE = new UsersFE();
		}
		
		if(state==null){
			if(!StringUtils.isEmpty(type) ){
				state = type;
			}else {
				baseFE = new UserAppFto();
				state = "C";
			}
		}
		baseFE.setState(state);			
		
		if("C".equals(baseFE.getState()) || "U".equals(baseFE.getState())) {
			addEmptyBlob((baseFE));
		}
		
		model.addAttribute("baseFE", baseFE);
		model.addAttribute("roles", getAllRoles());
		return PREFIX_USERS+SUFFIX_CRUD;
	}
	

	@PostMapping(PREFIX_USERS+SUFFIX_CRUD)
	public String postRequest(ModelMap model, @Valid @ModelAttribute("baseFE") UserAppFto baseFE, BindingResult result,
			HttpServletRequest request) {
		
		String action = request.getParameter("submit");
		
		if(action!=null && "backToList".equals(action)) {
			return "redirect: Search/";
		}
		
		if("D".equals(baseFE.getState())) {
			baseEntityToDtoRepository.deleteDto(new UserAppDto(baseFE.getId()));
		}else {
			if(result.hasErrors()){
				model.put("allErrors", result.getAllErrors());
				model.put("baseFE", baseFE);
				model.addAttribute("roles", getAllRoles());
				return PREFIX_USERS+SUFFIX_CRUD;
			}
			baseEntityToDtoRepository.saveDto(UserAppFto.createDtoFromFto(baseFE), getCurrentUsername());			
		}
		
		return "redirect:Search/msgOK";
	}

	
	@RequestMapping(value= PREFIX_USERS + SUFFIX_CRUD, method=RequestMethod.POST, params="Delete")
	public String deletedDocumentUser(@ModelAttribute("baseFE") UserAppFto baseFE, BindingResult result, ModelMap model, 
			@RequestParam("Delete") String valueDelete) throws IOException{
		return super.deleteDocument((baseFE), result, model, valueDelete);
	}

	@RequestMapping(value=PREFIX_USERS + SUFFIX_CRUD, method=RequestMethod.POST, params="Download")
	public String downloaddDocumentUser(@ModelAttribute("baseFE") UserAppFto baseFE, BindingResult result, ModelMap model, 
			@RequestParam("Download") String valueDownload, HttpServletResponse response) throws IOException{
		return super.downloadDocument(baseFE, result, model, valueDownload, response);
	}

	@RequestMapping(value=PREFIX_USERS + SUFFIX_CRUD, method=RequestMethod.POST, params="Upload")
	public String uploadDocumentUser(@ModelAttribute("baseFE") UserAppFto baseFE, BindingResult result, 
			ModelMap model, HttpServletRequest request) throws IOException{
		return super.uploadDocument((baseFE), result, model, request);
	}

}
