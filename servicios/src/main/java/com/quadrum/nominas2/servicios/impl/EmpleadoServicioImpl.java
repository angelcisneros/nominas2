/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios.impl;

import com.quadrum.nominas2.entidades.Empleado;
import com.quadrum.nominas2.repositorios.EmpleadoRepositorio;
import com.quadrum.nominas2.servicios.EmpleadoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vcisneros
 */
@Service
public class EmpleadoServicioImpl implements EmpleadoServicio {

    @Autowired
    EmpleadoRepositorio empleadoRepositorio;
    private static final String ALUMNO_CLASE = "un empleado.#";

    @Override
    public String agregar(Empleado empleado) {
        if (this.empleadoRepositorio.agregar(empleado)) {
            return "Correcto...#Se ha agregado un empleado.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String actualizar(Empleado empleado) {
        if (this.empleadoRepositorio.actualizar(empleado)) {
            return "Correcto...#Se ha actualizado un empleado.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String eliminar(Empleado empleado) {
        if (this.empleadoRepositorio.eliminar(empleado)) {
            return "Correcto...#Se ha eliminado un empleado.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public List<Empleado> buscarTodos() {
        return this.empleadoRepositorio.buscarTodos(Empleado.class);
    }

    @Override
    public String eliminar(String id) {
        Empleado empleado = (Empleado) this.empleadoRepositorio.buscarPorId(Empleado.class, id);
        if (this.empleadoRepositorio.eliminar(empleado)) {
            return "Correcto...#Se ha eliminado un empleado.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public Empleado buscarPorId(String id) {
        return (Empleado) this.empleadoRepositorio.buscarPorId(Empleado.class, id);
    }
}
