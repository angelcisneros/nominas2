/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.entidades.Empresa;
import com.quadrum.nominas2.repositorios.EmpresaRepositorio;
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
public class EmpresaRepositorioImpl  extends GenericDaoImpl<Empresa, Integer> implements EmpresaRepositorio {

    @Override
    public Empresa buscarPorUsuario(String usuario) {
        return (Empresa) sessionFactory.getCurrentSession().createCriteria(Empresa.class)
                .createAlias("usuario", "u", JoinType.INNER_JOIN)
                .createAlias("regimenFiscal", "r", JoinType.INNER_JOIN)
                .add(Restrictions.eq("u.userName", usuario))
                .uniqueResult();
    }

}