<#import "/common/standardPage.ftl" as layout>
<#import "/spring.ftl" as spring />

<@layout.standardPage title="Home">

<#-- <@spring.bind "utente" /> -->
  
   <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <h1 class="page-header">Search Client</h1>
          
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
		
	    <h2 class="sub-header">Table Client</h2>
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
					      <td>${child.name}</td>
		                  <td>${child.piva}</td>
		                  <td>${child.phone}</td>
		                  <td>${child.email}</td>
		                  <td>
		                  	<a class="glyphicon glyphicon-zoom-in" href="<@spring.url '/Manage_Clients/InsertUpdateViewDelete/'/>${child.id}/R" title="Read"></a>
		                    <a class="glyphicon glyphicon-pencil" href="<@spring.url '/Manage_Clients/InsertUpdateViewDelete/'/>${child.id}/U" title="Update"></a>
		                    <a class="glyphicon glyphicon-off" href="<@spring.url '/Manage_Clients/InsertUpdateViewDelete/'/>${child.id}/D" title="Delete"></a>		                  
		                  </td>
					    </tr>
				    </#list>
	              </tbody>
	            </table>
	            <nav aria-label="Page navigation example">
				  <ul class="pagination justify-content-center">
				  	
				  	<#if listBeanTable.firstPage > 
						<li class="page-item disabled">
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
					    <li class="page-item disabled">
					      <a class="page-link" href="#">Next</a>
					    </li>
					<#else>
						<li class="page-item disabled">
					      <a class="page-link" href="<@spring.url '/Manage_Users/Search/next' />">Next</a>
					    </li>						
					</#if>				    
				  </ul>
				</nav>
				           
	          </div>
		<#else> 
		    No Details Available
		</#if>

    </div>
    
</@layout.standardPage>    