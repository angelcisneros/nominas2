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
import com.quadrum.nominas2.entidades.Administrador;
import java.util.List;

public interface AdministradorServicio {

    String agregar(Administrador paramAdministrador);

    String actualizar(Administrador paramAdministrador);

    String eliminar(Administrador paramAdministrador);

    String eliminar(Integer paramInteger);

    Administrador buscarPorId(Integer paramInteger);

    Administrador buscarPorCorreo(String paramString);

    List<Administrador> buscarTodos();
}
