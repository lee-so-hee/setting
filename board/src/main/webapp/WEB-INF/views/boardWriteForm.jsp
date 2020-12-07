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
<!-- Favicon -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->
<script>
  $( function() {
    $( "#datepicker" ).datepicker({
      changeMonth: true,
      changeYear: true
    });
  } );
  </script>
</head>
<body class="sb-nav-fixed"  style="font-family: Do Hyeon;">

	<jsp:include page="/WEB-INF/views/header.jsp" />
	<div id="layoutSidenav_content">
		<main>
			<div class="container-fluid">
				<h1 class="mt-4">게시판 작성</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item active">게시판 작성</li>
				</ol>

				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-table mr-1"></i> 게시판 작성
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<form action="boardWrite" method="POST">
								<table class="table table-bordered" id="dataTable" width="100%"
									align="center">
									<tr>
										<td width="100">닉네임</td>
										<td colspan="3"><input type="text"
											name="b_writer" disabled="disabled"
											value="${sessionScope.userName }" style="width:20%;"> 
											<input type="hidden" name="b_writer"
											value="${sessionScope.userName }"></td>
									</tr>
									<tr>
										<td width="100">영화</td>
										<td colspan="3"><select name="m_no" id="head" align="right">
											<c:forEach items="${movieNameList }" var="movieName">
												<option value="${movieName.m_no }">${movieName.m_title }</option>
											</c:forEach>
										</select></td>
									</tr>
									<tr>
										<td width="100">제목</td>
										<td><input type="text"
											name="b_title" style="width:100%;"></td>
										<td width="100">관람일</td>
										<td><input type="text" id="datepicker"></td>
									</tr>
									<tr>
										<td width="100">내용</td>
										<td colspan="3"><textarea rows="20" cols="100%"
												name="b_content"></textarea></td>
									</tr>
								</table>
								<br /> <input type="submit" value="작성">
							</form>
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
<!-- <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		crossorigin="anonymous"></script> -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script
		src="${pageContext.request.contextPath }/resources/js/scripts.js"></script>

<!-- 	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
		crossorigin="anonymous"></script> -->
	<%-- <script
		src="${pageContext.request.contextPath }/resources/assets/demo/datatables-demo.js"></script> --%>

</body>
</html>
