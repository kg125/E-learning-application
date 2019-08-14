<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
       <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="shortcut icon" href="/images/favicon.ico">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- <meta http-equiv="x-ua-compatible" content="ie=edge">-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Pontano+Sans" rel="stylesheet">
   
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
    <!-- materialdesign icons CSS -->
    <link href="css/material-icons.css" rel="stylesheet">
    
    <!-- Material Design Bootstrap -->
    <link href="css/mdb.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Sign up</title>
<style type="text/css">

.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
body,{
    height: 100%;
}
html,
header,
#intro {
    height: 100%;
	font-family: "Comic Sans MS","Comic Sans", cursive;
}
 
 #intro{
 background: url("/images/sunrisefield.jpg")no-repeat center center fixed;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
    margin-top:10px;
}

body {font-family: Arial, Helvetica, sans-serif;}
form {
    margin-left: 25%;
    margin-right:25%;
    width: 50%;
}
form {
    display: inline-block;
    text-align: center;
}
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}
hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}

.avatar {
    width: 40px;
    border-radius: 50%;
}

.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}


/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
</head>
<body>
<nav class="navbar navbar navbar-inverse navbar-fixed fluid-top " style="margin-bottom:0px;" >
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">TOPMARKS EDUCATION</a>
    </div>

    <ul class="nav navbar-nav navbar-right">
      <li><a href="/signup/"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="/login/"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
<div id="intro" class="view hm-black-strong" style="position: relative; left: 0px; top: -10px; height: auto;">
   
<form:form method="POST" commandName="user" action="/signup/add"  align="center">
		 
		 <h1>Sign Up</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>
		<table align ="center">
			<tr>
				<td><form:label path="firstName" >First Name</form:label></td>
				<td><form:input path="firstName" placeholder="firstname" /></td>
				<td><form:errors path="firstName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last names</form:label></td>
				<td><form:input path="lastName" placeholder="lastname"/></td>
				<td><form:errors path="lastName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="username">Username</form:label></td>
				<td><form:input path="username" placeholder="username"/></td>
				<td><form:errors path="username" cssClass="error" /></td>
			</tr>
			<tr>
				<!--  <td><form:label path="role" type="hidden">Role</form:label></td>-->
				<td><form:input path="role" value="user" type="hidden"/></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:input path="password" placeholder="password" /></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="password2">Confirm Password</form:label></td>
				<td><form:input path="password2" placeholder="Confirm Password" /></td>
				<td><form:errors path="password2" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="securityQuestion">Security Question</form:label></td>
				<td><form:select path="securityQuestion">
						<c:forEach var="securityQuestion" items="${questionsList}">
							<c:if test="${securityQuestion == selectedQuestion}">
								<option value="${securityQuestion}" selected="selected">${securityQuestion}</option>
							</c:if>
							<c:if test="${securityQuestion != selectedQuestion}">
								<option value="${securityQuestion}">${securityQuestion}</option>
							</c:if>
						</c:forEach>
					</form:select>
				<td><form:errors path="securityQuestion" cssClass="error" /></td>
			</tr>
			<tr>
				<td></td>
				<td><form:input path="securityAnswer" placeholder="Security Answer"/></td>
				<td><form:errors path="securityAnswer" cssClass="error" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Sign up" name="add"
					class="btn btn-default" /></td>
				<td><input type="submit" value="Cancel" name="cancel"
					class="btn btn-default" /></td>
			</tr>
			
		</table>
		<p><small class="text-white mr-2">Already have an account ?</small> <a href="/login" class="text-white font-weight-bold text-capitalize">Log In</a></p>
		</form:form>


  </div>
  
	<!-- SCRIPTS -->
	<!-- JQuery -->
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="js/mdb.min.js"></script>
</body>
</html>