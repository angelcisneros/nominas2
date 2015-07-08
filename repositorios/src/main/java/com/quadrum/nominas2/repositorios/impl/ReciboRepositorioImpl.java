/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.entidades.Recibo;
import com.quadrum.nominas2.repositorios.ReciboRepositorio;
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
public class ReciboRepositorioImpl implements ReciboRepositorio {

    @Autowired
    SessionFactory sf;
    
    @Override
    public Boolean agregar(Recibo recibo) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().save(recibo);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean actualizar(Recibo recibo) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().update(recibo);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Recibo recibo) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().delete(recibo);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Integer id) {        
        Boolean completo = null;
        Recibo recibo = buscarPorId(id);
        try {
            sf.getCurrentSession().delete(recibo);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Recibo buscarPorId(Integer id) {
        return (Recibo) sf.getCurrentSession().createCriteria(Recibo.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<Recibo> buscarTodos() {
        return sf.getCurrentSession().createCriteria(Recibo.class)
               .list();
    }
    
}
