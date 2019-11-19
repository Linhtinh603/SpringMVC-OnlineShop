package controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhom13.dao.DanhMucDAORemote;
import com.nhom13.dao.SanPhamDAORemote;
import com.nhom13.entity.DanhMuc;
import com.nhom13.entity.SanPham;

/**
 * Servlet implementation class SuaSanPham_QuanLy
 */
@WebServlet("/SuaSanPham_QuanLy")
public class SuaSanPham_QuanLy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @EJB
       private SanPhamDAORemote sanPhamDAORemote;
       
       @EJB
       private DanhMucDAORemote danhMucDAORemote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaSanPham_QuanLy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SanPham sanPham = sanPhamDAORemote.getSanPhamFindByMaSanPham(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("ttsp", sanPham);
		List<DanhMuc> danhMucs = danhMucDAORemote.getDanhMucFindAll();
		request.setAttribute("dsdm", danhMucs);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("/WEB-INF/view/SuaThongTinSanPham.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SanPham sanPham = sanPhamDAORemote.getSanPhamFindByMaSanPham(Integer.parseInt(request.getParameter("id")));
		sanPham.setTenSanPham(request.getParameter("tensanpham"));
		sanPham.setGia(Integer.parseInt(request.getParameter("gia")));
		sanPham.setSoLuong(Integer.parseInt(request.getParameter("soluong")));
		sanPham.setMoTa(request.getParameter("mota"));
		sanPham.setHinh(request.getParameter("hinh"));
		DanhMuc danhMuc =  danhMucDAORemote.getDanhMucFindByMaDanhMuc(Integer.parseInt(request.getParameter("madanhmuc")));
		sanPham.setMaDanhMuc(danhMuc);
		sanPham.toString();
		sanPhamDAORemote.mergeSanPham(sanPham);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.sendRedirect("QuanLySanPham");
	}

}
