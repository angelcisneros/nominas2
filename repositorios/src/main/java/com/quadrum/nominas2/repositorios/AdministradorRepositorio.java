/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios;

import com.quadrum.nominas2.entidades.Administrador;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface AdministradorRepositorio{
    Boolean agregar(Administrador admin);
    Boolean actualizar(Administrador admin);
    Boolean eliminar(Administrador admin);
    Boolean eliminar(Integer id);
    
    Administrador buscarPorId(Integer id);
    Administrador buscarPorCorreo(String correo);
    List<Administrador> buscarTodos();
}
