<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <!-- Theme Made By www.w3schools.com - No Copyright -->
  <title>Bootstrap Theme Simply Me</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  .bg-1 {
      background-color: #1abc9c;
      color: #ffffff;
  }
  #table1{
  margin-top: 40px;
  font-size: 20px;
  }
  </style>
</head>

<body>
<div class="bg-1">
  <div class="container text-center">
    <h3>Team City Configuration</h3>
    <img src="image/download.png" class="img-circle" alt="Bird" width="350" height="350">
    <h3>Team City</h3>
  </div>
</div>
<div id="table1" align="center">
<f:view>
<h:form>
<h:panelGrid border="1" bgcolor="red" styleClass="formdiv" columns="4">
<h:commandButton value="Create Project" action="create"></h:commandButton>
<h:commandButton value="Build Agent" action="delete"></h:commandButton>
<h:commandButton value="Build Step" action="start"></h:commandButton>

</h:panelGrid>
<br>
<br>
<br>
<h:panelGrid columns="1" border="2" styleClass="formdiv" bgcolor="red">
  
   <h:commandButton value="back" action="front.jsp" styleClass="formdiv"></h:commandButton>
   </h:panelGrid>
</h:form>
</f:view>
</div>
</body>
</html>