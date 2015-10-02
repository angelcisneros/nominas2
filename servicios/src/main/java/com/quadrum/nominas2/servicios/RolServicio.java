/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.Rol;
import java.util.List;

public interface RolServicio {
    String agregar(Rol paramRol);
    String actualizar(Rol paramRol);
    String eliminar(Rol paramRol);
    String eliminar(Integer paramInteger);
    Rol buscarPorId(Integer paramInteger);
    Rol buscarPorCorreo(String paramString);
    List<Rol> buscarTodos();
}
