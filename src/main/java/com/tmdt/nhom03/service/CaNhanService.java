package com.tmdt.nhom03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tmdt.nhom03.dao.ChiTietDonHangDAO;
import com.tmdt.nhom03.dao.DonHangDAO;
import com.tmdt.nhom03.dao.NguoiDungDAO;
import com.tmdt.nhom03.model.ChiTietDonHang;
import com.tmdt.nhom03.model.DonHang;
import com.tmdt.nhom03.model.NguoiDung;

@Service
@Transactional
public class CaNhanService {

	@Autowired
	DonHangDAO donHangDAO;
	@Autowired
	NguoiDungDAO nguoiDungDAO;
	@Autowired
	ChiTietDonHangDAO chiTietDonHangDAO;
	
	public List<DonHang> getDonHangbyNguoiDung(NguoiDung nguoiDung) {
		return donHangDAO.getDonHangFindByNguoiDung(nguoiDung);
	}
	
	public NguoiDung getNguoiDungbyUsername(String username) {
		return nguoiDungDAO.getNguoiDungFindByUsername(username);
	}
	
	public NguoiDung updateNguoiDung(NguoiDung nguoiDung) {
		return nguoiDungDAO.mergeNguoiDung(nguoiDung);
	}
	
	public List<ChiTietDonHang> getChiTietDonHangbyMaDonHang(int maDonHang){
		return chiTietDonHangDAO.getChiTietDonHangFindByMaDonHang(maDonHang);
	}
}
