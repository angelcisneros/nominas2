/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios.impl;

import com.quadrum.nominas2.entidades.Percepcion;
import com.quadrum.nominas2.repositorios.PercepcionRepositorio;
import com.quadrum.nominas2.servicios.PercepcionServicio;
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
public class PercepcionServicioImpl implements PercepcionServicio {

   @Autowired
    PercepcionRepositorio percepcionRepositorio;
    private static final String ALUMNO_CLASE = "un percepcion.#";
    
     @Override
    public String agregar(Percepcion percepcion) {
        if (percepcionRepositorio.agregar(percepcion)) {
            return ADD_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(Percepcion percepcion) {
        if (percepcionRepositorio.actualizar(percepcion)) {
            return UPDATE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(Percepcion percepcion) {
        if (percepcionRepositorio.eliminar(percepcion)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<Percepcion> buscarTodos() {
        return percepcionRepositorio.buscarTodos(Percepcion.class);
    }

    @Override
    public String eliminar(Integer id) {
       Percepcion percepcion = percepcionRepositorio.buscarPorId(Percepcion.class, id);
       if (percepcionRepositorio.eliminar(percepcion)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public Percepcion buscarPorId(Integer id) {
       return percepcionRepositorio.buscarPorId(Percepcion.class, id);
    }
    
}
