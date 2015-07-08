/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.entidades.Empleado;
import com.quadrum.nominas2.repositorios.EmpleadoRepositorio;
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
public class EmpleadoRepositorioImpl implements EmpleadoRepositorio {

    @Autowired
    SessionFactory sf;
    
    @Override
    public Boolean agregar(Empleado empleado) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().save(empleado);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean actualizar(Empleado empleado) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().update(empleado);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Empleado empleado) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().delete(empleado);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Integer id) {        
        Boolean completo = null;
        Empleado empleado = buscarPorId(id);
        try {
            sf.getCurrentSession().delete(empleado);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Empleado buscarPorId(Integer id) {
        return (Empleado) sf.getCurrentSession().createCriteria(Empleado.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<Empleado> buscarTodos() {
        return sf.getCurrentSession().createCriteria(Empleado.class)
               .list();
    }
    
}
