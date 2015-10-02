/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.Empleado;
import java.util.List;

public interface EmpleadoServicio {

    String agregar(Empleado paramEmpleado);

    String actualizar(Empleado paramEmpleado);

    String eliminar(Empleado paramEmpleado);

    String eliminar(String paramString);

    Empleado buscarPorId(String paramString);

    List<Empleado> buscarTodos();
}
