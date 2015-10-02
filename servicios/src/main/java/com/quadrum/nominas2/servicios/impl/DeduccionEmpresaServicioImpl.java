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
import com.quadrum.nominas2.entidades.DeduccionEmpresa;
import com.quadrum.nominas2.entidades.DeduccionEmpresaId;
import com.quadrum.nominas2.repositorios.DeduccionEmpresaRepositorio;
import com.quadrum.nominas2.servicios.DeduccionEmpresaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeduccionEmpresaServicioImpl implements DeduccionEmpresaServicio {

    @Autowired
    DeduccionEmpresaRepositorio deduccionEmpresaRepositorio;
    private static final String ALUMNO_CLASE = "un deduccionEmpresa.#";

    @Override
    public String agregar(DeduccionEmpresa deduccionEmpresa) {
        if (deduccionEmpresaRepositorio.agregar(deduccionEmpresa)) {
            return "Correcto...#Se ha agregado un deduccionEmpresa.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String actualizar(DeduccionEmpresa deduccionEmpresa) {
        if (this.deduccionEmpresaRepositorio.actualizar(deduccionEmpresa)) {
            return "Correcto...#Se ha actualizado un deduccionEmpresa.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String eliminar(DeduccionEmpresa deduccionEmpresa) {
        if (this.deduccionEmpresaRepositorio.eliminar(deduccionEmpresa)) {
            return "Correcto...#Se ha eliminado un deduccionEmpresa.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public List<DeduccionEmpresa> buscarTodos() {
        return this.deduccionEmpresaRepositorio.buscarTodos(DeduccionEmpresa.class);
    }

    @Override
    public String eliminar(DeduccionEmpresaId id) {
        DeduccionEmpresa deduccionEmpresa = (DeduccionEmpresa) this.deduccionEmpresaRepositorio.buscarPorId(DeduccionEmpresa.class, id);
        if (this.deduccionEmpresaRepositorio.eliminar(deduccionEmpresa)) {
            return "Correcto...#Se ha eliminado un deduccionEmpresa.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public DeduccionEmpresa buscarPorId(DeduccionEmpresaId id) {
        return (DeduccionEmpresa) this.deduccionEmpresaRepositorio.buscarPorId(DeduccionEmpresa.class, id);
    }
}
