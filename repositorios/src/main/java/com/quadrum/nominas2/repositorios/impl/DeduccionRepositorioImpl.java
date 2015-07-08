/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.entidades.Deduccion;
import com.quadrum.nominas2.repositorios.DeduccionRepositorio;
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
public class DeduccionRepositorioImpl implements DeduccionRepositorio {

    @Autowired
    SessionFactory sf;
    
    @Override
    public Boolean agregar(Deduccion deduccion) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().save(deduccion);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean actualizar(Deduccion deduccion) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().update(deduccion);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Deduccion deduccion) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().delete(deduccion);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Integer id) {        
        Boolean completo = null;
        Deduccion deduccion = buscarPorId(id);
        try {
            sf.getCurrentSession().delete(deduccion);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Deduccion buscarPorId(Integer id) {
        return (Deduccion) sf.getCurrentSession().createCriteria(Deduccion.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<Deduccion> buscarTodos() {
        return sf.getCurrentSession().createCriteria(Deduccion.class)
               .list();
    }
    
}
