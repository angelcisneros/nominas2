/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios;

import com.quadrum.nominas2.entidades.Archivo;
import com.quadrum.nominas2.entidades.Recibo;
import java.util.List;
/**
 *
 * @author vcisneros
 */
public interface ReciboRepositorio extends GenericDao<Recibo, Integer>{
    boolean guradarConEmpleado(Recibo recibo);
    List<Recibo> buscarPorArchivo(Archivo archivo);
}
