/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios.impl;

import com.quadrum.nominas2.entidades.Usuario;
import com.quadrum.nominas2.repositorios.UsuarioRepositorio;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vcisneros
 */

@Repository
@Transactional
public class UsuarioRepositorioImpl extends GenericDaoImpl<Usuario, String> implements UsuarioRepositorio {
    
}
