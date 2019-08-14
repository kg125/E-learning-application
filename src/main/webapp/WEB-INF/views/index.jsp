<!DOCTYPE HTML>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head> 
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="shortcut icon" href="/images/favicon.ico">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Educational Game</title>
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
    <!--  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />-->
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
html,
body,
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


button:hover {
    opacity: 0.8;
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
          <li><a href="/leaderboard/"><span class="glyphicon glyphicon-stats"></span> Leaderboards</a></li>
      <li><a href="/signup/"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="/login/"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>


<div id="intro" class="view hm-black-strong">
<form:form method="POST" commandName="indexFormDto" action="/main">
<h2> Login Form</h2>
<p>Please fill in this form to log in</p>
    <hr>
    <div class="imgcontainer">
		<img src="/images/avatar.png" alt="Avatar" class="avatar">
	</div>
   <table align ="center">
    <tr>
    <td><form:label path="username">Username</form:label></td>
    <td><form:input type="text" path="username" placeholder="Username"/></td>
     <td><form:errors path="username"  cssClass="error" /></td>
    </tr>
        
      <tr> 
      <td><form:label path="password">Password</form:label></td>
      <td>
     <form:input type="password" path="password" placeholder="Password" /></td>
      <td><form:errors path="password"  cssClass="error" /></td>
    </tr>
    
    <tr>
      <td><input type="submit" name="login" value="Login" class="btn btn-default"/></td>
    
      <td> <a href = "/"><input type = "button" value = "Cancel" class="btn btn-default"></a></td>
    </tr>
    
    <tr>
    <td>
            <input type="submit"  name="passwordReset"value="Forgot your password?" class="btn btn-default"/>
        </td>
  
       <td><input type="submit" name="guest" value="Play as guest" class="btn btn-default"/></td>
    </tr>
</table>  
		<p><small class="text-white mr-2">Have You Registered ?</small> <a href="/signup/" class="text-white font-weight-bold text-capitalize">sign up</a></p>

</form:form>

</div>
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