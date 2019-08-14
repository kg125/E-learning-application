<!DOCTYPE HTML>
<%@page import="eduWebApp.controllers.indexValidator"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Top-Marks Education</title>
   
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Material Design Bootstrap -->
    <link href="css/mdb.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
     <style type="text/css" >
 
html,
body,
header,
#intro {
    height: 100%;
}
 
 #intro{
 background: url("/images/YO_Monkey.gif")no-repeat center center fixed;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
}
 #intro2{
 background: url("/images/landing3.png")no-repeat center center fixed;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
}

</style>
    
</head>
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
    <!-- Start your project here-->
     <div id="intro" "class="view hm-black-strong">
   <div style="position:relative;left:0px;top:200px;"> 
   
    <div class="container-fluid full-bg-img d-flex 
     justify-content-center align-items-center">
     <div class="row d-flex justify-content-center">
     

            <div class="col-md-12 text-center">
    
    <!-- Heading -->
    <h2 class="display-3 font-bold white-text mb-2">TOPMARKS EDUCATION</h2>
    <!-- Divider -->
    <hr class="hr-light">
    <!-- Description -->
    <h4 class="white-text my-4">Amazing Intercative e-learning for Schoolers</h4>
    <a role ="button" href="/guest"  class="btn btn-outline-white">Play As Guest<i class="fa fa-gamepad ml-4"></i></a>
</div>
</div>
</div>
</div>
</div>

	

     <div id="intro2" "class="view hm-black-strong">

<main class="mt-5">
 <!--Section: Contact-->
            <div class="container">

   
      <section id="About">

     <!-- Heading -->
       <center> <h2 class="mb-5 font-weight-bold">About us </h2></center>
       
       <div class="row d-flex justify-content-center mb-4">

          <!--Grid column-->
          <div class="col-md-12">

            <!-- Description -->
           <center><p class="white-text">Help ignite your child's passion for learning with our suite of teacher created and kid tested games. 
            From numeracy questions and sight words to fractions and typing, our games are designed to both teach and entertain your child no matter where they're at in their educational journey. Your child will love the vibrant colors and Brainzy characters,
            and you will love watching your child learn and grow!</p></center>

          </div>
          <!--Grid column-->

        </div>
       

        <!--Grid row-->
        <div class="row" style="position:relative;left:-70px;top:80px; margin-bottom:100px">

          <!--Grid column-->
          <div class="col-md-6 ">

            
<div id="myCarousel">
    <div class="carousel slide">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner z-depth-1-half">
            <div class="item active">
                <img src="/images/aboutus3.jpg" alt="Slide 1" style="width:1200px;height:280px;" />
                <div class="carousel-caption">
                    <h1>Live</h1>
                    <p></p>
                </div>
            </div>

            <div class="item">
                <img src="/images/aboutus2.jpg"  alt="Slide 2" style="width:1200px;height:280px;" />
                <div class="carousel-caption">
                    <h1>Learn </h1>
                    <p></p>
                </div>
            </div>

            <div class="item">
                <img src="/images/aboutus4.jpg" alt="Slide 3" style="width:1200px;height:280px;" />
                <div class="carousel-caption">
                    <h1> Play </h1>
                    <p></p>
                </div>
            </div>
</div>
            <!-- Controls -->
            <a class="left carousel-control" href="myCarousel" data-slide="prev" >
                <span class="icon-prev"></span>
            </a>
            <a class="right carousel-control" href="myCarousel" data-slide="next">
                <span class="icon-next"></span>
            </a>
        
    </div>
</div>
          </div>
          <!--Grid column-->

          <!--Grid column-->
          <div class="col-md-6">

            <!--Excerpt-->
            <a href="#" class="teal-text">
              <h6 class="pb-1"><i class="fa fa-heart"></i><strong> Interactive Education  </strong></h6>
            </a>
            <h4 class="mb-3"><strong>Embracing Interactive and Educational Games for Every Young Learner</strong></h4>
            <p>From basic matching and identification skills to reading, writing, typing,
             and maths skills of all kinds, explore our vast collection of educational games geared 
             toward elementary students of all ages and learning levels.</p>

            <p>Your child will love the vibrant colors and wacky characters they'll meet along the way, and you'll love the look of satisfaction on their face as they complete challenges and expand their learning boundaries. 
            The learning never ends when you upgrade to a premium membership which provides access to our full array of interactive games. </p>
            <p>by <a><strong>Kasey Gordon</strong></a>, 20/02/2018</p>
            <a class="btn btn-primary btn-md">Read more</a>

          </div>
          <!--Grid column-->

        </div>
        <!--Grid row-->

      </section>
 <br>
  <br>
 <br>
  <br>
      <section id="Aboutfeatures" class="text-center" style ="position: relative; left: 200px;">

   
        <!--Grid row-->
                <!--Grid row-->
 <br>
  <br>
 
        <!--Grid row-->
        <div class="row">

          <!--Grid column-->
          <!--  <div class="col-md-4 mb-5">
            <i class="fa fa-camera-retro fa-4x blue-text"></i>
            <h4 class="my-4 font-weight-bold"> Student Experience</h4>
            <p class="grey-text">???.</p>
          </div>-->
          <!--Grid column-->

           <div class="col-md-4 mb-1">
            <i class="fa fa-heart fa-4x red-text"></i>
            <h4 class="my-4 font-weight-bold white-text">Trusted by Educators and Parents</h4>
            <p class="white-text">over 50,000 users played our games</p>
          </div>
          <!--Grid column-->

          <!--Grid column-->
          <div class="col-md-4 mb-1">
            <i class="fa fa-bicycle fa-4x blue-text"></i>
            <h4 class="my-4 font-weight-bold white-text">Student Adventure</h4>
            <p class="white-text">An accurate, up-to-the-minute portrait
of each and every student</p>
          </div>
          <!--Grid column-->

        </div>
        <!--Grid row-->

      </section>
<a class="scroll-to-top rounded" href="/"> <i
			class="fas fa-angle-up"></i>
		</a>
        </div>
</main>
</div>
<footer class="page-footer center-on-small-only unique-color-dark pt-0">
<div class="footer-copyright">
            <div class="container-fluid">
                ©Copyright 2018: Final Project
               
            </div>
            </div>
</footer>

<!-- SCRIPTS -->

<script type="text/javascript">
$('.carousel').carousel({
    interval: 3000,
  })
  </script>
  <script type="text/javascript">
  $(function(){
	  $('#myCarousel').carousel();
	})</script>
    <!-- JQuery -->
    <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="../js/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="../js/mdb.min.js"></script>
    
   <script src="../js/jquery-1.7.1.min.js"></script>
<script src="../js/bootstrap.js"></script>
   
 <script>

</script>
    
</body>
</html>
