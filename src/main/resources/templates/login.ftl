<#include "/common/standardPage.ftl" />

<@standardPage title="Home">
  
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

      <div class="jumbotron">
        <h2>Jumbotron heading</h2>
        <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>

		<div class="row">
	        <div class="col-xs-6">
			<@security.authorize access="isAuthenticated()==false">	
		        <div class="container">
	   			<form class="form-signin" action="<@spring.url '/login' />" method='POST'>
				  <#-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> -->		 	   
	   			    <#--
	   			    <div class="headerCollasabile">
	   			    	<a class="btn btn-lg btn-success" role="button">Accedi</a>
				    </div>
				    -->
				    
				    <div class="content">
					     <h2 class="form-signin-heading">Please sign in</h2>

					    <#if RequestParameters.error??>
	                        <div class="alert alert-danger">
	                            Invalid username and password.
	                        </div>
	                    </#if>
	                    <#if RequestParameters.logout??>
	                        <div class="alert alert-info">
	                            You have been logged out.
	                        </div>
	                    </#if>
					     
					     <label for="inputEmail" class="sr-only">Email address</label>
					     <input name='username' type="username" id="username" class="form-control" placeholder="Email address" required autofocus>
					     <label for="inputPassword" class="sr-only">Password</label>
					     <input name='password' type="password" id="password" class="form-control" placeholder="Password" required >
					     <div class="checkbox">
					       <label>
					         <input name="remember-me" type="checkbox" value="remember-me"> Remember me
					       </label>
					     </div>
					     <button class="btn btn-lg btn-primary btn-block" name="submit" type="submit" value="Sign In">Sign in</button>
				     </div>			     
				   </form>			
				 </div> <!-- /container -->
	        </@security.authorize>
	        </div> <!-- /col-xs-6 -->
      	</div> <#-- /row -->        
      </div> <#-- /jumbotron -->
         

      <div class="row marketing">
        <div class="col-lg-6">
          <h4>Subheading</h4>
          <p>Donec id elit non mi porta gravida at eget metus. Maecenas faucibus mollis interdum.</p>

          <h4>Subheading</h4>
          <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>

          <h4>Subheading</h4>
          <p>Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
        </div>

        <div class="col-lg-6">
          <h4>Subheading</h4>
          <p>Donec id elit non mi porta gravida at eget metus. Maecenas faucibus mollis interdum.</p>

          <h4>Subheading</h4>
          <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>

          <h4>Subheading</h4>
          <p>Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
        </div>
      </div>

    </div> <#-- /col-sm-9 -->
    
</@standardPage>    