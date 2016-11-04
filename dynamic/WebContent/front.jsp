<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
<link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/modern-business.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<style>
 body {
      font: 400 15px/1.8 Lato, sans-serif;
      color: #777;
      background: #D3D3D3;
  }
div.img {
    margin: 5px;
    border: 1px solid #ccc;
    float: left;
    width: 180px;
}

div.img:hover {
    border: 1px solid #777;
}

div.img img {
    width: 100%;
    height: auto;
}

div.desc {
    padding: 15px;
    text-align: center;
}
div.heading {
    text-align: center;
    background-color: #ffe4b2;
}
#heading1{
font-size: 100px;

margin-top: 0px;
color: #000 !important;
background-color: #ffe4b2;
}

#new{

font-family: serif;
text-align: center;
background-color:#C6FFFF;
font-size:25px;
margin-bottom: 70px;
}
#new1{
font-size: 20px;
font-family: serif;
text-align: center;


background-color: #ffe4b2;
}
#new2{
background-color: #ffe4b2;
}
#xa{
margin-left: 70px;
}
#myCarousel{
margin-left:150px;
width:75%;
height: 25%;
}
.bg-1 p {font-style: italic;}
</style>

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Service Delivery Platform </a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="#">About</a>
                    </li>
                    <li>
                        <a href="#">Services</a>
                    </li>
                    <li>
                        <a href="#">Contact</a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Pipeline <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#">Source Code Management</a>
                            </li>
                            <li>
                                <a href="#l">Deployment Management</a>
                            </li>
                            <li>
                                <a href="#">Build Management</a>
                            </li>
                            
                        </ul>
                    </li>
                    
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Other Tools <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#">Nagios (& Icinga) </a>
                            </li>
                            <li>
                                <a href="#">Monit</a>
                            </li>
                            <li>
                                <a href="#">Consul</a>
                            </li>
                            <li>
                                <a href="#">Docker</a>
                            </li>
                            <li>
                                <a href="#">Ansible</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    
    <header id="myCarousel" class="carousel slide">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" >
            <div class="item active">
                <div class="fill"  style="background-image:url(image/newj.png);"></div>
                <div class="carousel-caption">
                    <h2><font color="black"> Jenkins</font></h2>
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url(image/gm.png);"></div>
                <div class="carousel-caption">
                    <h2>GIT</h2>
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url(image/jim.png);"></div>
                <div class="carousel-caption">
                    <h2>Jira</h2>
                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a>
    </header>
<br>

<!-- <div  class="container-fluid bg-1 text-center">
<div id="heading1">INFOSYS SDP</div>

<div class="img">
  <a target="_self" href="body.jsp">
    <img src="image/jenkins.jpg" alt="Trolltunga Norway" width="300" height="200">
  </a>
  <div class="desc">Click Here for jenkins configuration</div>
</div>

<div class="img">
  <a target="_blank" href="#">
    <img src="image/git.png" alt="Forest" width="600" height="400">
  </a>
  <div class="desc">Click Here for jenkins configuration</div>
</div>
<p id="new1">Service Delivery Platform</p>
<div id="new">

<br><b>
Configure And Manage DevOPs Tool</b> 
<br>
<br>

</div>
</div> -->

<div class="container">
  <div class="row">
            <div class="col-lg-12">
                <CENTER><h1 class="page-header">
                    Infosys SDP
                </h1></CENTER>
            </div>
    <div class="col-sm-4">
    <div id="xa" class="btn btn-primary">
      <a target="_self" href="body.jsp">
    <img class="img-circle" src="image/jenkins.jpg" alt="Trolltunga Norway" width="100" height="100" align="center" >
  </a>
  <div class="desc">Click Here for jenkins configuration &nbsp&nbsp</div>
  </div>
  
    </div>
    <div class="col-sm-4">
    <div id="xa"  class="btn btn-primary" >
      <a target="_self" href="gitbody.jsp">
    <img class="img-rounded" src="image/git.png" alt="Forest" width="100" height="100" align="center" >
  </a>
  <div class="desc">Click Here for git configuration &nbsp &nbsp &nbsp &nbsp &nbsp</div>
  </div>
  
  
    </div>
    <div class="col-sm-4" >
    <div id="xa" class="btn btn-primary">
      <a target="_self" href="JiraBody.jsp">
    <img class="img-rounded" src="image/jira.png" alt="Trolltunga Norway" width="100" height="100" align="center">
  </a>
  <div class="desc">Click Here for jira configuration &nbsp &nbsp &nbsp &nbsp</div>
  </div>
  
  </div>
  </div>
  <br>
  <br>
  <div class="row">
    <div class="col-sm-4">
    <div id="xa"  class="btn btn-primary">
      <a target="_self" href="TeamCityBody.jsp">
    <img class="img-rounded"  src="image/download.png" alt="Forest" width="100" height="100" align="center">
  </a>
  <div class="desc">Click Here for Teamcity configuration</div>
  </div>
  
  
  
  
  
    </div>
      <div class="col-sm-4" >
      <div id="xa" class="btn btn-primary">
      <a target="_self" href="BambooBody.jsp">
    <img src="image/bamboo.png"  class="img-rounded"  alt="Forest" width="100" height="100" align="center">
  </a>
  <div class="desc">Click Here for Bamboo configuration</div>
  </div>
  
    </div>
      <div class="col-sm-4">
      <div id="xa" class="btn btn-primary">
      <a target="_self" href="UdeployBody.jsp">
      
    <img  class="img-rounded" src="image/udeploy.jpg" alt="Forest" width="100" height="100" align="center">
  </a>
  <div class="desc">Click Here for Udeploy configuration</div>
  </div>
  
  </div> 
  </div>
</div>
<br>
<br>
<hr>

        <!-- Call to Action Section -->
        <div class="well">
            <div class="row">
                <div class="col-md-8">
                    <p>Infosys DevOps provides an integrated solution to address the various concerns raised by different groups; by bringing in synergy across the 3 key aspects - people, process and technology. It encompasses technology innovation for no-touch automation along with progressive people and process transformation</p>
                </div>
                <div class="col-md-4">
                    <a class="btn btn-lg btn-default btn-block" href="#">Call to Action</a>
                </div>
            </div>
        </div>

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Infosys</p>
                </div>
            </div>
        </footer>
<footer class="container-fluid text-center">
 
    <span class="glyphicon glyphicon-chevron-up"></span>
 
  <p>Made By <a title="Visit Infosys" href="#">Infosys..</a></p>
</footer>

</body>
</html>