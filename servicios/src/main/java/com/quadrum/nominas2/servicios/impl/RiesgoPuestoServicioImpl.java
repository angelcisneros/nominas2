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
import com.quadrum.nominas2.entidades.RiesgoPuesto;
import com.quadrum.nominas2.repositorios.RiesgoPuestoRepositorio;
import com.quadrum.nominas2.servicios.RiesgoPuestoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiesgoPuestoServicioImpl implements RiesgoPuestoServicio {

    @Autowired
    RiesgoPuestoRepositorio riesgoPuestoRepositorio;
    private static final String ALUMNO_CLASE = "un riesgoPuesto.#";

    @Override
    public String agregar(RiesgoPuesto riesgoPuesto) {
        if (this.riesgoPuestoRepositorio.agregar(riesgoPuesto)) {
            return "Correcto...#Se ha agregado un riesgoPuesto.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String actualizar(RiesgoPuesto riesgoPuesto) {
        if (this.riesgoPuestoRepositorio.actualizar(riesgoPuesto)) {
            return "Correcto...#Se ha actualizado un riesgoPuesto.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String eliminar(RiesgoPuesto riesgoPuesto) {
        if (this.riesgoPuestoRepositorio.eliminar(riesgoPuesto)) {
            return "Correcto...#Se ha eliminado un riesgoPuesto.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public List<RiesgoPuesto> buscarTodos() {
        return this.riesgoPuestoRepositorio.buscarTodos(RiesgoPuestoRepositorio.class);
    }

    @Override
    public String eliminar(Integer id) {
        RiesgoPuesto riesgoPuesto = (RiesgoPuesto) this.riesgoPuestoRepositorio.buscarPorId(RiesgoPuestoRepositorio.class, id);
        if (this.riesgoPuestoRepositorio.eliminar(riesgoPuesto)) {
            return "Correcto...#Se ha eliminado un riesgoPuesto.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public RiesgoPuesto buscarPorId(Integer id) {
        return (RiesgoPuesto) this.riesgoPuestoRepositorio.buscarPorId(RiesgoPuestoRepositorio.class, id);
    }
}
