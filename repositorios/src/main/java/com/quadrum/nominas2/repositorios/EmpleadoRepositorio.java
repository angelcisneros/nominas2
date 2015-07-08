/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios;

import com.quadrum.nominas2.entidades.Empleado;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface EmpleadoRepositorio{
    Boolean agregar(Empleado empleado);
    Boolean actualizar(Empleado empleado);
    Boolean eliminar(Empleado empleado);
    Boolean eliminar(Integer id);
    
    Empleado buscarPorId(Integer id);
    List<Empleado> buscarTodos();
}
