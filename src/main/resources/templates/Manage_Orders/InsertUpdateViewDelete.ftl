<#import "/common/standardPage.ftl" as layout>
<#import "/spring.ftl" as spring />

<@layout.standardPage title="Home">

<@spring.bind "baseFE" />

<#assign titlePrefix="Read">
<#if baseFE.state== "D">
	<#assign titlePrefix="Delete">
<#elseif baseFE.state== "C">
	<#assign titlePrefix="Insert">
<#elseif baseFE.state== "U">
	<#assign titlePrefix="Update">		
</#if>
  
   <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <h1 class="page-header">${titlePrefix} Order</h1>
          
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
          	<div class="row placeholders">          
	            <div class="col-xs-6 placeholder">
	             <label class="control-label"><@spring.message 'label.order.codeOrder' /></label>
	             <@spring.formInput "baseFE.codeOrder" 'class="form-control"' />
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	            </div>
	            <div class="col-xs-6 placeholder" id="sandbox-container">
	             <label class="control-label"><@spring.message 'label.order.dataScadenza'/></label>
	             <@spring.formInput "baseFE.dataScadenza" 'class="form-control"' />
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	            </div>
         	</div>
			<div class="row placeholders">	            
				<div class="col-xs-6 placeholder">
	             <label class="control-label"><@spring.message 'label.order.client' /></label>
				 <@spring.formSingleSelect "baseFE.clientApp.id", clients, 'class="form-control"'/>
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	            </div>
	            <div class="col-xs-6 placeholder">
	             <label class="control-label">Pre Amount</label>
	             <@spring.formInput "baseFE.preAmount" 'class="form-control"' 'number' />
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	            </div>	            
          	</div>
			<div class="row placeholders">	            
				<div class="col-xs-6 placeholder">
	             <label class="control-label">Final Amount</label>
				 <@spring.formInput "baseFE.finalAmount", 'class="form-control"' 'number'/>
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	            </div>
	            <div class="col-xs-6 placeholder">
	             <label class="control-label">Is Active</label>
	             <@spring.formCheckbox "baseFE.flagActive" 'class="form-control"' />
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	            </div>	            
          	</div>   
			<div class="row placeholders">	            
				<div class="col-xs-6 placeholder">
	             <label class="control-label">Year</label>
				 <@spring.formInput "baseFE.yearRefer", 'class="form-control"' 'date'/>
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	            </div>
         	</div>   
			<div class="row placeholders">	            
				
				<div class="col-xs-6 placeholder" id="locationField">
				 <label class="control-label">Address</label>
			     <input class="form-control" id="autocomplete" placeholder="Enter your address"
			             onFocus="geolocate()" type="text"></input>
			    </div>
			    
				<div class="col-xs-3 placeholder">
				 <label class="control-label">Civico</label>
			     <input class="form-control" id="street_number" disabled="true"></input>
			     
			     <label class="control-label">City</label>
			     <input class="form-control" id="locality" disabled="true"></input>
			     
			     <label class="control-label">State</label>
			     <input class="form-control" id="administrative_area_level_1" disabled="true"></input>
			     
			     <label class="control-label">???</label>
			     <input class="form-control" id="administrative_area_level_2" disabled="true"></input>			     
				 </div>			    
				
				<div class="col-xs-3 placeholder">  
			     
			     <label class="control-label">Street</label>
			     <input class="form-control" id="route" disabled="true"></input>	
			     				   
			     <label class="control-label">Zip code</label>
			     <input class="form-control" id="postal_code" disabled="true"></input>		
			     
			     <label class="control-label">County</label>
			     <input class="form-control" id="country" disabled="true"></input>
			     
			     <label class="control-label">???</label>
			     <input class="form-control" id=administrative_area3 disabled="true"></input>			     
        
				 </div>
	           	            
          	</div>           	         	       	
			<div class="row placeholders">	  
			 	<div class="col-xs-12 placeholder">
	             <label class="control-label"><@spring.message 'label.client.notes' /></label>
	             <@spring.formTextarea "baseFE.notes" 'class="form-control"' />
	             <@spring.showErrors "</br>", "form-control alert-danger" />
             	</div>           
          	</div>  
          	        	
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
     			<a href="<@spring.url '/Manage_Orders/Search' />" class="btn btn-info" role="button">Back</a>
     		</#if>
     	  </div>
    	</form>

    </div>
    
</@layout.standardPage>    