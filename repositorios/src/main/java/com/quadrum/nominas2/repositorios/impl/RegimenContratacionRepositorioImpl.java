/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.entidades.RegimenContratacion;
import com.quadrum.nominas2.repositorios.RegimenContratacionRepositorio;
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
public class RegimenContratacionRepositorioImpl implements RegimenContratacionRepositorio {

    @Autowired
    SessionFactory sf;
    
    @Override
    public Boolean agregar(RegimenContratacion regimenContratacion) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().save(regimenContratacion);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean actualizar(RegimenContratacion regimenContratacion) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().update(regimenContratacion);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(RegimenContratacion regimenContratacion) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().delete(regimenContratacion);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Integer id) {        
        Boolean completo = null;
        RegimenContratacion regimenContratacion = buscarPorId(id);
        try {
            sf.getCurrentSession().delete(regimenContratacion);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public RegimenContratacion buscarPorId(Integer id) {
        return (RegimenContratacion) sf.getCurrentSession().createCriteria(RegimenContratacion.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<RegimenContratacion> buscarTodos() {
        return sf.getCurrentSession().createCriteria(RegimenContratacion.class)
               .list();
    }
    
}
