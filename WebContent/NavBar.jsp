<%@page import="bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Nhà sách</title>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	   response.setCharacterEncoding("utf-8");
	   
	   String username = request.getParameter("username");
	   String password = request.getParameter("password");
	%>
<div>
	<nav class="navbar navbar-expand navbar-dark bg-dark d-flex justify-content-between">
		<a class="col-2 navbar-brand text-warning ml-4 h1" href="HtSachController">Nhà sách</a>
		<form class="col-5 form-inline d-flex justify-content-center" action="HtSachController" method="get">
			<div class="form-group w-75">
				<input class="form-control mx-2 w-75 border-top-0 border-left-0 border-right-0" name="search" type="text" placeholder="Công nghệ thông tin, văn học,...">
				<input class="btn btn-dark" type="submit" value="tìm kiếm">
			</div>
		</form>
		
		<div class="col-5 d-flex justify-content-around pr-5">
			<div class="navbar-text ">
				<a href="GioHangController">
					<i class="fa fa-shopping-cart" style="font-size:24px"></i> <!-- Giỏ hàng -->
				</a>
			</div>
			<%
			if (session.getAttribute("user") != null){
			%>
			<%
			UserBean user = (UserBean)session.getAttribute("user");
			%>
				
				<div class="navbar-text">
					xin chào, <%=user.getHoTen() %>!
				</div>
				<div class="navbar-text">
					<a href="LichSuController">Lịch sử mua hàng</a>
				</div>
				<div class="navbar-text">
					<a href="TaiKhoanController?logout=true">Đăng xuất</a>
				</div>
			<%} else{ %>
				<%
					if (session.getAttribute("loginFail") != null){%>
						<script> alert("Đăng nhập không thành công"); </script>
						<%session.removeAttribute("loginFail"); %>
					<%} %>
					<div class="col-6 d-flex justify-content-around">
						<div class="navbar-text">
							<a href="DangKyController">Đăng ký</a>
						</div>
						<div class="navbar-text">
							<a href="#" data-toggle="modal" data-target="#loginModal">Đăng Nhập</a>
						</div>
					</div>
			<%} %>
		</div>
	</nav>
</div>

<!-- Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModal" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content p-3">
      <div class="modal-header">
        <h5 class="modal-title" id="loginModalLabel">Đăng nhập</h5>
      </div>
      <div class="modal-body">
        <form action="TaiKhoanController" method="post">
        	<div class="form-group">
        		<input class="form-control" id="Username" name="username" type="text" placeholder="Tên đăng nhập" required>
        	</div>
        	<div class="form-group">
        		<input class="form-control" id="Password" name="password" type="password" placeholder="Mât khẩu" required>
        	</div>
        	<div class="d-flex">
	       		<div class="ml-auto">
	        		<input class="btn btn-secondary" type="button" data-dismiss="modal" value="Huỷ">
	        		<input class="btn btn-success" type="submit" value="Đăng nhập">
	        	</div>
        	</div>
        </form>
      </div>
    </div>
  </div>
</div>
</body>
</html>