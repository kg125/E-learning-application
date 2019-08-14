<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hangman</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Material Design Bootstrap -->
    <link href="css/mdb.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/hangmanGame.js"></script>
<script type="text/javascript">
window.onload = function (){
	var alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
		        'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
		        't', 'u', 'v', 'w', 'x', 'y', 'z'];
		  
		  var categories;         // Array of topics
		  var chosenCategory;     // Selected catagory
		  var getHint ;          // Word getHint
		  var word ;              // Selected word
		  var guess ;             // Geuss
		  var geusses = [ ];      // Stored geusses
		  var lives ;             // Lives
		  var counter ;           // Count correct geusses
		  var space;  // Number of spaces in word '-'
		var score;
		  // Get elements
		  var showLives = document.getElementById("mylives");
		  var showScore = document.getElementById("myScore");

		  var showCatagory = document.getElementById("scatagory");
		  var getHint = document.getElementById("hint");
		  var showClue = document.getElementById("clue");



		  // create alphabet ul
		  var buttons = function () {
		    myButtons = document.getElementById('buttons');
		    letters = document.createElement('ul');

		    for (var i = 0; i < alphabet.length; i++) {
		      letters.id = 'alphabet';
		      list = document.createElement('li');
		      list.id = 'letter';
		      list.innerHTML = alphabet[i];
		      check();
		      myButtons.appendChild(letters);
		      letters.appendChild(list);
		    }
		  }
		    
		  
		  // Select Catagory
		  var selectCat = function () {
		    if (chosenCategory === categories[0]) {
		      catagoryName.innerHTML = "The Chosen Category Is Shapes";
		    } else if (chosenCategory === categories[1]) {
		      catagoryName.innerHTML = "The Chosen Category Is animails";
		    } else if (chosenCategory === categories[2]) {
		      catagoryName.innerHTML = "The Chosen Category Is colours";
		    }
		  }

		
		   result = function () {
		    wordHolder = document.getElementById('hold');
		    correct = document.createElement('ul');
		   

		    for (var i = 0; i < word.length; i++) {
		      correct.setAttribute('id', 'my-word');
		      guess = document.createElement('li');
		      guess.setAttribute('class', 'guess');
		      if (word[i] === "-") {
		        guess.innerHTML = "-";
		        space = 1;
		         
		      } else {
		        guess.innerHTML = "_";
		      }

		      geusses.push(guess);
		      wordHolder.appendChild(correct);
		      correct.appendChild(guess);

		    }
		  }
		  
		  // Show lives
		   comments = function () {
		    showLives.innerHTML = "You have " + lives + " lives";
		    if (lives < 1) {
		      showLives.innerHTML = "Game Over";
		    }
		    for (var i = 0; i < geusses.length; i++) {
		      if (counter + space === geusses.length) {
		        showLives.innerHTML = "You Win!";
		      }
		    }
		  }

		      // Animate man
		  var animate = function () {
		    var drawMe = lives ;
		    drawArray[drawMe]();
		  }

		  
		   // Hangman
		  canvas =  function(){

		    myStickman = document.getElementById("stickman");
		    context = myStickman.getContext('2d');
		    context.beginPath();
		    context.strokeStyle = "#fff";
		    context.lineWidth = 2;
		  };
		  
		    head = function(){
		      myStickman = document.getElementById("stickman");
		      context = myStickman.getContext('2d');
		      context.beginPath();
		      context.arc(60, 25, 10, 0, Math.PI*2, true);
		      context.stroke();
		    }
		    
		  draw = function($pathFromx, $pathFromy, $pathTox, $pathToy) {
		    
		    context.moveTo($pathFromx, $pathFromy);
		    context.lineTo($pathTox, $pathToy);
		    context.stroke(); 
		}

		   frame1 = function() {
		     draw (0, 150, 150, 150);
		   };
		   
		   frame2 = function() {
		     draw (10, 0, 10, 600);
		   };
		  
		   frame3 = function() {
		     draw (0, 5, 70, 5);
		   };
		  
		   frame4 = function() {
		     draw (60, 5, 60, 15);
		   };
		  
		   torso = function() {
		     draw (60, 36, 60, 70);
		   };
		  
		   rightArm = function() {
		     draw (60, 46, 100, 50);
		   };
		  
		   leftArm = function() {
		     draw (60, 46, 20, 50);
		   };
		  
		   rightLeg = function() {
		     draw (60, 70, 100, 100);
		   };
		  
		   leftLeg = function() {
		     draw (60, 70, 20, 100);
		   };
		  
		  drawArray = [rightLeg, leftLeg, rightArm, leftArm,  torso,  head, frame4, frame3, frame2, frame1]; 


		  // OnClick Function
		   check = function () {
		    list.onclick = function () {
		      var geuss = (this.innerHTML);
		      this.setAttribute("class", "active");
		      this.onclick = null;
		      for (var i = 0; i < word.length; i++) {
		        if (word[i] === geuss) {
		          geusses[i].innerHTML = geuss;
		          counter += 1;
		        } 
		      }
		      var j = (word.indexOf(geuss));
		      if (j === -1) {
		        lives -= 1;
		        comments();
		        animate();
		      } else {
		        comments();
		      }
		    }
		  }
		  
		    
		  // Play
		  play = function () {
		    categories = [
		        ["trinagle", "square", "circle", "cylinder", "rectangle", "pentagon", "hexagon"],
		        ["cat", "dog", "rabbit", "fish", "octopus", "bears","zebra","horse" , "lion" ],
		        ["red", "blue", "pink", "yellow", "black", "white","green", "orange","purple"]
		    ];

		    chosenCategory = categories[Math.floor(Math.random() * categories.length)];
		    word = chosenCategory[Math.floor(Math.random() * chosenCategory.length)];
		    word = word.replace(/\s/g, "-");
		    console.log(word);
		    buttons();

		    geusses = [ ];
		    lives = 10;
		    counter = 0;
		    space = 0;
		    result();
		    comments();
		    selectCat();
		    canvas();
		  }

		  play();
		  
		  // Hint

		    hint.onclick = function() {

		      hints = [
		        [" 3 Sided Shape", "4 equal sides", "has infinite sides ", "same shape as a straw", "2 parallel sides", "5 sided shape", "6 sided shape"],
		        ["who is Garfield", "A mans best friend ", "bugs bunny "," finding nemo ", "releases ink when scared ", "brother bear","black and white at the same time","ride with a sadle" , "simba"],
		        ["colour of blood", "colour of the sky", "girls favorite colour","thunder bolt", "Darkness", "colour of paper", "Grass", "same as a fruit", "barney the dinosaur" ]
		    ];

		    var catagoryIndex = categories.indexOf(chosenCategory);
		    var hintIndex = chosenCategory.indexOf(word);
		    showClue.innerHTML = "Clue: - " +  hints [catagoryIndex][hintIndex];
		  };

		   // Reset the keyword that has been spelled out

		  document.getElementById('reset').onclick = function() {
		    correct.parentNode.removeChild(correct);
		    letters.parentNode.removeChild(letters);
		    showClue.innerHTML = "";
		    context.clearRect(0, 0, 400, 400);
		    play();
		  }
		}




