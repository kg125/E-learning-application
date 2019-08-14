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
    
    <!-- Material Design Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



<script type="text/javascript">  
	function RemoveButtons() {
		if (${hardQuestion} == false) {
			document.getElementById("ans5").style.opacity = '0';
			document.getElementById("ans5").disabled = 'true';
		}
	}
	
</script>
<script type="text/javascript">   
	function Redirect() 
	{  
		alert("You ran out of time!\nProgress onto the next question.");
		window.location.replace("/english/skip");
		
	} 
	
	var timerRemaining = ${timerRemaining}+1;
	
	function UpdateTimer(i) {  
		if (${easyMode == true}) {
			if (i == 0) {
			
				document.getElementById("timer").textContent='0';
				document.getElementById("timer1").value='0';
				setTimeout('Redirect()', 100); 
				
			} else {
				
				${timerStart = ''+(timerDisplay-1)}
				document.getElementById("timer").textContent=i;
				document.getElementById("timer1").value=i;
				setTimeout('UpdateTimer('+(i-1)+')', 1000); 
			}
		} else {
			if (i == 0 && timerRemaining <= 0) {
				
				document.getElementById("timer").textContent='0';
				document.getElementById("timer1").value='0';
				document.getElementById("timerRemaining").textContent='0';
				document.getElementById("timerRemaining1").value='0';
				
				setTimeout('Redirect()', 100); 
				
			} else if (i > 0) {
				
				${timerStart = ''+(timerDisplay-1)}
				document.getElementById("timer").textContent=i;
				document.getElementById("timer1").value=i;
				setTimeout('UpdateTimer('+(i-1)+')', 1000); 
				
			} else {
				document.getElementById("defaultTimer").style.opacity = 0.4; 
				document.getElementById("timer").style.opacity = 0.4; 
				document.getElementById("defaultTimer").style.color = "#000";
				document.getElementById("timer").style.color = "#000";
				document.getElementById("reserve").style.opacity = 1.0;
				document.getElementById("timerRemaining").style.opacity = 1.0;
				document.getElementById("reserve").style.color = "#33cc33";
				document.getElementById("timerRemaining").style.color = "#33cc33";
				timerRemaining=timerRemaining-1;
				document.getElementById("timer").textContent=i;
				document.getElementById("timer1").value=i;
				document.getElementById("timerRemaining").textContent=timerRemaining;
				document.getElementById("timerRemaining1").value=timerRemaining;
				setTimeout('UpdateTimer(0)', 1000); 
			}
		}
		
	}
	
	function checkAnswer(button,userAnswer,answer) { 
		document.getElementById("ans1").disabled = true;
		document.getElementById("ans2").disabled = true;
		document.getElementById("ans3").disabled = true;
		document.getElementById("ans4").disabled = true;
		document.getElementById("ans5").disabled = true;
		button.disabled = false;
		if (userAnswer == answer) {
			// Make the button green
			document.getElementById("testing").style.color = "#33cc33";
			document.getElementById("testing").innerHTML= "Well done, correct!";
			document.getElementById("result").style.color = "#33cc33";
			document.getElementById("result").innerHTML = userAnswer;
			button.style.background = "#33cc33";
			
		} else {
			// Make the button red
			document.getElementById("testing").style.color ="red";
			document.getElementById("testing").innerHTML= "Oops, wrong!";
			document.getElementById("result").style.color ="red";
			document.getElementById("result").innerHTML = userAnswer;
			
			button.style.background = "red";
			
		}
	}
	
	 setTimeout("UpdateTimer(${timerStart})", 1000); 
</script>
<title>English Page</title>
<style>
html,
body,
header,
 #intro{
 background: url("/images/giphy4.gif")no-repeat center center fixed;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
     color: white;
}

h1, h2, h3, h4{
	font-family: "Comic Sans MS","Comic Sans", cursive;
    display: inline;
}
form {
    margin-left: 25%;
    margin-right:25%;
    width: 50%;
}
form {
    display: inline-block;
    text-align: center;
    font-size:40px;
    
}


 #timer {color: #33cc33;
 }
 #defaultTimer{ color: #33cc33;
 }
 #reserve{ color: white;
 			opacity:0.4;
 }
 #timerRemaining{ color: white;
 				opacity: 0.4;
 }

