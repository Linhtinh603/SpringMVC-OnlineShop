package com.tmdt.nhom03.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.tmdt.nhom03.model.NguoiDung;
import com.tmdt.nhom03.service.DangKyService;

@Controller
public class DangKy {

	@Autowired
	DangKyService dangKyService;
	
	@RequestMapping(value="/DangKy", method = RequestMethod.GET)
	public String DangKy() {
		
		return "DangKy";
	}
	
	@RequestMapping(value="/DangKy", method = RequestMethod.POST)
	public String DangKy(HttpServletRequest request, @ModelAttribute("nguoidung") NguoiDung nd) {
		String passconfirm = request.getParameter("passwordconfirm");
		try {
			dangKyService.getNguoiDungbyUsername(nd.getUsername());
			request.setAttribute("thongbao", "Tên đăng nhập đã tồn tại, vui lòng dùng tên đăng nhập khác.");
			return "DangKy";
		} catch (Exception e) {
			if (!nd.getPass().equals(passconfirm)) {
				request.setAttribute("thongbao", "Mật khẩu nhập lại không khớp với nhau, hãy thử lại.");
				return "DangKy";
			} else {
				dangKyService.saveNguoiDung(nd);
				return "redirect:/";
			}
		}
		
	}
}
