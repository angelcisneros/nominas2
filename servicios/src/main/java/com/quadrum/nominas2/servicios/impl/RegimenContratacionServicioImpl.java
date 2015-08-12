/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios.impl;

import com.quadrum.nominas2.entidades.RegimenContratacion;
import com.quadrum.nominas2.repositorios.RegimenContratacionRepositorio;
import com.quadrum.nominas2.servicios.RegimenContratacionServicio;
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
public class RegimenContratacionServicioImpl implements RegimenContratacionServicio {

   @Autowired
    RegimenContratacionRepositorio regimenContratacionRepositorio;
    private static final String ALUMNO_CLASE = "un regimenContratacion.#";
    
     @Override
    public String agregar(RegimenContratacion regimenContratacion) {
        if (regimenContratacionRepositorio.agregar(regimenContratacion)) {
            return ADD_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(RegimenContratacion regimenContratacion) {
        if (regimenContratacionRepositorio.actualizar(regimenContratacion)) {
            return UPDATE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(RegimenContratacion regimenContratacion) {
        if (regimenContratacionRepositorio.eliminar(regimenContratacion)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<RegimenContratacion> buscarTodos() {
        return regimenContratacionRepositorio.buscarTodos(RegimenContratacion.class);
    }

    @Override
    public String eliminar(Integer id) {
       RegimenContratacion regimenContratacion = regimenContratacionRepositorio.buscarPorId(RegimenContratacion.class, id);
       if (regimenContratacionRepositorio.eliminar(regimenContratacion)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public RegimenContratacion buscarPorId(Integer id) {
       return regimenContratacionRepositorio.buscarPorId(RegimenContratacion.class, id);
    }
    
}
