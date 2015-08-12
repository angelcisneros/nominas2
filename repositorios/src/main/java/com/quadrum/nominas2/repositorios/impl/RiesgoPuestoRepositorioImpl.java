/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.entidades.RiesgoPuesto;
import com.quadrum.nominas2.repositorios.RiesgoPuestoRepositorio;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vcisneros
 */
@Transactional
@Repository
public class RiesgoPuestoRepositorioImpl  extends GenericDaoImpl<RiesgoPuesto, Integer> implements RiesgoPuestoRepositorio {

}