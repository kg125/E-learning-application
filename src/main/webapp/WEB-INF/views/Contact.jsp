<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head><meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<!--  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">-->
<title>Contact us</title>
 <link href="css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Material Design Bootstrap -->
    <link href="css/mdb.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style type="text/css" >
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

 


</style>
<body>
<nav class="navbar navbar navbar-inverse navbar-fixed fluid-top scrolling-navbar " style="margin-bottom:0px;" >
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/"><span class="glyphicon glyphicon-home"></span> TOPMARKS EDUCATION</a>
    </div>

    <ul class="nav navbar-nav navbar-right smooth-scroll">
          <li><a href="/leaderboard/"><span class="glyphicon glyphicon-stats"></span> Leaderboards</a></li>
      <li><a href="/signup/"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="/login/"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      <li><a href="/contact/"><span class="glyphicon glyphicon-envelope"></span> contact</a></li>
      
    </ul>
  </div>
</nav> 

 <form:form method = "POST" commandName="contact" action ="/contact/send">
<h3>Contact Us </h3>
  <hr>
 <table align ="center">
<tr>
<td>name</td>
<td><i class="fa fa-user prefix grey-text"></i><form:input path ="name"/> </td>
</tr>
<tr>
<td>email</td>
<td><i class="fa fa-envelope prefix grey-text"></i><form:input path ="email"/> </td>

</tr>
<tr>
<td>Region</td>
<td><i class="fa fa-location-arrow prefix grey-text"></i><form:input path ="fromAddress"/> </td>
</tr>

<tr>
<td>subject</td>
<td><i class="fa fa-tag prefix grey-text"></i><form:input path ="subject"/> </td>
</tr>

<tr>
<td valign ="top">Your Message</td>
<td><i class="fa fa-pencil prefix grey-text"></i><form:textarea path ="content" style="height: 100px" /> </td>
</tr>

<tr>
  <td>&nbsp;</td>
<td><input type ="submit" value ="Send" class="btn btn-primary"/> </td>

</tr>
</table>
</form:form>
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="../js/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="../js/mdb.min.js"></script>
    
   <script src="../js/jquery-1.7.1.min.js"></script>
<script src="../js/bootstrap.js"></script>
</body>
</html>