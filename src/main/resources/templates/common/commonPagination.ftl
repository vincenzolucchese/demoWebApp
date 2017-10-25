<#--------------------------------------------------- -->
<#--------------------------------------------------- -->
<#-- FREAGMENT FOR ONLY THE PAGINATION AROUND A TABLE -->
<#macro standardPagination urlAction="">

<#assign url = springMacroRequestContext.getContextPath()+urlAction >

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
	   
  	<#if listBeanTable.pagesLinkable?first == 1 > 
		<li class="page-item ">
	      <a class="page-link" href="${url}/0">First</a>
	    </li>
		<li class="page-item ">
	      <a class="page-link" href="${url}/0">Prev</a>
	    </li>					    
	<#else>
		<li class="page-item ">
	       <a class="page-link" href="${url}/0">First</a>
	    </li>
		<li class="page-item ">
	      <a class="page-link" href="${url}/${listBeanTable.pagesLinkable?first-2}">Prev</a>
	    </li>	
	</#if>
	
	<#list listBeanTable.pagesLinkable as loop>
		<li class="page-item"><a class="page-link" href="${url}/${loop-1}">${loop}</a></li>						
 	</#list>

  	<#if listBeanTable.pagesLinkable?last == listBeanTable.totalPages > 
		<li class="page-item ">
	      <a class="page-link" href="${url}/${listBeanTable.pagesLinkable?last-1}">Next</a>
	    </li>
		<li class="page-item ">
	     <a class="page-link" href="${url}/${listBeanTable.totalPages-1}">Last</a>
	    </li>					    
	<#else>
		<li class="page-item ">
	      <a class="page-link"  href="${url}/${listBeanTable.pagesLinkable?last}">Next</a>
	    </li>
		<li class="page-item ">
	     <a class="page-link"  href="${url}/${listBeanTable.totalPages-1}">Last</a>
	    </li>
	</#if>							    		    
  </ul>
</nav>

</#macro>