package com.vince.boot.demo.webapp.fe.controller;

import java.io.IOException;
import java.security.Principal;
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

import com.vince.boot.demo.webapp.be.utility.NumberUtils;
import com.vince.boot.demo.webapp.beAndFe.dto.BaseDto;
import com.vince.boot.demo.webapp.beAndFe.dto.ClientAppDto;
import com.vince.boot.demo.webapp.beAndFe.dto.MyPagedListHolder;


@Controller
public class ClientsController extends BaseController {
	
	@RequestMapping(value= PREFIX_CLIENTS + SUFFIX_CRUD, method=RequestMethod.POST, params="Delete")
	public String deletedDocument(@ModelAttribute("baseFE") ClientAppDto baseFE, BindingResult result, ModelMap model, 
			@RequestParam("Delete") String valueDelete) throws IOException{
		return super.deleteDocument(baseFE, result, model, valueDelete);
	}

	@RequestMapping(value=PREFIX_CLIENTS + SUFFIX_CRUD, method=RequestMethod.POST, params="Download")
	public String downloaddDocument(@ModelAttribute("baseFE") ClientAppDto baseFE, BindingResult result, ModelMap model, 
			@RequestParam("Download") String valueDownload, HttpServletResponse response) throws IOException{
		return super.downloadDocument(baseFE, result, model, valueDownload, response);
	}

	@RequestMapping(value=PREFIX_CLIENTS + SUFFIX_CRUD, method=RequestMethod.POST, params="Upload")
	public String uploadDocument(@ModelAttribute("baseFE") ClientAppDto baseFE, BindingResult result, 
			ModelMap model, HttpServletRequest request) throws IOException{
		return super.uploadDocument(baseFE, result, model, request);
	}
	
	@RequestMapping(value = {PREFIX_CLIENTS+SUFFIX_SEARCH, PREFIX_CLIENTS+SUFFIX_SEARCH + "/{" + SUFFIX_PARAMS_SEARCH + "}"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String effettuaRicercaAvanzata(
			@PathVariable Map<String, String> pathVariablesMap, 
			final @RequestParam(required = false) String page,
			@RequestParam(required = false) String sort,
			@RequestParam(required = false) String dir,
			@RequestParam(required = false, name = "ricercaAvanzata", defaultValue = "false") Boolean ricercaAvanzataFlag,
			ModelMap model,
			@ModelAttribute("searchForm") ClientAppDto searchBean,
			Principal principal,
			HttpServletRequest request) {

		String sortLocale = sort;
		String dirLocale = dir;
		
		MyPagedListHolder<ClientAppDto> listBeanTable = null;		
		String msg = pathVariablesMap.get(SUFFIX_PARAMS_SEARCH);
		
		if("msgOK".equals(msg)) {
			model.addAttribute("msgOK", msg);
			msg = "0";
		}
		
		if(StringUtils.isEmpty(msg)){
			msg = "0";
		}else{
			/* manage session */
			ClientAppDto searchBeanSession = (ClientAppDto) request.getSession().getAttribute(searchBean.getClass().toString());
			if(searchBeanSession!=null) {
				searchBean = searchBeanSession;
				if(!NumberUtils.isLong(msg)){
					msg = searchBeanSession.getPageSearchSession();
				}				
			}		
		}
		
		listBeanTable = commonDtoRepository.findDtoPagedByCriteria(searchBean, Integer.parseInt(msg), PagedListHolder.DEFAULT_PAGE_SIZE, "timeInsert", false);
		model.addAttribute("listBeanTable",  listBeanTable);		
		model.addAttribute("searchForm", searchBean);
		
		logger.debug(searchBean.getClass().toString());
		searchBean.setPageSearchSession(msg);
		request.getSession().setAttribute(searchBean.getClass().toString(), searchBean);
		
		return PREFIX_CLIENTS+SUFFIX_SEARCH;
	}

	@GetMapping(value = {PREFIX_CLIENTS+SUFFIX_CRUD, PREFIX_CLIENTS+SUFFIX_CRUD + "/{ids}/{type}"})
	public String getRequest(ModelMap model, BaseDto baseFE, BindingResult result, @PathVariable Map<String, String> pathVariablesMap) {
		String state = baseFE.getState();
		Long id = null;
		
		String type = pathVariablesMap.get("type");
		String ids = pathVariablesMap.get("ids");
		
		if(!StringUtils.isEmpty(ids)){
			id = new Long(ids);
			baseFE = commonDtoRepository.findOneClientAppDto(id);
		}else {
//			baseFE = new ClientsFE();
		}
		
		if(state==null){
			if(!StringUtils.isEmpty(type) ){
				state = type;
			}else {
				baseFE = new ClientAppDto();
				state = "C";
			}
		}
		baseFE.setState(state);			
		
		if("C".equals(baseFE.getState()) || "U".equals(baseFE.getState())) {
			addEmptyBlob(baseFE);
		}
		
		model.addAttribute("baseFE", baseFE);
		model.addAttribute("roles", getAllRoles());
		return PREFIX_CLIENTS+SUFFIX_CRUD;
	}
	

	@PostMapping(PREFIX_CLIENTS+SUFFIX_CRUD)
	public String postRequest(ModelMap model, @Valid @ModelAttribute("baseFE") ClientAppDto baseFE, BindingResult result,
			HttpServletRequest request) throws IOException {
		
		String action = request.getParameter("submit");
		
		if(action!=null && "backToList".equals(action)) {
			return "redirect: Search/";
		}
		
		if("D".equals(baseFE.getState())) {
			commonDtoRepository.deleteDto(new ClientAppDto(baseFE.getId()));
		}else {
			if(result.hasErrors()){
				model.put("allErrors", result.getAllErrors());
				model.put("baseFE", baseFE);
				model.addAttribute("roles", getAllRoles());
				return PREFIX_CLIENTS+SUFFIX_CRUD;
			}
			commonDtoRepository.saveClientAppDto(baseFE, getCurrentUsername(), baseFE.getListBlobs());			
		}		
		return "redirect:Search/msgOK";
	}




}
