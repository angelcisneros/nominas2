/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.entidades.Domicilio;
import com.quadrum.nominas2.repositorios.DomicilioRepositorio;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vcisneros
 */
@Transactional
@Repository
public class DomicilioRepositorioImpl  extends GenericDaoImpl<Domicilio, Integer> implements DomicilioRepositorio {

}