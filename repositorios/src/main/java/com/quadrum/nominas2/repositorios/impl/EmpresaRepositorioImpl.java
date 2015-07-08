/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.entidades.Empresa;
import com.quadrum.nominas2.repositorios.EmpresaRepositorio;
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
public class EmpresaRepositorioImpl implements EmpresaRepositorio {

    @Autowired
    SessionFactory sf;
    
    @Override
    public Boolean agregar(Empresa empresa) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().save(empresa);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean actualizar(Empresa empresa) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().update(empresa);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Empresa empresa) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().delete(empresa);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Integer id) {        
        Boolean completo = null;
        Empresa empresa = buscarPorId(id);
        try {
            sf.getCurrentSession().delete(empresa);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Empresa buscarPorId(Integer id) {
        return (Empresa) sf.getCurrentSession().createCriteria(Empresa.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<Empresa> buscarTodos() {
        return sf.getCurrentSession().createCriteria(Empresa.class)
               .list();
    }
    
}
