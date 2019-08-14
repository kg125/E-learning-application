<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import= "java.util.Arrays" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Admin Page</title>

  <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">-->

<link rel="stylesheet"
 href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"> 


<!-- Page level plugin CSS-->
     <link href="../css/dataTables.bootstrap4.css" rel="stylesheet">

<!-- Custom styles for this template-->
  <link href="../css/sb-admin.css" rel="stylesheet">
   <link href="../css/mdb.min.css" rel="stylesheet">
 
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
</head>
<style type="text/css">
html, body, header, #intro {
	height: 100%;
}

#intro {
	background: url("/images/space2.gif" ) no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	font-family: "Comic Sans MS", "Comic Sans", cursive;
	color:white;
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

			<!-- Sidebar -->
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
						<h6 class="dropdown-header">Users:</h6>
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

					<div class="text-center">
						<h1>Admin page</h1>
						<h4>Welcome ${username}</h4>
						<p class="lead"></p>
					</div>
													  
		
			
					  <div class="row wow fadeIn">

						<div class="col-md-9 mb-4">

		
							<div class="card">

				
								<div class="card-body">

									<canvas id="myChart"></canvas>
									    <%-- <div id='chartContainer' style="width: 860px; height: 600px; margin-bottom: 25px;"></div>--%>
									

								</div>

							</div>
					

						</div>
				
						<div class="col-md-3 mb-4">

					
							<div class="card mb-4">

			
								<div class="card-header text-center">Pie chart</div>

						
								<div class="card-body">

									<canvas id="pieChart"></canvas>

								</div>

							</div>
						
							<div class="card mb-4">

							


							</div>
							
			
<form:form method="GET" action="/admin/all">
   <table>
    <tr>
        <td colspan="2">
            <input type="submit" value="Show all users" name="all" class="btn btn-default"/>
        </td>
    </tr>
   </table>
  </form:form>

  

<% 
	int[] records = new int[4];
	int i = 0;
%>
	<!-- user exam results  -->
	<c:set var="test1" value="${value0}"/>
	<c:set var="test2" value="${value1}"/>
	<c:set var="test3" value="${value2}"/>
	<c:set var="test4" value="${value3}"/>
	<!-- user game results  -->
	
	<c:set var="test5" value="${values0}"/>
	<c:set var="test6" value="${values1}"/>
	<c:set var="test7" value="${values2}"/>
	<c:set var="test8" value="${values3}"/>
	<!-- user game average results  -->
	<c:set var="test9" value="${mathsvalues}"/>
	<c:set var="test10" value="${englishvalues}"/>
	<c:set var="test11" value="${examvalues}"/>
	
	

 
  
						</div>
					

					</div> 
		
							<div class="row wow fadeIn">
					  		<div class="col-md-9 mb-4">

		
							<div class="card">

				
								<div class="card-body">

									<canvas id="lineChart"></canvas>
									    <%-- <div id='chartContainer' style="width: 860px; height: 600px; margin-bottom: 25px;"></div>--%>
									

								</div>

							</div>
					

						</div>
							<div class="col-md-9 mb-4">

		
							<div class="card">

				
								<div class="card-body">

									<canvas id="myChart2"></canvas>
									    <%-- <div id='chartContainer' style="width: 860px; height: 600px; margin-bottom: 25px;"></div>--%>
									

								</div>

							</div>
					

						</div>
					  </div>
					  </div>
				</div>
			

			</div>
			<!-- /.content-wrapper -->

		</div>
		<a class="scroll-to-top rounded" href="/admin/"> <i
			class="fas fa-angle-up"></i>
		</a>
	</div>







