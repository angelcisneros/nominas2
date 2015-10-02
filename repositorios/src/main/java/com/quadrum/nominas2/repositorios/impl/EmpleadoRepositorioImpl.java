/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.entidades.Empleado;
import com.quadrum.nominas2.repositorios.EmpleadoRepositorio;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vcisneros
 */
@Transactional
@Repository
public class EmpleadoRepositorioImpl extends GenericDaoImpl<Empleado, String> implements EmpleadoRepositorio {

    @Override
    public boolean guardarOrActualizar(Empleado empleado) {
        Boolean completo = null;
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(empleado);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

}
