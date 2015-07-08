/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios;

import com.quadrum.nominas2.entidades.DeduccionEmpresa;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface DeduccionEmpresaRepositorio{
    Boolean agregar(DeduccionEmpresa deduccionEmpresa);
    Boolean actualizar(DeduccionEmpresa deduccionEmpresa);
    Boolean eliminar(DeduccionEmpresa deduccionEmpresa);
    Boolean eliminar(Integer id);
    
    DeduccionEmpresa buscarPorId(Integer id);
    List<DeduccionEmpresa> buscarTodos();
}
