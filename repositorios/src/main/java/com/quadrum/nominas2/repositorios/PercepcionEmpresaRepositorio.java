/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios;

import com.quadrum.nominas2.entidades.PercepcionEmpresa;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface PercepcionEmpresaRepositorio{
    Boolean agregar(PercepcionEmpresa percepcionEmpresa);
    Boolean actualizar(PercepcionEmpresa percepcionEmpresa);
    Boolean eliminar(PercepcionEmpresa percepcionEmpresa);
    Boolean eliminar(Integer id);
    
    PercepcionEmpresa buscarPorId(Integer id);
    List<PercepcionEmpresa> buscarTodos();
}
