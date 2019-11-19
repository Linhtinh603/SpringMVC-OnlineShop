package com.tmdt.nhom03.dao;


import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tmdt.nhom03.model.DanhMuc;


/**
 * @generated DT_ID=none
 */
@Repository
@Transactional(rollbackFor = Exception.class)
public class DanhMucDAO{

    /**
     * @generated DT_ID=none
     */
	@PersistenceContext
    private EntityManager em;

    /**
     * @generated DT_ID=none
     */
    public DanhMucDAO() {
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
    public DanhMuc persistDanhMuc(DanhMuc danhMuc) {
        em.persist(danhMuc);
        return danhMuc;
    }

    /**
     * @generated DT_ID=none
     */
    public DanhMuc mergeDanhMuc(DanhMuc danhMuc) {
        return em.merge(danhMuc);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeDanhMuc(DanhMuc danhMuc) {
        danhMuc = em.find(DanhMuc.class, danhMuc.getMaDanhMuc());
        em.remove(danhMuc);
    }

    /**
     * @generated DT_ID=none
     */
    public List<DanhMuc> getDanhMucFindAll() {
        return em.createNamedQuery("DanhMuc.findAll").getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    public DanhMuc getDanhMucFindByMaDanhMuc(Integer maDanhMuc) {
        return (DanhMuc) em.createNamedQuery("DanhMuc.findByMaDanhMuc").setParameter("maDanhMuc", maDanhMuc).getSingleResult();
    }

    /**
     * @generated DT_ID=none
     */
    public List<DanhMuc> getDanhMucFindByTenDanhMuc(String tenDanhMuc) {
        return em.createNamedQuery("DanhMuc.findByTenDanhMuc").setParameter("tenDanhMuc", tenDanhMuc).getResultList();
    }

}
