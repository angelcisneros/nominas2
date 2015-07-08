/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.entidades.Domicilio;
import com.quadrum.nominas2.repositorios.DomicilioRepositorio;
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
public class DomicilioRepositorioImpl implements DomicilioRepositorio {

    @Autowired
    SessionFactory sf;
    
    @Override
    public Boolean agregar(Domicilio domicilio) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().save(domicilio);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean actualizar(Domicilio domicilio) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().update(domicilio);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Domicilio domicilio) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().delete(domicilio);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Integer id) {        
        Boolean completo = null;
        Domicilio domicilio = buscarPorId(id);
        try {
            sf.getCurrentSession().delete(domicilio);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Domicilio buscarPorId(Integer id) {
        return (Domicilio) sf.getCurrentSession().createCriteria(Domicilio.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<Domicilio> buscarTodos() {
        return sf.getCurrentSession().createCriteria(Domicilio.class)
               .list();
    }
    
}
