/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios.impl;

/**
 *
 * @author vcisneros
 */
import com.quadrum.nominas2.entidades.Banco;
import com.quadrum.nominas2.repositorios.BancoRepositorio;
import com.quadrum.nominas2.servicios.BancoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BancoServicioImpl implements BancoServicio {

    @Autowired
    BancoRepositorio bancoRepositorio;
    private static final String ALUMNO_CLASE = "un banco.#";

    @Override
    public String agregar(Banco banco) {
        if (this.bancoRepositorio.agregar(banco)) {
            return "Correcto...#Se ha agregado un banco.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String actualizar(Banco banco) {
        if (this.bancoRepositorio.actualizar(banco)) {
            return "Correcto...#Se ha actualizado un banco.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String eliminar(Banco banco) {
        if (this.bancoRepositorio.eliminar(banco)) {
            return "Correcto...#Se ha eliminado un banco.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public List<Banco> buscarTodos() {
        return this.bancoRepositorio.buscarTodos(Banco.class);
    }

    @Override
    public String eliminar(Integer id) {
        Banco banco = (Banco) this.bancoRepositorio.buscarPorId(Banco.class, id);
        if (this.bancoRepositorio.eliminar(banco)) {
            return "Correcto...#Se ha eliminado un banco.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public Banco buscarPorId(Integer id) {
        return (Banco) this.bancoRepositorio.buscarPorId(Banco.class, id);
    }
}
