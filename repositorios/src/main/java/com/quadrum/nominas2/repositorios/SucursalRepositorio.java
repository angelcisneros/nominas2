/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios;

import com.quadrum.nominas2.entidades.Sucursal;
import java.util.List;

/**
 *
 * @author vcisneros
 */
public interface SucursalRepositorio extends GenericDao<Sucursal, Integer>{
    Sucursal buscarPorMatriz(Integer empresa);
    Sucursal buscarPorIdAndEmpresa(Integer sucursal, Integer empresa);
    List<Sucursal> buscarPorEmpresa(Integer empresa);
}
