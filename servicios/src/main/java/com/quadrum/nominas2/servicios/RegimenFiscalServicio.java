/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.servicios;

import com.quadrum.nominas2.entidades.RegimenFiscal;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface RegimenFiscalServicio{
    String agregar(RegimenFiscal regimenFiscal);
    String actualizar(RegimenFiscal regimenFiscal);
    String eliminar(RegimenFiscal regimenFiscal);
    String eliminar(Integer id);
    
    RegimenFiscal buscarPorId(Integer id);
    List<RegimenFiscal> buscarTodos();
}
