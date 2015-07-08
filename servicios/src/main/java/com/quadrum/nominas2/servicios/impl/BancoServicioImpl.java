/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios.impl;

import com.quadrum.nominas2.entidades.Banco;
import com.quadrum.nominas2.repositorios.BancoRepositorio;
import com.quadrum.nominas2.servicios.BancoServicio;
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
public class BancoServicioImpl implements BancoServicio {

   @Autowired
    BancoRepositorio bancoRepositorio;
    private static final String ALUMNO_CLASE = "un banco.#";
    
     @Override
    public String agregar(Banco banco) {
        if (bancoRepositorio.agregar(banco)) {
            return ADD_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(Banco banco) {
        if (bancoRepositorio.actualizar(banco)) {
            return UPDATE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(Banco banco) {
        if (bancoRepositorio.eliminar(banco)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<Banco> buscarTodos() {
        return bancoRepositorio.buscarTodos();
    }

    @Override
    public String eliminar(Integer id) {
       Banco banco = bancoRepositorio.buscarPorId(id);
       if (bancoRepositorio.eliminar(banco)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public Banco buscarPorId(Integer id) {
       return bancoRepositorio.buscarPorId(id);
    }
    
}
