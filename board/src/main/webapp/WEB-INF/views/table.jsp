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
<title>VOD Portal System - 게시판</title>
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
</head>
<body class="sb-nav-fixed" style="font-family: Do Hyeon;" >
	<jsp:include page="/WEB-INF/views/header.jsp" />
	
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid">
					<h1 class="mt-4">게시판 목록</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item active">게시판 목록</li>
					</ol>

					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table mr-1"></i> 게시판 목록
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%">
									<thead>
										<tr>
											<th width="10%">순번</th>
											<th width="15%">영화</th>
											<th  width="40%">제목</th>
											<th width="10%">작성자</th>
											<th  width="15%">등록일</th>
											<th width="10%">조회수</th>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th>순번</th>
											<th>영화</th>
											<th>제목</th>
											<th>작성자</th>
											<th>등록일</th>
											<th>조회수</th>
										</tr>
									</tfoot>
									<tbody>
										<c:forEach items="${boardList }" var="board">
											<tr>
												<td>${board.b_no }</td>
												<td>${board.title }</td>
												<td><a href="detailBoard?b_no=${board.b_no }">${board.b_title }</a></td>
												<td>${board.b_writer }</td>
												<td>${board.b_regDate }</td>
												<td>${board.b_viewCnt }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<a href="boardWriteForm"
									class="btn btn-info" role="button">작성하기</a> 
							</div>
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
