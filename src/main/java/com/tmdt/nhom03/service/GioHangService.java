package com.tmdt.nhom03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tmdt.nhom03.dao.ChiTietDonHangDAO;
import com.tmdt.nhom03.dao.DonHangDAO;
import com.tmdt.nhom03.dao.NguoiDungDAO;
import com.tmdt.nhom03.dao.SanPhamDAO;
import com.tmdt.nhom03.model.ChiTietDonHang;
import com.tmdt.nhom03.model.DonHang;
import com.tmdt.nhom03.model.NguoiDung;
import com.tmdt.nhom03.model.SanPham;

@Service
@Transactional
public class GioHangService {
	@Autowired
	private NguoiDungDAO nguoiDungDAO;
	@Autowired
	private DonHangDAO donHangDAO;
	@Autowired
	private SanPhamDAO sanPhamDAO;
	@Autowired
	private ChiTietDonHangDAO chiTietDonHangDAO;
	
	public NguoiDung findNguoiDungbyUsername(String username) {
		return nguoiDungDAO.getNguoiDungFindByUsername(username);
	}
	
	public DonHang saveDonHang(DonHang donHang) {
		return donHangDAO.persistDonHang(donHang);
	}
	
	public SanPham getSanPhambyMaSanPham(int maSanPham) {
		return sanPhamDAO.getSanPhamFindByMaSanPham(maSanPham);
	}
	public void saveChiTietDonHang(ChiTietDonHang chiTietDonHang) {
		chiTietDonHangDAO.persistChiTietDonHang(chiTietDonHang);
	}
	public List<DonHang> getAllDonHang(){
		return donHangDAO.getDonHangFindAll();
	}
}
