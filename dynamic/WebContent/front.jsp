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
<style>
 body {
      font: 400 15px/1.8 Lato, sans-serif;
      color: #777;
      background: #2d2d30;
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
.bg-1 p {font-style: italic;}
</style>

</head>
<body>
<br>

<div  class="container-fluid bg-1 text-center">
<div id="heading1">INFOSYS SDP</div>

<!-- <div class="img">
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
</div> -->
<p id="new1">Service Delivery Platform</p>
<div id="new">

<br><b>
Configure And Manage DevOPs Tool</b> 
<br>
<br>

</div>
</div>

<div class="container">
  <div class="row">
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
<footer class="container-fluid text-center">
 
    <span class="glyphicon glyphicon-chevron-up"></span>
 
  <p>Made By <a title="Visit Infosys">Infosys..</a></p>
</footer>

</body>
</html>