<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,com.vod.movit.mybatis.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function idCheck() {
		//var id = document.myForm.id; // document. --> html문서 전체에서 하나하나 찾아가기
		var id = document.getElementById("id"); // id로 접근하기
		window.open("idCheck?id=" + id.value, "window1", "width=400,height=300"); //띄어줄 url id값을 던지면서 id 체크 , 새로 뜨는 윈도우 팝업창이름, 팝업창 모양
	}

	function checkPasswd() {
		var passwd1 = document.getElementById("passwd"); // id로 접근해서 값 받아오기	
		var passwd2 = document.getElementById("passwd2"); // id로 접근해서 값 받아오기
		var errorMessage = document.getElementById("errorMessage"); // id로 접근해서 값 받아오기

		if (passwd1.value != passwd2.value) { // 입력 양식의 값
			errorMessage.innerHTML = "<font color = 'red'>비밀번호가 일치하지 않습니다.</font>";//innerHTML 은 그 엘리먼트 안에 HTML태그를 삽입하는 것이다
		} else {
			errorMessage.innerHTML = "";
		}
	}
</script>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>회원가입</title>
<link
	href="${pageContext.request.contextPath }/resources/css/styles.css"
	rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js"
	crossorigin="anonymous"></script>
</head>
<body class="bg-primary">
	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">
			<main>
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-7">
						<div class="card shadow-lg border-0 rounded-lg mt-5">
							<div class="card-header">
								<h3 class="text-center font-weight-light my-4">회원가입</h3>
							</div>
							<div class="card-body">
								 <form:form role="form" modelAttribute="user" action="insertUser" method="post">
									<div class="form-row">
										<div class="col-md-6">
											<div class="form-group">
												<label class="small mb-1">ID</label> 
												<form:input type="text" class="form-control py-4" placeholder="아이디 입력" path="u_id"/>
												<form:errors path="u_id" class="register-errors"/>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="small mb-1">Name</label> 
												<form:input type="text" class="form-control py-4" placeholder="이름 입력" path="u_name" />
												<form:errors path="u_name" class="sregister-errors"/>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="small mb-1">Email</label>
											<form:input type="email" class="form-control py-4" aria-describedby="emailHelp" placeholder="이메일 입력" path="u_email" />
											<form:errors path="u_email" class="register-errors"/>
									</div>
									<div class="form-group">
										<label class="small mb-1">Phone</label> 
										<form:input type="text" class="form-control py-4" placeholder="번호 입력" path="u_phone" />
										<form:errors path="u_phone" class="register-errors"/>		
									</div>
									<div class="form-row">
										<div class="col-md-6">
											<div class="form-group">
												<label class="small mb-1">Password</label>
												<form:password class="form-control py-4" placeholder="비밀번호 입력" path="u_password"/>
                                                <form:errors path="u_password" class="register-errors"/>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
											<label class="small mb-1">Check Password</label>
												<form:password class="form-control py-4" placeholder="Password Check" path="checkPw"/>
                                                <form:errors path="checkPw" class="register-errors"/>
											</div>
										</div>
									</div>
									<div class="form-group mt-4 mb-0">
										 <button type="submit" class="btn btn-primary btn-block">가입하기</button>
									</div>
								</form:form>
							</div>
							<div class="card-footer text-center">
								<div class="small">
									<a href="login.html">Have an account? Go to login</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			</main>
		</div>
		<div id="layoutAuthentication_footer">
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
</body>
</html>