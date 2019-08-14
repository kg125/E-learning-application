<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.ArrayList, eduWebApp.domain.ExamAnswers" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Material Design Bootstrap -->
    <link href="css/mdb.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Admin page</title>
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

<form action="/admin/editAnswer" method ="POST">
<div class = "table-responsive">
				<center><h3>Update Answers Details</h3></center>

<table align ="center" style = "margin:auto; width:40%" cell-spacing="10px" class = "table table-bordered">

<tbody>
<%--  <input type = "hidden" name ="id"  id="id" value ="${answerlist.id}"/>
<tr><th> Question</th><td><textarea cols="60" rows="5" disbaled>${answerlist.content}</textarea></td></tr>--%>
<tr><th> Exam Questions </th><td> 
	<%
		ArrayList<ExamAnswers> lists = (ArrayList) request.getAttribute("answerlist");
		for(ExamAnswers e : lists){ %>
			<tr><td>
				<input type="hidden" name="ansid[]"  id ="ansid[]" value="<%=e.getId() %>">
				<%=e.getId() %><input type="text" name="content[]"  id ="content[]" value="<%=e.getContent() %>"> </td></tr>	
		<% } %>
 </td></tr>

<tr>
	<th> <input type="submit" value="Done" id="submit" class="btn btn-success"/> <a href = "/admin/allQuestions" role ="button" class="btn btn-danger" style="float:right">Back</a></th>
	
</tr> 




</tbody>
     </table>
     </div>

</form> 	
</body>
</html>