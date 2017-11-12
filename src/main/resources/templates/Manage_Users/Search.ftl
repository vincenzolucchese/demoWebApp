<#import "/common/commonPagination.ftl" as pagination>
<#include "/common/commonBodyProtected.ftl" />
<@commonBodyProtected>

<@spring.bind "searchForm" />

      <h1>Search User</h1>
          
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
		
		<form action="<@spring.url '/Manage_Users/Search' />" method="POST">
      	<div class="row"> 
      	 <div class="col-xl-9">       
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
     	</br>
		
		<div class="row"> 
	      	<div class="col-xl-12">  
		    <h2 class="sub-header">Table Users</h2>
		    <#if listBeanTable?? && listBeanTable.source?? && listBeanTable.source?has_content  > 
			      <div class="table-responsive">
		            <table class="table table-striped">
		              <thead>
		                <tr>
		                  <th>Username</th>
		                  <th>Firstname</th>
		                  <th>LastName</th>
		                  <th>Role</th>
		                  <th>Actions</th>
		                </tr>
		              </thead>
		              <tbody>
		              	<#list listBeanTable.source as child>
						    <tr>
						      <td>${child.username}</td>
			                  <td>${child.firstName}</td>
			                  <td>${child.lastName}</td>
			                  <td>${child.roleUser.roleDescription}</td>
			                  <td>
			                  	<a class="fa fa-info-circle" href="<@spring.url '/Manage_Users/InsertUpdateViewDelete/'/>${child.id?string.computer}/R" title="Read"></a>
			                    <a class="fa fa-pencil-square" href="<@spring.url '/Manage_Users/InsertUpdateViewDelete/'/>${child.id?string.computer}/U" title="Update"></a>
			                    <a class="fa fa-trash" href="<@spring.url '/Manage_Users/InsertUpdateViewDelete/'/>${child.id?string.computer}/D" title="Delete"></a>		                  
			                  </td>
						    </tr>
					    </#list>
		              </tbody>
		            </table>
					<#-- pagination -->	
					<@pagination.standardPagination urlAction="/Manage_Users/Search" />
						           	           
		          </div>
			<#else> 
			    No Details Available
			</#if>	
			</div>
		</div>	
		</form>
    
</@commonBodyProtected>   