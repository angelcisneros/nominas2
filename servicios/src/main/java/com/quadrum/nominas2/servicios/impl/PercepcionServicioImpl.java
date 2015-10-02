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
import com.quadrum.nominas2.entidades.Percepcion;
import com.quadrum.nominas2.repositorios.PercepcionRepositorio;
import com.quadrum.nominas2.servicios.PercepcionServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PercepcionServicioImpl implements PercepcionServicio {

    @Autowired
    PercepcionRepositorio percepcionRepositorio;
    private static final String ALUMNO_CLASE = "un percepcion.#";

    @Override
    public String agregar(Percepcion percepcion) {
        if (this.percepcionRepositorio.agregar(percepcion)) {
            return "Correcto...#Se ha agregado un percepcion.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String actualizar(Percepcion percepcion) {
        if (this.percepcionRepositorio.actualizar(percepcion)) {
            return "Correcto...#Se ha actualizado un percepcion.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String eliminar(Percepcion percepcion) {
        if (this.percepcionRepositorio.eliminar(percepcion)) {
            return "Correcto...#Se ha eliminado un percepcion.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public List<Percepcion> buscarTodos() {
        return this.percepcionRepositorio.buscarTodos(Percepcion.class);
    }

    @Override
    public String eliminar(Integer id) {
        Percepcion percepcion = (Percepcion) this.percepcionRepositorio.buscarPorId(Percepcion.class, id);
        if (this.percepcionRepositorio.eliminar(percepcion)) {
            return "Correcto...#Se ha eliminado un percepcion.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public Percepcion buscarPorId(Integer id) {
        return (Percepcion) this.percepcionRepositorio.buscarPorId(Percepcion.class, id);
    }
}
