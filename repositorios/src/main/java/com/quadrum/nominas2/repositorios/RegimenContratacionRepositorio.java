/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios;

import com.quadrum.nominas2.entidades.RegimenContratacion;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface RegimenContratacionRepositorio{
    Boolean agregar(RegimenContratacion regimenContratacion);
    Boolean actualizar(RegimenContratacion regimenContratacion);
    Boolean eliminar(RegimenContratacion regimenContratacion);
    Boolean eliminar(Integer id);
    
    RegimenContratacion buscarPorId(Integer id);
    List<RegimenContratacion> buscarTodos();
}
