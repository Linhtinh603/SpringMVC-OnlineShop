package com.tmdt.nhom03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tmdt.nhom03.dao.NguoiDungDAO;
import com.tmdt.nhom03.model.NguoiDung;

@Service
@Transactional
public class DangKyService {

	@Autowired
	NguoiDungDAO nguoiDungDAO;
	
	public NguoiDung saveNguoiDung(NguoiDung nguoiDung) {
		return nguoiDungDAO.persistNguoiDung(nguoiDung);
	}
	
	public NguoiDung getNguoiDungbyUsername(String username) {
		return nguoiDungDAO.getNguoiDungFindByUsername(username);
	}
}
