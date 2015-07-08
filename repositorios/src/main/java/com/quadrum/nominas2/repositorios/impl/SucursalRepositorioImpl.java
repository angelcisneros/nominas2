/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.entidades.Sucursal;
import com.quadrum.nominas2.repositorios.SucursalRepositorio;
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
public class SucursalRepositorioImpl implements SucursalRepositorio {

    @Autowired
    SessionFactory sf;
    
    @Override
    public Boolean agregar(Sucursal sucursal) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().save(sucursal);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean actualizar(Sucursal sucursal) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().update(sucursal);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Sucursal sucursal) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().delete(sucursal);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Integer id) {        
        Boolean completo = null;
        Sucursal sucursal = buscarPorId(id);
        try {
            sf.getCurrentSession().delete(sucursal);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Sucursal buscarPorId(Integer id) {
        return (Sucursal) sf.getCurrentSession().createCriteria(Sucursal.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<Sucursal> buscarTodos() {
        return sf.getCurrentSession().createCriteria(Sucursal.class)
               .list();
    }
    
}
