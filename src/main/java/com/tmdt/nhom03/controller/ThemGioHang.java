package com.tmdt.nhom03.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tmdt.nhom03.model.ChiTietDonHang;
import com.tmdt.nhom03.model.ChiTietDonHangPK;
import com.tmdt.nhom03.model.SanPham;
import com.tmdt.nhom03.service.HomeService;

@Controller
public class ThemGioHang {
	@Autowired
	private HomeService homeService;
	
	@RequestMapping("/ThemGioHang")
	public String ThongTinGioHang(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		SanPham sp = homeService.findSanPhambyID(id);
		
		if(sp.getSoLuong() < 1) {
			 out.println("alert('Sản phẩm đã hết hàng.');");
		}else {
			List<ChiTietDonHang> dsDH = (List<ChiTietDonHang>) session.getAttribute("cart");
			
			if(dsDH == null) {
				 dsDH = new ArrayList<ChiTietDonHang>();
					session.setAttribute("cart", dsDH);
			}
			
			ChiTietDonHang ct = new ChiTietDonHang(sp, 1, sp.getGia());
			
			dsDH.add(ct);
			
			session.setAttribute("cart", dsDH);
			
			return "redirect:ThongTinGioHang";
		}
		
		return "redirect:ThongTinGioHang";

	}
}
