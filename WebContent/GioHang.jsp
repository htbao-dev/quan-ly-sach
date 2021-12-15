<%@page import="bean.GioHangBean"%>
<%@page import="bo.GioHangBo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Giỏ hàng</title>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https:	//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<%
GioHangBo gioHangBo = (GioHangBo) session.getAttribute("gioHang");
	Object muaStatus = session.getAttribute("muaStatus");
	String folder = "image_sach/";
%>
<%@include file="NavBar.jsp" %>
<div class="d-flex">
	<%@include file="Menu.jsp"%>
	<%
		if (request.getAttribute("muaStatus") != null){
			int status = (int)request.getAttribute("muaStatus");
			if (status == 1){%>
				<script> alert("Đặt mua thành công !"); </script>
			<%}else if (status == 0){%>
				<script> alert("Bạn phải đăng nhập để đặt mua"); </script>
			<%}
			else if (status == -1){%>
				<script> alert("Lỗi hệ thống, chưa thể đặt mua"); </script>
			<%}
		}%>
	<div class="col p-5	">
		<%if (gioHangBo == null || gioHangBo.getDsSanPham().size() == 0){ %>
			<div class="d-flex justify-content-center">
				<div>
					<div class="h3">Giỏ hàng của bạn đang trống!</div>
					<div class="d-flex justify-content-center">
						<a href="HtSachController"><button class="btn btn-secondary"> Hãy tiếp tục mua sắm</button></a>
					</div>
				</div>
			</div>
		<%} else{%>
			<form action="GioHangController" id="form1" method="get">
				<table class="table table-hover table-striped">
					<thead> 
						<tr> 
							<th class="col-5"> Sản phẩm</th>
							<th class="col-2"> Giá</th>
							<th class="col-1"> Số lượng </th>
							<th class="col-1"> Thành tiền </th>
						</tr>
					</thead>
					<tbody>
						<%
							ArrayList<GioHangBean> listItems = gioHangBo.getDsSanPham();
							for (GioHangBean item : listItems){%>
								<tr> 
									<td class="d-flex"> 
										<img width="80" class="img-thumbnail" alt="" src="<%=item.getSachBean().getAnh() %>">
										<div class="mx-4">
											<%=item.getSachBean().getTenSach() %>
											<br>
											<a href="GioHangController?xoa=<%=item.getSachBean().getMaSach() %>">Loại bỏ</a>
										</div>
								
									</td>
									<td>
										<%=String.format("%,d", item.getSachBean().getGia()) + " đ"%>
									</td>
									<td>
										<input class="w-50" name="soLuong" type="number" min="1" value=<%=item.getSoLuong() %> required>
									</td>
									<td >
										<div class="d-flex justify-content-end"><%=String.format("%,d đ", item.getThanhTien())%></div>
									</td>
								</tr>
							<%} %>
					</tbody>
					<tfoot> 
						<tr> 
							<td colspan="3"> <b>Tổng tiền</b> </td>
							<td class="d-flex justify-content-end"> <b><%=String.format("%,d đ", gioHangBo.tongTien())%></b> </td>
						</tr>
					</tfoot>
				</table>
			</form>
			<div class="d-flex justify-content-end">
				<a class="mx-2" href="HtSachController"><button class="btn">Quay lại cửa hàng</button></a>
				<button class="btn btn-warning mx-2" type="submit" form="form1" value="update">Cập nhật</button>
				<form action="GioHangController" method="post" id="form2">
					<button class="btn btn-success mx-2" type="submit" form="form2" value="true" name="mua"> Đặt mua</button>
				</form>
			</div>
		<%} %>
		
	</div>
</div>
</body>
</html>