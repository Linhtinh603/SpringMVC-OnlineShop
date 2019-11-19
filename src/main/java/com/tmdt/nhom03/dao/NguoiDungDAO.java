package com.tmdt.nhom03.dao;


import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tmdt.nhom03.model.NguoiDung;


/**
 * @generated DT_ID=none
 */
@Repository
@Transactional(rollbackFor = Exception.class)
public class NguoiDungDAO{

    /**
     * @generated DT_ID=none
     */


	@PersistenceContext
    private EntityManager em;

    /**
     * @generated DT_ID=none
     */
    public NguoiDungDAO() {
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
    public NguoiDung persistNguoiDung(NguoiDung nguoiDung) {
        em.persist(nguoiDung);
        return nguoiDung;
    }

    /**
     * @generated DT_ID=none
     */
    public NguoiDung mergeNguoiDung(NguoiDung nguoiDung) {
        return em.merge(nguoiDung);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeNguoiDung(NguoiDung nguoiDung) {
        nguoiDung = em.find(NguoiDung.class, nguoiDung.getMaNguoiDung());
        em.remove(nguoiDung);
    }

    /**
     * @generated DT_ID=none
     */
    public List<NguoiDung> getNguoiDungFindAll() {
        return em.createNamedQuery("NguoiDung.findAll").getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    public NguoiDung getNguoiDungFindByMaNguoiDung(Integer maNguoiDung) {
        return (NguoiDung) em.createNamedQuery("NguoiDung.findByMaNguoiDung").setParameter("maNguoiDung", maNguoiDung).getSingleResult();
    }

    /**
     * @generated DT_ID=none
     */
    public List<NguoiDung> getNguoiDungFindByTenNguoiDung(String tenNguoiDung) {
        return em.createNamedQuery("NguoiDung.findByTenNguoiDung").setParameter("tenNguoiDung", tenNguoiDung).getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    public List<NguoiDung> getNguoiDungFindByDiaChi(String diaChi) {
        return em.createNamedQuery("NguoiDung.findByDiaChi").setParameter("diaChi", diaChi).getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    public List<NguoiDung> getNguoiDungFindByEmail(String email) {
        return em.createNamedQuery("NguoiDung.findByEmail").setParameter("email", email).getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    public List<NguoiDung> getNguoiDungFindBySoDienThoai(String soDienThoai) {
        return em.createNamedQuery("NguoiDung.findBySoDienThoai").setParameter("soDienThoai", soDienThoai).getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    public NguoiDung getNguoiDungFindByUsername(String username) {
        return (NguoiDung) em.createNamedQuery("NguoiDung.findByUsername").setParameter("username", username).getSingleResult();
    }


    /**
     * @generated DT_ID=none
     */
    public List<NguoiDung> getNguoiDungFindByIsNhanVien(Boolean isNhanVien) {
        return em.createNamedQuery("NguoiDung.findByIsNhanVien").setParameter("isNhanVien", isNhanVien).getResultList();
    }

}
