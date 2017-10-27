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

import com.vince.boot.demo.webapp.be.utility.AppStringUtils;
import com.vince.boot.demo.webapp.be.utility.NumberUtils;
import com.vince.boot.demo.webapp.beAndFe.dto.BaseDto;
import com.vince.boot.demo.webapp.beAndFe.dto.MyPagedListHolder;
import com.vince.boot.demo.webapp.beAndFe.dto.OrderJobDto;
import com.vince.boot.demo.webapp.beAndFe.dto.UserAppDto;



@Controller
public class OrdersController extends BaseController {	
	
	@RequestMapping(value= PREFIX_ORDERS + SUFFIX_CRUD, method=RequestMethod.POST, params="Delete")
	public String deletedDocumentOrder(@ModelAttribute("baseFE") OrderJobDto baseFE, BindingResult result, ModelMap model, 
			@RequestParam("Delete") String valueDelete) throws IOException{
		return super.deleteDocument(baseFE, result, model, valueDelete);
	}

	@RequestMapping(value=PREFIX_ORDERS + SUFFIX_CRUD, method=RequestMethod.POST, params="Download")
	public String downloaddDocumentOrder(@ModelAttribute("baseFE") OrderJobDto baseFE, BindingResult result, ModelMap model, 
			@RequestParam("Download") String valueDownload, HttpServletResponse response) throws IOException{
		return super.downloadDocument(baseFE, result, model, valueDownload, response);
	}

	@RequestMapping(value=PREFIX_ORDERS + SUFFIX_CRUD, method=RequestMethod.POST, params="Upload")
	public String uploadDocumentOrder(@ModelAttribute("baseFE") OrderJobDto baseFE, BindingResult result, 
			ModelMap model, HttpServletRequest request) throws IOException{
		return super.uploadDocument(baseFE, result, model, request);
	}
	
	@RequestMapping(value = {PREFIX_ORDERS+SUFFIX_SEARCH, PREFIX_ORDERS+SUFFIX_SEARCH + "/{" + SUFFIX_PARAMS_SEARCH + "}" }, method = {RequestMethod.GET, RequestMethod.POST})
	public String effettuaRicercaAvanzata(
			@PathVariable Map<String, String> pathVariablesMap, 
			final @RequestParam(required = false) String page,
			@RequestParam(required = false) String sort,
			@RequestParam(required = false) String dir,
			@RequestParam(required = false, name = "ricercaAvanzata", defaultValue = "false") Boolean ricercaAvanzataFlag,
			ModelMap model,
			@ModelAttribute("searchForm") OrderJobDto searchBean,
			Principal principal,
			HttpServletRequest request) {

		String sortLocale = sort;
		String dirLocale = dir;
		
		MyPagedListHolder<OrderJobDto> listBeanTable = null;		
		String msg = pathVariablesMap.get(SUFFIX_PARAMS_SEARCH);
		
		if("msgOK".equals(msg)) {
			model.addAttribute("msgOK", msg);
			msg = "0";
		}
		
		if(StringUtils.isEmpty(msg)){
			msg = "0";
		}else{
			/* manage session */
			OrderJobDto searchBeanSession = (OrderJobDto) request.getSession().getAttribute(searchBean.getClass().toString());
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
		
		return PREFIX_ORDERS+SUFFIX_SEARCH;
	}
	

	@GetMapping(value = {PREFIX_ORDERS+SUFFIX_CRUD, PREFIX_ORDERS+SUFFIX_CRUD + "/{ids}/{type}"})
	public String getRequest(ModelMap model, BaseDto baseFE, BindingResult result, @PathVariable Map<String, String> pathVariablesMap) {
		String state = baseFE.getState();
		Long id = null;
		
		String type = pathVariablesMap.get("type");
		String ids = pathVariablesMap.get("ids");
		
		if(!StringUtils.isEmpty(ids)){
			id = new Long(ids);
			baseFE = commonDtoRepository.findOneOrderJobDto(id);
		}else {
			
		}
		
		if(state==null){
			if(!StringUtils.isEmpty(type) ){
				state = type;
			}else {
				baseFE = new OrderJobDto();
				state = "C";
			}
		}
		baseFE.setState(state);			
		
		if("C".equals(baseFE.getState()) || "U".equals(baseFE.getState())) {
			addEmptyBlob(baseFE);
		}
		
		model.addAttribute("baseFE", baseFE);
		model.addAttribute("clients", getAllClients());
				
		return PREFIX_ORDERS+SUFFIX_CRUD;
	}
	

	@PostMapping(PREFIX_ORDERS+SUFFIX_CRUD)
	public String postRequest(ModelMap model, @Valid @ModelAttribute("baseFE") OrderJobDto baseFE, BindingResult result,
			HttpServletRequest request) throws IOException {
		
		String action = request.getParameter("submit");
		
		if(action!=null && "backToList".equals(action)) {
			return "redirect: Search/";
		}
		
		if("D".equals(baseFE.getState())) {
			commonDtoRepository.deleteDto(new OrderJobDto(baseFE.getId()));
		}else {
			validate(baseFE, result);
			if(result.hasErrors()){
				model.put("allErrors", result.getAllErrors());
				model.put("baseFE", baseFE);
				model.addAttribute("clients", getAllClients());
				return PREFIX_ORDERS+SUFFIX_CRUD;
			}
			commonDtoRepository.saveOrderJobDto(baseFE, getCurrentUsername(), baseFE.getListBlobs());
		}		
		return "redirect:Search/msgOK";
	}
	
	private void validate(OrderJobDto baseFE, BindingResult result) {
		
		/* codeOrder */
		if(StringUtils.isEmpty(baseFE.getCodeOrder())){
			result.rejectValue("codeOrder", "error.field.required",  new String[]{}, "error.field.required");
		}else{
			if(baseFE.getCodeOrder().length()>20){
				result.rejectValue("codeOrder", "error.field.max.size", new String[]{"20"}, "error.field.max.size");
			}
		}	
		/* clientApp.id */
		if(baseFE.getClientApp().getId()==null){
			result.rejectValue("clientApp.id", "error.field.required",  new String[]{}, "error.field.required");
		}
		
	}


	

}
