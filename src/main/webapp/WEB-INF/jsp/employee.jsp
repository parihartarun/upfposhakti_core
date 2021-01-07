<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Boot JSP CRUD</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>

<div class="container">
  <spring:url value="/employee/insert" var="saveURL" />
  <h2>
  Employee
  <spring:url value="/cancelInsertOrUpdate" var="cancelURL" />
  <a class="btn btn-primary" href="${cancelURL}" role="button" >Cancel</a>
  </h2>
  <form:form modelAttribute="employeeForm" method="post" action="${saveURL }" cssClass="form" >
   <form:hidden path="id"/>
   <div class="form-group">
    <label>Name</label>
    <form:input path="name" cssClass="form-control" id="name" />
   </div>
   <div class="form-group">
    <label>Address</label>
    <form:input path="address" cssClass="form-control" id="address" />
   </div>
   <div class="form-group">
    <label>Phone</label>
    <form:input path="phone" cssClass="form-control" id="phone" />
   </div>
   <button type="submit" class="btn btn-primary">Save</button>
  </form:form>
  </div>
	
</body>
</html>