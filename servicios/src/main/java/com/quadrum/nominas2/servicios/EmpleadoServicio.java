/* * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.Empleado;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface EmpleadoServicio{
    String agregar(Empleado empleado);
    String actualizar(Empleado empleado);
    String eliminar(Empleado empleado);
    String eliminar(String id);
    
    Empleado buscarPorId(String id);
    List<Empleado> buscarTodos();
}
