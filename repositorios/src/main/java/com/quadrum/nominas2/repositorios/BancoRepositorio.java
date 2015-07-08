/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios;

import com.quadrum.nominas2.entidades.Banco;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface BancoRepositorio{
    Boolean agregar(Banco banco);
    Boolean actualizar(Banco banco);
    Boolean eliminar(Banco banco);
    Boolean eliminar(Integer id);
    
    Banco buscarPorId(Integer id);
    List<Banco> buscarTodos();
}
