/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.entidades.DeduccionEmpresa;
import com.quadrum.nominas2.repositorios.DeduccionEmpresaRepositorio;
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
public class DeduccionEmpresaRepositorioImpl implements DeduccionEmpresaRepositorio {

    @Autowired
    SessionFactory sf;
    
    @Override
    public Boolean agregar(DeduccionEmpresa deduccionEmpresa) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().save(deduccionEmpresa);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean actualizar(DeduccionEmpresa deduccionEmpresa) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().update(deduccionEmpresa);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(DeduccionEmpresa deduccionEmpresa) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().delete(deduccionEmpresa);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Integer id) {        
        Boolean completo = null;
        DeduccionEmpresa deduccionEmpresa = buscarPorId(id);
        try {
            sf.getCurrentSession().delete(deduccionEmpresa);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public DeduccionEmpresa buscarPorId(Integer id) {
        return (DeduccionEmpresa) sf.getCurrentSession().createCriteria(DeduccionEmpresa.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<DeduccionEmpresa> buscarTodos() {
        return sf.getCurrentSession().createCriteria(DeduccionEmpresa.class)
               .list();
    }
    
}
