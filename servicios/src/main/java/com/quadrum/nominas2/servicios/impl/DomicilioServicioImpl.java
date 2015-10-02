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
import com.quadrum.nominas2.entidades.Domicilio;
import com.quadrum.nominas2.repositorios.DomicilioRepositorio;
import com.quadrum.nominas2.servicios.DomicilioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioServicioImpl implements DomicilioServicio {

    @Autowired
    DomicilioRepositorio domicilioRepositorio;
    private static final String ALUMNO_CLASE = "un domicilio.#";

    @Override
    public String agregar(Domicilio domicilio) {
        if (this.domicilioRepositorio.agregar(domicilio)) {
            return "Correcto...#Se ha agregado un domicilio.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String actualizar(Domicilio domicilio) {
        if (this.domicilioRepositorio.actualizar(domicilio)) {
            return "Correcto...#Se ha actualizado un domicilio.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String eliminar(Domicilio domicilio) {
        if (this.domicilioRepositorio.eliminar(domicilio)) {
            return "Correcto...#Se ha eliminado un domicilio.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public List<Domicilio> buscarTodos() {
        return this.domicilioRepositorio.buscarTodos(Domicilio.class);
    }

    @Override
    public String eliminar(Integer id) {
        Domicilio domicilio = (Domicilio) this.domicilioRepositorio.buscarPorId(Domicilio.class, id);
        if (this.domicilioRepositorio.eliminar(domicilio)) {
            return "Correcto...#Se ha eliminado un domicilio.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public Domicilio buscarPorId(Integer id) {
        return (Domicilio) this.domicilioRepositorio.buscarPorId(Domicilio.class, id);
    }
}
