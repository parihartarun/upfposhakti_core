<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/assets" var="resourceurl" />
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="UP FPO Shakti">
<meta name="keywords" content="FPO, UP FPO Shakti, FPO Empowerment,">
<title>UP FPO Shakti</title>
<!-- New Design Files -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700;900&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="http://www.shieldui.com/shared/components/latest/css/light/all.min.css" />
<link href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${resourceurl}/newdesign/css/custom.css" />
<script>
	function getURL(e) {

		var url = location.href;

		var fin = url.substring(0, url.indexOf("?"));

		if (e == "en") {
			fin += '?lang=en';
			$("#lang_en").attr("href", fin);
		} else {
			fin += '?lang=hi';
			$("#lang_hi").attr("href", fin);
		}
	}
</script>
</head>
<body>
	<!-- New design part -->

	<div class="header">
	
		<div class="text-center" >
			<span class="parent"><spring:message code="home.header" text="UP FPO Shakti"/></span>
			</br>
			<span class="child"><spring:message code="home.sub.header" text="Sangathan.Satark.Shakti"/>
			</span>
			</div>
			
			<div style="margin-left: 140px; margin-top: -45px;">
			<span class="gov"><spring:message code="home.upgovt" text="Agriculture Department,"/></span>
			</br>
			<span class="up"><spring:message code="home.up" text="Uttar Pradesh"/> </span>
			
			</div>  
			
		
			<!-- Commented on 29th December 2020 by Prashant -->
			<%-- <span class="upag">
			<spring:message code="home.deptheader" text="Agriculture Department, Uttar Pradesh" /></span> --%>
		
	</div>
	
	

	<div class="innerContent">
		<!--Manu start-->

		<nav class="navbar navbar-default">
			<div class="">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bsnavbar-collapse"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="${pageContext.request.contextPath}/"> <img
						src="${resourceurl}/newdesign/img/logo.png" alt="logo"
						 style="border-radius: 58px 58px 58px 58px;height: 120px;margin-top: -75px;position: absolute;margin-left: -9px;z-index: 10000;border: 5px solid #C7A100;min-width: 0;">
					</a>
					
				</div>
				<div class="collapse navbar-collapse" id="bsnavbar-collapse">
					<ul class="nav navbar-nav">

						<li class="nav-item dropdown">
							<div class="triangle-topright"></div> <a
							class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">
								<img
								src="${resourceurl}/newdesign/img/language.png"
								style="height: 30px;" alt="logo" /> <spring:message code="app.lang"
									text="Language" />
									<img
                                        src="${resourceurl}/newdesign/img/arrodwon.png" alt="logo" style="height: 12px;"/>
						</a>
							<ul class="dropdown-menu" style="top: 50px;background: #cdae01;">
								<li><a id="lang_en" class="dropdown-item" href=""
									onclick="getURL('en');">English</a></li>
								<li><a id="lang_hi" class="dropdown-item" href=""
									onclick="getURL('hi');"><spring:message
											code="app.lang.hindi" text="Hindi" /></a></li>
							</ul>
						</li>
						<li><a href="${pageContext.request.contextPath}/downloads1">
						<img src="${resourceurl}/newdesign/img/fpomenu.png" alt="logo" style="height: 30px;"> <spring:message
									code="home.tabfpoguidelines" text="FPO Guidelines" /> </a></li>
						<li><a href="${pageContext.request.contextPath}/downloads">
								<img src="${resourceurl}/newdesign/img/scemenu.png" alt="logo" style="height: 30px;"/> <spring:message
									code="home.scheme" text="Schemes" />
						</a></li>
						<li><a href="${pageContext.request.contextPath}/getLogin">
						<img src="${resourceurl}/newdesign/img/signup.png" alt="logo" style="height: 30px;"/>
						<spring:message code="home.login" text="Login" />
						</a>
						</li>
						<li class="nav-item dropdown">
						<a  class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">
						<img src="${resourceurl}/newdesign/img/usermenu.png" alt="logo" style="height: 30px;"/>
							<spring:message	code="home.register" text="Sign Up" />
							<img src="${resourceurl}/newdesign/img/arrodwon.png" alt="logo" style="height: 12px;"/>
							</a>
							<ul class="dropdown-menu" style="background: #cdae01;">
							 	<li><a class="dropdown-item" href="${pageContext.request.contextPath}/fpo"><b><spring:message code="home.fporeg" text="FPO" /></b></a></li>
							 	<li><a class="dropdown-item" href="${pageContext.request.contextPath}/farmer"><b><spring:message code="home.farmers" text="Farmers" /></b></a></li>
								<li><a class="dropdown-item" href="#"><spring:message code="home.buyer" text="Buyer/ Seller" /></a></li>
								<li><a class="dropdown-item" href="#"><spring:message code="home.lab" text="Input Supplier" /></a></li>
								<li><a class="dropdown-item" href="#"><spring:message code="home.renter" text="Equipment Centre" /></a></li>
								
							</ul> </li>
					</ul>
				</div>
			</div>
		</nav>

</body>

</html>
