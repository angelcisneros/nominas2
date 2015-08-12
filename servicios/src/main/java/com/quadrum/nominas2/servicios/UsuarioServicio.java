/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.Usuario;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface UsuarioServicio {
    String agregar(Usuario usuario);
    String actualizar(Usuario usuario);
    String eliminar(Usuario usuario);
    String eliminar(String id);
    
    Usuario buscarPorId(String id);
    Usuario buscarPorCorreo(String correo);
    List<Usuario> buscarTodos();
}
