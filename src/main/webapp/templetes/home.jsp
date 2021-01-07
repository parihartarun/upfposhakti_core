<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/assets" var="resourceurl" />
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta content="" name="description" />
<title>UP FPO Shakti</title>
<%-- <link href="${resourceurl}/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="${resourceurl}/css/custom-styles.css" rel="stylesheet" type='text/css'/>
<link href="${resourceurl}/font-awesome/fonts/fonts.css" rel='stylesheet' type='text/css' />
<script type="text/javascript"  src="${resourceurl}/js/jquery.min.js"></script>
<script type="text/javascript"  src="${resourceurl}/js/bootstrap.min.js"></script> --%>
</head>

<body>

<section class="fms-wrapper" style="background-color: #cfb000;
background-image: linear-gradient(#fbd70f, #735d17,#4a3c0f);
height: 243px;">
<tiles:insertAttribute name="header"/>

<tiles:insertAttribute name="body"/>

<tiles:insertAttribute name="footer"/>
</section>


<!--  <script type="text/javascript">
        function noBack()
         {
             window.history.forward()
         }
        noBack();
        window.onload = noBack;
        window.onpageshow = function(evt) { if (evt.persisted) noBack() }
        window.onunload = function() { void (0) }
    </script> 
 -->
</body>
</html>