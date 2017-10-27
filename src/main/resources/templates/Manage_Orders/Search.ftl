<#import "/common/standardPage.ftl" as layout>
<#import "/spring.ftl" as spring />
<#import "/common/commonPagination.ftl" as pagination>

<@layout.standardPage title="Home">

<@spring.bind "searchForm" />
  
   <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <h1 class="page-header">Search Order</h1>
          
      	<#if allErrors??>
            <div class="alert alert-danger">
                Check all errors showed.
            </div>
    	</#if>  
    	<#if msgOK??>
            <div class="alert alert-success">
               Operation success.
            </div>
    	</#if>  
    	
		<form action="<@spring.url '/Manage_Orders/Search' />" method="POST">
      	<div class="row placeholders"> 
      		<div class="col-xs-9 placeholder">       
			<label class="control-label"><@spring.message 'label.user.simplefilter' /></label>
			<div class="input-group">
			 <@spring.formInput "searchForm.filterSimpleSearch" 'class="form-control"' />
             <@spring.showErrors "</br>", "form-control alert-danger" />
			    <span class="input-group-btn">
			        <button class="btn btn-info" name="submit" type="submit" value="Search">Search</button>
			    </span>
			</div>            
         </div>
     	</div>    			
	   
	   <h2 class="sub-header">Table Order</h2>
	    <#if listBeanTable?? && listBeanTable.source?? && listBeanTable.source?has_content  >
	    <label>Table Order</label>
		      <div class="table-responsive">
	            <table class="table table-striped">
	              <thead>
	                <tr>
	                  <th>Order job</th>
	                  <th>Finish Date</th>
	                  <th>Client job</th>
	                  <th>Actions</th>
	                </tr>
	              </thead>
	              <tbody>
	              	<#list listBeanTable.source as child>
					    <tr>
					      <td>${(child.codeOrder??)?then(child.codeOrder, '')}</td>
		                  <td>${(child.dataScadenza??)?then(child.dataScadenza, '')}</td>
		                  <td>${(child.clientApp?? && child.clientApp.name??)?then(child.clientApp.name, '')}</td>
		                  <td>
		                  	<a class="glyphicon glyphicon-zoom-in" href="<@spring.url '/Manage_Orders/InsertUpdateViewDelete/'/>${child.id?string.computer}/R" title="Read"></a>
		                    <a class="glyphicon glyphicon-pencil" href="<@spring.url '/Manage_Orders/InsertUpdateViewDelete/'/>${child.id?string.computer}/U" title="Update"></a>
		                    <a class="glyphicon glyphicon-off" href="<@spring.url '/Manage_Orders/InsertUpdateViewDelete/'/>${child.id?string.computer}/D" title="Delete"></a>		                  
		                  </td>
					    </tr>
				    </#list>
	              </tbody>
	            </table>
				<#-- pagination -->	
				<@pagination.standardPagination urlAction="/Manage_Orders/Search" />
									           
	          </div>
		<#else> 
		    No Details Available
		</#if>

    </div>
    
</@layout.standardPage>    