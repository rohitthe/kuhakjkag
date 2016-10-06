<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
  #new11{
  margin-top: 40px;
  
  }
  </style>
</head>
<body>
<div class="bg-1">
  <div class="container text-center">
    <h3>Jenkins Configuration</h3>
    <img src="image/jenkins.jpg" class="img-circle" alt="Bird" width="350" height="350">
    <h3>Jenkins</h3>
  </div>
</div>
<div id="new11" align="center">
<f:view>
<h:form>
<h:panelGrid columns="2" border="1" styleClass="formdiv" bgcolor="red">
  <h:outputLabel>Job Name to be delete</h:outputLabel>
  <h:inputText id="rohit" value="#{delete.jobNamedeleted}"></h:inputText>
  <h:outputLabel>enter job url</h:outputLabel>
  <h:inputText id="rohit1" value="#{delete.joburl}"></h:inputText>
    </h:panelGrid>
  <h:panelGrid columns="2" border="2" styleClass="formdiv" bgcolor="red">
  
  <h:commandButton value="submit" action="#{delete.delete}" styleClass="formdiv"></h:commandButton>
  <h:commandButton value="back" action="body.jsp" styleClass="formdiv"></h:commandButton>
   </h:panelGrid>
</h:form>
</f:view>
</div>
</body>
</html>