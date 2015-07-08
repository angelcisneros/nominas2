/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.RegimenContratacion;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface RegimenContratacionServicio{
    String agregar(RegimenContratacion regimenContratacion);
    String actualizar(RegimenContratacion regimenContratacion);
    String eliminar(RegimenContratacion regimenContratacion);
    String eliminar(Integer id);
    
    RegimenContratacion buscarPorId(Integer id);
    List<RegimenContratacion> buscarTodos();
}
