package com.tmdt.nhom03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tmdt.nhom03.dao.NguoiDungDAO;
import com.tmdt.nhom03.model.NguoiDung;

@Service
@Transactional
public class DangNhapService {

	@Autowired
	NguoiDungDAO nguoiDungDAO;
	
	public NguoiDung getNguoiDungbyUsername(String username) {
		return nguoiDungDAO.getNguoiDungFindByUsername(username);
	}
}
