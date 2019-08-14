
   <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exam Results</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
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
<script type="text/javascript">  
	function RemoveButtons() {
		if ("${UserName}" == "Guest") {
			document.getElementById("score").innerHTML='My Highest Score: <input type="submit" id="signup" value="Signup to save score" name="signup" class="btn btn-default" style="background-color: #D8FFFF;">';
		} else {
			document.getElementById("score").innerHTML="My Highest Score: ${HighestScore}";
		}
		
	}
	setTimeout("RemoveButtons()", 0); 
	
	
</script>
</head>
<style  type="text/css">
#intro {
	background: url("/images/space1.gif" ) no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	font-family: "Comic Sans MS", "Comic Sans", cursive;
	color:white;
}
form {
	font-family: "Comic Sans MS","Comic Sans", cursive;
    margin-left: 25%;
    margin-right:25%;
    width: 50%;
	color:white}
form {
    display: inline-block;
    text-align: center;
    font-size:40px;
</style>

<body>

<nav class="navbar navbar navbar-inverse navbar-fixed fluid-top " style="margin-bottom:0px;" >
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/"> <span class="glyphicon glyphicon-home"></span> TOPMARKS EDUCATION</a>
    </div>

    <ul class="nav navbar-nav navbar-right">
          <li><a href="/leaderboard/"><span class="glyphicon glyphicon-stats"></span> Leaderboards</a></li>
      <li><a href="/signup/"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#" data-toggle="modal" data-target="#logoutModal" ><span class="glyphicon glyphicon-log-out"></span>logout</a></li>
      
    </ul>
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
     <div id="intro" class="view hm-black-strong" style="position: relative; left: 0px; top: -25px; height: 1000px;">
  
	<div class="text-center">
    <h1>TOPMARKS EDUCATION EXAM</h1>
    <h4>Thank you ${username}</h4>
    <p class="lead">Thank you for completing our exam </p>
  </div>
	
<form>
<h1> Your Results </h1>

	<table align = "center" style="text-align:left">
	<tr>
	<td>Your Overall Score:${score}/10</td>
	</tr>
	<tr>
	<!--  <td>Student to Beat: ${HighestScoreEver}</td>-->
	</tr>
</table>
 
 	
 	
 	<div style="text-align:center"><a href = "/"><input type = "button" value = "Return Back to the Menu " class="btn btn-success"></a></div>
</form>
</div>
</body>
</html>