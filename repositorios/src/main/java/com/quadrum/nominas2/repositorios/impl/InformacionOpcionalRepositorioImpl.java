/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.entidades.InformacionOpcional;
import com.quadrum.nominas2.repositorios.InformacionOpcionalRepositorio;
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
public class InformacionOpcionalRepositorioImpl implements InformacionOpcionalRepositorio {

    @Autowired
    SessionFactory sf;
    
    @Override
    public Boolean agregar(InformacionOpcional informacionOpcional) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().save(informacionOpcional);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean actualizar(InformacionOpcional informacionOpcional) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().update(informacionOpcional);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(InformacionOpcional informacionOpcional) {
        Boolean completo = null;
        try {
            sf.getCurrentSession().delete(informacionOpcional);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public Boolean eliminar(Integer id) {        
        Boolean completo = null;
        InformacionOpcional informacionOpcional = buscarPorId(id);
        try {
            sf.getCurrentSession().delete(informacionOpcional);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public InformacionOpcional buscarPorId(Integer id) {
        return (InformacionOpcional) sf.getCurrentSession().createCriteria(InformacionOpcional.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<InformacionOpcional> buscarTodos() {
        return sf.getCurrentSession().createCriteria(InformacionOpcional.class)
               .list();
    }
    
}
