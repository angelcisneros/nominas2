/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios;

import com.quadrum.nominas2.entidades.Empleado;

/**
 *
 * @author vcisneros
 */
public interface EmpleadoRepositorio extends GenericDao<Empleado, String>{
    boolean guardarOrActualizar(Empleado empleado);
}
