/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.Rol;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface RolServicio {
    String agregar(Rol rol);
    String actualizar(Rol rol);
    String eliminar(Rol rol);
    String eliminar(Integer id);
    
    Rol buscarPorId(Integer id);
    Rol buscarPorCorreo(String correo);
    List<Rol> buscarTodos();
}
