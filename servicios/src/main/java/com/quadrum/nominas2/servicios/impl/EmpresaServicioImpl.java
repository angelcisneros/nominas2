/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios.impl;

import com.quadrum.nominas2.entidades.Empresa;
import com.quadrum.nominas2.repositorios.EmpresaRepositorio;
import com.quadrum.nominas2.servicios.EmpresaServicio;
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
public class EmpresaServicioImpl implements EmpresaServicio {

   @Autowired
    EmpresaRepositorio empresaRepositorio;
    private static final String ALUMNO_CLASE = "una empresa.#";
    
     @Override
    public String agregar(Empresa empresa) {
        if (empresaRepositorio.agregar(empresa)) {
            return ADD_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(Empresa empresa) {
        if (empresaRepositorio.actualizar(empresa)) {
            return UPDATE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(Empresa empresa) {
        if (empresaRepositorio.eliminar(empresa)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<Empresa> buscarTodos() {
        return empresaRepositorio.buscarTodos();
    }

    @Override
    public String eliminar(Integer id) {
       Empresa empresa = empresaRepositorio.buscarPorId(id);
       if (empresaRepositorio.eliminar(empresa)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public Empresa buscarPorId(Integer id) {
       return empresaRepositorio.buscarPorId(id);
    }
    
}
