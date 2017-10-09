    <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project Vince</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="#">Home</a></li>
            
	        <@security.authorize access="hasRole('ROLE_ADMIN')">
	        	<li><a href="<@spring.url '/Manage_Users/' />" >Gestione Utenti</a></li>	   
			</@security.authorize>
	        <@security.authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')">
	        	<li><a href="<@spring.url '/Manage_Clients/' />" >Gestione Clienti</a></li>			   
			</@security.authorize>		
	        <@security.authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')">
	        	<li><a href="<@spring.url '/Manage_Orders/' />" >Gestione Ordini</a></li>			   
			</@security.authorize>					
           <@security.authorize access="hasRole('ROLE_ANONYMOUS')">
            	<li><a href="#about">About</a></li>
            	<li><a href="#contact">Contact</a></li>		   
	            <li class="dropdown">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
	              <ul class="dropdown-menu">
	                <li><a href="#">Action</a></li>
	                <li><a href="#">Another action</a></li>
	                <li><a href="#">Something else here</a></li>
	                <li role="separator" class="divider"></li>
	                <li class="dropdown-header">Nav header</li>
	                <li><a href="#">Separated link</a></li>
	                <li><a href="#">One more separated link</a></li>
	              </ul>
	            </li>            
			</@security.authorize>            
          </ul>
          
          
		<@security.authorize access="isAuthenticated()">
		   <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
              	Profilo Utente<span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">UTENTE: <@security.authentication property="principal.username" /></a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li role="separator" class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">
                	<form action="/logout" method="post">
		            	<input type="submit" value="Sign Out"/>
		        	</form>
                </a></li>
                <li><a href="#">One more separated link</a></li>
              </ul>
            </li> 
          </ul>
		</@security.authorize>  


		       

        </div>	<!--/navbar-collapse collapse-->	   
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
    <#--  -->
  <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li>
            <div class="panel-group" id="accordion">
            	<div class="panel panel-default">
		            <div class="panel-heading">
		                <h4 class="panel-title">
		                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseDash">Dashboard</a>
		                    <span class="glyphicon glyphicon-dashboard"></span>
		                </h4>
		            </div>
		            <div id="collapseDash" class="panel-collapse collapse">
		                <div class="panel-body">
		                    <p><a href="<@spring.url '/Dashboard/Overview/' />" >Overview</a></p>
		                </div>
		            </div>
		        </div>
            <@security.authorize access="hasRole('ROLE_ADMIN')">
		        <div class="panel panel-default">
		            <div class="panel-heading">
		                <h4 class="panel-title">
		                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseUtenti">		                    
		                    Gestione Utenti</a>
		                	<span class="glyphicon glyphicon-user"></span>
		                </h4>
		            </div>
		            <div id="collapseUtenti" class="panel-collapse collapse">
		                <div class="panel-body">
		                    <p>
		                    <a href="<@spring.url '/Manage_Users/InsertUpdateViewDelete/' />" >Inserimento Utente</a>
		                    <span class="glyphicon glyphicon-floppy-disk"></span></p>		                    
		                    <p><a href="<@spring.url '/Manage_Users/Search/' />" >Ricerca Utente</a>
		                    <span class="glyphicon glyphicon-search"></span></p>
		                </div>
		            </div>
		        </div>
				</@security.authorize>
		        <@security.authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')">		        
		        <div class="panel panel-default">
		            <div class="panel-heading">
		                <h4 class="panel-title">
		                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOrdini">Gestione Ordini</a>		                    
		                     <span class="glyphicon glyphicon-shopping-cart"></span>
		                </h4>
		            </div>
		            <div id="collapseOrdini" class="panel-collapse collapse">
		                <div class="panel-body">
		                    <p><a href="<@spring.url '/Manage_Orders/InsertUpdateViewDelete/' />" >Inserimento Ordini</a>
		                    <span class="glyphicon glyphicon-floppy-disk"></span></p>
		                    <p><a href="<@spring.url '/Manage_Orders/Search/' />" >Ricerca Ordini </a>
		                    <span class="glyphicon glyphicon-search"></p>
		                </div>
		            </div>
		        </div>
		        </@security.authorize>		
	        	<@security.authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')">            
		        <div class="panel panel-default">
		            <div class="panel-heading">
		                <h4 class="panel-title">
		                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseClienti">Gestione Clienti</a>		                    
		                    <span class="glyphicon glyphicon-tree-deciduous"></span>
		                </h4>
		            </div>
		            <div id="collapseClienti" class="panel-collapse collapse">
		                <div class="panel-body">
		                    <p><a href="<@spring.url '/Manage_Clients/InsertUpdateViewDelete/' />" >Inserimento Clienti</a>
		                    <span class="glyphicon glyphicon-floppy-disk"></span></p>
		                    <p><a href="<@spring.url '/Manage_Clients/Search/' />" >Ricerca Clienti </a>
		                    <span class="glyphicon glyphicon-search"></p>
		                </div>
		            </div>
		        </div>
		        </@security.authorize>
	       </div>
            
            </li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">About</a></li>
            <li><a href="">Contact</a></li>
          </ul>
        </div>
       </div> <#-- row -->       
      </div> <#-- container-fluid -->
        

          