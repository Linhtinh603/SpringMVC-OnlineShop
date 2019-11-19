/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmdt.nhom03.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Anh Tu Dev
 */
@Entity
@Table(name = "DonHang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DonHang.findAll", query = "SELECT d FROM DonHang d")
    , @NamedQuery(name = "DonHang.findByMaDonHang", query = "SELECT d FROM DonHang d WHERE d.maDonHang = :maDonHang")
    , @NamedQuery(name = "DonHang.findByNgayTaoDonHang", query = "SELECT d FROM DonHang d WHERE d.ngayTaoDonHang = :ngayTaoDonHang")
    , @NamedQuery(name = "DonHang.findByTinhTrangDonHang", query = "SELECT d FROM DonHang d WHERE d.tinhTrangDonHang = :tinhTrangDonHang")
    , @NamedQuery(name = "DonHang.findByNguoiDung", query = "SELECT d FROM DonHang d WHERE d.maNguoiDung = :maNguoiDung")})
public class DonHang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "MaDonHang")
    private Integer maDonHang;
    @Column(name = "NgayTaoDonHang")
    @Temporal(TemporalType.DATE)
    private Date ngayTaoDonHang;
    @Basic(optional = false)
    @Column(name = "TinhTrangDonHang")
    private int tinhTrangDonHang;
    @JoinColumn(name = "MaNguoiDung", referencedColumnName = "MaNguoiDung")
    @ManyToOne
    private NguoiDung maNguoiDung;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "donHang", fetch = FetchType.EAGER)
    private List<ChiTietDonHang> chiTietDonHangList;

    public DonHang() {
    }

    public DonHang(Integer maDonHang) {
        this.maDonHang = maDonHang;
    }

    public DonHang(Integer maDonHang, int tinhTrangDonHang) {
        this.maDonHang = maDonHang;
        this.tinhTrangDonHang = tinhTrangDonHang;
    }

    public Integer getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(Integer maDonHang) {
        this.maDonHang = maDonHang;
    }

    public Date getNgayTaoDonHang() {
        return ngayTaoDonHang;
    }

    public void setNgayTaoDonHang(Date ngayTaoDonHang) {
        this.ngayTaoDonHang = ngayTaoDonHang;
    }

    public int getTinhTrangDonHang() {
        return tinhTrangDonHang;
    }

    public void setTinhTrangDonHang(int tinhTrangDonHang) {
        this.tinhTrangDonHang = tinhTrangDonHang;
    }

    public NguoiDung getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(NguoiDung maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    @XmlTransient
    public List<ChiTietDonHang> getChiTietDonHangList() {
        return chiTietDonHangList;
    }

    public void setChiTietDonHangList(List<ChiTietDonHang> chiTietDonHangList) {
        this.chiTietDonHangList = chiTietDonHangList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maDonHang != null ? maDonHang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DonHang)) {
            return false;
        }
        DonHang other = (DonHang) object;
        if ((this.maDonHang == null && other.maDonHang != null) || (this.maDonHang != null && !this.maDonHang.equals(other.maDonHang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhom13.entity.DonHang[ maDonHang=" + maDonHang + " ]";
    }
    
}
