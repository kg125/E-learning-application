<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<!--  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
<title>Main Page</title>
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
	background: url("/images/giphy5.gif" ) no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	font-family: "Comic Sans MS", "Comic Sans", cursive;
	 color: white;
}
.card {
        margin: 0 auto; 
        float: none; 
        margin-bottom: 10px; 
         color: black;
}
</style>



<body>
<nav class="navbar navbar navbar-inverse navbar-fixed fluid-top " style="margin-bottom:0px;" >
  <div class="container-fluid">
    <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	          </button>
      <a class="navbar-brand" href="/"><span class="glyphicon glyphicon-home"></span> TOPMARKS EDUCATION</a>
    </div>
<div class="collapse navbar-collapse">
    <ul class="nav navbar-nav navbar-right">
          <li><a href="/leaderboard/"><span class="glyphicon glyphicon-stats"></span> Leaderboards</a></li>
      <li><a href="/signup/"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#" data-toggle="modal" data-target="#logoutModal" ><span class="glyphicon glyphicon-log-out"></span>logout</a></li>
      
    </ul>
  </div>
  </div>
</nav>


	 <div class="modal" id="logoutModal" tabindex="-1" role="dialog" aria-hidden="true" aria-labelledby="exampleModalLabel">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
                <h4 class="modal-title" id="exampleModalLabel">Ready to Leave? <i class="fa fa-lock"></i></h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">x</span></button>
      </div>
       <center> <div class="modal-body"> <i class="fa fa-question-circle"></i>Select "Logout" below if you are ready to end your current session.</div></center>
      <!--  <p><i class="fa fa-question-circle"></i> Are you sure you want to logout? <br /></p>-->
        
        <div class="actionsBtns">
            <form:form method="POST" action="/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" name="logout" value="Logout" class="btn btn-primary btn-block"/>
	          <center><button class="btn btn-default" data-dismiss="modal">Cancel</button></center>
            </form:form>
        </div>
      </div>
    </div>
  </div> 
	<div id="intro" class="view hm-black-strong" style="position: relative; left: 0px; top: -10px; height: auto;">
	<div class="container">
    <div class="text-center">
    <h1 class="white-text">TOPMARKS EDUCATION</h1>
    <h4 class="white-text ">Welcome ${username}</h4>
    <p class="lead white-text">Choose a Topic </p>
  </div>
  
    <div class="row">
        <!--Grid column-->
        <div class="col-lg-4 col-md-5" >

			<div class="card card-cascade narrower">

        			<!--Card image-->
        			<div class="view overlay">
            			<center><a href="/main/start-english/">
            				<img style = "height:300px" src="/images/matching.jpg" class="img-fluid"  action="/main/english">
           			</a></center>
        			</div>

		        <!--Card content-->
		        <div class="card-body" align="center">
		            <!--Title-->
		            <h4 class="card-title">Matching Game</h4>
		            <!--Text-->
		            <p class="card-text">Play our Matching game</p>
           		</div>


        		</div>

        </div>

        <!--Grid column-->
		<div class="col-lg-4 col-md-5">


			<div class="card card-cascade narrower">

        			<!--Card image-->
      			<div class="view overlay">
          		<center>	<a href="/main/start-maths/">
          				<img src="/images/numbers.png" class="img-fluid"  style = "height:300px" >
         			 </a></center>
      			</div>

		        <!--Card content-->
		        <div class="card-body" align="center">
		            <!--Title-->
		            <h4 class="card-title">Numbers Game</h4>
		            <!--Text-->
		            <p class="card-text">Play our Numbers game</p>
		           
		        </div>
        	</div>
        
        </div>
         <div class="col-lg-4 col-md-5" >

			<div class="card card-cascade narrower">

        			<!--Card image-->
        			<div class="view overlay">
            			<a href="/main/start-hangman/">
            				<img style = "height:300px; width: 400px; " src="/images/hangman.jpg" class="img-fluid"  action="/main/hangman">
           			</a>
        			</div>

		        <!--Card content-->
		        <div class="card-body" align="center">
		            <!--Title-->
		            <h4 class="card-title">Hangman</h4>
		            <!--Text-->
		            <p class="card-text">play our Hangman game</p>
           		</div>


        		</div>

        </div>
  

       

</div>
<div class ="row">





        			<!--Card image-->
        		<div class="card card-cascade narrower">

        			<!--Card image-->
        			<div class="view overlay">
            			<center><a href="/main/start-exam/">
            				<img style = "height:300px" src="/images/exam.png" class="img-fluid"  action="/main/exam">
           			</a></center>
        			</div>

		        <!--Card content-->
		        <div class="card-body" align="center">
		            <!--Title-->
		            <h4 class="card-title">Take Our Exam</h4>
		            <!--Text-->
		            <p class="card-text">Exam</p>
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
</body>
</html>