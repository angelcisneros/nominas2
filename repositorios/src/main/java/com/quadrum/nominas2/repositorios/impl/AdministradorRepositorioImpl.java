/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.entidades.Administrador;
import com.quadrum.nominas2.repositorios.AdministradorRepositorio;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vcisneros
 */
@Transactional
@Repository
public class AdministradorRepositorioImpl extends GenericDaoImpl<Administrador, Integer> implements AdministradorRepositorio {
    
    @Override
    public Administrador buscarPorCorreo(String correo) {
        return (Administrador) sessionFactory.getCurrentSession().createCriteria(Administrador.class)
                .add(Restrictions.eq("correo", correo))
                .uniqueResult();
    }
    
}
