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
      <h1 class="page-header">${titlePrefix} User</h1>
          
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

		<form action="<@spring.url '/Manage_Users/InsertUpdateViewDelete' />" method="POST" enctype="multipart/form-data">

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
	             <label class="control-label"><@spring.message 'label.user.firstname' /></label>
	             <@spring.formInput "baseFE.firstName" 'class="form-control"' />
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	            </div>
	            <div class="col-xs-6 placeholder">
	             <label class="control-label"><@spring.message 'label.user.lastname'/></label>
	             <@spring.formInput "baseFE.lastName" 'class="form-control"' />
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	            </div>
         	</div>
	        <div class="row placeholders">
	            <div class="col-xs-6 placeholder">
	             <label class="control-label"><@spring.message 'label.user.email' /></label>
	             <@spring.formInput "baseFE.email" 'class="form-control"' />
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	            </div>
				<div class="col-xs-6 placeholder">
	             <label class="control-label"><@spring.message 'label.user.role' /></label>
				 <@spring.formSingleSelect "baseFE.roleUser.id", roles, 'class="form-control"'/>
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	            </div>
            </div>
			<div class="row placeholders">	            
	            <div class="col-xs-6 placeholder">
	             <label class="control-label"><@spring.message 'label.user.username' /></label>
	             <@spring.formInput "baseFE.username" 'class="form-control"' />
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	            </div>
	            <div class="col-xs-6 placeholder">
	             <label class="control-label"><@spring.message 'label.user.password' /></label>
	             <@spring.formInput "baseFE.password" 'class="form-control"' />
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	            </div>            
          	</div>
			<div class="row placeholders">
				<div class="col-xs-6 placeholder" id="locationField">
				 <label class="control-label">Search Address</label>
			     <input class="form-control" id="autocomplete" placeholder="Enter your address"
			             onFocus="geolocate()" type="text"></input>
			    </div>
			    
				<div class="col-xs-3 placeholder">
	             <label class="control-label"><@spring.message 'label.address.streetnumber' /></label>
	             <@spring.formInput "baseFE.street_number" 'class="form-control" readonly="readonly"' />			
	             
	             <label class="control-label"><@spring.message 'label.address.city' /></label>
	             <@spring.formInput "baseFE.locality" 'class="form-control" readonly="readonly"' />	
	             	             		     		     
	             <label class="control-label"><@spring.message 'label.address.state' /></label>
	             <@spring.formInput "baseFE.administrative_area_level_1" 'class="form-control" readonly="readonly"' />			
				</div>			    
				
				<div class="col-xs-3 placeholder">	
	             <label class="control-label"><@spring.message 'label.address.street' /></label>
	             <@spring.formInput "baseFE.route" 'class="form-control" readonly="readonly"' />		
	             						     
	             <label class="control-label"><@spring.message 'label.address.zipcode' /></label>
	             <@spring.formInput "baseFE.postal_code" 'class="form-control" readonly="readonly"' />	
				     				   
	             <label class="control-label"><@spring.message 'label.address.country' /></label>
	             <@spring.formInput "baseFE.country" 'class="form-control" readonly="readonly"' />				
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
     			<a href="<@spring.url '/Manage_Users/Search' />" class="btn btn-info" role="button">Back</a>
     		</#if>
     	  </div>
    	</form>
    </div>
    
    <#-- include all js required here -->
    <#include "/common/js/maps.ftl" >
    
</@layout.standardPage>    