</script>
<style>

@mixin transition {
  -webkit-transition: all 0.5s ease-in-out;
  -moz-transition: all 0.5s ease-in-out;
  transition: all 0.5s ease-in-out;
}

@mixin clear {
  &:after {
      content: "";
      display: table;
      clear: both;
    }
}

 @mixin box-size {
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
}

 @mixin transition {
  -webkit-transition: all 0.3s ease-in-out;
  -moz-transition: all 0.3s ease-in-out;
  transition: all 0.3s ease-in-out;
}

@mixin fade {
  -moz-transition: all 1s ease-in;
  -moz-transition:all 0.3s ease-in-out;
  -webkit-transition:all 0.3s ease-in-out;
}

@mixin opacity {
  opacity:0.4;
  filter:alpha(opacity=40); 
  @include fade;
}

@mixin corners ($radius) {
  -moz-border-radius: $radius;
  -webkit-border-radius: $radius;
  border-radius: $radius; 
  -khtml-border-radius: $radius; 
}

body {

  height:100%;
  text-align:center;
  font-size:18px;
}

.wrappper{
  
  width:100%;
  margin:0 auto;
  
}


canvas{
  color:#FFFFFF;
  border: #FFFFFF dashed 2px;
  padding:15px;
  align:center
}

h1, h2, h3 {
	font-family: 'Roboto', sans-serif;
	font-weight: 100;
	text-transform: uppercase;
   margin:5px 0;
}

