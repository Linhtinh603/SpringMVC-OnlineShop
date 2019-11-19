package com.tmdt.nhom03.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tmdt.nhom03.model.DanhMuc;
import com.tmdt.nhom03.model.SanPham;
import com.tmdt.nhom03.service.HomeService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class Home {
	@Autowired
	private HomeService homeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session, HttpServletRequest request, ModelMap model) {
		session = request.getSession();
		
		List<DanhMuc> danhMucs = homeService.findAllDanhMuc();
		List<SanPham> sanPhams = homeService.getAllSanPhamByTinhTrang(true);
		model.addAttribute("dssp", sanPhams);
		session.setAttribute("dsdm", danhMucs);
		return "index";
	}
	
	@RequestMapping("/DanhMucSanPham")
	public String HienThiSanPhamTheoDanhMuc(HttpServletRequest request, ModelMap model) {
		int maDanhMuc = Integer.parseInt(request.getParameter("id"));
		DanhMuc dm = homeService.findDanhMucbyMaDanhMuc(maDanhMuc);
		List<SanPham> sanPhams = homeService.findSanPhambyDanhMuc(dm);
		model.addAttribute("dssp", sanPhams);
		request.setAttribute("tenDanhMuc", dm.getTenDanhMuc());
		return "index";
		
	}
	@RequestMapping("/ChiTietSanPham")
	public String ChiTietSanPham(HttpServletRequest request) {
		int masp = Integer.parseInt(request.getParameter("id"));
		SanPham sanPham = homeService.findSanPhambyID(masp);
		request.setAttribute("ttsp", sanPham);
		List<SanPham> sanPhams = homeService.findAllSanPham();
		request.setAttribute("dssp", sanPhams);
		return "ThongTinSanPham";
	}
}
