package com.tmdt.nhom03.dao;

import java.util.List;
import javax.annotation.Resource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tmdt.nhom03.model.DanhMuc;
import com.tmdt.nhom03.model.SanPham;


/**
 * @generated DT_ID=none
 */
@Repository
@Transactional(rollbackFor = Exception.class)
public class SanPhamDAO{

    /**
     * @generated DT_ID=none
     */

    /**
     * @generated DT_ID=none
     */
	@PersistenceContext
    private EntityManager em;

    /**
     * @generated DT_ID=none
     */
    public SanPhamDAO() {
    }
    
    

    /**
     * @generated DT_ID=none
     */
    public Object queryByRange(String jpqlStmt, int firstResult,
                               int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }

        return query.getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    public SanPham persistSanPham(SanPham sanPham) {
        em.persist(sanPham);
        return sanPham;
    }

    /**
     * @generated DT_ID=none
     */
    public SanPham mergeSanPham(SanPham sanPham) {
        return em.merge(sanPham);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeSanPham(SanPham sanPham) {
        sanPham = em.find(SanPham.class, sanPham.getMaSanPham());
        em.remove(sanPham);
    }

    /**
     * @generated DT_ID=none
     */
    public List<SanPham> getSanPhamFindAll() {
        return em.createNamedQuery("SanPham.findAll").getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    public SanPham getSanPhamFindByMaSanPham(Integer maSanPham) {
        return (SanPham) em.createNamedQuery("SanPham.findByMaSanPham").setParameter("maSanPham", maSanPham).getSingleResult();
    }

    /**
     * @generated DT_ID=none
     */
    public List<SanPham> getSanPhamFindByTenSanPham(String tenSanPham) {
        return em.createNamedQuery("SanPham.findByTenSanPham").setParameter("tenSanPham", tenSanPham).getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    public List<SanPham> getSanPhamFindByGia(Integer gia) {
        return em.createNamedQuery("SanPham.findByGia").setParameter("gia", gia).getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    public List<SanPham> getSanPhamFindBySoLuong(Integer soLuong) {
        return em.createNamedQuery("SanPham.findBySoLuong").setParameter("soLuong", soLuong).getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    public List<SanPham> getSanPhamFindByMoTa(String moTa) {
        return em.createNamedQuery("SanPham.findByMoTa").setParameter("moTa", moTa).getResultList();
    }
    
    public List<SanPham> getSanPhamFindByTinhTrang(Boolean tinhTrang) {
        return em.createNamedQuery("SanPham.findByTinhTrang").setParameter("tinhTrang", tinhTrang).getResultList();
    }
    
    public List<SanPham> getSanPhamFindByDanhMuc(DanhMuc danhMuc) {
        return em.createNamedQuery("SanPham.findByDanhMuc").setParameter("maDanhMuc", danhMuc).getResultList();
    }

}
