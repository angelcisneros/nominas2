/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.entidades.RiesgoPuesto;
import com.quadrum.nominas2.repositorios.RiesgoPuestoRepositorio;
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
public class RiesgoPuestoRepositorioImpl implements RiesgoPuestoRepositorio {

    @Autowired
    SessionFactory sf;
    
    @Override
    public Boolean agregar(RiesgoPuesto RiesgoPuesto) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().save(RiesgoPuesto);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean actualizar(RiesgoPuesto RiesgoPuesto) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().update(RiesgoPuesto);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(RiesgoPuesto RiesgoPuesto) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().delete(RiesgoPuesto);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Integer id) {        
        Boolean completo = null;
        RiesgoPuesto RiesgoPuesto = buscarPorId(id);
        try {
            sf.getCurrentSession().delete(RiesgoPuesto);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public RiesgoPuesto buscarPorId(Integer id) {
        return (RiesgoPuesto) sf.getCurrentSession().createCriteria(RiesgoPuesto.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<RiesgoPuesto> buscarTodos() {
        return sf.getCurrentSession().createCriteria(RiesgoPuesto.class)
               .list();
    }
    
}
