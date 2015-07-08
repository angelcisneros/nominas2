/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.Banco;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface BancoServicio{
    String agregar(Banco banco);
    String actualizar(Banco banco);
    String eliminar(Banco banco);
    String eliminar(Integer id);
    
    Banco buscarPorId(Integer id);
    List<Banco> buscarTodos();
}
