package com.tmdt.nhom03.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.tmdt.nhom03.model.NguoiDung;
import com.tmdt.nhom03.service.DangNhapService;

@Controller
public class DangNhap {
	@Autowired
	DangNhapService dangNhapservice;
	
	@RequestMapping(value= "/DangNhap", method = RequestMethod.GET)
	public String DangNhap() {
		return "DangNhap";
	}
	
	@RequestMapping(value="/DangNhap", method = RequestMethod.POST)
	public String DangNhap(HttpServletRequest request, HttpSession session, @ModelAttribute("user") NguoiDung nd) {
		NguoiDung ndDB = null;
		try {
			ndDB = dangNhapservice.getNguoiDungbyUsername(nd.getUsername());
		}catch(Exception e){
			if(e != null) {
				ndDB = new NguoiDung();
			}
		}
		if(nd.getPass().equals(ndDB.getPass())) {
			session.setAttribute("user", ndDB.getUsername());
			if(ndDB.getIsNhanVien()) {
				session.setAttribute("admin", "1");
				return "redirect:QuanLyDonHang";
			}else {
				return "redirect:/";
			}
		}else {
			request.setAttribute("thongbao", "Tài khoản hoặc mật khẩu chưa chính xác. Vui lòng thử lại.");
			return "DangNhap";
		}
	}
}
