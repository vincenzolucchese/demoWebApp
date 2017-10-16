<#import "/common/standardPage.ftl" as layout>
<#import "/spring.ftl" as spring />

<@layout.standardPage title="Home">

<@spring.bind "searchForm" />
  
   <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <h1 class="page-header">Search User</h1>
          
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
		
	    <h2 class="sub-header">Table Users</h2>
	    <#if "${listBeanTable}"??  > 
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
		                  	<a class="glyphicon glyphicon-zoom-in" href="<@spring.url '/Manage_Users/InsertUpdateViewDelete/'/>${child.id}/R" title="Read"></a>
		                    <a class="glyphicon glyphicon-pencil" href="<@spring.url '/Manage_Users/InsertUpdateViewDelete/'/>${child.id}/U" title="Update"></a>
		                    <a class="glyphicon glyphicon-off" href="<@spring.url '/Manage_Users/InsertUpdateViewDelete/'/>${child.id}/D" title="Delete"></a>		                  
		                  </td>
					    </tr>
				    </#list>
	              </tbody>
	            </table>
	            <nav aria-label="Page navigation example">
				  <ul class="pagination justify-content-center">
				  	
				  	<#if listBeanTable.firstPage > 
						<li class="page-item ">
					      <a class="page-link" href="#" tabindex="-1">Previous</a>
					    </li>
					<#else>
						<li class="page-item">
					      <a class="page-link" href="<@spring.url '/Manage_Users/Search/prev' />" tabindex="-1">Previous</a>
					    </li>
					</#if>
					<#list 1..listBeanTable.pageCount as loop>
						<#if loop?index == listBeanTable.page >
							<li class="page-item disabled"><a class="page-link" href="#">${loop?index+1}</a></li>
						<#else>
							<li class="page-item"><a class="page-link" href="<@spring.url '/Manage_Users/Search' />/${loop?index+1}">${loop?index+1}</a></li>
						</#if>
				 	</#list>

					<#if listBeanTable.lastPage>
					    <li class="page-item ">
					      <button class="btn" name="Next" type="submit" value="Next">Next</button>
					    </li>
					<#else>
						<li class="page-item ">
					      <a class="page-link" href="<@spring.url '/Manage_Users/Search/next' />">Next</a>
					    </li>						
					</#if>				    
				  </ul>
				</nav>
				           
	          </div>
		<#else> 
		    No Details Available
		</#if>
		
		</form>

    </div>
    
</@layout.standardPage>    