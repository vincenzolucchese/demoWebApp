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
import com.vince.boot.demo.webapp.be.utility.AppStringUtils;
import com.vince.boot.demo.webapp.beAndFe.dto.BaseDto;
import com.vince.boot.demo.webapp.beAndFe.dto.UserAppDto;


@Controller
public class UsersController extends BaseController {
	
	@RequestMapping(value= PREFIX_USERS + SUFFIX_CRUD, method=RequestMethod.POST, params="Delete")
	public String deletedDocumentUser(@ModelAttribute("baseFE") UserAppDto baseFE, BindingResult result, ModelMap model, 
			@RequestParam("Delete") String valueDelete) throws IOException{
		return super.deleteDocument(baseFE, result, model, valueDelete);
	}

	@RequestMapping(value=PREFIX_USERS + SUFFIX_CRUD, method=RequestMethod.POST, params="Download")
	public String downloaddDocumentUser(@ModelAttribute("baseFE") UserAppDto baseFE, BindingResult result, ModelMap model, 
			@RequestParam("Download") String valueDownload, HttpServletResponse response) throws IOException{
		return super.downloadDocument(baseFE, result, model, valueDownload, response);
	}

	@RequestMapping(value=PREFIX_USERS + SUFFIX_CRUD, method=RequestMethod.POST, params="Upload")
	public String uploadDocumentUser(@ModelAttribute("baseFE") UserAppDto baseFE, BindingResult result, 
			ModelMap model, HttpServletRequest request) throws IOException{
		return super.uploadDocument(baseFE, result, model, request);
	}
	
	@RequestMapping(value = {PREFIX_USERS+SUFFIX_SEARCH, PREFIX_USERS+SUFFIX_SEARCH + "/{" + SUFFIX_PARAMS_SEARCH + "}" }, 
			method = {RequestMethod.GET})
	public String getRicercaAvanzata(
			@PathVariable Map<String, String> pathVariablesMap, 
			final @RequestParam(required = false) String page,
			@RequestParam(required = false) String sort,
			@RequestParam(required = false) String dir,
			@RequestParam(required = false, name = "ricercaAvanzata", defaultValue = "false") Boolean ricercaAvanzataFlag,
			ModelMap model,
			@ModelAttribute("searchForm") UserAppDto searchBean,
			Principal principal,
			HttpServletRequest request) {

		String sortLocale = sort;
		String dirLocale = dir;
		
		PagedListHolder<UserAppDto> listBeanTable = null;		
		String msg = pathVariablesMap.get(SUFFIX_PARAMS_SEARCH);
		
		if("msgOK".equals(msg)) {
			model.addAttribute("msgOK", msg);
		}
		 
//        if(null == type) {
//            // First Request, Return first set of list
//            List<UserApp> phonesList = (List<UserApp>) usersRepository.findAll();
//            
//            productList = new PagedListHolder<UserApp>();
//            productList.setSource(phonesList);
//            
//            req.getSession().setAttribute("phonesList",  productList);
//
//            
//        } else if("next".equals(type)) {
//            // Return next set of list
//            productList = (PagedListHolder<UserApp>) req.getSession()
//                                .getAttribute("phonesList");
//            
//            productList.nextPage();
//
//            
//        } else if("prev".equals(type)) {
//            // Return previous set of list
//            productList = (PagedListHolder<UserApp>) req.getSession()
//                                .getAttribute("phonesList");
//            
//            productList.previousPage();
//
//            
//        } else {
//            // Return specific index set of list
//            System.out.println("type:" + type);
//            
//            productList = (PagedListHolder<UserApp>) req.getSession()
//                                .getAttribute("phonesList");
//            
//            int pageNum = Integer.parseInt(type);
//            
//            productList.setPage(pageNum);
//        }
		
		listBeanTable = commonDtoRepository.findDtoPagedByCriteria(searchBean, 0, 10, "timeInsert", false);
		
//		listBeanTable.setPage();

		request.getSession().setAttribute("listBeanTable",  listBeanTable);
		
		model.addAttribute("searchForm", searchBean);
		return PREFIX_USERS+SUFFIX_SEARCH;
	}

//	@RequestMapping(value = {"PREFIX_USERS/SUFFIX_SEARCH/{type}","PREFIX_USERS/SUFFIX_SEARCH"}, method = RequestMethod.GET)
//    public ModelAndView all(
//            @PathVariable Map<String, String> pathVariablesMap, 
//            HttpServletRequest req) {
//        
//        PagedListHolder<UserApp> productList = null;
//        
//        String type = pathVariablesMap.get("type");
//        
//        if(null == type) {
//            // First Request, Return first set of list
//            List<UserApp> phonesList = (List<UserApp>) usersRepository.findAll();
//            
//            productList = new PagedListHolder<UserApp>();
//            productList.setSource(phonesList);
//            
//            req.getSession().setAttribute("phonesList",  productList);
//
//            
//        } else if("next".equals(type)) {
//            // Return next set of list
//            productList = (PagedListHolder<UserApp>) req.getSession()
//                                .getAttribute("phonesList");
//            
//            productList.nextPage();
//
//            
//        } else if("prev".equals(type)) {
//            // Return previous set of list
//            productList = (PagedListHolder<UserApp>) req.getSession()
//                                .getAttribute("phonesList");
//            
//            productList.previousPage();
//
//            
//        } else {
//            // Return specific index set of list
//            System.out.println("type:" + type);
//            
//            productList = (PagedListHolder<UserApp>) req.getSession()
//                                .getAttribute("phonesList");
//            
//            int pageNum = Integer.parseInt(type);
//            
//            productList.setPage(pageNum);
//        }
//                    
//        ModelAndView mv = new ModelAndView(PREFIX_USERS+SUFFIX_SEARCH);
//        
//        return  mv;
//    }

	

	
	@RequestMapping(value = {PREFIX_USERS+SUFFIX_SEARCH }, 
			method = {RequestMethod.POST}, params={"Next"})
	public String postRicercaAvanzata(
			@PathVariable Map<String, String> pathVariablesMap, 
			final @RequestParam(required = false) String page,
			@RequestParam(required = false) String sort,
			@RequestParam(required = false) String dir,
			@RequestParam(required = false, name = "ricercaAvanzata", defaultValue = "false") Boolean ricercaAvanzataFlag,
			ModelMap model,
			@ModelAttribute("searchForm") UserAppDto searchBean,
			Principal principal,
			HttpServletRequest request) {
		request.getParameterNames();
		return getRicercaAvanzata(pathVariablesMap, page, sort, dir, ricercaAvanzataFlag, model, searchBean, principal, request);	
	}


