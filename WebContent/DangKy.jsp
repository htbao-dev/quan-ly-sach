<%@page import="common.SignupStatus"%>
<%@page import="bean.ChiTietHoaDonBean"%>
<%@page import="bean.HoaDonBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Đăng ký</title>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<%@include file="NavBar.jsp" %>
<div class="d-flex">
	<%@include file="Menu.jsp"%>
	<%
	UserBean userBean = (UserBean)request.getAttribute("userBean");
	%>
	<div class="col p-5 d-flex justify-content-center">
		<form action="DangKyController" method="post">
			<div class="form-group">
				<div class="d-flex my-2">
					<div class="col-6"> Họ và tên <span class="text-danger">*</span></div>
					<div> <input class="form-control" type="text" name="HoTen" value="<%=(userBean!=null?userBean.getHoTen():"") %>" required></div>
				</div>
				<div class="d-flex my-2">
					<div class="col-6"> Tên đăng nhập <span class="text-danger">*</span></div>
					<div> <input class="form-control w-2" type="text" name="TenDangNhap" value="<%=(userBean!=null?userBean.getUsername():"") %>" required></div>
				</div>
				<div class="d-flex my-2">
					<div class="col-6"> Mật khẩu <span class="text-danger">*</span></div>
					<div> <input class="form-control" type="password" name="MatKhau" required></div>
				</div>
				<div class="d-flex my-2">
					<div class="col-6">Nhập lại mật khẩu <span class="text-danger">*</span></div>
					<div> <input class="form-control" type="password" name="NhapLaiMatKhau" required></div>
				</div>
				<div class="d-flex my-2">
					<div class="col-6"> Email</div>
					<div> <input class="form-control" type="email" name="Email" value="<%=(userBean!=null?userBean.getEmail():"") %>"></div>
				</div>
				<div class="d-flex my-2">
					<div class="col-6"> Địa chỉ</div>
					<div> <input class="form-control" type="text" name="DiaChi" value="<%=(userBean!=null?userBean.getDiaChi():"") %>"></div>
				</div>
				<div class="d-flex my-2">
					<div class="col-6"> Số điện thoại</div>
					<div> <input class="form-control" type="text" name="SoDienThoai" pattern="[0-9]{10,}" value="<%=(userBean!=null?userBean.getSoDT():"") %>"></div>
				</div>
				<div class="d-flex justify-content-center"> 
						<%
							SignupStatus status = (SignupStatus)request.getAttribute("status");
							if (status == SignupStatus.INVALID_USERNAME){%>
								<div class="text-danger">Tên đăng nhập không hợp lệ!</div>
							<%}else if(status == SignupStatus.INVALID_PASSWORD){ %>
								<div class="text-danger"> Mật khẩu không hợp lệ</div>	
							<%}else if(status == SignupStatus.INVALID_CONFIRM_PASSWORD){ %>
								<div class="text-danger"> nhập lại mật khẩu không đúng</div>				
							<%}else if(status == SignupStatus.AVALIABLE_USERNAME){ %>
								<div class="text-danger">Tên đăng nhập đã tồn tại</div>
							<%}else if(status == SignupStatus.UNKNOW_ERROR){ %>
								<div class="text-danger">Lỗi không xác định, vui lòng thử lại sau</div>
							<%}else if(status == SignupStatus.SIGNUP_SUCCESS){ %>
								<div class="text-success">Đăng ký thành công!</div>
							<%} 
								request.removeAttribute("status");
						%>
				</div>
				<div class="d-flex justify-content-center">
					<input class="btn btn-warning" type="submit" value="Đăng ký">
				</div>
			</div>
		</form>
			
	</div>
</div>
</body>
</html>