h1 {
	font-size: 2.6em;
	  color:white;
	
}

h2 {
	font-size: 1.6em;
	  color:white;
	
}

p{
  font-size: 1.6em;
    color:white;
  
}
form {
    margin-left: 25%;
    margin-right:25%;
    width: 50%;
}
form {
    display: inline-block;
    text-align: center;
    color:white;
}

#alphabet {
 @include clear;
  margin:15px auto;
  padding:0;
  max-width:900px;
}

#alphabet li {
  float:left;
  margin: 0 10px 10px 0;
  list-style:none;
  width:35px;
  height:30px;
  padding-top:10px;
  
  color:white;
  cursor:pointer;
  
    
  
}

#my-word {
  margin: 0;
  display: block;
  padding: 0;
  display:block;
    color:white;
   
  
}

#my-word li {
  position: relative;
  list-style: none;
  margin: 0;
  display: inline-block;
  padding: 0 10px;
  font-size:1.6em;
    color:white;
  
   
  
  
}

.active {
  
  cursor:default;
    
  
}

#mylives{

  font-size:1.6em;
  text-align:center;
  display:block;
    color:white;
    
   
  
}

button{
  
  background:green;
  color:#FFFFFF;
  border: solid 1px #FFFFFF;
  text-decoration:none;
  cursor:pointer;
  font-size:1.2em;
  padding:18px 10px;
  width:180px;
  margin: 10px;
  outline: none;
  
   
}

@media (max-width: 767px) {
  #alphabet {
  padding:0 0 0 15px;
}
  }

  @media (max-width: 480px) {
  #alphabet {
  padding:0 0 0 25px;
}
  }
  html, body, header, #intro {
	height: 100%;
}

#intro {
	background: url("/images/space2.gif" ) no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	font-family: "Comic Sans MS", "Comic Sans", cursive;
}
.wrapper2 {
  
  
}
#button1{
 background:green;
  color:#FFFFFF;
  border: solid 1px #FFFFFF;
  text-decoration:none;
  cursor:pointer;
  font-size:1.2em;
  padding:18px 10px;
  width:180px;
  margin: 10px;
  outline: none;

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
  <div id="intro" class="view hm-black-strong" style="position: relative; left: 0px; top: -10px; height: 1000px;">
<div class="wrapper">
   <h1>Hangman</h1>
    <h2>TOPMARKS Hangman Game</h2>
    <p>Use the alphabet below to guess the word, or click hint to get a clue. </p>
     <p id="mylives"></p>
</div>
   <form> 
    <p id="catagoryName"></p>
    
    </form>
    
<div>
<div id = hold>
    </div>
    <div id="buttons" >
    </div> 

   
    
     <canvas id="stickman"style="position:relative;top:104px; left:-750px;" >This Text will show if the Browser does NOT support HTML5 Canvas tag</canvas>
    <div class="container" style="position:relative;top:104px;" >
    <p id="clue" >Clue -</p>  
      <button id="hint">Hint</button>
      <button id="reset">Play again</button>
      <a href = "/main/" id="button1" >Exit Game</a>
    </div>
    

</div>



<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="js/mdb.min.js"></script>

	
</body>
</html>