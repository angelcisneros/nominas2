/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.repositorios;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vcisneros
 * @param <Entity>
 * @param <PK>
 */
public interface GenericDao <Entity, PK extends Serializable> {
    Boolean agregar(Entity e);
    Boolean actualizar(Entity e);
    Boolean eliminar(Entity e);
    
    Entity buscarPorId(Class klass, PK id);
    List<Entity> buscarTodos(Class klass);
}
