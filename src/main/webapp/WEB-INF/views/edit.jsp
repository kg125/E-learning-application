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
<title>Editing</title>



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

<form method= "POST" action="/admin/adminEdit">
		<div class = "table-responsive">
				<center><h3>Update User Details</h3></center>

<table align ="center" style = "margin:auto; width:40%" class = "table table-bordered">

<tbody>
<input type = "hidden" name ="id"  id="id" value ="${user.id}" readonly/>
<!-- <tr><th> Key(ID)</th><td><input type = "number" name ="id"  id="id" value ="${user.id}" readonly/></td></tr>-->
<tr><th> User Name</th><td><input type = "text" name ="userName"  id="userName" value ="${user.username}" readonly disabled></td></tr>
<tr><th> First Name</th><td><input type = "text" name ="firstName"  id="firstName" value ="${user.firstName}"></td></tr>
<tr><th> Last Name</th><td><input type = "text" name ="lastName"  id="lastName" value ="${user.lastName}"></td></tr>
<tr>
	<th> <input type="submit" value="Done" id="submit" class="btn btn-success"/></th>
	<th><a href = "/admin/all" role ="button" class="btn btn-danger" style="float:right">Back</a></th>
</tr> 




</tbody>
     </table>
     </div>
     <div style ="text-align:center"></div>
     <div style ="text-align:left"></div>
<br><br>


</form>

</body>

</html>