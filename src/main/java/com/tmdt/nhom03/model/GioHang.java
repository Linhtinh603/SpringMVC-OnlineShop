package com.tmdt.nhom03.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GioHang implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static List<SanPham> listSP  = new ArrayList<SanPham>();
	
	public GioHang() {
		super();
		
	}
	
    public static List<SanPham> getListSP() {
		return listSP;
	}

	public static void themSanPham(SanPham sp) {
    	listSP.add(sp);
    }
    
    public static void xoaSanPham(SanPham sp) {
    	listSP.remove(sp);
    }

}
