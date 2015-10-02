/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.entidades.Sucursal;
import com.quadrum.nominas2.repositorios.SucursalRepositorio;
import java.util.List;
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
public class SucursalRepositorioImpl  extends GenericDaoImpl<Sucursal, Integer> implements SucursalRepositorio {

    @Override
    public Sucursal buscarPorMatriz(Integer empresa) {
        return (Sucursal) sessionFactory.getCurrentSession().createCriteria(Sucursal.class)
                .createAlias("empresa", "e", JoinType.INNER_JOIN)
                .add(Restrictions.eq("e.id", empresa))
                .add(Restrictions.eq("matriz", true))
                .list().get(0);
    }

    @Override
    public List<Sucursal> buscarPorEmpresa(Integer empresa) {
        return sessionFactory.getCurrentSession().createCriteria(Sucursal.class)
                .createAlias("empresa", "e", JoinType.INNER_JOIN)
                .add(Restrictions.eq("e.id", empresa))
                .list();
    }

    @Override
    public Sucursal buscarPorIdAndEmpresa(Integer sucursal, Integer empresa) {
        return (Sucursal) sessionFactory.getCurrentSession().createCriteria(Sucursal.class)
                .createAlias("empresa", "e", JoinType.INNER_JOIN)
                .add(Restrictions.eq("e.id", empresa))
                .add(Restrictions.eq("id", sucursal))
                .uniqueResult();
    }
}