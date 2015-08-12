/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.RolUsuario;
import com.quadrum.nominas2.entidades.RolUsuarioId;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface RolUsuarioServicio {
    String agregar(RolUsuario rolUsuario );
    String actualizar(RolUsuario rolUsuario );
    String eliminar(RolUsuario rolUsuario );
    String eliminar(RolUsuarioId id);
    
    RolUsuario buscarPorId(RolUsuarioId id);
    List<RolUsuario> buscarTodos();
}
