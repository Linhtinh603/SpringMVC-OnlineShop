package com.tmdt.nhom03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tmdt.nhom03.dao.DanhMucDAO;
import com.tmdt.nhom03.dao.NguoiDungDAO;
import com.tmdt.nhom03.dao.SanPhamDAO;
import com.tmdt.nhom03.model.DanhMuc;
import com.tmdt.nhom03.model.SanPham;

@Service
@Transactional
public class HomeService {
	@Autowired
	private SanPhamDAO sanPhamDAO;
	@Autowired
	private DanhMucDAO danhMucDAO;
	
	public List<SanPham> findAllSanPham(){
		return sanPhamDAO.getSanPhamFindAll();
	}
	//Dat ten Class khac ko dc a/ chung cho nó g�?n rồi ai nhớ class nào ra class nào chỉ gần g�?i tới service nó tự source ra mà
	public List<DanhMuc> findAllDanhMuc(){
		return danhMucDAO.getDanhMucFindAll();
	}
	
	public SanPham findSanPhambyID(int id) {
		return sanPhamDAO.getSanPhamFindByMaSanPham(id);
	}
	
	public List<SanPham> findSanPhambyDanhMuc(DanhMuc danhMuc){
		return sanPhamDAO.getSanPhamFindByDanhMuc(danhMuc);
	}
	
	public DanhMuc findDanhMucbyMaDanhMuc(int maDanhMuc) {
		return danhMucDAO.getDanhMucFindByMaDanhMuc(maDanhMuc);
	}
	
	public List<SanPham> getAllSanPhamByTinhTrang(boolean tinhTrang) {
		return sanPhamDAO.getSanPhamFindByTinhTrang(tinhTrang);
	}
}
