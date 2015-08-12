/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios.impl;

import com.quadrum.nominas2.entidades.Domicilio;
import com.quadrum.nominas2.repositorios.DomicilioRepositorio;
import com.quadrum.nominas2.servicios.DomicilioServicio;
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
public class DomicilioServicioImpl implements DomicilioServicio {

   @Autowired
    DomicilioRepositorio domicilioRepositorio;
    private static final String ALUMNO_CLASE = "un domicilio.#";
    
     @Override
    public String agregar(Domicilio domicilio) {
        if (domicilioRepositorio.agregar(domicilio)) {
            return ADD_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(Domicilio domicilio) {
        if (domicilioRepositorio.actualizar(domicilio)) {
            return UPDATE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(Domicilio domicilio) {
        if (domicilioRepositorio.eliminar(domicilio)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<Domicilio> buscarTodos() {
        return domicilioRepositorio.buscarTodos(Domicilio.class);
    }

    @Override
    public String eliminar(Integer id) {
       Domicilio domicilio = domicilioRepositorio.buscarPorId(Domicilio.class, id);
       if (domicilioRepositorio.eliminar(domicilio)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public Domicilio buscarPorId(Integer id) {
       return domicilioRepositorio.buscarPorId(Domicilio.class, id);
    }
    
}
