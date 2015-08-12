/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.entidades.PercepcionEmpresa;
import com.quadrum.nominas2.entidades.PercepcionEmpresaId;
import com.quadrum.nominas2.repositorios.PercepcionEmpresaRepositorio;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vcisneros
 */
@Transactional
@Repository
public class PercepcionEmpresaRepositorioImpl  extends GenericDaoImpl<PercepcionEmpresa, PercepcionEmpresaId> implements PercepcionEmpresaRepositorio {

}