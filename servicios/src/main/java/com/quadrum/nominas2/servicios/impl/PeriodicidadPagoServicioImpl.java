/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios.impl;

import com.quadrum.nominas2.entidades.PeriodicidadPago;
import com.quadrum.nominas2.repositorios.PeriodicidadPagoRepositorio;
import com.quadrum.nominas2.servicios.PeriodicidadPagoServicio;
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
public class PeriodicidadPagoServicioImpl implements PeriodicidadPagoServicio {

   @Autowired
    PeriodicidadPagoRepositorio periodicidadPagoRepositorio;
    private static final String ALUMNO_CLASE = "un periodicidadPago.#";
    
     @Override
    public String agregar(PeriodicidadPago periodicidadPago) {
        if (periodicidadPagoRepositorio.agregar(periodicidadPago)) {
            return ADD_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(PeriodicidadPago periodicidadPago) {
        if (periodicidadPagoRepositorio.actualizar(periodicidadPago)) {
            return UPDATE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(PeriodicidadPago periodicidadPago) {
        if (periodicidadPagoRepositorio.eliminar(periodicidadPago)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<PeriodicidadPago> buscarTodos() {
        return periodicidadPagoRepositorio.buscarTodos(PeriodicidadPago.class);
    }

    @Override
    public String eliminar(Integer id) {
       PeriodicidadPago periodicidadPago = periodicidadPagoRepositorio.buscarPorId(PeriodicidadPago.class, id);
       if (periodicidadPagoRepositorio.eliminar(periodicidadPago)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public PeriodicidadPago buscarPorId(Integer id) {
       return periodicidadPagoRepositorio.buscarPorId(PeriodicidadPago.class, id);
    }
    
}
