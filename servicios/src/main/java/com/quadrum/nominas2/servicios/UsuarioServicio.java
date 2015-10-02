/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.Usuario;
import java.util.List;

public interface UsuarioServicio {
    String agregar(Usuario paramUsuario);
    String actualizar(Usuario paramUsuario);
    String eliminar(Usuario paramUsuario);
    String eliminar(String paramString);
    Usuario buscarPorId(String paramString);
    Usuario buscarPorCorreo(String paramString);
    List<Usuario> buscarTodos();
}
