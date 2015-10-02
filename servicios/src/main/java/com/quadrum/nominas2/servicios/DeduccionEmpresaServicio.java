/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.DeduccionEmpresa;
import com.quadrum.nominas2.entidades.DeduccionEmpresaId;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface DeduccionEmpresaServicio {

    String agregar(DeduccionEmpresa paramDeduccionEmpresa);

    String actualizar(DeduccionEmpresa paramDeduccionEmpresa);

    String eliminar(DeduccionEmpresa paramDeduccionEmpresa);

    String eliminar(DeduccionEmpresaId paramDeduccionEmpresaId);

    DeduccionEmpresa buscarPorId(DeduccionEmpresaId paramDeduccionEmpresaId);

    List<DeduccionEmpresa> buscarTodos();
}
