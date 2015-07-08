/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.entidades.PercepcionEmpresa;
import com.quadrum.nominas2.repositorios.PercepcionEmpresaRepositorio;
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
public class PercepcionEmpresaRepositorioImpl implements PercepcionEmpresaRepositorio {

    @Autowired
    SessionFactory sf;
    
    @Override
    public Boolean agregar(PercepcionEmpresa percepcionEmpresa) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().save(percepcionEmpresa);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean actualizar(PercepcionEmpresa percepcionEmpresa) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().update(percepcionEmpresa);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(PercepcionEmpresa percepcionEmpresa) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().delete(percepcionEmpresa);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Integer id) {        
        Boolean completo = null;
        PercepcionEmpresa percepcionEmpresa = buscarPorId(id);
        try {
            sf.getCurrentSession().delete(percepcionEmpresa);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public PercepcionEmpresa buscarPorId(Integer id) {
        return (PercepcionEmpresa) sf.getCurrentSession().createCriteria(PercepcionEmpresa.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<PercepcionEmpresa> buscarTodos() {
        return sf.getCurrentSession().createCriteria(PercepcionEmpresa.class)
               .list();
    }
    
}
