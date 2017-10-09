<#import "/spring.ftl" as spring />
<#assign security=JspTaglibs["/META-INF/security.tld"] />


<#macro standardPage title="Vince">
<!DOCTYPE html>
<html lang="it">
<#-- NON FUNGE
<#setting locale="it_IT">
<#setting number_format="0.####">
<#setting date_format="dd/MM/yyyy">
 -->

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  
  	<title>Vince</title>

  	<link rel="stylesheet" type="text/css" href="<@spring.url '/bootstrap/css/bootstrap.min.css'/>" />
  	<link rel="stylesheet" type="text/css" href="<@spring.url '/css/style.css'/>" />
	<#-- Bootstrap Date-Picker Plugin -->
	<link rel="stylesheet" type="text/css" href="<@spring.url '/datepicker/css/bootstrap-datepicker3.css'/>" />	
  	
  
</head>
<body>
   <#include "header.ftl"  parse=true>
   <#nested/>
   <#include "footer.ftl"  parse=true>     
</body>
</html>
</#macro>