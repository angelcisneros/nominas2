/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.RolUsuario;
import com.quadrum.nominas2.entidades.RolUsuarioId;
import java.util.List;

public interface RolUsuarioServicio {
    String agregar(RolUsuario paramRolUsuario);
    String actualizar(RolUsuario paramRolUsuario);
    String eliminar(RolUsuario paramRolUsuario);
    String eliminar(RolUsuarioId paramRolUsuarioId);
    RolUsuario buscarPorId(RolUsuarioId paramRolUsuarioId);
    List<RolUsuario> buscarTodos();
}
