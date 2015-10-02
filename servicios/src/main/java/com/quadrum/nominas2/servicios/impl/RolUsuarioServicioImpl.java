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
import com.quadrum.nominas2.entidades.RolUsuario;
import com.quadrum.nominas2.entidades.RolUsuarioId;
import com.quadrum.nominas2.repositorios.RolUsuarioRepositorio;
import com.quadrum.nominas2.servicios.RolUsuarioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolUsuarioServicioImpl implements RolUsuarioServicio {

    @Autowired
    RolUsuarioRepositorio rolUsuarioRepositorio;
    private static final String ALUMNO_CLASE = "un rolUsuario.#";

    @Override
    public String agregar(RolUsuario rolUsuario) {
        if (this.rolUsuarioRepositorio.agregar(rolUsuario)) {
            return "Correcto...#Se ha agregado un rolUsuario.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String actualizar(RolUsuario rolUsuario) {
        if (this.rolUsuarioRepositorio.actualizar(rolUsuario)) {
            return "Correcto...#Se ha actualizado un rolUsuario.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String eliminar(RolUsuario rolUsuario) {
        if (this.rolUsuarioRepositorio.eliminar(rolUsuario)) {
            return "Correcto...#Se ha eliminado un rolUsuario.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public List<RolUsuario> buscarTodos() {
        return this.rolUsuarioRepositorio.buscarTodos(RolUsuario.class);
    }

    @Override
    public String eliminar(RolUsuarioId id) {
        RolUsuario rolUsuario = (RolUsuario) this.rolUsuarioRepositorio.buscarPorId(RolUsuarioId.class, id);
        if (this.rolUsuarioRepositorio.eliminar(rolUsuario)) {
            return "Correcto...#Se ha eliminado un rolUsuario.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public RolUsuario buscarPorId(RolUsuarioId id) {
        return (RolUsuario) this.rolUsuarioRepositorio.buscarPorId(RolUsuarioId.class, id);
    }
}
