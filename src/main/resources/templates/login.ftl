<#include "/common/standardPage.ftl" />
<@standardPage title="Home">
<body class="bg-dark">
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Order Manager App - Login</div>
      <div class="card-body">
        <form class="form-signin" action="<@spring.url '/login' />" method='POST'>
          <div class="form-group">
            <label for="username">Email address</label>
            <input class="form-control" name='username' type="username" id="username" aria-describedby="emailHelp" placeholder="Enter email" required autofocus>
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input class="form-control" id="exampleInputPassword1" name='password' type="password" id="password" placeholder="Password" required>
          </div>
          <div class="form-group">
            <div class="form-check">
              <label class="form-check-label">
                <input class="form-check-input" type="checkbox"> Remember Password</label>
            </div>
          </div>
          <button class="btn btn-primary btn-block" name="submit" type="submit" value="Sign In">Sign in</button>
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="register.html">Register an Account</a>
          <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
        </div>
      </div>
    </div>
  </div>
  
  <!-- Bootstrap core JavaScript-->
  <script src="../adminBoot/vendor/jquery/jquery.min.js"></script>
  <script src="../adminBoot/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="../adminBoot/vendor/jquery-easing/jquery.easing.min.js"></script>
</body>  
 
</@standardPage>  