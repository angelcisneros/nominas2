/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios.impl;

import com.quadrum.nominas2.entidades.InformacionOpcional;
import com.quadrum.nominas2.repositorios.InformacionOpcionalRepositorio;
import com.quadrum.nominas2.servicios.InformacionOpcionalServicio;
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
public class InformacionOpcionalServicioImpl implements InformacionOpcionalServicio {

   @Autowired
    InformacionOpcionalRepositorio informacionOpcionalRepositorio;
    private static final String ALUMNO_CLASE = "un informacionOpcional.#";
    
     @Override
    public String agregar(InformacionOpcional informacionOpcional) {
        if (informacionOpcionalRepositorio.agregar(informacionOpcional)) {
            return ADD_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(InformacionOpcional informacionOpcional) {
        if (informacionOpcionalRepositorio.actualizar(informacionOpcional)) {
            return UPDATE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(InformacionOpcional informacionOpcional) {
        if (informacionOpcionalRepositorio.eliminar(informacionOpcional)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<InformacionOpcional> buscarTodos() {
        return informacionOpcionalRepositorio.buscarTodos();
    }

    @Override
    public String eliminar(Integer id) {
       InformacionOpcional informacionOpcional = informacionOpcionalRepositorio.buscarPorId(id);
       if (informacionOpcionalRepositorio.eliminar(informacionOpcional)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public InformacionOpcional buscarPorId(Integer id) {
       return informacionOpcionalRepositorio.buscarPorId(id);
    }
    
}
