<#--------------------------------------------------- -->
<#--------------------------------------------------- -->
<#-- FREAGMENT FOR ONLY THE PAGINATION AROUND A TABLE -->
<#macro standardPagination urlAction="">

<#assign url = springMacroRequestContext.getContextPath()+urlAction >

<nav aria-label="Page navigation example">

	<div class="page-item ">
      <a class="">Total elements: ${listBeanTable.totalElements}
      &nbsp;
      Page ${listBeanTable.page+1} of ${listBeanTable.totalPages}
      </a>
    </div>
	
	<ul class="pagination">
	<#if (listBeanTable.totalPages > 10) >
	  	<#if listBeanTable.pagesLinkable?first == 1 > 
			<li class="page-item disabled">
		      <a class="page-link">First</a>
	 	   </li>
			<li class="page-item disabled">
		      <a class="page-link">Prev</a>
	 	   </li>					    
		<#else>
			<li class="page-item ">
		       <a class="page-link" href="${url}/0">First</a>
		    </li>
			<li class="page-item ">
		      <a class="page-link" href="${url}/${listBeanTable.pagesLinkable?first-2}">Prev</a>
		    </li>	
		</#if>
	</#if>

	<#if (listBeanTable.totalPages > 1) >
		<#list listBeanTable.pagesLinkable as loop>
			<li class="page-item
			<#if listBeanTable.page+1==loop >
				active
			</#if> ">
			<a class="page-link" href="${url}/${loop-1}">${loop}</a></li>						
 		</#list>
 	</#if>


	<#if (listBeanTable.totalPages > 10) >
  		<#if listBeanTable.pagesLinkable?last == listBeanTable.totalPages > 
			<li class="page-item disabled">
		      <a class="page-link">Next</a>
		    </li>
			<li class="page-item disabled">
		     <a class="page-link">Last</a>
	 	   </li>					    
		<#else>
			<li class="page-item ">
	   	   <a class="page-link"  href="${url}/${listBeanTable.pagesLinkable?last}">Next</a>
	   	 </li>
			<li class="page-item ">
	    	 <a class="page-link"  href="${url}/${listBeanTable.totalPages-1}">Last</a>
		    </li>
		</#if>
	</#if>							    		    
  </ul>
</nav>

</#macro>