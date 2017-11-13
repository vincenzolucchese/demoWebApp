<#include "/common/commonBodyProtected.ftl" />
<@commonBodyProtected>

<@spring.bind "baseFE" />

<#assign titlePrefix="Read">
<#if baseFE.state== "D">
	<#assign titlePrefix="Delete">
<#elseif baseFE.state== "C">
	<#assign titlePrefix="Insert">
<#elseif baseFE.state== "U">
	<#assign titlePrefix="Update">		
</#if>
  
  <h1>${titlePrefix} Order</h1>
          
      	<#if allErrors??>
            <div class="alert alert-danger">
                Check all errors showed.
            </div>
    	</#if> 
    	<#if baseFE.state== "D">    	
		     <div class="alert alert-info">
	            Are you sure to delete this entity?.
	        </div>
		</#if> 	        

		 <form id="fileuploadForm" action="<@spring.url '/Manage_Orders/InsertUpdateViewDelete' />" method="POST" enctype="multipart/form-data">

		<@spring.formHiddenInput "baseFE.state"/>
		<#if baseFE.id??>
			<@spring.formHiddenInput "baseFE.id"/>		
		</#if>
		
		<#assign attributeDisabled="class='form-group'">
		<#if baseFE.state== "D" || baseFE.state=="R">
			<#assign attributeDisabled="disabled">		
		</#if>

		<fieldset ${attributeDisabled} >
          	<div class="row">          
	            <div class="col-xl-6">
	             <label class="control-label"><@spring.message 'label.order.codeOrder' /></label>
	             <@spring.formInput "baseFE.codeOrder" 'class="form-control"' />
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	            </div>
	            <div class="col-xs-6 placeholder" id="sandbox-container">
	             <label class="control-label"><@spring.message 'label.order.dataScadenza'/></label>
	             <#-- 
	             <@spring.formInput "baseFE.dataScadenza" 'class="form-control"' />
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	              -->
	            </div>
         	</div>
         	<p></p>
         	
			<div class="row">	            
				<div class="col-xl-6">
	             <label class="control-label"><@spring.message 'label.order.client' /></label>
				 <@spring.formSingleSelect "baseFE.clientApp.id", clients, 'class="form-control"'/>
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	            </div>
	            <div class="col-xl-6">
	             <label class="control-label">Pre Amount</label>
	             <@spring.formInput "baseFE.preAmount" 'class="form-control"' 'number' />
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	            </div>	            
          	</div>
          	<p></p>
          	
			<div class="row">	            
				<div class="col-xl-6">
	             <label class="control-label">Final Amount</label>
				 <@spring.formInput "baseFE.finalAmount", 'class="form-control"' 'number'/>
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	            </div>
	            <div class="col-xl-6">
	             <label class="control-label">Is Active</label>
	             <@spring.formCheckbox "baseFE.flagActive" 'class="form-control"' />
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	            </div>	            
          	</div>  
          	<p></p>
          	 
			<div class="row">	            
				<div class="col-xl-6">
	             <label class="control-label">Year</label>
	             <#-- 
				 <@spring.formInput "baseFE.yearRefer", 'class="form-control"' 'date'/>
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	              -->
	            </div>
         	</div>   
         	<p></p>
         	
			<div class="row">
				<div class="col-xl-6" id="locationField">
				 <label class="control-label">Search Address</label>
			     <input class="form-control" id="autocomplete" placeholder="Enter your address"
			             onFocus="geolocate()" type="text"></input>
			    </div>
			    
				<div class="col-xl-3">
	             <label class="control-label"><@spring.message 'label.address.streetnumber' /></label>
	             <@spring.formInput "baseFE.street_number" 'class="form-control" readonly="readonly"' />			
	             
	             <label class="control-label"><@spring.message 'label.address.city' /></label>
	             <@spring.formInput "baseFE.locality" 'class="form-control" readonly="readonly"' />	
	             	             		     		     
	             <label class="control-label"><@spring.message 'label.address.state' /></label>
	             <@spring.formInput "baseFE.administrative_area_level_1" 'class="form-control" readonly="readonly"' />			
				</div>			    
				
				<div class="col-xl-3">	
	             <label class="control-label"><@spring.message 'label.address.street' /></label>
	             <@spring.formInput "baseFE.route" 'class="form-control" readonly="readonly"' />		
	             						     
	             <label class="control-label"><@spring.message 'label.address.zipcode' /></label>
	             <@spring.formInput "baseFE.postal_code" 'class="form-control" readonly="readonly"' />	
				     				   
	             <label class="control-label"><@spring.message 'label.address.country' /></label>
	             <@spring.formInput "baseFE.country" 'class="form-control" readonly="readonly"' />				
			  </div> 
			 </div>
			 <p></p>
			        	         	       	
			<div class="row">	  
			 	<div class="col-xl-12">
	             <label class="control-label"><@spring.message 'label.client.notes' /></label>
	             <@spring.formTextarea "baseFE.notes" 'class="form-control"' />
	             <@spring.showErrors "</br>", "form-control alert-danger" />
             	</div>           
          	</div>   
          	<p></p>        	        	
      	</fieldset>
      	
		<#include "../common/commonTableAttachment.ftl"  parse=true>
      	
      	<hr style="border-top: 3px solid #0f23b1;">
          <div class="col-xs-3 pull-right">
          	<#if baseFE.state== "D" || baseFE.state=="C" || baseFE.state=="U">
				<button class="btn btn-default btn-primary" name="submit" type="submit" value="Insert">Save</button>	
			</#if>
			<#if baseFE.state!="C">	     		
     			<#-- <button class="btn btn-default btn-primary" name="submit" type="submit" value="backToList">Back</button>
     			-->
     			<a href="<@spring.url '/Manage_Orders/Search/backToList' />" class="btn btn-info" role="button">Back</a>
     		</#if>
     	  </div>
    	</form>

    <#-- include all js required here -->
    <#include "/common/js/maps.ftl" >    
    
</@commonBodyProtected>     