	@GetMapping(value = {PREFIX_USERS+SUFFIX_CRUD, PREFIX_USERS+SUFFIX_CRUD + "/{ids}/{type}"})
	public String getRequest(ModelMap model, BaseDto baseFE, BindingResult result, @PathVariable Map<String, String> pathVariablesMap) {
		String state = baseFE.getState();
		Long id = null;
		
		String type = pathVariablesMap.get("type");
		String ids = pathVariablesMap.get("ids");
		
		if(!StringUtils.isEmpty(ids)){
			id = new Long(ids);
			baseFE = commonDtoRepository.findOneUserAppDto(id);
		}else {
//			baseFE = new UsersFE();
		}
		
		if(state==null){
			if(!StringUtils.isEmpty(type) ){
				state = type;
			}else {
				baseFE = new UserAppDto();
				state = "C";
			}
		}
		baseFE.setState(state);			
		
		if("C".equals(baseFE.getState()) || "U".equals(baseFE.getState())) {
			addEmptyBlob(baseFE);
		}
		
		model.addAttribute("baseFE", baseFE);
		model.addAttribute("roles", getAllRoles());
		return PREFIX_USERS+SUFFIX_CRUD;
	}
	

	@PostMapping(PREFIX_USERS+SUFFIX_CRUD)
	public String postRequest(ModelMap model, @Valid @ModelAttribute("baseFE") UserAppDto baseFE, BindingResult result,
			HttpServletRequest request) throws IOException {
		
		String action = request.getParameter("submit");
		
		if(action!=null && "backToList".equals(action)) {
			return "redirect: Search/";
		}
		
		if("D".equals(baseFE.getState())) {
			commonDtoRepository.deleteDto(new UserAppDto(baseFE.getId()));
		}else {
			validate(baseFE, result);
			if(result.hasErrors()){
				model.put("allErrors", result.getAllErrors());
				model.put("baseFE", baseFE);
				model.addAttribute("roles", getAllRoles());
				return PREFIX_USERS+SUFFIX_CRUD;
			}
			
			commonDtoRepository.saveUserAppDto(baseFE, getCurrentUsername(), baseFE.getListBlobs());			
		}		
		return "redirect:Search/msgOK";
	}

	
	private void validate(UserAppDto baseFE, BindingResult result) {
	
		/* firstName */
		if(StringUtils.isEmpty(baseFE.getFirstName())){
			result.rejectValue("firstName", "error.field.required",  new String[]{}, "error.field.required");
		}else{
			if(baseFE.getFirstName().length()>50){
				result.rejectValue("firstName", "error.field.max.size", new String[]{"50"}, "error.field.max.size");
			}
		}	
		/* lastName */
		if(StringUtils.isEmpty(baseFE.getLastName())){
			result.rejectValue("lastName", "error.field.required",  new String[]{}, "error.field.required");
		}else{
			if(baseFE.getLastName().length()>50){
				result.rejectValue("lastName", "error.field.max.size", new String[]{"50"}, "error.field.max.size");
			}
		}	
		/* username */
		if(StringUtils.isEmpty(baseFE.getUsername())){
			result.rejectValue("username", "error.field.required",  new String[]{}, "error.field.required");
		}else{
			if(baseFE.getUsername().length()>100){
				result.rejectValue("username", "error.field.max.size", new String[]{"100"}, "error.field.max.size");
			}else{
				UserAppDto temp = commonDtoRepository.findOneDto(new UserAppDto(baseFE.getUsername()));
				if(temp !=null && temp.equals(baseFE.getUsername())){
					result.rejectValue("username", "error.username.exists",  new String[]{baseFE.getUsername()}, "error.username.exists");
				}
			}
		}
		/* password */
		if(StringUtils.isEmpty(baseFE.getPassword())){
			result.rejectValue("password", "error.field.required",  new String[]{}, "error.field.required");
		}else{
			if(baseFE.getPassword().length()>20){
				result.rejectValue("password", "error.field.max.size", new String[]{"20"}, "error.field.max.size");
			}
		}
		/* email */
		if(StringUtils.isEmpty(baseFE.getEmail())){
			result.rejectValue("email", "error.field.required",  new String[]{}, "error.field.required");
		}else{
			if(baseFE.getEmail().length()>100){
				result.rejectValue("email", "error.field.max.size", new String[]{"100"}, "error.field.max.size");
			}else{
				if(!AppStringUtils.isValidSingleEmailAddress(baseFE.getEmail())){
					result.rejectValue("email", "error.valid.email", new String[]{baseFE.getEmail()}, "error.valid.email");
				}
			}
		}
		
		/* roleUser */
		if(baseFE.getRoleUser().getId()==null){
			result.rejectValue("roleUser", "error.field.required",  new String[]{}, "error.field.required");
		}		
		
	}



}
