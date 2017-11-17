<#import "/spring.ftl" as spring />
<#assign security=JspTaglibs["/META-INF/security.tld"] />


<#macro standardPage title="Order Manager App">
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
	  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	  <meta name="description" content="">
	  <meta name="author" content="">
	  <title>Order Manager App</title>
	  <!-- Bootstrap core CSS-->
	  <link rel="stylesheet" type="text/css" href="<@spring.url '/adminBoot/vendor/bootstrap/css/bootstrap.min.css'/>" />
	  <!-- Custom fonts for this template-->
	  <link rel="stylesheet" type="text/css" href="<@spring.url '/adminBoot/vendor/font-awesome/css/font-awesome.min.css'/>" />
	  <!-- Page level plugin CSS-->
	  <link rel="stylesheet" type="text/css" href="<@spring.url '/adminBoot/vendor/datatables/dataTables.bootstrap4.css'/>" />
	  <!-- Custom styles for this template-->
	  <link rel="stylesheet" type="text/css" href="<@spring.url '/adminBoot/css/sb-admin.css'/>" />
      <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
</head>

   <#-- <#include "headerVince.ftl"  parse=true>
   -->
   <#nested/>
   <#-- <#include "footerVince.ftl"  parse=true>
    -->     
</html>
</#macro>