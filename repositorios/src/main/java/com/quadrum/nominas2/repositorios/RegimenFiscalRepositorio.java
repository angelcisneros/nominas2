/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios;

import com.quadrum.nominas2.entidades.RegimenFiscal;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface RegimenFiscalRepositorio{
    Boolean agregar(RegimenFiscal regimenFiscal);
    Boolean actualizar(RegimenFiscal regimenFiscal);
    Boolean eliminar(RegimenFiscal regimenFiscal);
    Boolean eliminar(Integer id);
    
    RegimenFiscal buscarPorId(Integer id);
    List<RegimenFiscal> buscarTodos();
}
