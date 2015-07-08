/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios.impl;

import com.quadrum.nominas2.entidades.Sucursal;
import com.quadrum.nominas2.repositorios.SucursalRepositorio;
import com.quadrum.nominas2.servicios.SucursalServicio;
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
public class SucursalServicioImpl implements SucursalServicio {

   @Autowired
    SucursalRepositorio sucursalRepositorio;
    private static final String ALUMNO_CLASE = "un sucursal.#";
    
     @Override
    public String agregar(Sucursal sucursal) {
        if (sucursalRepositorio.agregar(sucursal)) {
            return ADD_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(Sucursal sucursal) {
        if (sucursalRepositorio.actualizar(sucursal)) {
            return UPDATE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(Sucursal sucursal) {
        if (sucursalRepositorio.eliminar(sucursal)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<Sucursal> buscarTodos() {
        return sucursalRepositorio.buscarTodos();
    }

    @Override
    public String eliminar(Integer id) {
       Sucursal sucursal = sucursalRepositorio.buscarPorId(id);
       if (sucursalRepositorio.eliminar(sucursal)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public Sucursal buscarPorId(Integer id) {
       return sucursalRepositorio.buscarPorId(id);
    }
    
}
