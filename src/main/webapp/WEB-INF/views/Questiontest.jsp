<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

</head>
<style type="text/css">
html, body, header, #intro {
	height: 100%;
}
form {
    margin-left: 25%;
    margin-right:25%;
    width: 50%;
}
form {
    display: inline-block;
    text-align: center;
}

#intro {
	background: url("/images/main.jpg" ) no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	font-family: "Comic Sans MS", "Comic Sans", cursive;
}
#container {
        margin: 0 auto; 
        float: none; 
        margin-bottom: 10px; 
        background-color: white ;
}

.fixed_header{
    width: 700px;
    table-layout: fixed;
    border-collapse: collapse;
}

.fixed_header tbody{
  display:block;
  width: 100%;
  overflow: auto;
  height: 500px;
}

.fixed_header thead tr {
   display: block;
}

.fixed_header thead {
  background: black;
  color:#fff;
}

.fixed_header th, .fixed_header td {
  padding: 5px;
  text-align: left;
  width: 1000px;
}
</style>
<body>
<nav class="navbar navbar navbar-inverse navbar-fixed fluid-top " style="margin-bottom:0px;" >
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">TOPMARKS EDUCATION</a>
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
  	<div id="intro" class="view hm-black-strong">
  	<div class="container" style = "margin:auto; ">
  
<form method ="POST" action ="/examControl/examResult"  commandName="Answer">
 <div class="text-center">
    <h1>TOPMARKS EDUCATION EXAM</h1>
    <h4>Welcome ${username}</h4>
    <p class="lead">Complete exam </p>
  </div>
<table class="fixed_header">
<tbody>
	<c:forEach var="examqu" items="${question}">

	<tr>
	<th><div id ="hr"><hr></div></th>
	<th style="position:relative;left:-100px;">${examqu.id}</th><th style="position:relative;left:-300px;">${examqu.question}</th>
	
			<c:forEach var="opt" items="${options}">
			<c:if test = "${opt.getQuestion_id() == examqu.getId() }">
				<tr ><td><input type="checkbox"  value = "${opt.getId()}"></td>
				<td>${opt.getOption()}</td></tr>
				</c:if>
			
			</c:forEach>
		
		
	</tr>
		</c:forEach>
				
		
			<tr>
		<td>
		<td>
        </td>
			<td>
	
			</td>
		</tr>
		
	
</tbody>

</table>
				<a href = "/"><input type = "button" style="position:relative;left:10px;top:100px;" value = "Exit to Main Menu" class="btn btn-default"></a>
           
            <input type="submit"  name="Submit"value="Submit" class="btn btn-default" style="position:relative;left:10px;top:100px;"/>

</form>
</div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
		$(document).ready(function() { 
			
		  $("Submit").click(function(){
			  
		    alert("Button is clicked!");
		    
		  });
		  
		});
		
	</script>



</body>
</html>