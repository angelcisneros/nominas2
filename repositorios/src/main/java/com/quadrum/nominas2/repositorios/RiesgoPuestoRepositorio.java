/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios;

import com.quadrum.nominas2.entidades.RiesgoPuesto;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface RiesgoPuestoRepositorio{
    Boolean agregar(RiesgoPuesto riesgoPuesto);
    Boolean actualizar(RiesgoPuesto riesgoPuesto);
    Boolean eliminar(RiesgoPuesto riesgoPuesto);
    Boolean eliminar(Integer id);
    
    RiesgoPuesto buscarPorId(Integer id);
    List<RiesgoPuesto> buscarTodos();
}
