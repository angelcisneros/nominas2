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
import com.quadrum.nominas2.entidades.InformacionOpcional;
import com.quadrum.nominas2.repositorios.InformacionOpcionalRepositorio;
import com.quadrum.nominas2.servicios.InformacionOpcionalServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformacionOpcionalServicioImpl implements InformacionOpcionalServicio {

    @Autowired
    InformacionOpcionalRepositorio informacionOpcionalRepositorio;
    private static final String ALUMNO_CLASE = "un informacionOpcional.#";

    @Override
    public String agregar(InformacionOpcional informacionOpcional) {
        if (this.informacionOpcionalRepositorio.agregar(informacionOpcional)) {
            return "Correcto...#Se ha agregado un informacionOpcional.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String actualizar(InformacionOpcional informacionOpcional) {
        if (this.informacionOpcionalRepositorio.actualizar(informacionOpcional)) {
            return "Correcto...#Se ha actualizado un informacionOpcional.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String eliminar(InformacionOpcional informacionOpcional) {
        if (this.informacionOpcionalRepositorio.eliminar(informacionOpcional)) {
            return "Correcto...#Se ha eliminado un informacionOpcional.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public List<InformacionOpcional> buscarTodos() {
        return this.informacionOpcionalRepositorio.buscarTodos(InformacionOpcional.class);
    }

    @Override
    public String eliminar(Integer id) {
        InformacionOpcional informacionOpcional = (InformacionOpcional) this.informacionOpcionalRepositorio.buscarPorId(InformacionOpcional.class, id);
        if (this.informacionOpcionalRepositorio.eliminar(informacionOpcional)) {
            return "Correcto...#Se ha eliminado un informacionOpcional.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public InformacionOpcional buscarPorId(Integer id) {
        return (InformacionOpcional) this.informacionOpcionalRepositorio.buscarPorId(InformacionOpcional.class, id);
    }
}
