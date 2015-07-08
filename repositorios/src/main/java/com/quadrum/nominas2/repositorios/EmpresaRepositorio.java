/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios;

import com.quadrum.nominas2.entidades.Empresa;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface EmpresaRepositorio{
    Boolean agregar(Empresa empresa);
    Boolean actualizar(Empresa empresa);
    Boolean eliminar(Empresa empresa);
    Boolean eliminar(Integer id);
    
    Empresa buscarPorId(Integer id);
    List<Empresa> buscarTodos();
}
