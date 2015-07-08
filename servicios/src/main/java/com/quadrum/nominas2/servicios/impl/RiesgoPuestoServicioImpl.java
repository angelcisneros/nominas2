/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios.impl;

import com.quadrum.nominas2.entidades.RiesgoPuesto;
import com.quadrum.nominas2.repositorios.RiesgoPuestoRepositorio;
import com.quadrum.nominas2.servicios.RiesgoPuestoServicio;
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
public class RiesgoPuestoServicioImpl implements RiesgoPuestoServicio {

   @Autowired
    RiesgoPuestoRepositorio riesgoPuestoRepositorio;
    private static final String ALUMNO_CLASE = "un riesgoPuesto.#";
    
     @Override
    public String agregar(RiesgoPuesto riesgoPuesto) {
        if (riesgoPuestoRepositorio.agregar(riesgoPuesto)) {
            return ADD_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(RiesgoPuesto riesgoPuesto) {
        if (riesgoPuestoRepositorio.actualizar(riesgoPuesto)) {
            return UPDATE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(RiesgoPuesto riesgoPuesto) {
        if (riesgoPuestoRepositorio.eliminar(riesgoPuesto)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<RiesgoPuesto> buscarTodos() {
        return riesgoPuestoRepositorio.buscarTodos();
    }

    @Override
    public String eliminar(Integer id) {
       RiesgoPuesto riesgoPuesto = riesgoPuestoRepositorio.buscarPorId(id);
       if (riesgoPuestoRepositorio.eliminar(riesgoPuesto)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public RiesgoPuesto buscarPorId(Integer id) {
       return riesgoPuestoRepositorio.buscarPorId(id);
    }
    
}
