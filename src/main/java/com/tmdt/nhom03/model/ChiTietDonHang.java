/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmdt.nhom03.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anh Tu Dev
 */
@Entity
@Table(name = "ChiTietDonHang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChiTietDonHang.findAll", query = "SELECT c FROM ChiTietDonHang c")
    , @NamedQuery(name = "ChiTietDonHang.findByMaDonHang", query = "SELECT c FROM ChiTietDonHang c WHERE c.chiTietDonHangPK.maDonHang = :maDonHang")
    , @NamedQuery(name = "ChiTietDonHang.findByMaSanPham", query = "SELECT c FROM ChiTietDonHang c WHERE c.chiTietDonHangPK.maSanPham = :maSanPham")
    , @NamedQuery(name = "ChiTietDonHang.findBySoLuongSanPham", query = "SELECT c FROM ChiTietDonHang c WHERE c.soLuongSanPham = :soLuongSanPham")
    , @NamedQuery(name = "ChiTietDonHang.findByGiaSanPham", query = "SELECT c FROM ChiTietDonHang c WHERE c.giaSanPham = :giaSanPham")})
public class ChiTietDonHang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChiTietDonHangPK chiTietDonHangPK;
    @Column(name = "SoLuongSanPham")
    private Integer soLuongSanPham;
    @Column(name = "GiaSanPham")
    private Integer giaSanPham;
    @JoinColumn(name = "MaDonHang", referencedColumnName = "MaDonHang", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DonHang donHang;
    @JoinColumn(name = "MaSanPham", referencedColumnName = "MaSanPham", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SanPham sanPham;

    public ChiTietDonHang() {
    }

    public ChiTietDonHang(ChiTietDonHangPK chiTietDonHangPK) {
        this.chiTietDonHangPK = chiTietDonHangPK;
    }
    

    public ChiTietDonHang(SanPham sanPham, Integer soLuongSanPham, Integer giaSanPham) {
		super();
		this.soLuongSanPham = soLuongSanPham;
		this.giaSanPham = giaSanPham;
		this.sanPham = sanPham;
	}

	public ChiTietDonHang(int maDonHang, int maSanPham) {
        this.chiTietDonHangPK = new ChiTietDonHangPK(maDonHang, maSanPham);
    }

    public ChiTietDonHangPK getChiTietDonHangPK() {
        return chiTietDonHangPK;
    }

    public void setChiTietDonHangPK(ChiTietDonHangPK chiTietDonHangPK) {
        this.chiTietDonHangPK = chiTietDonHangPK;
    }

    public Integer getSoLuongSanPham() {
        return soLuongSanPham;
    }

    public void setSoLuongSanPham(Integer soLuongSanPham) {
        this.soLuongSanPham = soLuongSanPham;
    }

    public Integer getGiaSanPham() {
        return giaSanPham;
    }

    public void setGiaSanPham(Integer giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public DonHang getDonHang() {
        return donHang;
    }

    public void setDonHang(DonHang donHang) {
        this.donHang = donHang;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chiTietDonHangPK != null ? chiTietDonHangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietDonHang)) {
            return false;
        }
        ChiTietDonHang other = (ChiTietDonHang) object;
        if ((this.chiTietDonHangPK == null && other.chiTietDonHangPK != null) || (this.chiTietDonHangPK != null && !this.chiTietDonHangPK.equals(other.chiTietDonHangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhom13.entity.ChiTietDonHang[ chiTietDonHangPK=" + chiTietDonHangPK + " ]";
    }
    
}
