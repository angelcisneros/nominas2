/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.Deduccion;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface DeduccionServicio{
    
    String agregar(Deduccion deduccion);
    String actualizar(Deduccion deduccion);
    String eliminar(Deduccion deduccion);
    String eliminar(Integer id);
    
    Deduccion buscarPorId(Integer id);
    List<Deduccion> buscarTodos();
}
