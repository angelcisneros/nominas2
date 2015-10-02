/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.entidades.Archivo;
import com.quadrum.nominas2.entidades.Recibo;
import com.quadrum.nominas2.repositorios.ReciboRepositorio;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vcisneros
 */
@Transactional
@Repository
public class ReciboRepositorioImpl  extends GenericDaoImpl<Recibo, Integer> implements ReciboRepositorio {

    @Override
    public boolean guradarConEmpleado(Recibo recibo) {
         Boolean completo = null;
        try {
            sessionFactory.getCurrentSession().merge(recibo);
            completo = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return completo;
    }

    @Override
    public List<Recibo> buscarPorArchivo(Archivo archivo) {
        return sessionFactory.getCurrentSession().createCriteria(Recibo.class)
                .createAlias("archivo", "a", JoinType.INNER_JOIN)
                .add(Restrictions.eq("a.id", archivo.getId()))
                .list();
    }
    
    

}