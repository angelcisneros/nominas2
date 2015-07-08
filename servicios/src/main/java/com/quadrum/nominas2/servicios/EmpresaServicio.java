/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.Empresa;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface EmpresaServicio{
    String agregar(Empresa empresa);
    String actualizar(Empresa empresa);
    String eliminar(Empresa empresa);
    String eliminar(Integer id);
    
    Empresa buscarPorId(Integer id);
    List<Empresa> buscarTodos();
}
