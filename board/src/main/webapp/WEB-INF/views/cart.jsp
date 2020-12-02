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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('.cart-check-all').click(function() {
			$('.cartToPay').prop('checked', this.checked);
		});
	});
</script>
</head>
<body class="sb-nav-fixed" style="font-family: Do Hyeon;">
	<jsp:include page="/WEB-INF/views/header.jsp" />
	<c:choose>
		<c:when test="${cartMsg=='success' }">
			<script>
				alert("찜 등록 완료.");
			</script>
		</c:when>
		<c:when test="${cartMsg=='fail'}">
			<script>
				alert("해당 영화가 이미 찜목록에 있습니다.");
			</script>
		</c:when>
		<c:when test="${null eq cartlist}">
			<script>
				alert("찜하신 상품이 존재하지 않습니다.");
				location.href="index";
			</script>
		</c:when>
		<c:otherwise>

		</c:otherwise>
	</c:choose>
	<div id="layoutSidenav_content" style="width: 100%">

		<main style="width: 100%">
			<div class="container-fluid" style="width: 100%">
				<h1>찜 목록</h1>
				<div class="card-body" style="width: 100%">
					<div class="table-responsive" style="width: 100%">
						<input type="checkbox" name="all" class="cart-check-all">
						<label>Check ALL</label>
						<table class="table table-bordered" id="dataTable"
							style="width: 100%; aling: center;">
							<c:forEach items="${cartlist}" var="cart">
								<tr>
									<td><input type="checkbox" name="${cart.c_no }"
										class="cartToPay" /></td>
									<td width="15%">제목</td>
									<td colspan="2">${cart.title }</td>
									<td>
										<form action="addPay" method="POST">
											<input type="hidden" name="c_no" value="${cart.c_no }" /> <input
												type="hidden" name="m_no" value="${cart.m_no }" /> <input
												type="hidden" name="u_id" value="${cart.u_id }" /> <input
												type="hidden" name="p_money" value="${cart.c_money }" /> <input
												type="submit" value="구매" class="btn btn-info" />
										</form>
									</td>
									<td><a href="removeCart?c_no=${cart.c_no }"
										class="btn btn-info" role="button">삭제</a></td>
								</tr>
								<tr>
									<td>구매자</td>
									<td>${cart.u_id }</td>
									<td width="15%">작성일</td>
									<td>${cart.c_orderDate }</td>
									<td width="15%">가격</td>
									<td>${cart.c_money }</td>
								</tr>
								<tr>
									<td colspan="6"></td>
								</tr>
							</c:forEach>

						</table>
					</div>
				</div>
			</div>
		</main>
		<footer class="py-4 bg-light mt-auto">
			<div class="container-fluid">
				<div class="d-flex align-items-center justify-content-between small">
					<div class="text-muted">Copyright &copy; MovIT</div>
				</div>
			</div>
		</footer>
	</div>


	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		crossorigin="anonymous"></script>
	s
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
