package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.PageContext;

import java.io.IOException;

import dao.NhanVienDao;
import dao.PhongBanDao;
import daoimpl.NhanVienImpl;
import daoimpl.PhongBanImpl;
import entities.NhanVien;
import entities.PhongBan;

/**
 * Servlet implementation class QuanLyNhanVienServlet
 */
@WebServlet("/QuanLyNhanVienServlet")
public class QuanLyNhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NhanVienDao nhanVienDao;

	public QuanLyNhanVienServlet() {
		super();
		nhanVienDao = new NhanVienImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("listNV", nhanVienDao.getAllNhanVien());
		request.setAttribute("tongNV", nhanVienDao.getAllNhanVien().size());
		request.getRequestDispatcher("DanhSachNhanVien.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maNhanVien = request.getParameter("maNhanVien");
		if (maNhanVien != null) {
			nhanVienDao.deleteNhanVien(maNhanVien);
			response.sendRedirect(request.getContextPath() + "/QuanLyNhanVienServlet");
		} else {
			request.setAttribute("error", "Xóa nhân viên thất bại");
			doGet(request, response);
		}
	}

}
