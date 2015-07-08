/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.Administrador;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface AdministradorServicio{
    String agregar(Administrador admin);
    String actualizar(Administrador admin);
    String eliminar(Administrador admin);
    String eliminar(Integer id);
    
    Administrador buscarPorId(Integer id);
    Administrador buscarPorCorreo(String correo);
    List<Administrador> buscarTodos();
}
