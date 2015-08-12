/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios.impl;

import com.quadrum.nominas2.entidades.PercepcionEmpresa;
import com.quadrum.nominas2.entidades.PercepcionEmpresaId;
import com.quadrum.nominas2.repositorios.PercepcionEmpresaRepositorio;
import com.quadrum.nominas2.servicios.PercepcionEmpresaServicio;
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
public class PercepcionEmpresaServicioImpl implements PercepcionEmpresaServicio {

   @Autowired
    PercepcionEmpresaRepositorio percepcionEmpresaRepositorio;
    private static final String ALUMNO_CLASE = "un percepcionEmpresa.#";
    
     @Override
    public String agregar(PercepcionEmpresa percepcionEmpresa) {
        if (percepcionEmpresaRepositorio.agregar(percepcionEmpresa)) {
            return ADD_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(PercepcionEmpresa percepcionEmpresa) {
        if (percepcionEmpresaRepositorio.actualizar(percepcionEmpresa)) {
            return UPDATE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(PercepcionEmpresa percepcionEmpresa) {
        if (percepcionEmpresaRepositorio.eliminar(percepcionEmpresa)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<PercepcionEmpresa> buscarTodos() {
        return percepcionEmpresaRepositorio.buscarTodos(PercepcionEmpresa.class);
    }

    @Override
    public String eliminar(PercepcionEmpresaId id) {
       PercepcionEmpresa percepcionEmpresa = percepcionEmpresaRepositorio.buscarPorId(PercepcionEmpresa.class, id);
       if (percepcionEmpresaRepositorio.eliminar(percepcionEmpresa)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public PercepcionEmpresa buscarPorId(PercepcionEmpresaId id) {
       return percepcionEmpresaRepositorio.buscarPorId(PercepcionEmpresa.class, id);
    }
    
}
