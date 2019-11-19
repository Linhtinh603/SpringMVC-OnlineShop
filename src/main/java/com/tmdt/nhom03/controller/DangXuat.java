package com.tmdt.nhom03.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DangXuat {

	@RequestMapping("/DangXuat")
	public String DangXuat(HttpSession session) {
		
		session.removeAttribute("user");
		
		return "redirect:/";
	}
}
