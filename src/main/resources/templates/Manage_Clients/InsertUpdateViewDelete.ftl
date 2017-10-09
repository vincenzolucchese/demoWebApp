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
      <h1 class="page-header">${titlePrefix} Client</h1>
          
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
    	   	
		<form action="<@spring.url '/Manage_Clients/InsertUpdateViewDelete' />" method="POST" enctype="multipart/form-data">

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
	             <label class="control-label"><@spring.message 'label.client.name' /></label>
	             <@spring.formInput "baseFE.name" 'class="form-control" required' />
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	            </div>
	            <div class="col-xs-6 placeholder">
	             <label class="control-label"><@spring.message 'label.client.piva'/></label>
	             <@spring.formInput "baseFE.piva" 'class="form-control" required' />
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	            </div>
         	</div>
	        <div class="row placeholders">
	            <div class="col-xs-6 placeholder">
	             <label class="control-label"><@spring.message 'label.client.address' /></label>
	             <@spring.formInput "baseFE.address" 'class="form-control" required' />
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	            </div>
	            <div class="col-xs-6 placeholder">
	             <label class="control-label"><@spring.message 'label.client.zipcode' /></label>
	             <@spring.formInput "baseFE.zipcode" 'class="form-control" required' />
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	            </div>
            </div>
			<div class="row placeholders">	            
	            <div class="col-xs-6 placeholder">
	             <label class="control-label"><@spring.message 'label.client.phone' /></label>
	             <@spring.formInput "baseFE.phone" 'class="form-control" required' />
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	            </div>
	            <div class="col-xs-6 placeholder">
	             <label class="control-label"><@spring.message 'label.client.email' /></label>
	             <@spring.formInput "baseFE.email" 'class="form-control" required' />
	             <@spring.showErrors "</br>", "form-control alert-danger" />
	            </div>            
          	</div>
			<div class="row placeholders">	  
			 	<div class="col-xs-12 placeholder">
	             <label class="control-label"><@spring.message 'label.client.notes' /></label>
	             <@spring.formTextarea "baseFE.notes" 'class="form-control" required' />
	             <@spring.showErrors "</br>", "form-control alert-danger" />
             	</div>           
          	</div>          	
      	</fieldset>
      	
      	<#if  baseFE.fileDocuments?? &&  baseFE.fileDocuments?has_content >
	  		<div class="table-responsive">
		        <table class="table table-striped">
		        <caption>Table documents</caption>
		          <thead>
		            <tr>
		              <th>File</th>
		              <th>Action</th>
		            </tr>
		          </thead>
		          <tbody>
		          	<#list baseFE.fileDocuments as child>
					    <tr>
		                   <#if child.id??>
		                   <@spring.formHiddenInput "baseFE.fileDocuments["+child?index+"].id"/>
		                   <@spring.formHiddenInput "baseFE.fileDocuments["+child?index+"].filename"/>
						    <td>${child.filename}</td>
			                <td>
			                  	<button class="btn btn-info btn-sm" name="Download" type="submit" value="Download_${child.id}">
							      <span class="glyphicon glyphicon-download"></span> Download
							    </button>
							    <#if baseFE.state== "C" || baseFE.state=="U">
				                   	<button class="btn btn-danger btn-sm" name="Delete" type="submit" value="Delete_${child.id}">
								      <span class="glyphicon glyphicon-remove-circle"></span> Delete
								    </button> 
							    </#if>
		                  	</td>
						   <#else>
						      <td><@spring.formInput "baseFE.fileDocuments["+child?index+"].file" 'class="form-control"' "file" /></td>
			                  <td>
		                      	<button class="btn btn-primary btn-sm" name="Upload" type="submit" value="Upload">
							      <span class="glyphicon glyphicon-upload"></span> Upload
							    </button>	
			                  </td>	
						   </#if>               
					    </tr>
				    </#list>
		          </tbody>
		        </table>
	        </div>
	    <#else> 
		    No Details Available
		</#if>
      	
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