/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.entidades.PeriodicidadPago;
import com.quadrum.nominas2.repositorios.PeriodicidadPagoRepositorio;
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
public class PeriodicidadPagoRepositorioImpl implements PeriodicidadPagoRepositorio {

    @Autowired
    SessionFactory sf;
    
    @Override
    public Boolean agregar(PeriodicidadPago periodicidadPago) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().save(periodicidadPago);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean actualizar(PeriodicidadPago periodicidadPago) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().update(periodicidadPago);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(PeriodicidadPago periodicidadPago) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().delete(periodicidadPago);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Integer id) {        
        Boolean completo = null;
        PeriodicidadPago periodicidadPago = buscarPorId(id);
        try {
            sf.getCurrentSession().delete(periodicidadPago);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public PeriodicidadPago buscarPorId(Integer id) {
        return (PeriodicidadPago) sf.getCurrentSession().createCriteria(PeriodicidadPago.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<PeriodicidadPago> buscarTodos() {
        return sf.getCurrentSession().createCriteria(PeriodicidadPago.class)
               .list();
    }
    
}
