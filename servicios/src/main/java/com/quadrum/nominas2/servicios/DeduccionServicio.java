/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.Deduccion;
import java.util.List;

public interface DeduccionServicio {

    String agregar(Deduccion paramDeduccion);

    String actualizar(Deduccion paramDeduccion);

    String eliminar(Deduccion paramDeduccion);

    String eliminar(Integer paramInteger);

    Deduccion buscarPorId(Integer paramInteger);

    List<Deduccion> buscarTodos();
}
