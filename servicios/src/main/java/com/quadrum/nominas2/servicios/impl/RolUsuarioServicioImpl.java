/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios.impl;

import com.quadrum.nominas2.entidades. RolUsuario;
import com.quadrum.nominas2.entidades. RolUsuarioId;
import com.quadrum.nominas2.repositorios. RolUsuarioRepositorio;
import com.quadrum.nominas2.servicios.RolUsuarioServicio;
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
public class RolUsuarioServicioImpl implements  RolUsuarioServicio {

   @Autowired
     RolUsuarioRepositorio rolUsuarioRepositorio;
    private static final String ALUMNO_CLASE = "un rolUsuario.#";
    
     @Override
    public String agregar( RolUsuario rolUsuario) {
        if (rolUsuarioRepositorio.agregar(rolUsuario)) {
            return ADD_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar( RolUsuario rolUsuario) {
        if (rolUsuarioRepositorio.actualizar(rolUsuario)) {
            return UPDATE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar( RolUsuario rolUsuario) {
        if (rolUsuarioRepositorio.eliminar(rolUsuario)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List< RolUsuario> buscarTodos() {
        return rolUsuarioRepositorio.buscarTodos( RolUsuario.class);
    }

    @Override
    public String eliminar(RolUsuarioId id) {
        RolUsuario rolUsuario = rolUsuarioRepositorio.buscarPorId( RolUsuarioId.class, id);
       if (rolUsuarioRepositorio.eliminar(rolUsuario)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public  RolUsuario buscarPorId(RolUsuarioId id) {
       return rolUsuarioRepositorio.buscarPorId( RolUsuarioId.class, id);
    }

    
}
