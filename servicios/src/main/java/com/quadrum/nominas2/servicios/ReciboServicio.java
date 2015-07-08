/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.Recibo;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface ReciboServicio{
    String agregar(Recibo recibo);
    String actualizar(Recibo recibo);
    String eliminar(Recibo recibo);
    String eliminar(Integer id);
    
    Recibo buscarPorId(Integer id);
    List<Recibo> buscarTodos();
}
