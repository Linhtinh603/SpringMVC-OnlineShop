package com.tmdt.nhom03.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.tmdt.nhom03.model.ChiTietDonHang;
import com.tmdt.nhom03.model.DanhMuc;
import com.tmdt.nhom03.model.DonHang;
import com.tmdt.nhom03.model.MyFile;
import com.tmdt.nhom03.model.NguoiDung;
import com.tmdt.nhom03.model.SanPham;
import com.tmdt.nhom03.service.QuanLyService;



@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 50) // 50MB
@Controller
public class QuanLyController {
	@Autowired
	private QuanLyService quanLyService;
	//---------------------------------------- Quản lý đơn hàng -----------------------------------------------------
	@RequestMapping(value="/QuanLyDonHang", method = RequestMethod.GET)
	public String quanlydonhang(ModelMap model, HttpSession session) {
		if(session.getAttribute("admin") != null){
			List<DonHang> donHangsCu = quanLyService.getAllDonHangCu();
			List<DonHang> donHangsMoi = quanLyService.getAllDonHangMoi();
			model.addAttribute("dsdhtrue", donHangsCu);
			model.addAttribute("dsdhfalse", donHangsMoi);
			return "QuanLyDonHang";
		}else {
			return "redirect:/";
		}
	}
	@RequestMapping(value="/QuanLyDonHangXacNhan", method = RequestMethod.POST)
	public String quanlydonhangxacnhan(HttpSession session, ModelMap model
			, @RequestParam(name="ma", required= true) int maDonHang) throws IOException {
		
		if(session.getAttribute("admin") != null){
			DonHang donHang2 = quanLyService.getDonHangByMaDonHang(maDonHang);
			donHang2.setTinhTrangDonHang(1);
			quanLyService.updateDonHang(donHang2);
			return "redirect:QuanLyDonHang";
		}else {
			return "redirect:/";
		}
	}
	@RequestMapping(value="/QuanLyDonHangHuy", method = RequestMethod.POST)
	public String quanlydonhanghuy(HttpSession session, ModelMap model
			, @RequestParam(name="ma", required= true) int maDonHang) throws IOException {
		if(session.getAttribute("admin") != null){
			DonHang donHang = quanLyService.getDonHangByMaDonHang(maDonHang);
			donHang.setTinhTrangDonHang(0);
			quanLyService.updateDonHang(donHang);
			return "redirect:QuanLyDonHang";
		}else {
			return "redirect:/";
		}
	}
	
	
	
