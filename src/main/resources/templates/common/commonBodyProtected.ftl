<#include "standardPage.ftl" />

<#macro commonBodyProtected>

<@standardPage title="Home">
  
 <body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="<@spring.url '/homeProtected/' />">Order Manager App</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link" href="<@spring.url '/homeProtected/' />">
            <i class="fa fa-fw fa-dashboard"></i>
            <span class="nav-link-text">Dashboard</span>
          </a>
        </li>
        
        
        <@security.authorize access="hasRole('ROLE_ADMIN')">
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Users">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseUsers" data-parent="#exampleAccordion">
            <i class="fa fa-user-o"></i>
            <span class="nav-link-text">Users</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseUsers">
            <li>
              <a href="<@spring.url '/Manage_Users/InsertUpdateViewDelete/' />" >Insert User</a>
            </li>
            <li>
              <a href="<@spring.url '/Manage_Users/Search/' />" >Search</a>
            </li>
          </ul>
        </li>  
        </@security.authorize>

		<@security.authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Clients">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseClients" data-parent="#exampleAccordion">
            <i class="fa fa-id-card-o"></i>
            <span class="nav-link-text">Clients</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseClients">
            <li>
              <a href="<@spring.url '/Manage_Clients/InsertUpdateViewDelete/' />" >Insert Client</a>
            </li>
            <li>
              <a href="<@spring.url '/Manage_Clients/Search/' />" >Search</a>
            </li>
          </ul>
        </li>  
        
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Orders Job">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseOrders" data-parent="#exampleAccordion">
            <i class="fa fa-th-list"></i>
            <span class="nav-link-text">Orders</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseOrders">
            <li>
              <a href="<@spring.url '/Manage_Orders/InsertUpdateViewDelete/' />" >Insert Order</a>
            </li>
            <li>
              <a href="<@spring.url '/Manage_Orders/Search/' />" >Search</a>
            </li>
          </ul>
        </li> 
        </@security.authorize>                                                              
        
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Link">
          <a class="nav-link" href="#">
            <i class="fa fa-fw fa-link"></i>
            <span class="nav-link-text">Link</span>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
          <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle mr-lg-2" id="messagesDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fa fa-fw fa-envelope"></i>
            <span class="d-lg-none">Messages
              <span class="badge badge-pill badge-primary">12 New</span>
            </span>
            <span class="indicator text-primary d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
          </a>
          <div class="dropdown-menu" aria-labelledby="messagesDropdown">
            <h6 class="dropdown-header">New Messages:</h6>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <strong>David Miller</strong>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">Hey there! This new version of SB Admin is pretty awesome! These messages clip off when they reach the end of the box so they don't overflow over to the sides!</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <strong>Jane Smith</strong>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">I was wondering if you could meet for an appointment at 3:00 instead of 4:00. Thanks!</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <strong>John Doe</strong>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">I've sent the final files over to you for review. When you're able to sign off of them let me know and we can discuss distribution.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item small" href="#">View all messages</a>
          </div>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fa fa-fw fa-bell"></i>
            <span class="d-lg-none">Alerts
              <span class="badge badge-pill badge-warning">6 New</span>
            </span>
            <span class="indicator text-warning d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
          </a>
          <div class="dropdown-menu" aria-labelledby="alertsDropdown">
            <h6 class="dropdown-header">New Alerts:</h6>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <span class="text-success">
                <strong>
                  <i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
              </span>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <span class="text-danger">
                <strong>
                  <i class="fa fa-long-arrow-down fa-fw"></i>Status Update</strong>
              </span>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <span class="text-success">
                <strong>
                  <i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
              </span>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item small" href="#">View all alerts</a>
          </div>
        </li>
        <li class="nav-item">
          <form class="form-inline my-2 my-lg-0 mr-lg-2">
            <div class="input-group">
              <input class="form-control" type="text" placeholder="Search for...">
              <span class="input-group-btn">
                <button class="btn btn-primary" type="button">
                  <i class="fa fa-search"></i>
                </button>
              </span>
            </div>
          </form>
        </li>
        <li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-fw fa-sign-out"></i>Logout</a>
        </li>
      </ul>
    </div>
  </nav>
  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">My Dashboard</li>
      </ol>
		
		<#nested/>
		
      </div>
		</br></br></br>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    
	<footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright © Your Website 2017</small>
        </div>
      </div>
    </footer>
    
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
          	<form action="/logout" method="post">            	
	            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
	            <input class="btn btn-primary" type="submit" value="Logout"/>
        	</form>
          </div>
        </div>
      </div>
    </div>
	
	
	<!-- Bootstrap core JavaScript-->
	<script type="text/javascript" src="<@spring.url '/adminBoot/vendor/jquery/jquery.min.js'/>"></script>
	<script type="text/javascript" src="<@spring.url '/adminBoot/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
	<script type="text/javascript" src="<@spring.url '/adminBoot/vendor/jquery-easing/jquery.easing.min.js'/>"></script>
	<script type="text/javascript" src="<@spring.url '/adminBoot/vendor/chart.js/Chart.min.js'/>"></script>
	<script type="text/javascript" src="<@spring.url '/adminBoot/vendor/datatables/jquery.dataTables.js'/>"></script>
	<script type="text/javascript" src="<@spring.url '/adminBoot/vendor/datatables/dataTables.bootstrap4.js'/>"></script>
	<script type="text/javascript" src="<@spring.url '/adminBoot/js/sb-admin.min.js'/>"></script>
	<script type="text/javascript" src="<@spring.url '/adminBoot/js/sb-admin-datatables.min.js'/>"></script>
	<script type="text/javascript" src="<@spring.url '/adminBoot/js/sb-admin-charts.min.js'/>"></script>	

  </div>
</body>
    
</@standardPage> 
</#macro>   