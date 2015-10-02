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
import com.quadrum.nominas2.entidades.PercepcionEmpresa;
import com.quadrum.nominas2.entidades.PercepcionEmpresaId;
import com.quadrum.nominas2.repositorios.PercepcionEmpresaRepositorio;
import com.quadrum.nominas2.servicios.PercepcionEmpresaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PercepcionEmpresaServicioImpl implements PercepcionEmpresaServicio {

    @Autowired
    PercepcionEmpresaRepositorio percepcionEmpresaRepositorio;
    private static final String ALUMNO_CLASE = "un percepcionEmpresa.#";

    @Override
    public String agregar(PercepcionEmpresa percepcionEmpresa) {
        if (this.percepcionEmpresaRepositorio.agregar(percepcionEmpresa)) {
            return "Correcto...#Se ha agregado un percepcionEmpresa.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String actualizar(PercepcionEmpresa percepcionEmpresa) {
        if (this.percepcionEmpresaRepositorio.actualizar(percepcionEmpresa)) {
            return "Correcto...#Se ha actualizado un percepcionEmpresa.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String eliminar(PercepcionEmpresa percepcionEmpresa) {
        if (this.percepcionEmpresaRepositorio.eliminar(percepcionEmpresa)) {
            return "Correcto...#Se ha eliminado un percepcionEmpresa.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public List<PercepcionEmpresa> buscarTodos() {
        return this.percepcionEmpresaRepositorio.buscarTodos(PercepcionEmpresa.class);
    }

    @Override
    public String eliminar(PercepcionEmpresaId id) {
        PercepcionEmpresa percepcionEmpresa = (PercepcionEmpresa) this.percepcionEmpresaRepositorio.buscarPorId(PercepcionEmpresa.class, id);
        if (this.percepcionEmpresaRepositorio.eliminar(percepcionEmpresa)) {
            return "Correcto...#Se ha eliminado un percepcionEmpresa.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public PercepcionEmpresa buscarPorId(PercepcionEmpresaId id) {
        return (PercepcionEmpresa) this.percepcionEmpresaRepositorio.buscarPorId(PercepcionEmpresa.class, id);
    }
}
