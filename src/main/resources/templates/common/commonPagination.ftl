	            <nav aria-label="Page navigation example">
				  <ul class="pagination justify-content-center">
				  		<li class="page-item ">
					      <a class="">Total elements: ${listBeanTable.totalElements}
					      &nbsp;
					      Page ${listBeanTable.page+1} of ${listBeanTable.totalPages}
					      </a>
					    </li>
					    <li class="page-item ">
					    </li>
					   
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