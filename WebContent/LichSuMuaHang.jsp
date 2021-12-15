<%@page import="bean.ChiTietHoaDonBean"%>
<%@page import="bean.HoaDonBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Lịch sử mua hàng</title>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<%
ArrayList<HoaDonBean> listHoaDon = (ArrayList<HoaDonBean>)request.getAttribute("listHoaDon");
%>

<%@include file="NavBar.jsp" %>
<div class="d-flex">
	<%@include file="Menu.jsp"%>
	<div class="col p-5">
		<table class="table table-hover table-striped">
			<thead> 
				<tr> 
					<th class="col-1"> Mã hoá đơn</th>
					<th class="col-1"> Mã khách hàng </th>
					<th class="col-1"> ngày mua</th>
					<th class="col-1"> Trạng thái </th>
					<th class="col-1">  </th>
				</tr>
			</thead>
			<tbody>
				<%int n = listHoaDon.size();
				for(int i = 0; i< n; i++){
					HoaDonBean hoaDonBean = listHoaDon.get(i);%>
					<tr> 
						<td> 
							<%=hoaDonBean.getMaHoaDon() %>
						</td>
						<td>
							<%=hoaDonBean.getMaKH() %>
						</td>
						<td>
							<%=hoaDonBean.getNgayMua() %>
						</td>
						<td>
							<%if (hoaDonBean.isDaMua()) {%>
								<div>Đã thanh toán</div>
							<%}else{ %>
								<div>Chưa thanh toán</div>
							<%} %>
						</td>
						<td>
							<!-- Button trigger modal -->
							<a class="btn btn-primary" href="#" data-toggle="modal" data-target=<%="#ChiTietModal" + i%>>Chi Tiết</a>
							
							<!-- Modal -->
							<div class="modal fade" id=<%="ChiTietModal" + i%> tabindex="-1" role="dialog" aria-labelledby=ChiTietModal aria-hidden="true">
							  <div class="modal-dialog modal-lg" role="document">
							    <div class="modal-content p-3">
							      <div class="modal-header">
							        	<h5 class="modal-title" id="ChiTietModalLabel">Chi tiết hoá đơn</h5>
							      </div>
							      <div class="modal-body">
							       		<table class="table table-hover table-striped">
											<thead> 
												<tr> 
													<th class="col-2"> Mã sách</th>
													<th class="col-3"> Tên sách</th>
													<th class="col-2"> Giá</th>
													<th class="col-2"> Số lượng </th>
													<th class="col-2"> Thành tiền </th>
												</tr>
											</thead>
											<tbody>
													
											<%ArrayList<ChiTietHoaDonBean> listChiTiet = hoaDonBean.getChiTiet();%>
												<%for(ChiTietHoaDonBean chiTiet : listChiTiet){%>
													<tr> 
														<td> 
															<%=chiTiet.getSach().getMaSach() %>
														</td>
														<td>
															<%=chiTiet.getSach().getTenSach() %>
														</td>
														<td>
															
															<%=String.format("%,d đ", chiTiet.getSach().getGia()) %>
														</td>
														<td >
															<%=chiTiet.getSoLuongMua()%>
														</td>
														<td>
															<%=String.format("%,d đ", chiTiet.getThanhTien())%>
														</td>
													</tr>
												<%}%>
											</tbody>
											<tfoot> 
												<tr> 
													<td colspan="4"> <b>Tổng tiền</b> </td>
													<td> <b><%=String.format("%,d đ", hoaDonBean.getTongTien()) %></b> </td>
												</tr>
											</tfoot>
										</table>
							      </div>
							    </div>
							  </div>
							</div>
						</td>
					</tr>
				<%}%>
			</tbody>
		</table>
	</div>
	

	
</div>
</body>
</html>