/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.entidades.Administrador;
import com.quadrum.nominas2.repositorios.AdministradorRepositorio;
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
public class AdministradorRepositorioImpl implements AdministradorRepositorio {

    @Autowired
    SessionFactory sf;
    
    @Override
    public Boolean agregar(Administrador admin) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().save(admin);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean actualizar(Administrador admin) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().update(admin);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Administrador admin) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().delete(admin);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Integer id) {        
        Boolean completo = null;
        Administrador admin = buscarPorId(id);
        try {
            sf.getCurrentSession().delete(admin);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Administrador buscarPorId(Integer id) {
        return (Administrador) sf.getCurrentSession().createCriteria(Administrador.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<Administrador> buscarTodos() {
        return sf.getCurrentSession().createCriteria(Administrador.class)
               .list();
    }

    @Override
    public Administrador buscarPorCorreo(String correo) {
        return (Administrador) sf.getCurrentSession().createCriteria(Administrador.class)
                .add(Restrictions.eq("correo", correo))
                .uniqueResult();
    }
    
}
