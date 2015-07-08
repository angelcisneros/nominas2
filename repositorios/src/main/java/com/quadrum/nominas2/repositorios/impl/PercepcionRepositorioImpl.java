/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.entidades.Percepcion;
import com.quadrum.nominas2.repositorios.PercepcionRepositorio;
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
public class PercepcionRepositorioImpl implements PercepcionRepositorio {

    @Autowired
    SessionFactory sf;
    
    @Override
    public Boolean agregar(Percepcion percepcion) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().save(percepcion);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean actualizar(Percepcion percepcion) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().update(percepcion);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Percepcion percepcion) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().delete(percepcion);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Integer id) {        
        Boolean completo = null;
        Percepcion percepcion = buscarPorId(id);
        try {
            sf.getCurrentSession().delete(percepcion);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Percepcion buscarPorId(Integer id) {
        return (Percepcion) sf.getCurrentSession().createCriteria(Percepcion.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<Percepcion> buscarTodos() {
        return sf.getCurrentSession().createCriteria(Percepcion.class)
               .list();
    }
    
}
