/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios.impl;

import com.quadrum.nominas2.entidades.Administrador;
import com.quadrum.nominas2.repositorios.AdministradorRepositorio;
import com.quadrum.nominas2.servicios.AdministradorServicio;
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
public class AdministradorServicioImpl implements AdministradorServicio {

   @Autowired
    AdministradorRepositorio adminRepositorio;
    private static final String ALUMNO_CLASE = "un admin.#";
    
     @Override
    public String agregar(Administrador admin) {
        if (adminRepositorio.agregar(admin)) {
            return ADD_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(Administrador admin) {
        if (adminRepositorio.actualizar(admin)) {
            return UPDATE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(Administrador admin) {
        if (adminRepositorio.eliminar(admin)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<Administrador> buscarTodos() {
        return adminRepositorio.buscarTodos(Administrador.class);
    }

    @Override
    public String eliminar(Integer id) {
       Administrador admin = adminRepositorio.buscarPorId(Administrador.class, id);
       if (adminRepositorio.eliminar(admin)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public Administrador buscarPorId(Integer id) {
       return adminRepositorio.buscarPorId(Administrador.class, id);
    }

    @Override
    public Administrador buscarPorCorreo(String correo) {
        return adminRepositorio.buscarPorCorreo(correo);
    }
    
}
