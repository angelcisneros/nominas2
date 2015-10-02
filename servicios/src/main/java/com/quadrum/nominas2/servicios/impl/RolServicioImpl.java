/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios.impl;

import com.quadrum.nominas2.entidades.Rol;
import com.quadrum.nominas2.repositorios.RolRepositorio;
import com.quadrum.nominas2.servicios.RolServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vcisneros
 */

@Service
public class RolServicioImpl implements RolServicio {

    @Autowired
    RolRepositorio usuarioRepositorio;
    private final String ALUMNO_CLASE = " un Rol";

    @Override
    public String agregar(Rol usuario) {
        if (this.usuarioRepositorio.agregar(usuario)) {
            return "Correcto...#Se ha agregado  un Rol";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String actualizar(Rol usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String eliminar(Rol usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Rol buscarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Rol buscarPorCorreo(String correo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Rol> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
