<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="style.css" media="screen" rel="stylesheet">
</head>
<body>
	<f:view>
		<h:form>
			<center>
		        <h:form>
                      <h:panelGrid columns="2"  border="1" styleClass="formdiv" bgcolor="red">
                      <h:outputLabel>Enter github project url</h:outputLabel>
                      <h:inputText id="rohit" value="#{rohit.REMOTE_URL}"></h:inputText>
                       <h:outputLabel>Enter github project name</h:outputLabel>
                      <h:inputText id="rohit1" value="#{rohit.projectname}"></h:inputText>
  <h:commandButton value="submit" action="#{rohit.call}" styleClass="formdiv"></h:commandButton>
  </h:panelGrid>
</h:form>
			</center>
		</h:form>
	</f:view>
</body>
</html>