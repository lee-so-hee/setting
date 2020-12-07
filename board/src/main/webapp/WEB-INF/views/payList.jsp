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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
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
	$(document).ready(function() {
		$('.cart-check-all').click(function() {
			$('.cartToPay').prop('checked', this.checked);
		});
	});

	$(function() {
		var progressTimer, progressbar = $("#progressbar"), progressLabel = $(".progress-label"), dialogButtons = [ {
			text : "다운로드 종료",
			click : closeDownload
		} ], dialog = $("#dialog").dialog({
			autoOpen : false,
			closeOnEscape : false,
			resizable : false,
			buttons : dialogButtons,
			open : function() {
				progressTimer = setTimeout(progress, 2000);
			},
			beforeClose : function() {
				downloadButton.button("option", {
					disabled : false,
					label : "다운로드 시작"
				});
			}
		}), downloadButton = $("#downloadButton").button().on("click",
				function() {
					$(this).button("option", {
						disabled : true,
						label : "다운로드 중..."
					});
					dialog.dialog("open");
				});

		progressbar.progressbar({
			value : false,
			change : function() {
				progressLabel.text("진행도 : " + progressbar.progressbar("value")
						+ "%");
			},
			complete : function() {
				progressLabel.text("완료!");
				dialog.dialog("option", "buttons", [ {
					text : "닫기",
					click : closeDownload
				} ]);
				$(".ui-dialog button").last().trigger("focus");
			}
		});

		function progress() {
			var val = progressbar.progressbar("value") || 0;

			progressbar.progressbar("value", val
					+ Math.floor(Math.random() * 3));

			if (val <= 99) {
				progressTimer = setTimeout(progress, 100);
			}
		}

		function closeDownload() {
			clearTimeout(progressTimer);
			dialog.dialog("option", "buttons", dialogButtons).dialog("close");
			progressbar.progressbar("value", false);
			progressLabel.text("다운로드 중...");
			downloadButton.trigger("focus");
		}
	});
</script>
<style>
#progressbar {
	margin-top: 20px;
}

.progress-label {
	font-weight: bold;
	text-shadow: 1px 1px 0 #fff;
}

.ui-dialog-titlebar-close {
	display: none;
}
</style>
</script>
</head>
<body class="sb-nav-fixed" style="font-family: Do Hyeon;">
	<jsp:include page="/WEB-INF/views/header.jsp" />
	<c:choose>
		<c:when test="${null eq payList }">
			<script>
				alert("결제하신 상품이 존재하지 않습니다.");
				location.href = "index";
			</script>
		</c:when>
		<c:otherwise>

		</c:otherwise>
	</c:choose>
	<div id="layoutSidenav_content" style="width: 100%">

		<main style="width: 100%">
			<div class="container-fluid" style="width: 100%">
				<h1 class="mt-4">결제 목록</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item active">결제 목록</li>
				</ol>
				<div id="dialog" title="파일 다운로드">
					<div class="progress-label">다운로드 중...</div>
					<div id="progressbar"></div>
				</div>
				<div class="card-body" style="width: 100%">
					<div class="table-responsive" style="width: 100%">
						<input type="checkbox" name="all" class="cart-check-all">
						<label>Check ALL</label>
						<table class="table table-bordered" id="dataTable"
							style="width: 100%; aling: center;">
							<c:forEach items="${payList}" var="pay">
								<tr>
									<td><input type="checkbox" name="${pay.p_no }"
										class="cartToPay" /></td>
									<td width="15%">제목</td>
									<td>${pay.m_title }</td>
									<td>구매자</td>
									<td>${pay.u_id }</td>
									<td><a href="removeCart?p_no=${pay.p_no }"
										class="btn btn-info" role="button">삭제</a></td>
									<td><button id="downloadButton">다운로드 시작</button></td>
								</tr>
								<tr>
									<td></td>
									<td width="15%">구매일</td>
									<td colspan="2">${pay.p_orderDate }</td>
									<td width="15%">가격</td>
									<td colspan="2">${pay.p_money }</td>
								</tr>
								<tr>
									<td colspan="7"></td>
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
