package com.tmdt.nhom03.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tmdt.nhom03.model.ChiTietDonHang;
import com.tmdt.nhom03.model.DonHang;
import com.tmdt.nhom03.model.NguoiDung;
import com.tmdt.nhom03.service.CaNhanService;

@Controller
public class CaNhan {

	@Autowired
	CaNhanService caNhanService;
	
	@RequestMapping("/ThongTinCaNhan")
		public String CaNhan(HttpSession session, HttpServletRequest request) {
			String username = (String) session.getAttribute("user");
			 NguoiDung nd = caNhanService.getNguoiDungbyUsername(username);
			 
			 request.setAttribute("canhan", nd);
			return "CaNhan";
		}
	
	@RequestMapping("/DonHangCuaToi")
	public String DonHangCuaToi(HttpSession session, HttpServletRequest request) {
		
		String username = (String) session.getAttribute("user");
		NguoiDung nguoiDung = caNhanService.getNguoiDungbyUsername(username);
		List<DonHang> list = caNhanService.getDonHangbyNguoiDung(nguoiDung);
		
		request.setAttribute("dsdonhang", list);
		return "DonHangCuaToi";
	}
	
	@RequestMapping("/XemChiTietDonHang")
	public String XemChiTietDonHang(HttpServletRequest request, HttpSession session) {
		int maDonHang = Integer.parseInt(request.getParameter("id"));
		List<ChiTietDonHang> list = caNhanService.getChiTietDonHangbyMaDonHang(maDonHang);
		
		String username = (String) session.getAttribute("user");
		NguoiDung nguoiDung = caNhanService.getNguoiDungbyUsername(username);
		List<DonHang> listdh = caNhanService.getDonHangbyNguoiDung(nguoiDung);
		request.setAttribute("dsdonhang", listdh);
		
		request.setAttribute("maDonHang", maDonHang);
		request.setAttribute("listCTDH", list);
		return "DonHangCuaToi";
	}
	
	@RequestMapping(value="/ThayDoiThongTin", method = RequestMethod.GET)
	public String ThayDoiThongTin( HttpSession session, HttpServletRequest request) {
		String username = (String) session.getAttribute("user");
		
		NguoiDung user = caNhanService.getNguoiDungbyUsername(username);
		request.setAttribute("thongtin", user);
		return "ThayDoiThongTinCaNhan";
	}
	
	@RequestMapping(value="/ThayDoiThongTin", method = RequestMethod.POST)
	public String ThayDoiThongTin(@ModelAttribute("nguoiDung") NguoiDung userInput, HttpSession session, HttpServletRequest request) {
		
		String username = (String) session.getAttribute("user");
		String passwordConfirm = request.getParameter("passwordconfirm");
		String oldPass = request.getParameter("oldPassword");
		
		NguoiDung user = caNhanService.getNguoiDungbyUsername(username);
		
		user.setEmail(userInput.getEmail());
		user.setDiaChi(userInput.getDiaChi());
		user.setSoDienThoai(userInput.getSoDienThoai());
		user.setTenNguoiDung(userInput.getTenNguoiDung());
		
		if(!oldPass.equals("")) {
			if(oldPass.equals(user.getPass())) {
				if(passwordConfirm.equals(userInput.getPass())) {
					user.setPass(passwordConfirm);
				}else {
					request.setAttribute("thongbao", "Mật khẩu mới gõ lại chưa khớp.");
					return "ThayDoiThongTinCaNhan";
				}
			}else {
				request.setAttribute("thongbao", "Mật khẩu cũ không chính xác.");
				return "ThayDoiThongTinCaNhan";
			}
		}
		
		caNhanService.updateNguoiDung(user);
		
		return "redirect:ThongTinCaNhan";
	}
	
}
