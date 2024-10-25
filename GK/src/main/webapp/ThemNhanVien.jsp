<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Them Nhan Vien</title>
</head>
<body>
	<a href="<c:url value='/QuanLyNhanVienServlet'/>">Danh Sach Nhan Vien</a> |
	<a href="<c:url value='/ThemNhanVienServlet'/>">Them Nhan Vien</a>
	<h3>Them Nhan Vien</h3>
	<form action="<c:url value=''/>" method="post">
		<label>Nhập mã Nhân Viên</label>
		<input type="text" name="maNhanVien" required>	<br>
		<label>Nhập Tên Nhân Viên</label>
		<input type="text" name="tenNhanVien" required><br>
		<label>Nhập Email:</label>
		<input required type="email" name="email">	<br>
		<label>Nhập Địa Chỉ:</label>
		<input type="text" name="diaChi"  required>	<br>
		<label>Nhập Số Điện Thoại:</label>
		<input type="text" name="soDienThoai"  required>	<br>
		<label>Chọn Phòng Ban:</label>
		<select name="maPB">
			<c:forEach var="listPB" items="${listPhongBan }">
				<option value="${listPB.maPhongBan}">${listPB.tenPhongBan}</option>
			</c:forEach>
		</select>
	<br>
		<button type="submit">Them</button>
		<c:if test="${not empty error }">
			<p style="color: red">${error }</p>
		</c:if>
	</form>


</body>
</html>