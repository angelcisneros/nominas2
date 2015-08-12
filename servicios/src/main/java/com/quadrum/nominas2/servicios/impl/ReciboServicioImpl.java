/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios.impl;

import com.quadrum.nominas2.entidades.Recibo;
import com.quadrum.nominas2.repositorios.ReciboRepositorio;
import com.quadrum.nominas2.servicios.ReciboServicio;
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
public class ReciboServicioImpl implements ReciboServicio {

   @Autowired
    ReciboRepositorio reciboRepositorio;
    private static final String ALUMNO_CLASE = "un recibo.#";
    
     @Override
    public String agregar(Recibo recibo) {
        if (reciboRepositorio.agregar(recibo)) {
            return ADD_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(Recibo recibo) {
        if (reciboRepositorio.actualizar(recibo)) {
            return UPDATE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(Recibo recibo) {
        if (reciboRepositorio.eliminar(recibo)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<Recibo> buscarTodos() {
        return reciboRepositorio.buscarTodos(Recibo.class);
    }

    @Override
    public String eliminar(Integer id) {
       Recibo recibo = reciboRepositorio.buscarPorId(Recibo.class, id);
       if (reciboRepositorio.eliminar(recibo)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public Recibo buscarPorId(Integer id) {
       return reciboRepositorio.buscarPorId(Recibo.class, id);
    }
    
}
