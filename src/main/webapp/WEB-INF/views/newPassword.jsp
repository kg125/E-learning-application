<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<meta http-equiv="x-ua-compatible" content="ie=edge">

   
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Material Design Bootstrap -->
    <link href="css/mdb.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Reset Password</title>
 <style type="text/css">
 #intro{
 background: url("/images/sunrisefield.jpg")no-repeat center center fixed;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
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
} input[type=password] {
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
form {
    margin-left: 25%;
    margin-right:25%;
    width: 50%;
}
form {
    display: inline-block;
    text-align: center;
    
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
        <li><a href="/leaderboard/"><span class="glyphicon glyphicon-log-in"></span> Leaderboard</a></li>
      <li><a href="/signup/"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="/login/"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav> 

	<div id="intro" class="view hm-black-strong" style="position: relative;  height: 1000px;">
		<form:form method= "POST" commandName="user" action="/passwordReset/resetPasswordSuccess">
		<center><h2> Forgot your Password ?</h2></center>
<p>Please fill in this to recover your account </p>
    <hr>
	<table align ="center">
	 <tr>
        <td><form:label path="password">Password</form:label></td>
        <td><form:input path="password" /></td>
        <td><form:errors path="password"  cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="password2">Confirm Password</form:label></td>
        <td><form:input path="password2" /></td>
        <td><form:errors path="password2"  cssClass="error" /></td>
    </tr>
      <tr>
      <td>
            <input type="submit" value="Reset Password" name="reset" class="btn btn-default" style="position: relative; left: 130px;"/>
            </td>
        </tr>
     </table>
             <div style="text-align:center"><a href = "/"><input type = "button" value = "Cancel" class="btn btn-success"></a></div>
     
</form:form>
</div>
 <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="js/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="js/mdb.min.js"></script>
    
   <script src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>
   
</body>
</html>