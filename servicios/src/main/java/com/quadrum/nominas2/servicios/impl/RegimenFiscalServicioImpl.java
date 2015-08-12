/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios.impl;

import com.quadrum.nominas2.entidades.RegimenFiscal;
import com.quadrum.nominas2.repositorios.RegimenFiscalRepositorio;
import com.quadrum.nominas2.servicios.RegimenFiscalServicio;
import static com.quadrum.nominas2.servicios.util.MensajesCrud.ADD_CORRECT;
import static com.quadrum.nominas2.servicios.util.MensajesCrud.DELETE_CORRECT;
import static com.quadrum.nominas2.servicios.util.MensajesCrud.ERROR_HIBERNATE;
import static com.quadrum.nominas2.servicios.util.MensajesCrud.UPDATE_CORRECT;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vcisneros
 */
@Service
public class RegimenFiscalServicioImpl implements RegimenFiscalServicio {

    @Autowired
    RegimenFiscalRepositorio regimenFiscalRepositorio;
    private static final String ALUMNO_CLASE = "un regimenFiscal.#";

    @Override
    public String agregar(RegimenFiscal regimenFiscal) {
        if (regimenFiscalRepositorio.agregar(regimenFiscal)) {
            return ADD_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(RegimenFiscal regimenFiscal) {
        if (regimenFiscalRepositorio.actualizar(regimenFiscal)) {
            return UPDATE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(RegimenFiscal regimenFiscal) {
        if (regimenFiscalRepositorio.eliminar(regimenFiscal)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<RegimenFiscal> buscarTodos() {
        return regimenFiscalRepositorio.buscarTodos(RegimenFiscal.class);
    }

    @Override
    public String eliminar(Integer id) {
        RegimenFiscal regimenFiscal = regimenFiscalRepositorio.buscarPorId(RegimenFiscal.class, id);
        if (regimenFiscalRepositorio.eliminar(regimenFiscal)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public RegimenFiscal buscarPorId(Integer id) {
        return regimenFiscalRepositorio.buscarPorId(RegimenFiscal.class, id);
    }

}
