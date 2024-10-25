<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Danh Sach Nhan Vien</title>
</head>
<body>
	<a href="<c:url value='/QuanLyNhanVienServlet'/>">Danh Sach Nhan Vien</a> |
	<a href="<c:url value='/ThemNhanVienServlet'/>">Them Nhan Vien</a>
	<h3>
		Tong Nhan Vien:
		<c:out value="${tongNV }"></c:out>
	</h3>
	<table border="1">
		<thead>
			<tr>
				<th>Ten Phong Ban</th>
				<th>Ma Nhan Vien</th>
				<th>Ten Nhan Vien</th>
				<th>Email</th>
				<th>Dia Chi</th>
				<th>Dien Thoai</th>


			</tr>
		</thead>
		<tbody>
			<c:forEach var="listNhanVien" items="${listNV }">
				<tr>
					<td>${listNhanVien.phongBan.tenPhongBan }</td>
					<td>${listNhanVien.maNhanVien }</td>
					<td>${listNhanVien.tenNhanVien }</td>
					<td>${listNhanVien.email }</td>
					<td>${listNhanVien.diaChi }</td>
					<td>${listNhanVien.soDienThoai }</td>
					<td>
						<form onsubmit="return confirmData()" action="<c:url value='/QuanLyNhanVienServlet'/>" method="post">
							<input   name="maNhanVien" type="hidden" value="${listNhanVien.maNhanVien }"></input>
							<button>Xóa</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h3>
		<c:if test="${not empty error}">
			<p>${error}</p>
		</c:if>
	</h3>
	<script>
		function confirmData() {
            return confirm('Ban co chac chan muon xoa  khong?');
		}
	</script>
	</body>
</html>