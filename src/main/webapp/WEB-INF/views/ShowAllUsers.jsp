<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta charset="UTF-8">
<title>exam</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css"
	integrity="sha384-y3tfxAZXuh4HwSYylfB+J125MxIs6mR5FOHamPBG064zB+AFeWH94NdvaCBm8qnd"
	crossorigin="anonymous">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
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
	background: url("" ) no-repeat center center fixed;
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
div.examForm {
  text-align: left;
  display:block;
  width: 100%;
  height: 100%;
  overflow: auto;
  padding: 5px;
  font-size: 20px;
  
}


</style>
<body>
<nav class="navbar navbar navbar-inverse navbar-fixed fluid-top " style="margin-bottom:0px;" >
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/"><span class="glyphicon glyphicon-home"></span>TOPMARKS EDUCATION</a>
    </div>

    <ul class="nav navbar-nav navbar-right">
          <li><a href="/leaderboard/"><span class="glyphicon glyphicon-stats"></span> Leaderboards</a></li>
                <li><a href="/admin/addUsers"><span class="glyphicon glyphicon-user"></span> Add Person</a></li>      
                <li><a href="/admin/all"><span class="glyphicon glyphicon-list-alt"></span>  Settings </a></li>
          
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
	<div class="text-center">
    <h1>TOPMARKS EDUCATION </h1>
    <h2>Active users</h2>
  </div>

<form>

<table align ="center"  class ="table">

<thead>
	<tr>
		<th>ID</th>
		<th>Username</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Admin Comment</th>
		<th>Maths Score</th>
		<th>English Score </th>
		<th>Edit</th>
		<th>Comment</th>
		<th>Delete</th>
	</tr>
</thead>
<tbody>
      <c:forEach var ="par" items ="${users}">
      	<tr>
      		<td>"${par.id}"</td>
      		<td>"${par.username}"</td>
      		<td>"${par.firstName}"</td>
      		<td>"${par.lastName}"</td>
      		<td>"${par.adminComment}"</td>
      		<td>"${par.mathsScore}"</td>
      		<td>"${par.englishScore}"</td>
      		<td><a href ="/admin/edit/${par.id}" class = "btn btn-default">Edit</a></td>
      		<td><a href ="/admin/adminComment/${par.id}" class = "btn btn-success">Add Comment </a></td>
      		<td><a href="/admin/delete/?id=${par.id}" class="btn btn-danger">Delete</a></td>
      	</tr>	
      
      </c:forEach> 
                                   

</tbody>
     </table>
     <div style="text-align:center"><a href = "/admin/"><input type = "button" value = "Back to Admin Page " class="btn btn-default" ></a></div>
     
     </form>
		
	
		
</body>
</html>