<%@ page contentType="text/html; UTF-8" language="java"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/assets" var="resourceurl" />
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!--Main Contain Start-->
<div class="container-fluid">
	<div class="row">
		<div class="col-md-2 col-sm-12">
			<div class="notificationBox" style="margin-top: 26px;">
				<h4 class="set_notifications">
					<spring:message code="home.noti" text="Notifications" />
				</h4>
				<div class="panel panel-default" style="border: 0px;">
					<div class="panel-body">
						<div class="row">
							<div class="col-xs-12 newsBox">
								<ul class="demo1"
									style="height1: 250px; padding: 0px; list-style-type: none;">
									<c:forEach var="circulars" items="${circulars}"
										varStatus="status">
										<c:if test="${circulars.uploadedBy=='ROLE_MIN'}">
											<c:url var="viewcirculars" value="/viewFile">
												<c:param name="path" value="${circulars.filePath}"></c:param>
											</c:url>
											<li class="news-item" style="">
												<table cellpadding="4">
													<tr>
														<td><img
															src="${resourceurl}/icons/icons8-new-96 (1).png"
															width="20" class="img-circle" /></td>
														<td class="news-td"><a href="${viewcirculars}"
															class="text-left text-danger" target="_blank">${circulars.description}:
																<fmt:formatDate pattern="dd-MMM-yy"
																	value="${circulars.uploadDate}" />

														</a></td>

														<!-- <td class="news-td"></td> -->
													</tr>
												</table>
											</li>
										</c:if>
									</c:forEach>
								</ul>
							<div class="text-right">
							<small style="color:black"><a href="${pageContext.request.contextPath}/viewallnotifications"><spring:message code="home.viewall" text="View all" /></a>&nbsp;</small>
						</div>	
							</div>
							
						</div>
					</div>
				</div>
			</div>





			<!--Notifications End-->


			<!--View FPO's On Map Start-->
			<div style="height: 100px; background-color: #ccc; margin-top: 0%;">
				<h4 class="set_notifications">
					<spring:message code="home.fpomap" text="View FPOs on Map" />
				</h4>
				<a href="${pageContext.request.contextPath}/fpoMap"> <img
					src="${pageContext.request.contextPath}/resources/assets/newdesign/img/map.jpg"
					alt="" class="img-thumbnail mob-width"
					style="height: 128px; width: 100%;">
				</a>
			</div>
			<!--View FPO's On Map End-->
		</div>
		<!--Left Contain Start-->
		<!-- Right Contain Start -->
		<div class="col-md-3 col-md-push-7 col-sm-6 set_comdbox no_padding"
			style="background: #fff; min-height: 100px; border-right: 15px solid #ccc;">
			<div class="row" style="margin-left: auto; margin-right: auto;">
				<div class="col-md-12" style="height: 162px; background: #fff;">


					<div class="text-block">
						<img
							src="${pageContext.request.contextPath}/resources/assets/newdesign/img/yogi.png"
							alt="Avatar"
							style="margin-left: 10px; z-index: 1000000; height: 70px;" />
						<!--<img src="img/circle.png" alt="" style="position: absolute;height: 120px;">-->
						<h4 class="set_name">
							<spring:message code="agri.cmname" text="Shri. Yogi Adityanath" />
						</h4>
						<h4 class="set_post">
							<spring:message code="agri.cm" text="Hon'ble Chief Minister" />
						</h4>
					</div>
				</div>
				<div class="col-md-12" style="height: 90px; background: #fff;">
					<div class="text-block">
						<img
							src="${pageContext.request.contextPath}/resources/assets/newdesign/img/sury.png"
							alt="Avatar"
							style="z-index: 1000000; height: 58px; margin-top: -27px; background: #fff;" />
						<!-- <img src="img/circle.png" alt="" style="position: absolute;height: 120px;">-->
						<h4 class="set_name">
							<spring:message code="agri.ministername"
								text="Shri Surya Pratap Shahi" />
						</h4>
						<h4 class="set_post">
							<spring:message code="agri.minister"
								text="Hon'ble Agriculture Minister" />
						</h4>
					</div>

				</div>
				<div class="col-md-12" style="height: 140px; background: #fff;">
					<div class="text-block">
						<img
							src="${pageContext.request.contextPath}/resources/assets/newdesign/img/lakhan.png"
							alt="Avatar"
							style="height: 46px; margin-top: 13px; background: #fff;" />
						<!-- <img src="img/circle.png" alt="" style="position: absolute;height: 120px;">-->
						<h4 class="set_name">
							<spring:message code="agri.stateministername"
								text="Shri Lakhan Singh Rajput" />
						</h4>
						<h4 class="set_post">
							<spring:message code="agri.stateminister"
								text="Hon'ble State Minister Agriculture" />
						</h4>
					</div>

				</div>

			</div>

		</div>
		<!--Right Contain End-->

		<!--Middle Contain Start-->
		<div class="col-md-7 col-md-pull-3">
			<!--Image Slider Start-->

			<div id="myCarousel" class="carousel slide" data-ride="carousel"
				style="height: 300px;">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner">

					<div class="item next left">
						<img
							src="${pageContext.request.contextPath}/resources/assets/newdesign/img/slider/1.jpg"
							alt="Los Angeles" class="img-thumbnail mob-width"
							style="width: 100%;">
						<div class="carousel-caption">
							<p>
								<spring:message code="home.slide1"
									text="Connect with buyers and exporters" />
							</p>
						</div>
					</div>


					<div class="item">
						<img
							src="${pageContext.request.contextPath}/resources/assets/newdesign/img/slider/3.jpg"
							alt="Chicago" class="img-thumbnail mob-width"
							style="width: 100%;">
						<div class="carousel-caption">
							<p>
								<spring:message code="home.slide3"
									text="Get information about FPO registration" />
							</p>
						</div>
					</div>

					<div class="item active left">
						<img
							src="${pageContext.request.contextPath}/resources/assets/newdesign/img/slider/4.jpg"
							class="img-thumbnail mob-width" alt="New York"
							style="width: 100%;">
						<div class="carousel-caption">
							<p>
								<spring:message code="home.slide4"
									text="Get information about seeds, fertilizers, agricultural implements etc" />
							</p>
						</div>
					</div>

				</div>

				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
			<!--Image Slider End-->


			<!--Search Box Start-->
			<div class="main" style="margin-top: 1%;">
				<div style="background-color: #cfb000;">
					<strong style="color: white; margin-left: 10px; font-size: 20px;"><spring:message
							code='home.searchtext'
							text='Search FPO by Name/ District/ Crop/ Services/ Products' /></strong>
				</div>
				<div class="col-md-8" style="padding: 0px;">
					<div class="form-group has-feedback">
						<div class="form-group">
							<div id="filterDate2">
								<input type="text" id="homesearch" class="form-control"
									style="cursor: pointer; width: 100%;"
									placeholder="<spring:message code='home.searchtext1' text= 'Type here to search' />" />
							</div>
						</div>
					</div>

				</div>
				<div class="col-md-2" style="padding: 0px;">
					<div class="dropdown">
						<select class="btn btn-default dropdown-toggle" id="searchin"
							name="Searchin" style="width: 100%; height: 34px;">
							<option value="any"><spring:message code='home.any' text='Any' /></option>
							<option value="crop"><spring:message code='home.crop' text='Crop' /></option>
							<option value="district"><spring:message code='home.district' text='District' /></option>
							<option value="fpo_name"><spring:message code='home.fpo' text='FPO' /></option>
							<option value="services"><spring:message code='home.services' text='Services/ Products' /></option>
						</select>
					</div>
				</div>
				<div class="col-md-2" style="padding: 0px;">
					<input type="button" value="&#x1F50D; Search"
						class="form-control-feedback btn-warning"
						style="width: 100%; pointer-events: all;"
						onclick="return getsearchathome();">
				</div>

			</div>
		</div>



	</div>
	<!--Search Box End-->

	<!--Tile Section Start-->
	<div class="row">
		<div class="container-fluid set_row_bg_image">
			<div class="row tileBoxRow"
				style="margin: auto auto; padding-left: 3%; padding-right: 3%">
				<!-- FPO tile--->
				<div class="col-md-3 set_box_md4" style="padding: 0px;">
					<div>
						<span class="set_span_titel"> <spring:message
								code="home.fpo" text="FPOs" />
						</span> <img
							src="${pageContext.request.contextPath}/resources/assets/newdesign/img/bg_box2.png"
							alt="" style="width: 100%; height: 35px;">
					</div>
					<div class="tile_nember">
						<a href="${pageContext.request.contextPath}/allfpcs"
							style="color: white"><fmt:formatNumber type="number"
								maxFractionDigits="0" value="${fpcs}" /> </a>
					</div>

				</div>
				<!--FPO tile end-->

				<!-- FPO tile--->
				<div class="col-md-3 set_box_md4" style="padding: 0px;">
					<div>
						<span class="set_span_titel"> <spring:message
								code="home.totalfarmers" text="Total Farmers" />
						</span> <img
							src="${pageContext.request.contextPath}/resources/assets/newdesign/img/bg_box2.png"
							alt="" style="width: 100%; height: 35px;">
					</div>
					<div class="tile_nember">
						<%-- <a href="${pageContext.request.contextPath}/allfpcs"
									style="color: white"> ${fpcs}</a> --%>

						<fmt:formatNumber type="number" maxFractionDigits="0" value="${farmers}"/>
					</div>

				</div>
				<!--FPO tile end-->

				<!-- Farmer tile-->

				<div class="col-md-3 set_box_md4" style="padding: 0px;">
					<div>
						<span class="set_span_titel"> <spring:message
								code="home.farmers" text="Farmers" />
						</span> <img
							src="${pageContext.request.contextPath}/resources/assets/newdesign/img/bg_box2.png"
							alt="" style="width: 100%; height: 35px;">
					</div>
					<div>
						<%-- <c:forEach var="typeframer" items="${number_farmertype}"
									varStatus="status"> --%>
						<table rowspacing="20" style="width: 99%;">
							<tbody>
								<tr class="table_tile_tr">
									<td class="table_tile_text"><spring:message
											code="home.mfarmer" text="Marginal" /></td>
									<td class="table_tile_number"><fmt:formatNumber
											type="number" maxFractionDigits="0"
											value="${marginalfarmers}" /> <%-- <a
													href="${pageContext.request.contextPath}/getmarginalfarmers"
													style="color: white;"> --%> <%-- ${typeframer.marginalFarmer} --%>
										<!-- </a> --></td>
								</tr>
								<tr class="table_tile_tr">
									<td class="table_tile_text"><spring:message
											code="home.sfarmer" text="Small" /></td>
									<td class="table_tile_number"><fmt:formatNumber
											type="number" maxFractionDigits="0" value="${smallfarmers}" />

										<%-- <a
													href="${pageContext.request.contextPath}/getsmallfarmers"
													style="color: white;"> --%>
										<%-- ${typeframer.smallFarmer} --%>
										<!-- </a> --></td>
								</tr>
								<tr class="table_tile_tr">
									<td class="table_tile_text"><spring:message
											code="home.bfarmer" text="Others" /></td>
									<td class="table_tile_number"><fmt:formatNumber
											type="number" maxFractionDigits="0" value="${otherfarmers}" />


										<%-- <a
													href="${pageContext.request.contextPath}/getotherfarmers"
													style="color: white;"> --%>
										<%-- ${typeframer.bigFarmer} --%>
										<!-- </a> --></td>
								</tr>
							</tbody>
						</table>
						<%-- </c:forEach> --%>

					</div>
				</div>
				<!--Famer tile end--->
				<!-- Land tile -->

				<div class="col-md-3 set_box_md4" style="padding: 0px;">
					<div>
						<span class="set_span_titel"> <spring:message
								code="home.land" text="Total Land (in Ha.)" />
						</span> <img
							src="${pageContext.request.contextPath}/resources/assets/newdesign/img/bg_box2.png"
							alt="" style="width: 100%; height: 35px;">
					</div>
					<div class="tile_nember">
						<fmt:formatNumber type="number" maxFractionDigits="0"
							value="${land}" />
					</div>

				</div>
				<!-- Land tile end -->


			</div>
			<div class="row tileBoxRow"
				style="margin: auto auto; padding-left: 3%; padding-right: 3%">
				<!-- Production tile -->
				<div class="col-md-3 set_box_md4" style="padding: 0px;">
					<div>
						<span class="set_span_titel"> <spring:message
								code="home.production" text="Production (in Qt.)" />
						</span> <img
							src="${pageContext.request.contextPath}/resources/assets/newdesign/img/bg_box2.png"
							alt="" style="width: 100%; height: 35px;">

					</div>
					<div>



						<table rowspacing="20" style="width: 99%;">
							<tbody>
								<tr class="table_tile_tr">
									<td class="table_tile_text"><spring:message
											code="home.rabi" text="Rabi" /></td>
									<td class="table_tile_number"><fmt:formatNumber
											type="number" maxFractionDigits="0"
											value="${production_rabi}" /></td>
								</tr>

								<tr class="table_tile_tr">
									<td class="table_tile_text"><spring:message
											code="home.zayd" text="Zayd" /></td>
									<td class="table_tile_number"><fmt:formatNumber
											type="number" maxFractionDigits="0"
											value="${production_zayad}" /></td>
								</tr>

								<tr class="table_tile_tr">
									<td class="table_tile_text"><spring:message
											code="home.kharif" text="Kharif" /></td>
									<td class="table_tile_number"><fmt:formatNumber
											type="number" maxFractionDigits="0"
											value="${production_kharif}" /></td>
								</tr>


							</tbody>
						</table>

					</div>

				</div>
				<!-- Production tile end -->
				<!-- Farm Machinery bank tilw -->

				<div class="col-md-3 set_box_md4" style="padding: 0px;">
					<div>
						<span class="set_span_titel"> <spring:message
								code="home.fmb" text="Farm Machinery Bank" />
						</span> <img
							src="${pageContext.request.contextPath}/resources/assets/newdesign/img/bg_box2.png"
							alt="" style="width: 100%; height: 35px;">

					</div>
					<div class="tile_nember">
						<fmt:formatNumber type="number" maxFractionDigits="0" value="92" />

						<%-- <a href="${pageContext.request.contextPath}/allfmbs"
									style="color: white"> --%>
						<%-- ${fmbs} --%>
						<!-- </a> -->
					</div>

				</div>
				<!-- Farm Manchinery Bank tile end -->



				<!-- Storage centre tile-->
				<div class="col-md-3 set_box_md4" style="padding: 0px;">
					<div>
						<span class="set_span_titel"> <spring:message
								code="home.collection.center" text="Warehouse / Cold Storage" />
						</span> <img
							src="${pageContext.request.contextPath}/resources/assets/newdesign/img/bg_box2.png"
							alt="" style="width: 100%; height: 35px;">
					</div>
					<div class="tile_nember">
						<!--<img src="img/storage.png" alt="" class="set_box_image">-->
						<fmt:formatNumber type="number" maxFractionDigits="0"
							value="${storagecenters}" />

					</div>

				</div>
				<!-- Storgare centre tile end -->

				<!-- Seed processing unit  tile-->
				<div class="col-md-3 set_box_md4" style="padding: 0px;">
					<div>
						<span class="set_span_titel"> <spring:message
								code="collection.seedprocessing" text="Seed Processing Unit" />
						</span> <img
							src="${pageContext.request.contextPath}/resources/assets/newdesign/img/bg_box2.png"
							alt="" style="width: 100%; height: 35px;">
					</div>
					<div class="tile_nember">
						<!--<img src="img/storage.png" alt="" class="set_box_image">-->
						<fmt:formatNumber type="number" maxFractionDigits="0"
							value="11" />
						
						<%-- ${storagecenters} --%>
					</div>

				</div>
				<!-- Storgare centre tile end -->
			</div>
		</div>
	</div>
	<!--Tile Section End-->

</div>
<!--Middle Contain End-->

<!--Right Contain Start-->
<!--Right Contain End-->


</div>
</div>