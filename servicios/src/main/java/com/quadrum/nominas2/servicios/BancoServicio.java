/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios;

/**
 *
 * @author vcisneros
 */
import com.quadrum.nominas2.entidades.Banco;
import java.util.List;

public interface BancoServicio {
    String agregar(Banco paramBanco);
    String actualizar(Banco paramBanco);
    String eliminar(Banco paramBanco);
    String eliminar(Integer paramInteger);
    Banco buscarPorId(Integer paramInteger);
    List<Banco> buscarTodos();
}
