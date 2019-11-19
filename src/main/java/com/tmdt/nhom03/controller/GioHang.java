package com.tmdt.nhom03.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tmdt.nhom03.model.ChiTietDonHang;
import com.tmdt.nhom03.model.ChiTietDonHangPK;
import com.tmdt.nhom03.model.DonHang;
import com.tmdt.nhom03.model.NguoiDung;
import com.tmdt.nhom03.model.SanPham;
import com.tmdt.nhom03.service.GioHangService;

@Controller
public class GioHang {
	@Autowired
	private GioHangService gioHangService;
	
	@RequestMapping("/ThongTinGioHang")
	public String ThongTinGioHang(HttpSession session, ModelMap model) {
		List<ChiTietDonHang> list = (List<ChiTietDonHang>) session.getAttribute("cart");
		int tongtien = 0;
		if(list == null) {
			return "/GioHang";
		}else {
			for(ChiTietDonHang ct : list) {
				tongtien += ct.getGiaSanPham() * ct.getSoLuongSanPham();
			}
			model.addAttribute("tongtien", tongtien);
			return "/GioHang";
		}
	}
	
	@RequestMapping("/CapNhatGioHang")
	public String CapNhatGioHang(HttpServletRequest request, HttpSession session) {
		
		int sl = Integer.parseInt(request.getParameter("sl"));
		int id = Integer.parseInt(request.getParameter("id"));
		List<ChiTietDonHang> list = (List<ChiTietDonHang>) session.getAttribute("cart");
		
		if(list != null) {
			int soluong;
			
			for(ChiTietDonHang ct : list) {
				if(ct.getSanPham().getMaSanPham() == id) {
					soluong = ct.getSoLuongSanPham();
					if(soluong+sl <1 || soluong+sl> gioHangService.getSanPhambyMaSanPham(id).getSoLuong() ) {
						return "redirect:ThongTinGioHang";
					}else {
						ct.setSoLuongSanPham(soluong+sl);
						return "redirect:ThongTinGioHang";
					}
				}
			}
		}
		
		return "redirect:ThongTinGioHang";
	}
	
	@RequestMapping(value="/XacNhanDonHang")
	public String XacNhanDonHang(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>vao xac nha don hang");
		List<ChiTietDonHang> chiTietDonHangList = (List<ChiTietDonHang>) session.getAttribute("cart");
		
		String user = (String) session.getAttribute("user");
		if(user == null) {
			String thongbao = "Bạn cần đăng nhập trước khi xác nhận đơn hàng";
			request.setAttribute("thongbao", thongbao);
			return "DangNhap";
		}else {
			DonHang dh = new DonHang();
			NguoiDung nd  = gioHangService.findNguoiDungbyUsername(user);
			
			dh.setMaNguoiDung(nd);
			 dh.setTinhTrangDonHang(-1);
			LocalDate ldate = LocalDate.now();
			Date date = Date.valueOf(ldate);
			dh.setNgayTaoDonHang(date);
			gioHangService.saveDonHang(dh);
			
			List<DonHang> ListDH = gioHangService.getAllDonHang();
			DonHang dhnew = ListDH.get((ListDH.size()) - 1);
			
			List<ChiTietDonHang> ctdhcc = dh.getChiTietDonHangList();
			for (ChiTietDonHang ct : chiTietDonHangList){
				ChiTietDonHang ctcc = new ChiTietDonHang();
				ChiTietDonHangPK pk = new ChiTietDonHangPK(dhnew.getMaDonHang(), ct.getSanPham().getMaSanPham());
				ctcc.setChiTietDonHangPK(pk);
				ctcc.setGiaSanPham(ct.getSanPham().getGia());
				ctcc.setSoLuongSanPham(ct.getSoLuongSanPham());
				ctcc.setDonHang(dhnew);
				ctcc.setSanPham(ct.getSanPham());
				gioHangService.saveChiTietDonHang(ctcc);
				session.removeAttribute("cart");
			}
			return "redirect:/";
		}
		
	}
	
	@RequestMapping(value="/XoaSanPhamGioHang")
	public String xoaSanPhamGioHang(HttpSession session, HttpServletRequest request) {
		
		List<ChiTietDonHang> list =  (List<ChiTietDonHang>) session.getAttribute("cart");
		
		int id = Integer.parseInt(request.getParameter("id"));
		List<ChiTietDonHang> list2 =new ArrayList<ChiTietDonHang>();
		for(ChiTietDonHang ct : list) {
			if(ct.getSanPham().getMaSanPham() != id) {
				//list.remove(ct);
				list2.add(ct);
			}
		}
		session.setAttribute("cart", list2);
		return "redirect:ThongTinGioHang";
		
		

	}
		
	

}
