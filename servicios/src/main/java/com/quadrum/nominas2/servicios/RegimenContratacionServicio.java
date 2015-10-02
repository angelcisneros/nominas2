/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.RegimenContratacion;
import java.util.List;

public interface RegimenContratacionServicio {
    String agregar(RegimenContratacion paramRegimenContratacion);
    String actualizar(RegimenContratacion paramRegimenContratacion);
    String eliminar(RegimenContratacion paramRegimenContratacion);
    String eliminar(Integer paramInteger);
    RegimenContratacion buscarPorId(Integer paramInteger);
    List<RegimenContratacion> buscarTodos();
}
