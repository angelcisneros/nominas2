/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.PeriodicidadPago;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface PeriodicidadPagoServicio{
    String agregar(PeriodicidadPago periodicidadPago);
    String actualizar(PeriodicidadPago periodicidadPago);
    String eliminar(PeriodicidadPago periodicidadPago);
    String eliminar(Integer id);
    
    PeriodicidadPago buscarPorId(Integer id);
    List<PeriodicidadPago> buscarTodos();
}
