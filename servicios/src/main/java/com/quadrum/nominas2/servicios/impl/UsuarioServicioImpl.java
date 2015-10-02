/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios.impl;

/**
 *
 * @author vcisneros
 */
import com.quadrum.nominas2.entidades.Usuario;
import com.quadrum.nominas2.repositorios.UsuarioRepositorio;
import com.quadrum.nominas2.servicios.UsuarioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    private final String ALUMNO_CLASE = " un Usuario";

    @Override
    public String agregar(Usuario usuario) {
        if (this.usuarioRepositorio.agregar(usuario)) {
            return "Correcto...#Se ha agregado  un Usuario";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String actualizar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String eliminar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String eliminar(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Usuario buscarPorId(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Usuario buscarPorCorreo(String correo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Usuario> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
