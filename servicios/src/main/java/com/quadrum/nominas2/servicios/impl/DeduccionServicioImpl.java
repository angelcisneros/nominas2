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
import com.quadrum.nominas2.entidades.Deduccion;
import com.quadrum.nominas2.repositorios.DeduccionRepositorio;
import com.quadrum.nominas2.servicios.DeduccionServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeduccionServicioImpl implements DeduccionServicio {

    @Autowired
    DeduccionRepositorio deduccionRepositorio;
    private static final String ALUMNO_CLASE = "un deduccion.#";

    @Override
    public String agregar(Deduccion deduccion) {
        if (this.deduccionRepositorio.agregar(deduccion)) {
            return "Correcto...#Se ha agregado un deduccion.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String actualizar(Deduccion deduccion) {
        if (this.deduccionRepositorio.actualizar(deduccion)) {
            return "Correcto...#Se ha actualizado un deduccion.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String eliminar(Deduccion deduccion) {
        if (this.deduccionRepositorio.eliminar(deduccion)) {
            return "Correcto...#Se ha eliminado un deduccion.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public List<Deduccion> buscarTodos() {
        return this.deduccionRepositorio.buscarTodos(Deduccion.class);
    }

    @Override
    public String eliminar(Integer id) {
        Deduccion deduccion = (Deduccion) this.deduccionRepositorio.buscarPorId(Deduccion.class, id);
        if (this.deduccionRepositorio.eliminar(deduccion)) {
            return "Correcto...#Se ha eliminado un deduccion.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public Deduccion buscarPorId(Integer id) {
        return (Deduccion) this.deduccionRepositorio.buscarPorId(Deduccion.class, id);
    }
}
