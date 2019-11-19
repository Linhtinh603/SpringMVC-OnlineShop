package com.tmdt.nhom03.dao;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tmdt.nhom03.model.DonHang;
import com.tmdt.nhom03.model.NguoiDung;


/**
 * @generated DT_ID=none
 */
@Repository
@Transactional(rollbackFor = Exception.class)
public class DonHangDAO{

    /**
     * @generated DT_ID=none
     */
	@PersistenceContext
    private EntityManager em;

    /**
     * @generated DT_ID=none
     */
    public DonHangDAO() {
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
    public DonHang persistDonHang(DonHang donHang) {
        em.persist(donHang);
        return donHang;
    }

    /**
     * @generated DT_ID=none
     */
    public DonHang mergeDonHang(DonHang donHang) {
        return em.merge(donHang);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeDonHang(DonHang donHang) {
        donHang = em.find(DonHang.class, donHang.getMaDonHang());
        em.remove(donHang);
    }

    /**
     * @generated DT_ID=none
     */
    public List<DonHang> getDonHangFindAll() {
        return em.createNamedQuery("DonHang.findAll").getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    public List<DonHang> getDonHangFindByMaDonHang(Integer maDonHang) {
        return em.createNamedQuery("DonHang.findByMaDonHang").setParameter("maDonHang", maDonHang).getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    public List<DonHang> getDonHangFindByNgayTaoDonHang(java.util.Date ngayTaoDonHang) {
        return em.createNamedQuery("DonHang.findByNgayTaoDonHang").setParameter("ngayTaoDonHang", ngayTaoDonHang).getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    public List<DonHang> getDonHangFindByTinhTrangDonHang(int tinhTrangDonHang) {
        return em.createNamedQuery("DonHang.findByTinhTrangDonHang").setParameter("tinhTrangDonHang", tinhTrangDonHang).getResultList();
    }
    
    public List<DonHang> getDonHangFindByNguoiDung(NguoiDung nguoiDung) {
        return em.createNamedQuery("DonHang.findByNguoiDung").setParameter("maNguoiDung", nguoiDung).getResultList();
    }

}
