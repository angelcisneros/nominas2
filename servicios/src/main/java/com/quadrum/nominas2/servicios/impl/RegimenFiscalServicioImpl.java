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
import com.quadrum.nominas2.entidades.RegimenFiscal;
import com.quadrum.nominas2.repositorios.RegimenFiscalRepositorio;
import com.quadrum.nominas2.servicios.RegimenFiscalServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegimenFiscalServicioImpl implements RegimenFiscalServicio {

    @Autowired
    RegimenFiscalRepositorio regimenFiscalRepositorio;
    private static final String ALUMNO_CLASE = "un regimenFiscal.#";

    @Override
    public String agregar(RegimenFiscal regimenFiscal) {
        if (this.regimenFiscalRepositorio.agregar(regimenFiscal)) {
            return "Correcto...#Se ha agregado un regimenFiscal.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String actualizar(RegimenFiscal regimenFiscal) {
        if (this.regimenFiscalRepositorio.actualizar(regimenFiscal)) {
            return "Correcto...#Se ha actualizado un regimenFiscal.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String eliminar(RegimenFiscal regimenFiscal) {
        if (this.regimenFiscalRepositorio.eliminar(regimenFiscal)) {
            return "Correcto...#Se ha eliminado un regimenFiscal.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public List<RegimenFiscal> buscarTodos() {
        return this.regimenFiscalRepositorio.buscarTodos(RegimenFiscal.class);
    }

    @Override
    public String eliminar(Integer id) {
        RegimenFiscal regimenFiscal = (RegimenFiscal) this.regimenFiscalRepositorio.buscarPorId(RegimenFiscal.class, id);
        if (this.regimenFiscalRepositorio.eliminar(regimenFiscal)) {
            return "Correcto...#Se ha eliminado un regimenFiscal.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public RegimenFiscal buscarPorId(Integer id) {
        return (RegimenFiscal) this.regimenFiscalRepositorio.buscarPorId(RegimenFiscal.class, id);
    }
}
