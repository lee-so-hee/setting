<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,com.vod.movit.mybatis.*"%>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<!-- Favicon-->
<%-- <link rel="icon" type="image/x-icon"
	href="${pageContext.request.contextPath }/resources/assets/img/favicon.ico" />
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />

<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" /> --%>

<script>
$(document).ready(function() {

	// 버튼의 이벤트 핸들러를 붙입니다.
	$(".login-dialog").button().on("click", function () {
		// 다이얼로그 내용을 가져올 URL입니다.
		var url = "loginForm";
		// 다이얼로그를 생성합니다.
		$('<div id="DialogDiv">').dialog({
			// 커스텀 스타일을 줍니다.
			dialogClass: 'custom-dialog-style',
			// 모달 다이얼로그로 생성합니다.
			modal: true,
			// 다이얼로그 열기 콜백
			open: function () {
				// 모달 오버레이 설정
				$(".ui-widget-overlay").css({
					opacity: 0.5,
					filter: "Alpha(Opacity=50)",
					backgroundColor: "black"
				});
				// 내용을 불러 옵니다.
				$(this).load(url);
			},
			// 닫기 콜백
			close: function (e) {
				$(this).empty();
				$(this).dialog('destroy');
			},

			height: 600,
			width: 1000,
			title: '로그인 화면'
		});
	});
	
	// 버튼의 이벤트 핸들러를 붙입니다.
	$(".register-dialog").button().on("click", function () {
		// 다이얼로그 내용을 가져올 URL입니다.
		var url = "registerForm";
		// 다이얼로그를 생성합니다.
		$('<div id="DialogDiv">').dialog({
			// 커스텀 스타일을 줍니다.
			dialogClass: 'custom-dialog-style',
			// 모달 다이얼로그로 생성합니다.
			modal: true,
			// 다이얼로그 열기 콜백
			open: function () {
				// 모달 오버레이 설정
				$(".ui-widget-overlay").css({
					opacity: 0.5,
					filter: "Alpha(Opacity=50)",
					backgroundColor: "black"
				});
				// 내용을 불러 옵니다.
				$(this).load(url);
			},
			// 닫기 콜백
			close: function (e) {
				$(this).empty();
				$(this).dialog('destroy');
			},

			height: 750,
			width: 1000,
			title: '회원가입 화면'
		});
	});
});
</script>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Do+Hyeon&display=swap')
	;
</style>
<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark" style="font-family: Do Hyeon;">
	<a class="navbar-brand" href="index">VOD Portal System</a>
	<button class="btn btn-link btn-sm order-1 order-lg-0"
		id="sidebarToggle" href="#">
		<i class="fas fa-bars"></i>
	</button>
	<!-- Navbar Search-->
	<form
		class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
		<div class="input-group">
			
		</div>
	</form>
	<!-- Navbar-->
	<ul class="navbar-nav ml-auto ml-md-0">
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			id="userDropdown" href="#" role="button" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false"><i
				class="fas fa-user fa-fw"></i></a>
			<div class="dropdown-menu dropdown-menu-right"
				aria-labelledby="userDropdown">
				<c:choose>
					<c:when test="${msg=='success' }">
						<a class="dropdown-item">${sessionScope.userName }</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="logout">로그아웃</a>
					</c:when>
					<c:otherwise>
						<button class="dropdown-item login-dialog">로그인</button>
						<button class="dropdown-item register-dialog">회원가입</button>
					</c:otherwise>
				</c:choose>
			</div></li>
	</ul>
</nav>
<div id="layoutSidenav">
	<div id="layoutSidenav_nav">
		<nav class="sb-sidenav accordion sb-sidenav-dark"
			id="sidenavAccordion">
			<div class="sb-sidenav-menu">
				<div class="nav">
					<div class="sb-sidenav-menu-heading">Movie</div>
					<a class="nav-link" href="movie">
						<div class="sb-nav-link-icon">
							<i class="fas fa-tachometer-alt"></i>
						</div> 영화
					</a>
					<div class="sb-sidenav-menu-heading">MyPage</div>
					<a class="nav-link collapsed" href="#" data-toggle="collapse"
						data-target="#collapseLayouts" aria-expanded="false"
						aria-controls="collapseLayouts">
						<div class="sb-nav-link-icon">
							<i class="fas fa-columns"></i>
						</div> 회원정보
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseLayouts"
						aria-labelledby="headingOne" data-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<button class="dropdown-item login-dialog nav-link" style="color:white;">로그인</button>
						<button class="dropdown-item register-dialog nav-link" style="color:white;">회원가입</button>
						</nav>
					</div>
					<a class="nav-link collapsed" href="#" data-toggle="collapse"
						data-target="#collapsePages" aria-expanded="false"
						aria-controls="collapsePages">
						<div class="sb-nav-link-icon">
							<i class="fas fa-book-open"></i>
						</div> 주문정보
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapsePages"
						aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="cart">찜목록</a>
							<a class="nav-link" href="payList">결제목록</a> 
						</nav>
					</div>
					<div class="sb-sidenav-menu-heading">Board</div>
					<a class="nav-link" href="table">
						<div class="sb-nav-link-icon">
							<i class="fas fa-table"></i>
						</div> 게시판
					</a>
				</div>
			</div>
			<div class="sb-sidenav-footer">
				<c:choose>
					<c:when test="${sessionScope.userName!=null }">
						<div class="small">Logged in as:</div>
						${sessionScope.userName }
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
			</div>
		</nav>
	</div>