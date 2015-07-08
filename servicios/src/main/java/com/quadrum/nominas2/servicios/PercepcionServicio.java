/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.Percepcion;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface PercepcionServicio{
    String agregar(Percepcion percepcion);
    String actualizar(Percepcion percepcion);
    String eliminar(Percepcion percepcion);
    String eliminar(Integer id);
    
    Percepcion buscarPorId(Integer id);
    List<Percepcion> buscarTodos();
}
