<%@page import="bo.GioHangBo"%>
<%@page import="bean.UserBean"%>
<%@page import="bo.UserBo"%>
<%@page import="bean.SachBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.SachBo"%>
<%@page import="bean.LoaiBean"%>
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
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	   response.setCharacterEncoding("utf-8");

	   ArrayList<SachBean> dssach;
	   dssach = (ArrayList<SachBean>)request.getAttribute("dssach");
	%>
<%@include file="NavBar.jsp" %>
	<div class="d-flex">
	<%@include file="Menu.jsp" %>
		
	<div class="col">
		<div class="col d-flex flex-wrap"> <!-- Hien Thi -->
			<%for(SachBean sach : dssach){ %>
			<% //System.out.print("Bảo   "); %>
				<div class="text-center col-4 py-3">
					<img width="170" class="mb-3" alt="" src="<%=sach.getAnh()%>"><br>
					<a href="GioHangController?them=<%=sach.getMaSach()%>"><img alt="" src="btnMua.jpg"></a>
					<div><%=sach.getTenSach() %></div>
					<div>Tác giả: <a href="#"><%=sach.getTacGia() %></a></div>
					<div><b>Giá bán: </b><span><%=String.format("%,d", sach.getGia())%> đ</span></div>
				</div>
			<%} %>
		</div>
	</div>
	</div>
</body>
</html>