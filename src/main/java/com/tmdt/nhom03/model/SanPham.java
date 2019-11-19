/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmdt.nhom03.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Anh Tu Dev
 */
@Entity
@Table(name = "SanPham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SanPham.findAll", query = "SELECT s FROM SanPham s")
    , @NamedQuery(name = "SanPham.findByMaSanPham", query = "SELECT s FROM SanPham s WHERE s.maSanPham = :maSanPham")
    , @NamedQuery(name = "SanPham.findByTenSanPham", query = "SELECT s FROM SanPham s WHERE s.tenSanPham = :tenSanPham")
    , @NamedQuery(name = "SanPham.findByGia", query = "SELECT s FROM SanPham s WHERE s.gia = :gia")
    , @NamedQuery(name = "SanPham.findBySoLuong", query = "SELECT s FROM SanPham s WHERE s.soLuong = :soLuong")
    , @NamedQuery(name = "SanPham.findByMoTa", query = "SELECT s FROM SanPham s WHERE s.moTa = :moTa")
    , @NamedQuery(name = "SanPham.findByHinh", query = "SELECT s FROM SanPham s WHERE s.hinh = :hinh")
    , @NamedQuery(name = "SanPham.findByTinhTrang", query = "SELECT s FROM SanPham s WHERE s.tinhTrang = :tinhTrang")
    , @NamedQuery(name= "SanPham.findByDanhMuc", query = "SELECT s FROM SanPham s WHERE s.maDanhMuc = :maDanhMuc")})
public class SanPham implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "MaSanPham")
    private Integer maSanPham;
    @Basic(optional = false)
    @Column(name = "TenSanPham")
    private String tenSanPham;
    @Basic(optional = false)
    @Column(name = "Gia")
    private int gia;
    @Basic(optional = false)
    @Column(name = "SoLuong")
    private int soLuong;
    @Column(name = "MoTa")
    private String moTa;
    @Column(name = "Hinh")
    private String hinh;
    @Column(name = "TinhTrang")
    private Boolean tinhTrang;
    @JoinColumn(name = "MaDanhMuc", referencedColumnName = "MaDanhMuc")
    @ManyToOne
    private DanhMuc maDanhMuc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sanPham")
    private List<ChiTietDonHang> chiTietHoaDonList;

    public SanPham() {
    }

    public SanPham(Integer maSanPham) {
        this.maSanPham = maSanPham;
    }

    public SanPham(Integer maSanPham, String tenSanPham, int gia, int soLuong) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    public Boolean getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(Boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public Integer getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(Integer maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public DanhMuc getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(DanhMuc maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    @XmlTransient
    public List<ChiTietDonHang> getChiTietDonHangList() {
        return chiTietHoaDonList;
    }

    public void setChiTietDonHangList(List<ChiTietDonHang> chiTietHoaDonList) {
        this.chiTietHoaDonList = chiTietHoaDonList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maSanPham != null ? maSanPham.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SanPham)) {
            return false;
        }
        SanPham other = (SanPham) object;
        if ((this.maSanPham == null && other.maSanPham != null) || (this.maSanPham != null && !this.maSanPham.equals(other.maSanPham))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", gia=" + gia + ", soLuong="
				+ soLuong + ", moTa=" + moTa + ", hinh=" + hinh + ", tinhTrang=" + tinhTrang + ", maDanhMuc="
				+ maDanhMuc + "]";
	}

	

    
    
}
