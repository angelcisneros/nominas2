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
import com.quadrum.nominas2.entidades.RegimenContratacion;
import com.quadrum.nominas2.repositorios.RegimenContratacionRepositorio;
import com.quadrum.nominas2.servicios.RegimenContratacionServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegimenContratacionServicioImpl implements RegimenContratacionServicio {

    @Autowired
    RegimenContratacionRepositorio regimenContratacionRepositorio;
    private static final String ALUMNO_CLASE = "un regimenContratacion.#";

    @Override
    public String agregar(RegimenContratacion regimenContratacion) {
        if (this.regimenContratacionRepositorio.agregar(regimenContratacion)) {
            return "Correcto...#Se ha agregado un regimenContratacion.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String actualizar(RegimenContratacion regimenContratacion) {
        if (this.regimenContratacionRepositorio.actualizar(regimenContratacion)) {
            return "Correcto...#Se ha actualizado un regimenContratacion.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String eliminar(RegimenContratacion regimenContratacion) {
        if (this.regimenContratacionRepositorio.eliminar(regimenContratacion)) {
            return "Correcto...#Se ha eliminado un regimenContratacion.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public List<RegimenContratacion> buscarTodos() {
        return this.regimenContratacionRepositorio.buscarTodos(RegimenContratacion.class);
    }

    @Override
    public String eliminar(Integer id) {
        RegimenContratacion regimenContratacion = (RegimenContratacion) this.regimenContratacionRepositorio.buscarPorId(RegimenContratacion.class, id);
        if (this.regimenContratacionRepositorio.eliminar(regimenContratacion)) {
            return "Correcto...#Se ha eliminado un regimenContratacion.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public RegimenContratacion buscarPorId(Integer id) {
        return (RegimenContratacion) this.regimenContratacionRepositorio.buscarPorId(RegimenContratacion.class, id);
    }
}
