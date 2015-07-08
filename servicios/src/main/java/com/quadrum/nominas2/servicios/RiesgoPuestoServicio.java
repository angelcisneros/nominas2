/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.RiesgoPuesto;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface RiesgoPuestoServicio{
    String agregar(RiesgoPuesto riesgoPuesto);
    String actualizar(RiesgoPuesto riesgoPuesto);
    String eliminar(RiesgoPuesto riesgoPuesto);
    String eliminar(Integer id);
    
    RiesgoPuesto buscarPorId(Integer id);
    List<RiesgoPuesto> buscarTodos();
}
