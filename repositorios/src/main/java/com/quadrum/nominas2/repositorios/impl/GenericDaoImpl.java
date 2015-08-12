/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.repositorios.GenericDao;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vcisneros
 * @param <Entity>
 * @param <PK>
 */
@Repository
@Transactional
public class GenericDaoImpl<Entity, PK extends Serializable> implements GenericDao<Entity, PK> {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Boolean agregar(Entity e) {
        Boolean completo = null;
        try {
            sessionFactory.getCurrentSession().save(e);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean actualizar(Entity e) {
        Boolean completo = null;
        try {
            sessionFactory.getCurrentSession().merge(e);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Entity e) {
        Boolean completo = null;
        try {
            sessionFactory.getCurrentSession().save(e);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Entity buscarPorId(Class klass, PK id) {
        return (Entity) sessionFactory.getCurrentSession().get(klass, id);
    }

    @Override
    public List<Entity> buscarTodos(Class klass) {
        return sessionFactory.getCurrentSession().createCriteria(klass)
                .list();
    }
}
