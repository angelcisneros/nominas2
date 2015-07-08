/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios.impl;

import com.quadrum.nominas2.entidades.Empleado;
import com.quadrum.nominas2.repositorios.EmpleadoRepositorio;
import com.quadrum.nominas2.servicios.EmpleadoServicio;
import static com.quadrum.nominas2.servicios.util.MensajesCrud.ADD_CORRECT;
import static com.quadrum.nominas2.servicios.util.MensajesCrud.DELETE_CORRECT;
import static com.quadrum.nominas2.servicios.util.MensajesCrud.ERROR_HIBERNATE;
import static com.quadrum.nominas2.servicios.util.MensajesCrud.UPDATE_CORRECT;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vcisneros
 */
@Service
public class EmpleadoServicioImpl implements EmpleadoServicio {

   @Autowired
    EmpleadoRepositorio empleadoRepositorio;
    private static final String ALUMNO_CLASE = "un empleado.#";
    
     @Override
    public String agregar(Empleado empleado) {
        if (empleadoRepositorio.agregar(empleado)) {
            return ADD_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(Empleado empleado) {
        if (empleadoRepositorio.actualizar(empleado)) {
            return UPDATE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(Empleado empleado) {
        if (empleadoRepositorio.eliminar(empleado)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<Empleado> buscarTodos() {
        return empleadoRepositorio.buscarTodos();
    }

    @Override
    public String eliminar(Integer id) {
       Empleado empleado = empleadoRepositorio.buscarPorId(id);
       if (empleadoRepositorio.eliminar(empleado)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public Empleado buscarPorId(Integer id) {
       return empleadoRepositorio.buscarPorId(id);
    }
    
}
