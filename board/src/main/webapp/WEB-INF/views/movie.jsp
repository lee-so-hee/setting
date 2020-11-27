<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>VOD Portal System</title>
<!-- Favicon -->
<link rel="icon" type="image/x-icon"
	href="${pageContext.request.contextPath }/resources/assets/img/favicon.ico" />
<!-- Google fonts -->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />

<link
	href="${pageContext.request.contextPath }/resources/css/styles.css"
	rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js"
	crossorigin="anonymous"></script>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Do+Hyeon&display=swap')
	;
</style>

</head>
<body class="sb-nav-fixed">

	<jsp:include page="/WEB-INF/views/header.jsp" />

	<div id="layoutSidenav_content">
		<main>
			<section class="page-section portfolio" id="portfolio">
				<div class="container">
					<br /> <br />
					<!-- Portfolio Section Heading-->
					<h1 class="mt-4">영화</h1>
					<br /> <br />
					<!-- Icon Divider-->
					<div class="divider-custom">
						<div class="divider-custom-line"></div>
					</div>
					<!-- Portfolio Grid Items-->
					<div class="row justify-content-center">
						<!-- Portfolio Item 1-->
						<c:forEach items="${movieList }" var="movie">
							<div class="col-md-6 col-lg-4 mb-5">
								<div class="portfolio-item mx-auto" data-toggle="modal"
									data-target="#m${movie.m_no }">
									<div
										class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
										<div
											class="portfolio-item-caption-content text-center text-white">
											<i class="fas fa-plus fa-3x"></i>
										</div>
									</div>
									<img class="img-fluid"
										style="width: 400px; height: 500px; margin-bottom: 30px;"
										src="${pageContext.request.contextPath }/resources/assets/img/portfolio/${movie.m_title}.jpg"
										alt="" />
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</section>
			<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes)-->
			<div class="scroll-to-top d-lg-none position-fixed">
				<a class="js-scroll-trigger d-block text-center text-white rounded"
					href="#page-top"><i class="fa fa-chevron-up"></i></a>
			</div>
			<!-- Portfolio Modals-->
			<!-- Portfolio Modal 1-->
			<c:forEach items="${movieList }" var="movie">
				<div class="portfolio-modal modal fade" id="m${movie.m_no }"
					tabindex="-1" role="dialog" aria-labelledby="portfolioModal1Label"
					aria-hidden="true">
					<div class="modal-dialog modal-xl" role="document">
						<div class="modal-content">
							<button class="close" type="button" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true"><i class="fas fa-times"></i></span>
							</button>
							<div class="modal-body text-center">
								<div class="container">
									<div class="row justify-content-center">
										<div class="col-lg-10">
											<!-- Portfolio Modal - Image-->

											<table
												style="margin-bottom: 10px; margin-top: 20px; font-family: Do Hyeon; font-size: 25px;">
												<tr>
													<td rowspan="13" style="margin-bottom: 0px"><img
														class="img-fluid rounded mb-5"
														style="width: 300px; height: 450px;"
														src="${pageContext.request.contextPath }/resources/assets/img/portfolio/${movie.m_title }.jpg"
														alt="" /></td>
												<tr>
													<td>&nbsp;</td>
													<td></td>
												</tr>
												<tr>
													<td>&nbsp;</td>
													<td></td>
												</tr>
												<tr>
													<td>&nbsp;</td>
													<td></td>
												</tr>
												<td style="width: 300px; font-weight: 700;">제목</td>
												<td style="width: 200px;">${movie.m_title }</td>
												</tr>
												<tr>
													<td style="font-weight: 900; margin-top: 600px;">감독</td>
													<td>${movie.m_director }</td>
												</tr>
												<tr>
													<td style="font-weight: 900;">장르</td>
													<td>${movie.m_genre }</td>
												</tr>
												<tr>
													<td style="font-weight: 900;">평점</td>
													<td>${movie.m_score }</td>
												</tr>
												<tr>
													<td style="font-weight: 900;">개봉일</td>
													<td>${movie.m_regDate }</td>
												</tr>
												<tr>
													<td style="font-weight: 900;">등급</td>
													<td>${movie.m_grade }</td>
												</tr>
												<tr>
													<td style="font-weight: 900;">국가</td>
													<td>${movie.m_nation }</td>
												</tr>

												<tr>
													<td>&nbsp;</td>
													<td></td>
												</tr>
												<tr>
													<td>&nbsp;</td>
													<td></td>
												</tr>
												<tr>
													<td>&nbsp;</td>
													<td></td>
												</tr>

											</table>

											<p
												style="font-size: 35px; color: #8181F7; font-weight: 600; font-family: Do Hyeon">
												줄거리</p>
											<p style="font-size: 20px; font-family: Do Hyeon">${movie.m_content }</p>
											<br>
											<form action="addCart" method="POST">
												<input type="hidden" name="m_no" value="${movie.m_no }" /> 
												<input type="hidden" name="u_id" value="${sessionScope.userId }" /> 
												<input type="submit" class="btn btn-info" value="장바구니 담기">
											
											<button class="btn btn-primary" data-dismiss="modal">
												<i class="fas fa-times fa-fw"></i> 닫기
											</button>
											<button class="btn btn-primary" data-dismiss="modal"
												onclick="location.href='table'">
												<i class="fas fa-table mr-1"></i> 게시판
											</button>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</main>

		<footer class="py-4 bg-light mt-auto">
			<div class="container-fluid">
				<div class="d-flex align-items-center justify-content-between small">
					<div class="text-muted">Copyright &copy; Your Website 2020</div>
					<div>
						<a href="#">Privacy Policy</a> &middot; <a href="#">Terms
							&amp; Conditions</a>
					</div>
				</div>
			</div>
		</footer>
	</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script
		src="${pageContext.request.contextPath }/resources/js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<%--
	<script
		src="${pageContext.request.contextPath }/resources/assets/demo/chart-area-demo.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/assets/demo/chart-bar-demo.js"></script>
	 --%>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
		crossorigin="anonymous"></script>
	<script
		src="${pageContext.request.contextPath }/resources/assets/demo/datatables-demo.js"></script>

</body>
</html>