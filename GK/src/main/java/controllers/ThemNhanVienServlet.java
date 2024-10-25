package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.NhanVienDao;
import dao.PhongBanDao;
import daoimpl.NhanVienImpl;
import daoimpl.PhongBanImpl;
import entities.NhanVien;
import entities.PhongBan;

/**
 * Servlet implementation class ThemNhanVienServlet
 */
@WebServlet("/ThemNhanVienServlet")
public class ThemNhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhongBanDao phongBanDao;
	private NhanVienDao nhanVienDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemNhanVienServlet() {
		super();
		nhanVienDao = new NhanVienImpl();
		phongBanDao = new PhongBanImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("listPhongBan", phongBanDao.getAllPhongBan());
		request.getRequestDispatcher("ThemNhanVien.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maNhanVien = request.getParameter("maNhanVien");
		String tenNhanVien = request.getParameter("tenNhanVien");
		String email = request.getParameter("email");
		String diaChi = request.getParameter("diaChi");
		String soDienThoai = request.getParameter("soDienThoai");
		String maPB = request.getParameter("maPB");
		PhongBan phongBan = phongBanDao.findPhongBanById(maPB);
		NhanVien nhanVien = new NhanVien(maNhanVien, tenNhanVien, email, diaChi, soDienThoai, phongBan);
		if (nhanVien != null) {
			nhanVienDao.addNhanVien(nhanVien);
			response.sendRedirect(request.getContextPath() +"/QuanLyNhanVienServlet");
		}
		else {
			request.setAttribute("error", "Thêm nhân viên thất bại");
			request.getRequestDispatcher("ThemNhanVien.jsp").forward(request, response);
		}

	}

}