<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="js/mdb.min.js"></script>

	<script
		src='http://cdnjs.cloudflare.coadmin/m/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>
	<!-- Core plugin JavaScript-->
		<!-- Page level plugin JavaScript-->
		<!-- Custom scripts for all pages-->
		<!-- Demo scripts for this page-->
	
 <script src="../js/jquery.easing.min.js"></script>

	<script src="../js/jquery.dataTables.js"></script>
	<script src="../js/dataTables.bootstrap4.js"></script>

	<script src="../js/sb-admin.min.js"></script>

	<script src="../js/datatabadmin/les-demo.js"></script>
	<script src="../js/chart-area-demo.js"></script>
	<script src="../js/Chart.min.js"></script>
	<!-- user exam results  -->
   <% int number = (int) pageContext.getAttribute("test1");%>
  <% int number1 = (int) pageContext.getAttribute("test2");%>
  <% int number2 = (int) pageContext.getAttribute("test3");%>
  <% int number3 = (int) pageContext.getAttribute("test4");%>
  <!-- user game results  -->
  <% int number4 = (int) pageContext.getAttribute("test5");%>
  <% int number5 = (int) pageContext.getAttribute("test6");%>
  <% int number6 = (int) pageContext.getAttribute("test7");%>
  <% int number7 = (int) pageContext.getAttribute("test8");%>
  <!-- user game average results  -->
  <% double number8 = (double) pageContext.getAttribute("test9");%>
  <% double number9 = (double) pageContext.getAttribute("test10");%>
  <% double number10 = (double) pageContext.getAttribute("test11");%>
	<script>
		// Line
	
			var a= <%=number%>
			var b= <%=number1%>
			var c= <%=number2%>
			var d= <%=number3%>
			var e= <%=number4%>
			var f= <%=number5%>
			var g= <%=number6%>
			var h= <%=number7%>
			var i= <%=number8%>
			var j= <%=number9%>
			var k= <%=number10%>
			
			
			
	
		var c
		var ctx = document.getElementById("myChart").getContext('2d');
		var myChart = new Chart(ctx,
				{
					type : 'bar',
					data : {
						labels : [ "Users That Scored below 2", "Users That Scored below 4", "Users That Scored below 6", "Users That Scored Higher Than 8" ],
						//labels:$(users)				,
						datasets : [ {
							label : '# User Exam Results',
							data : [ a, b, c, d],
							backgroundColor : [ 'rgba(255, 99, 132, 0.2)',
									'rgba(54, 162, 235, 0.2)',
									'rgba(255, 206, 86, 0.2)',
									'rgba(75, 192, 192, 0.2)',
									'rgba(153, 102, 255, 0.2)',
									'rgba(255, 159, 64, 0.2)' ],
							borderColor : [ 'rgba(255,99,132,1)',
									'rgba(54, 162, 235, 1)',
									'rgba(255, 206, 86, 1)',
									'rgba(75, 192, 192, 1)',
									'rgba(153, 102, 255, 1)',
									'rgba(255, 159, 64, 1)' ],
							borderWidth : 1
						} ]
					},
					options : {
						scales : {
							yAxes : [ {
								ticks : {
									beginAtZero : true
								}
							} ]
						}
					}
				});
		// Chart2
		var ctx = document.getElementById("myChart2").getContext('2d');
		var myChart2 = new Chart(ctx,
				{
					type : 'bar',
					data : {
						labels : [ "Average Maths Score", "Average English Scores","Average Exam Scores"  ],
						//labels:$(users)				,
						datasets : [ {
							label : '# Average Score Results',
							data : [i, j, k],
							backgroundColor : [ 'rgba(255, 99, 132, 0.2)',
									'rgba(54, 162, 235, 0.2)',
									'rgba(255, 206, 86, 0.2)',
									'rgba(75, 192, 192, 0.2)',
									'rgba(153, 102, 255, 0.2)',
									'rgba(255, 159, 64, 0.2)' ],
							borderColor : [ 'rgba(255,99,132,1)',
									'rgba(54, 162, 235, 1)',
									'rgba(255, 206, 86, 1)',
									'rgba(75, 192, 192, 1)',
									'rgba(153, 102, 255, 1)',
									'rgba(255, 159, 64, 1)' ],
							borderWidth : 1
						} ]
					},
					options : {
						scales : {
							yAxes : [ {
								ticks : {
									beginAtZero : true
								}
							} ]
						}
					}
				});


		//pie
		var ctxP = document.getElementById("pieChart").getContext('2d');
		var myPieChart = new Chart(ctxP, {
			type : 'pie',
			data : {
				labels : [ "users that score lower than 5 ", "users that score lower than 15 ", "users that score lower than 25", " users that have scored 25 +" ],
				datasets : [ {
					label : "#User Exam Results",
					data : [ e, f, g, h],
					backgroundColor : [ "#F7464A", "#46BFBD", "#FDB45C",
							"#949FB1", "#4D5360" ],
					hoverBackgroundColor : [ "#FF5A5E", "#5AD3D1", "#FFC870",
							"#A8B3C5", "#616774" ]
				} ]
			},
			options : {
				responsive : true,
				legend : false
			}
		});

		//line
		var ctxL = document.getElementById("lineChart").getContext('2d');
		var myLineChart = new Chart(ctxL, {
			type : 'line',
			data : {
				labels : [ "January", "February", "March", "April" ],
				datasets : [ {
					label : "TopMarks Exam Results",
					backgroundColor : [ 'rgba(105, 0, 132, .2)', ],
					borderColor : [ 'rgba(200, 99, 132, .7)', ],
					borderWidth : 2,
					data : [ a,b,c,d ]
				}, {
					label : "TopMarks Game Results",
					backgroundColor : [ 'rgba(0, 137, 132, .2)', ],
					borderColor : [ 'rgba(0, 10, 130, .7)', ],
					data : [e,f,g,h ]
				} ]
			},
			options : {
				responsive : true,

				scales : {
					yAxes : [ {
						ticks : {
							beginAtZero : true
						}
					} ]
				}
				
				
			}
		});
	</script>
</body>
</html>