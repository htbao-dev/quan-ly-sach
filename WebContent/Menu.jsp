<%@page import="java.util.ArrayList"%>
<%@page import="bean.LoaiBean"%>
<%@page import="bo.LoaiBo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
		
<%	
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	

	ArrayList<LoaiBean> dsloai = (ArrayList<LoaiBean>)session.getAttribute("dsloai");
			//(ArrayList<LoaiBean>)request.getAttribute("dsloai");
%>
<div class="col-2 text-center pt-3"> <!-- menu -->
	<h4 class="text-info pb-3">Thể loại</h4>
	<div>
		<%for(LoaiBean loai : dsloai){ %>
			<a class="px-3 text-black" href="HtSachController?ml=<%=loai.getMaLoai()%>"><%=loai.getTenLoai()%></a><hr>
		<% }%>
	</div>
</div>
</body>
</html>