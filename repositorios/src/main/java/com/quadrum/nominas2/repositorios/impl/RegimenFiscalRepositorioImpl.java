/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.entidades.RegimenFiscal;
import com.quadrum.nominas2.repositorios.RegimenFiscalRepositorio;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vcisneros
 */
@Transactional
@Repository
public class RegimenFiscalRepositorioImpl implements RegimenFiscalRepositorio {

    @Autowired
    SessionFactory sf;
    
    @Override
    public Boolean agregar(RegimenFiscal regimenFiscal) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().save(regimenFiscal);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean actualizar(RegimenFiscal regimenFiscal) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().update(regimenFiscal);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(RegimenFiscal regimenFiscal) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().delete(regimenFiscal);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Integer id) {        
        Boolean completo = null;
        RegimenFiscal regimenFiscal = buscarPorId(id);
        try {
            sf.getCurrentSession().delete(regimenFiscal);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public RegimenFiscal buscarPorId(Integer id) {
        return (RegimenFiscal) sf.getCurrentSession().createCriteria(RegimenFiscal.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<RegimenFiscal> buscarTodos() {
        return sf.getCurrentSession().createCriteria(RegimenFiscal.class)
               .list();
    }
    
}
