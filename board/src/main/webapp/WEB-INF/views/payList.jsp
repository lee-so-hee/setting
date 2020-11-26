<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,com.vod.movit.mybatis.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>VOD Portal System</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon"
	href="${pageContext.request.contextPath }/resources/assets/img/favicon.ico" />
<!-- Google fonts-->
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('.cart-check-all').click(function() {
			$('.cartToPay').prop('checked', this.checked);
		});
	});
</script>
</head>
<body class="sb-nav-fixed">
	<jsp:include page="/WEB-INF/views/header.jsp" />
	
	<div id="layoutSidenav_content" style="width:100%">

		<main style="width:100%">
			<div class="container-fluid" style="width:100%">

				<div class="card-body" style="width:100%">
					<div class="table-responsive" style="width:100%">
						<input type="checkbox" name="all" class="cart-check-all"> <label>Check ALL</label>
						<table class="table table-bordered" id="dataTable" style="width:100%;aling:center;">
							<c:forEach items="${payList}" var="pay">
								<tr>
									<td><input type="checkbox" name="${pay.p_no }" class="cartToPay"/></td>
									<td width="15%">제목</td>
									<td colspan="2">${pay.m_title }</td>
									<td><a href="removeCart?p_no=${pay.p_no }"
									class="btn btn-info" role="button">삭제</a></td>
								</tr>
								<tr>
									<td>구매자</td>
									<td>${pay.u_id }</td>
									<td width="15%">작성일</td>
									<td>${pay.p_orderDate }</td>
									<td width="15%">가격</td>
									<td>${pay.p_money }</td>
								</tr>
								<tr>
									<td colspan="6"></td>
								</tr>
							</c:forEach>
							
						</table>
					</div>
				</div>
			</div>
	</div>
	</main>
	<footer class="py-4 bg-light mt-auto">
		<div class="container-fluid">
			<div class="d-flex align-items-center justify-content-between small">
				<div class="text-muted">Copyright &copy; Your Website 2020</div>
				<div>
					<a href="#">Privacy Policy</a> &middot; <a href="#">Terms &amp;
						Conditions</a>
				</div>
			</div>
		</div>
	</footer>
	</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		crossorigin="anonymous"></script>s
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script
		src="${pageContext.request.contextPath }/resources/js/scripts.js"></script>
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
