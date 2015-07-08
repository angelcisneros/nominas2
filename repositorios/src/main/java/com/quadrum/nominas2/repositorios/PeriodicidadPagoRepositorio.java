/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios;

import com.quadrum.nominas2.entidades.PeriodicidadPago;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface PeriodicidadPagoRepositorio{
    Boolean agregar(PeriodicidadPago periodicidadPago);
    Boolean actualizar(PeriodicidadPago periodicidadPago);
    Boolean eliminar(PeriodicidadPago periodicidadPago);
    Boolean eliminar(Integer id);
    
    PeriodicidadPago buscarPorId(Integer id);
    List<PeriodicidadPago> buscarTodos();
}
