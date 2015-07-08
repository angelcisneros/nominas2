/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios;

import com.quadrum.nominas2.entidades.Recibo;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface ReciboRepositorio{
    Boolean agregar(Recibo recibo);
    Boolean actualizar(Recibo recibo);
    Boolean eliminar(Recibo recibo);
    Boolean eliminar(Integer id);
    
    Recibo buscarPorId(Integer id);
    List<Recibo> buscarTodos();
}
