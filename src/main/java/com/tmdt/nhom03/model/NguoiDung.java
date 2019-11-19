/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmdt.nhom03.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author anhtu
 */
@Entity
@Table(name = "NguoiDung")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NguoiDung.findAll", query = "SELECT n FROM NguoiDung n")
    , @NamedQuery(name = "NguoiDung.findByMaNguoiDung", query = "SELECT n FROM NguoiDung n WHERE n.maNguoiDung = :maNguoiDung")
    , @NamedQuery(name = "NguoiDung.findByTenNguoiDung", query = "SELECT n FROM NguoiDung n WHERE n.tenNguoiDung = :tenNguoiDung")
    , @NamedQuery(name = "NguoiDung.findByDiaChi", query = "SELECT n FROM NguoiDung n WHERE n.diaChi = :diaChi")
    , @NamedQuery(name = "NguoiDung.findByEmail", query = "SELECT n FROM NguoiDung n WHERE n.email = :email")
    , @NamedQuery(name = "NguoiDung.findBySoDienThoai", query = "SELECT n FROM NguoiDung n WHERE n.soDienThoai = :soDienThoai")
    , @NamedQuery(name = "NguoiDung.findByUsername", query = "SELECT n FROM NguoiDung n WHERE n.username = :username")
    , @NamedQuery(name = "NguoiDung.findByPass", query = "SELECT n FROM NguoiDung n WHERE n.pass = :pass")
    , @NamedQuery(name = "NguoiDung.findByIsNhanVien", query = "SELECT n FROM NguoiDung n WHERE n.isNhanVien = :isNhanVien")})
public class NguoiDung implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "MaNguoiDung")
    private Integer maNguoiDung;
    @Basic(optional = false)
    @Column(name = "TenNguoiDung")
    private String tenNguoiDung;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "Email")
    private String email;
    @Column(name = "SoDienThoai")
    private String soDienThoai;
    @Basic(optional = false)
    @Column(name = "Username")
    private String username;
    @Basic(optional = false)
    @Column(name = "Pass")
    private String pass;
    @Basic(optional = false)
    @Column(name = "isNhanVien")
    private boolean isNhanVien;
    @OneToMany(mappedBy = "maNguoiDung", fetch = FetchType.LAZY)
    private List<DonHang> hoaDonList;

    public NguoiDung() {
    }

    public NguoiDung(Integer maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }
    
    public NguoiDung(String tenNguoiDung, String diaChi, String email, String soDienThoai, String username, String pass,
			boolean isNhanVien) {
		super();
		this.tenNguoiDung = tenNguoiDung;
		this.diaChi = diaChi;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.username = username;
		this.pass = pass;
		this.isNhanVien = isNhanVien;
	}

	public NguoiDung(Integer maNguoiDung, String tenNguoiDung, String username, String pass, boolean isNhanVien) {
        this.maNguoiDung = maNguoiDung;
        this.tenNguoiDung = tenNguoiDung;
        this.username = username;
        this.pass = pass;
        this.isNhanVien = isNhanVien;
    }

    public Integer getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(Integer maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean getIsNhanVien() {
        return isNhanVien;
    }

    public void setIsNhanVien(boolean isNhanVien) {
        this.isNhanVien = isNhanVien;
    }

    @XmlTransient
    public List<DonHang> getDonHangList() {
        return hoaDonList;
    }

    public void setDonHangList(List<DonHang> hoaDonList) {
        this.hoaDonList = hoaDonList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maNguoiDung != null ? maNguoiDung.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NguoiDung)) {
            return false;
        }
        NguoiDung other = (NguoiDung) object;
        if ((this.maNguoiDung == null && other.maNguoiDung != null) || (this.maNguoiDung != null && !this.maNguoiDung.equals(other.maNguoiDung))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication7.NguoiDung[ maNguoiDung=" + maNguoiDung + " ]";
    }
    
}
