/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios.impl;

import com.quadrum.nominas2.entidades.Deduccion;
import com.quadrum.nominas2.repositorios.DeduccionRepositorio;
import com.quadrum.nominas2.servicios.DeduccionServicio;
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
public class DeduccionServicioImpl implements DeduccionServicio {

   @Autowired
    DeduccionRepositorio deduccionRepositorio;
    private static final String ALUMNO_CLASE = "un deduccion.#";
    
     @Override
    public String agregar(Deduccion deduccion) {
        if (deduccionRepositorio.agregar(deduccion)) {
            return ADD_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(Deduccion deduccion) {
        if (deduccionRepositorio.actualizar(deduccion)) {
            return UPDATE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(Deduccion deduccion) {
        if (deduccionRepositorio.eliminar(deduccion)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<Deduccion> buscarTodos() {
        return deduccionRepositorio.buscarTodos();
    }

    @Override
    public String eliminar(Integer id) {
       Deduccion deduccion = deduccionRepositorio.buscarPorId(id);
       if (deduccionRepositorio.eliminar(deduccion)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public Deduccion buscarPorId(Integer id) {
       return deduccionRepositorio.buscarPorId(id);
    }
    
}
