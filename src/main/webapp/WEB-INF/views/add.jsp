<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<title>Adding a person</title>


<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="js/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="js/mdb.min.js"></script>
    
   <script src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>
   

</head>
<body>

<nav class="navbar navbar navbar-inverse navbar-fixed fluid-top " style="margin-bottom:0px;" >
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="landing"><span class="glyphicon glyphicon-home"></span>Home</a>
    </div>

    <ul class="nav navbar-nav navbar-right">
      <li><a href="settings"><span class="glyphicon glyphicon-list-alt"></span>  Settings </a></li>
      <li><a href="add"><span class="glyphicon glyphicon-user"></span> Add Person</a></li>
      <li><a href="search"><span class="glyphicon glyphicon-search"></span> Search Person Ancestor/ Decendents</a></li>
      
      
    </ul>
  </div>
</nav> 

<form:form method= "POST" action="/admin/new">
		<div class = "table-responsive">
				<center><h2>Adding a user ?</h2></center>
<center><p>Please fill in this to add a user </p></center>
<table align ="center" style = "margin:auto;">
<thead>
<tr>
<th> Key(ID)</th>
<th> First name</th>
<th> Last name</th>
<th> Username</th>
<th>Role</th>
<th> Security Question</th>
<th> Security Answer</th>
</tr>
</thead>
<tbody>
<tr>
<td><input type = "number" name ="id" required ="required" id="id"></td>
<td><input type = "text" name ="firstName" required ="required" id="firstName"></td>
<td><input type = "text" name ="lastName" required ="required" id="lastName"></td>
<td><input type = "text" name ="username" required ="required" id="username"></td>
<td><input type = "text" name ="role" required ="required" id="role"></td>
<td><input type = "text" name ="securiyQuestion" required ="required" id="securiyQuestion"></td>
<td><input type = "text" name ="securiyAnswer" required ="required" id="securiyAnswer"></td>
</tr>

</tbody>
     </table>
     </div>
     <div style ="text-align:center"><input type="submit" value="Add" id="add" class="btn btn-success"/></div>
     <div style ="text-align:left"><a href = "/admin/all" role ="button" class="btn btn-info">Back</a></div>
     
</form:form>


</body>

</html>