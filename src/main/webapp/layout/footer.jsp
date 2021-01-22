<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<spring:url value="/resources" var="resourceurl" />
<!-- Style working for Footer only -->
<link rel="styleSheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
<!-- End -->
<style>

.modal {
    display:    none;
   
    top:        0;
    left:       0;
    height:     100%;
    width:      100%;
    background: rgba( 255, 255, 255, .8 ) 
                url('http://i.stack.imgur.com/FhHRx.gif') 
                50% 50% 
                no-repeat;
}

/* When the body has the loading class, we turn
   the scrollbar off with overflow:hidden */
body.loading .modal {
    overflow: hidden;   
}

/* Anytime the body has the loading class, our
   modal element will be visible */
body.loading .modal {
    display: block;
}

</style>

<div id="footer" style="background-color: #cfb000;">
 <b style="color:white;">&copy; 2020 &nbsp;<spring:message code="footer.footnote" text="Department of Agriculture, Government of Uttar Pradesh. All Rights Reserved."/></b>
		
</div>
	<noscript><meta http-equiv = "refresh" content = "0; url = ${pageContext.request.contextPath}/invalid_script"/></noscript>
	<!-- Style Sheets and JS file used for after login pages -->
	<script src="${resourceurl}/js/jquery.min.js"></script>
    <script src="${resourceurl}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${resourceurl}/assets/js/jquery.metisMenu.js"></script>
  	<script type="text/javascript" src="${resourceurl}/assets/js/Lightweight-Chart/jquery.chart.js"></script>
    <script type="text/javascript" src="${resourceurl}/assets/js/custom-scripts.js"></script>
    <script type="text/javascript" src="${resourceurl}/assets/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${resourceurl}/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${resourceurl}/assets/css/font-awesome.css"/>
   
    <!-- End -->
<div class="modal"></div>
 <div class="covers"></div> 
</body>

<script>
$body = $("body");
$(document).on({
     ajaxStart: function() { $body.addClass("loading");    },
     ajaxStop: function() { $body.removeClass("loading"); }
});
</script>

</html>