	//---------------------------------------- Quản lý sản phẩm -----------------------------------------------------
	@RequestMapping(value="/QuanLySanPham")
	public String quanlysanpham(HttpSession session, HttpServletRequest request, Model model, @RequestParam(name="tbloi", required = false) String ttb) throws UnsupportedEncodingException {
		if(session.getAttribute("admin") != null){
			List<SanPham> phams = quanLyService.getAllSanPhamByTinhTrang(true);
			List<DanhMuc> danhMucs = quanLyService.getAllDanhMuc();
			model.addAttribute("dssp", phams);
			model.addAttribute("dsdm", danhMucs);
			model.addAttribute("sanpham", new SanPham());
			model.addAttribute("thongbaoloi", ttb);
			model.addAttribute("myFile", new MyFile());
			request.setCharacterEncoding("utf-8");
			return "QuanLySanPham";
		}else {
			return "redirect:/";
		}
	}
	@RequestMapping(value="/ThemSanPham", method = RequestMethod.POST)
	public RedirectView themsanpham(HttpSession session, HttpServletRequest request, RedirectAttributes redirectAttributes, MyFile myFile, Model model) throws IllegalStateException, IOException {
		if(session.getAttribute("admin") != null){
			SanPham pham =  new SanPham();
			try {
				pham = (SanPham) quanLyService.getSanPhamByTen(request.getParameter("tensanpham"));
				String  loi = "Sản phẩm đã tồn tại hoặc lỗi nhập liệu";
				redirectAttributes.addAttribute("tbloi", loi);
				return new RedirectView("QuanLySanPham");
			} catch (Exception e) {
				e.printStackTrace();
				pham = null;
			}	
			
			if(pham == null) {
				//------------------------------------
					MultipartFile multipartFile = myFile.getMultipartFile();
					String fileName = multipartFile.getOriginalFilename();
					System.out.println(fileName + "---------------------tên file hinh----------------------------");
					String filePath = "D:/IUHData/Thuong mai dien tu/TMDT_NHOM03_WEBSITEBANLINHKIENDIENTU/src/main/webapp/resources/images/HinhSanPham";
					File file = new File(filePath, fileName);
					multipartFile.transferTo(file);
					
				//------------------------------------
				SanPham sanPham = new SanPham();
				sanPham.setTenSanPham(request.getParameter("tensanpham"));
				sanPham.setGia(Integer.parseInt(request.getParameter("gia")));
				sanPham.setSoLuong(Integer.parseInt(request.getParameter("soluong")));
				sanPham.setMoTa(request.getParameter("mota"));
				//sanPham.setHinh(request.getParameter("hinh"));
				sanPham.setHinh("resources/images/HinhSanPham/" + fileName);
				DanhMuc danhMuc =  quanLyService.getDanhMucByMa(Integer.parseInt(request.getParameter("madanhmuc")));
				sanPham.setMaDanhMuc(danhMuc);
				sanPham.setTinhTrang(true);
				System.out.println("##################################Chayj vaof them san pham################################################");
				quanLyService.ThemSanPham(sanPham);
				return new RedirectView("QuanLySanPham");
			}
			return new RedirectView("QuanLySanPham");
		}else {
			return new RedirectView("/");
		}
		
	}
	@RequestMapping(value="/XoaSanPham_QuanLy")
	public RedirectView XoaSanPham_QuanLy(HttpSession session, HttpServletRequest request) throws IOException {
		if(session.getAttribute("admin") != null){
			List<ChiTietDonHang> list = quanLyService.getAllChiTietDonHang();
			boolean dinhchum = false ;
			for (ChiTietDonHang ct:list) {
				if (ct.getSanPham().getMaSanPham() == Integer.parseInt(request.getParameter("id"))) {
					dinhchum = true;
				}
			}
			if (dinhchum == false) {
				SanPham sanPhamXoa = quanLyService.getSanPhamByMa(Integer.parseInt(request.getParameter("id")));
				quanLyService.XoaSanPham(sanPhamXoa);
				return new RedirectView("QuanLySanPham");
			}else {
				SanPham sanPhamXoa = quanLyService.getSanPhamByMa(Integer.parseInt(request.getParameter("id")));
				sanPhamXoa.setTinhTrang(false);
				quanLyService.UpdateSanPham(sanPhamXoa);
				return new RedirectView("QuanLySanPham");
			}
		}else {
			return new RedirectView("/");
		}
		
	}
	@RequestMapping(value="QuanLySanPham_TimTen")
	public String TimKiemTheoTen(Model model, HttpServletRequest request, HttpSession session) {
		if(session.getAttribute("admin") != null){
			String ten = request.getParameter("tkten");
			if(ten == "") {
				return "redirect:QuanLySanPham";
			}else {
				List<SanPham> phams = quanLyService.getAllSanPhamByTinhTrang(true);
				ArrayList<SanPham> listNew = new ArrayList<SanPham>();
				System.out.println(ten + "???????????????????????????????????????????????");
				for (SanPham sp : phams) {
					if (ten.equalsIgnoreCase(sp.getTenSanPham())) {
						listNew.add(sp);
					}
				}
				System.out.println(listNew + "++++++++++++++++++++++++++++++++++++++++++++++++");
				model.addAttribute("dssp", listNew);
				List<DanhMuc> danhMucs = quanLyService.getAllDanhMuc();
				model.addAttribute("dsdm", danhMucs);
				model.addAttribute("sanpham", new SanPham());
				return "QuanLySanPham";
			}
		}else {
			return "redirect:/";
		}
	}
	@RequestMapping(value="QuanLySanPham_TimDanhMuc")
	public String TimKiemTheoDanhMuc(Model model, HttpServletRequest request, HttpSession session) {
		if(session.getAttribute("admin") != null){
			if (request.getParameter("madanhmuc").equals("all")) {
				return "redirect:QuanLySanPham";
			}else {
				int madm = Integer.parseInt(request.getParameter("madanhmuc"));
				System.out.println(madm + "||||||||||||||||||||||||||||||||||||||||||||||");
				List<SanPham> sanPhams = quanLyService.getAllSanPhamByTinhTrang(true);
				List<SanPham> listNew = new ArrayList<SanPham>();
				for (SanPham ss : sanPhams) {
					System.out.println(ss.getMaDanhMuc().getMaDanhMuc() + ">>>");
					if (ss.getMaDanhMuc().getMaDanhMuc() == madm) {
						listNew.add(ss);
					}
				}
				System.out.println(listNew + "++++++++++++++++++++++++++++++++++++++++++++++++");
				model.addAttribute("dssp", listNew);
				List<DanhMuc> danhMucs = quanLyService.getAllDanhMuc();
				model.addAttribute("dsdm", danhMucs);
				model.addAttribute("sanpham", new SanPham());
				return "QuanLySanPham";
			}
		}else {
			return "redirect:/";
		}
	}
	
	
	@RequestMapping(value="QuanLySanPham_SuaSanPham")
	public String SuaSanPham(HttpSession session, Model model, HttpServletRequest request) throws IOException {
		if(session.getAttribute("admin") != null){
			SanPham sanPham = quanLyService.getSanPhamByMa(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("ttsp", sanPham);
			List<DanhMuc> danhMucs = quanLyService.getAllDanhMuc();
			request.setAttribute("dsdm", danhMucs);
			model.addAttribute("myFile", new MyFile());
			return "SuaThongTinSanPham";
		}else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="QuanLySanPham_LuuSanPhamSua", method = RequestMethod.POST)
	public RedirectView LuuSanPhamSua(HttpSession session, Model model, HttpServletRequest request, MyFile myFile) throws IllegalStateException, IOException {
		
		if(session.getAttribute("admin") != null){
			SanPham sanPham = quanLyService.getSanPhamByMa(Integer.parseInt(request.getParameter("masanpham")));
			sanPham.setTenSanPham(request.getParameter("tensanpham"));
			sanPham.setGia(Integer.parseInt(request.getParameter("gia")));
			sanPham.setSoLuong(Integer.parseInt(request.getParameter("soluong")));
			sanPham.setMoTa(request.getParameter("mota"));
			sanPham.setHinh(request.getParameter("hinh"));
			
			DanhMuc danhMuc =  quanLyService.getDanhMucByMa(Integer.parseInt(request.getParameter("madanhmuc")));
			sanPham.setMaDanhMuc(danhMuc);
			quanLyService.UpdateSanPham(sanPham);
			return new RedirectView("QuanLySanPham");
		}else {
			return new RedirectView("/");
		}
	}	
	
	//---------------------------------------- Quản lý ngư�?i dùng -----------------------------------------------------
	@RequestMapping(value="/QuanLyNguoiDung")
	public String quanlynguoidung(ModelMap map, HttpSession session) {
		if(session.getAttribute("admin") != null){
			List<NguoiDung> dungs = quanLyService.getAllNguoiDung();
			map.addAttribute("dsnd", dungs);
			return "QuanLyNguoiDung";
		}else {
			return "redirect:/";
		}
	}

}
