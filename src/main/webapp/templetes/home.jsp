<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/assets" var="resourceurl" />
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta content="" name="description" />
<title>UP FPO Shakti</title>
</head>
<body>
<section class="fms-wrapper" style="background-color: #cfb000;
background-image: linear-gradient(#fbd70f, #735d17,#4a3c0f);
height: 243px;">
<tiles:insertAttribute name="header"/>

<tiles:insertAttribute name="body"/>

<tiles:insertAttribute name="footer"/>
</section>


</html>