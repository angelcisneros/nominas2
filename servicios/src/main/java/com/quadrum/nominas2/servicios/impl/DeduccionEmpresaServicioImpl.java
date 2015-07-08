/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios.impl;

import com.quadrum.nominas2.entidades.DeduccionEmpresa;
import com.quadrum.nominas2.repositorios.DeduccionEmpresaRepositorio;
import com.quadrum.nominas2.servicios.DeduccionEmpresaServicio;
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
public class DeduccionEmpresaServicioImpl implements DeduccionEmpresaServicio {

   @Autowired
    DeduccionEmpresaRepositorio deduccionEmpresaRepositorio;
    private static final String ALUMNO_CLASE = "un deduccionEmpresa.#";
    
     @Override
    public String agregar(DeduccionEmpresa deduccionEmpresa) {
        if (deduccionEmpresaRepositorio.agregar(deduccionEmpresa)) {
            return ADD_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(DeduccionEmpresa deduccionEmpresa) {
        if (deduccionEmpresaRepositorio.actualizar(deduccionEmpresa)) {
            return UPDATE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(DeduccionEmpresa deduccionEmpresa) {
        if (deduccionEmpresaRepositorio.eliminar(deduccionEmpresa)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<DeduccionEmpresa> buscarTodos() {
        return deduccionEmpresaRepositorio.buscarTodos();
    }

    @Override
    public String eliminar(Integer id) {
       DeduccionEmpresa deduccionEmpresa = deduccionEmpresaRepositorio.buscarPorId(id);
       if (deduccionEmpresaRepositorio.eliminar(deduccionEmpresa)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public DeduccionEmpresa buscarPorId(Integer id) {
       return deduccionEmpresaRepositorio.buscarPorId(id);
    }
    
}
