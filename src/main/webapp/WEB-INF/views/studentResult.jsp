<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Student Results</title>
 
  <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">-->

<link rel="stylesheet"
 href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"> 


<!-- Page level plugin CSS-->
  <!--   <link href="../css/dataTables.bootstrap4.css" rel="stylesheet">-->

<!-- Custom styles for this template-->
  <link href="../css/sb-admin.css" rel="stylesheet">
 
 <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css"
	integrity="sha384-y3tfxAZXuh4HwSYylfB+J125MxIs6mR5FOHamPBG064zB+AFeWH94NdvaCBm8qnd"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
html, body, header, #intro {
	height: 100%;
}
#div{
	color:white;
	}
#intro {
	background: url("/images/space2.gif" ) no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	font-family: "Comic Sans MS", "Comic Sans", cursive;

}

.card {
	margin: 0 auto;
	float: none;
	margin-bottom: 10px;
}

body {
	background-color: #eee;
	body {height: 100%;
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box
}
}
</style>

</head>
<body>
	<nav class="navbar navbar-expand navbar-dark bg-dark static-top"  style="margin-bottom:0px;" >
  <div class="container-fluid">

	<a class="navbar-brand mr-1" href="/admin/"><span class="glyphicon glyphicon-home"></span> TOPMARKS EDUCATION</a>

	<button class="btn btn-link btn-sm text-white order-1 order-sm-0"
		id="sidebarToggle" href="#">
		<i class="fas fa-bars"></i>
	</button>

	
	

	<ul class="navbar-nav ml-auto ml-md-0">
		<li class="nav-item dropdown no-arrow"><a
			class="nav-link dropdown-toggle" href="#" id="userDropdown"
			role="button" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="false"> <i class="fas fa-user-circle fa-fw"></i>
		</a>
			<div class="dropdown-menu dropdown-menu-right"
				aria-labelledby="userDropdown">
				<a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal1"  >Logout</a> 
				<a class="dropdown-item" href="/admin/all">  Settings </a>
				<a class="dropdown-item" href="/admin/addUsers">  Add User </a>
				
				
			</div>
			</li>
	</ul>
</div>
	</nav>
	

	
<div class="modal" id="logoutModal1" tabindex="-1" role="dialog" aria-hidden="true" aria-labelledby="exampleModalLabel">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
                <h4 class="modal-title" id="exampleModalLabel">Ready to Leave? <i class="fa fa-lock"></i></h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">x</span></button>
      </div>
       <center> <div class="modal-body"> <i class="fa fa-question-circle"></i>Select "Logout" below if you are ready to end your current session.</div></center>
      <!--  <p><i class="fa fa-question-circle"></i> Are you sure you want to logout? <br /></p>-->
        
        <div class="actionsBtns">
            <form:form method="POST" action="../admin/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" name="logout" value="Logout" class="btn btn-primary btn-block"/>
	          <center><button class="btn btn-default" data-dismiss="modal">Cancel</button></center>
            </form:form>
        </div>
      </div>
    </div>
  </div> 


	<div id="intro" class="view hm-black-strong" style="position: relative; left: 0px; top: -19px; height: auto;">
		<div id="wrapper">

	<ul class="sidebar navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/admin/"> <i
						class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
				</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle active waves-effect" href="#"
					id="pagesDropdown" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> <i
						class="fas fa-fw fa-folder"></i> <span>Pages</span>
				</a>
					<div class="dropdown-menu" aria-labelledby="pagesDropdown">
						<h6 clmaiass="dropdown-header">Users:</h6>
						<a class="dropdown-item" href="/login/">Login</a> <a
							class="dropdown-item" href="/signup/">Register</a> <a
							class="dropdown-item" href="/passwordReset/">Forgot Password</a>
						<div class="dropdown-divider"></div>
						<h6 class="dropdown-header">Other Pages:</h6>
						
					</div></li>
				<li class="nav-item"><a class="nav-link active waves-effect"
					href="../admin/results"> <i class="fas fa-fw fa-chart-area"></i> <span>Student
							Result</span></a></li>
				<li class="nav-item active waves-effect"><a class="nav-link"
					href="/admin/allQuestions"> <i class="fas fa-fw fa-table"></i> <span>Create
							exam</span></a></li>
			</ul>
			<div id="content-wrapper">

				<div class="container-fluid">

					<!-- Breadcrumbs-->
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="/admin/">Dashboard</a></li>
						<li class="breadcrumb-item active">Admin Analetics</li>
					</ol>

					<div class="text-center" id = "div" >
						<h1>Admin page</h1>
						<h4>Welcome ${username}</h4>
						<p class="lead"></p>
					</div>
					<div class="row wow fadeIn">
						<div class="col-md-9 mb-4">

							<div class="card mb-3">
								<div class="card-header">
									<i class="fas fa-table"></i> Students
								</div>
								<div class="card-body">
									<div class="table-responsive">


										<table class="table table-bordered" id="table_id"
											style="width: 100%" align="center">
											<thead>
												<tr>
													<th style="text-align: center">#</th>
													<th>Username</th>
													<th>Firstname</th>
													<th>Lastname</th>

													<th>Score</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${users}" var="u" varStatus="status">
													<tr>
														<td width="5"><c:out value="${num = num + 1}" /></td>
														<td><c:out value="${u.username}" /></td>
														<td><c:out value="${u.firstName}" /></td>
														<td><c:out value="${u.lastName}" /></td>
														<td><c:out value="${scores[status.index]}" /></td>
													</tr>
												</c:forEach>


											</tbody>
											<tfoot>
												<tr>
													<th style="text-align: center">#</th>
													<th>Username</th>
													<th>Firstname</th>
													<th>Lastname</th>
													<th>Score</th>

												</tr>
											</tfoot>
										</table>
									</div>
								</div>
							</div>
							<div class="card mb-3">
								<div class="card-header">
									<i class="fas fa-table"></i> Students Exam Results
								</div>
								<div class="card-body">
									<div class="table-responsive">


										<table class="table table-bordered" 
											style="width: 100%" align="center">
											<thead>
												<tr>
													<th style="text-align: center">#</th>
													<th>Username</th>
													<th>Firstname</th>
													<th>Lastname</th>
													<th>Exam Marks</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${users}" var="u" varStatus="status">
													<tr>
														<td width="5"><c:out value="${num1 = num1 + 1}" /></td>
														<td><c:out value="${u.username}" /></td>
														<td><c:out value="${u.firstName}" /></td>
														<td><c:out value="${u.lastName}" /></td>
														<td><c:out value="${scoress[status.index]}" /></td>
													</tr>
												</c:forEach>


											</tbody>
											<tfoot>
												<tr>
													<th style="text-align: center">#</th>
													<th>Username</th>
													<th>Firstname</th>
													<th>Lastname</th>
													<th>Exam Marks</th>
										</table>
					
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="js/mdb.min.js"></script>

	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>
	<!-- Core plugin JavaScript-->
		<!-- Page level plugin JavaScript-->
		<!-- Custom scripts for all pages-->
		<!-- Demo scripts for this page-->
	
 <script src="../js/jquery.easing.min.js"></script>

	<script src="../js/jquery.dataTables.js"></script>
	<script src="../js/dataTables.bootstrap4.js"></script>

	<script src="../js/sb-admin.min.js"></script>

	<script src="../js/datatables-demo.js"></script>
	<script src="../js/chart-area-demo.js"></script>
	<script src="../js/Chart.min.js"></script>

</body>
</html>