</style>
</head>
<body onload="setTimeout(RemoveButtons(), 1000)">
<nav class="navbar navbar-inverse navbar-static-top" style="margin-bottom:0px;" role="navigation">
      <div class="container">
      
	        <div class="navbar-header">
	          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	          </button>
	          <a class="navbar-brand" href="/"><span class="glyphicon glyphicon-home"></span> TOPMARKS EDUCATION</a>
	        </div>
	        
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active">
            	<a href="/">Home</a>
            </li>
          <li><a href="/leaderboard/"><span class="glyphicon glyphicon-stats"></span> Leaderboards</a></li>
            
          </ul>
          
          <ul class="nav navbar-nav navbar-right">
	          <li>
	          	<a href="#" data-toggle="modal" data-target="#logoutModal"> <span class="glyphicon glyphicon-log-out"></span>Logout</a>
	          </li>
          </ul>
        </div>
        
      </div>
    </nav>
        <div class="modal" id="logoutModal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">x</span></button>
        <h4>Log Out <i class="fa fa-lock"></i></h4>
      </div>
      <div class="modal-body">
        <p><i class="fa fa-question-circle"></i> Are you sure you want to logout? <br /></p>
        
        <div class="actionsBtns">
            <form:form method="POST" action="/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" name="logout" value="Logout" class="btn btn-primary btn-block"/>
	            <button class="btn btn-default" data-dismiss="modal">Cancel</button>
            </form:form>
        </div>
      </div>
    </div>
  </div>
</div>

           <div id="intro" class="view hm-black-strong">
    
     <table style="width:95%;" align="center">
 	<tr>
 		<td>
 			 <div align="left">
				<h2 id="defaultTimer">Time Remaining: </h2>
				<h2 id="timer">${timerDisplay}</h2><br>
				<h2>Score: ${score}</h2>
			</div>
 		</td>
 		<td>
 			 <div align="right">
				<h2 id="reserve"style="position:relative;left:0px;top:-10px;" >Bonus Time: </h2>
				<h2 id="timerRemaining" style="position:relative;left:0px;top:-10px;">${timerRemaining}</h2>
			</div>
 		</td>
 	</tr>
 </table>

  <div class="container">
  <div class="text-center">
    
    <h2 >Matching game </h2>
  </div>

<div style="position:relative;left:0px;top:-200px;"> 

 <form:form method= "POST" commandName="EnglishQuestionPair" action="/english/answer" style= "padding-top:90px;">
     <input id="timer1" name="timer" type="text" value="${timerDisplay}" style="visibility: hidden;"/>
	<input id="timerRemaining1" name="timerRemaining" type="text" value="${timerRemaining}" style="visibility: hidden;"/>
    
     <table align="center">
		<tr><td><p> </p></td></tr>
	<h4>${title} Question: ${questionNum}/4</h4>
	<tr><td><h3>What is this </h3><h3 id="result"> ? </h3><h3 id="testing"></h3>
	<br></td></tr>
	   <img src="/img/English/${name}" alt="Error. Could not load ${name}" style="width:200px;height:200px;">
	     
     </table>
  
     
     <table align="center" >
     	<tr>
     		<td><input type="submit" id="ans1" value="${ans1}" name="ans1" onClick="checkAnswer(ans1,${ans1},${answer})" class="btn btn-default" style="width:80px; height:60px;position:relative;left:30px;top:2px"></td>
	     	<td><input type="submit" id="ans2" value="${ans2}" name="ans2" onClick="checkAnswer(ans2,${ans2},${answer})" class="btn btn-default" style="width:80px; height:60px; position:relative;left:30px;top:2px"></td>
	     	<td><input type="submit" id="ans3" value="${ans3}" name="ans3" onClick="checkAnswer(ans3,${ans3},${answer})" class="btn btn-default" style="width:80px; height:60px;position:relative;left:30px;top:2px"></td>
	     	<td><input type="submit" id="ans4" value="${ans4}" name="ans4" onClick="checkAnswer(ans4,${ans4},${answer})" class="btn btn-default" style="width:80px; height:60px;position:relative;left:30px;top:2px"></td>
	     	<td><input type="submit" id="ans5" value="${ans5}" name="ans5" onClick="checkAnswer(ans5,${ans5},${answer})" class="btn btn-default" style="width:80px; height:60px;position:relative;left:30px;top:2px"></td>
     	</tr>
   <tr><td><p> </p></td></tr>
   <tr><td><p> </p></td></tr>
     	<tr>
     	<td colspan="2"> <a href = "/"><input type = "button" style="position:relative;left:80px;top:2px;" value = "Exit Game" class="btn btn-default"></a></td>
     	</tr>
     </table>

</form:form>
        <table align="center">
 	<tr>
 		<td>
 			<div align="center" style="padding-top:30px;">
				<h3 id="testing"></h3>
			</div>
 			
 		</td>
 	</tr>
 </table>
</div>
</div>
</div>

</body>
</html>