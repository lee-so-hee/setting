<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>로그인</title>
<link
	href="${pageContext.request.contextPath }/resources/css/styles.css"
	rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js"
	crossorigin="anonymous"></script>
	<style>
@import
	url('https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Do+Hyeon&display=swap')
	;
</style>
	
</head>
<body class="bg-primary" style="font-family: Do Hyeon;">
	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">
			<main>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-5">
							<div class="card shadow-lg border-0 rounded-lg mt-5">
								<div class="card-header">
									<h3 class="text-center font-weight-light my-4">로그인</h3>
								</div>
								<div class="card-body">
									<form action="login" method="post">
										<div class="form-group">
											<label class="small mb-1">ID</label> <input
												class="form-control py-4" name="u_id" id="u_id" type="text"
												placeholder="ID 입력" />
										</div>
										<div class="form-group">
											<label class="small mb-1">Password</label> <input
												class="form-control py-4" name="u_password" id="u_password"
												type="password" placeholder="패스워드 입력" />
										</div>
										<!-- 
                                            <div class="form-group">
                                                <div class="custom-control custom-checkbox">
                                                    <input class="custom-control-input" id="rememberPasswordCheck" type="checkbox" />
                                                    <label class="custom-control-label" for="rememberPasswordCheck">Remember password</label>
                                                </div>
                                            </div>
                                             -->
										<div
											class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
											<input  class="btn btn-info" type="submit" value="로그인" />
										</div>
									</form>
								</div>
								<div class="card-footer text-center">
									<div class="small">
										<a href="registerForm">회원가입하기</a>
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
					<div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; MovIT</div>
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