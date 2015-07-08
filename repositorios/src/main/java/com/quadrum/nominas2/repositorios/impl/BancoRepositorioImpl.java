/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.entidades.Banco;
import com.quadrum.nominas2.repositorios.BancoRepositorio;
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
public class BancoRepositorioImpl implements BancoRepositorio {

    @Autowired
    SessionFactory sf;
    
    @Override
    public Boolean agregar(Banco banco) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().save(banco);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean actualizar(Banco banco) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().update(banco);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Banco banco) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().delete(banco);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Integer id) {        
        Boolean completo = null;
        Banco banco = buscarPorId(id);
        try {
            sf.getCurrentSession().delete(banco);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Banco buscarPorId(Integer id) {
        return (Banco) sf.getCurrentSession().createCriteria(Banco.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<Banco> buscarTodos() {
        return sf.getCurrentSession().createCriteria(Banco.class)
               .list();
    }
    
}
