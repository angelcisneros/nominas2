/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios.impl;

import com.quadrum.nominas2.entidades.Empresa;
import com.quadrum.nominas2.entidades.RegimenFiscal;
import com.quadrum.nominas2.entidades.Rol;
import com.quadrum.nominas2.entidades.RolUsuario;
import com.quadrum.nominas2.entidades.RolUsuarioId;
import com.quadrum.nominas2.entidades.Usuario;
import com.quadrum.nominas2.repositorios.EmpresaRepositorio;
import com.quadrum.nominas2.repositorios.RolRepositorio;
import com.quadrum.nominas2.repositorios.RolUsuarioRepositorio;
import com.quadrum.nominas2.repositorios.UsuarioRepositorio;
import com.quadrum.nominas2.servicios.EmpresaServicio;
import com.quadrum.nominas2.servicios.RegimenFiscalServicio;
import com.quadrum.nominas2.servicios.util.EnviarCorreo;
import static com.quadrum.nominas2.servicios.util.LinkConfirmacion.generarLinkRegistro;
import static com.quadrum.nominas2.servicios.util.LinkConfirmacion.reconstruirLinkRegistro;
import static com.quadrum.nominas2.servicios.util.MensajesCrud.DELETE_CORRECT;
import static com.quadrum.nominas2.servicios.util.MensajesCrud.ERROR_DATOS;
import static com.quadrum.nominas2.servicios.util.MensajesCrud.ERROR_HIBERNATE;
import static com.quadrum.nominas2.servicios.util.MensajesCrud.UPDATE_CORRECT;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author vcisneros
 */
@Service
public class EmpresaServicioImpl implements EmpresaServicio {

    @Autowired
    EmpresaRepositorio empresaRepositorio;

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    RolUsuarioRepositorio rolUsuarioRepositorio;

    @Autowired
    RolRepositorio rolRepositorio;
    
    @Autowired
    RegimenFiscalServicio regimenFiscalServico;

    private static final String ALUMNO_CLASE = "una empresa.#";

    @Override
    public String agregar(Empresa empresa) {
        if(usuarioRepositorio.buscarPorId(Usuario.class, empresa.getUsuario().getUserName()) != null){
            return "Ups!...##Lo sentimos el usuario ya esta registrado.";
        }
        empresa.getUsuario().setPassword(new BCryptPasswordEncoder(12).encode(empresa.getUsuario().getPassword()));
        empresa.getUsuario().setLink(generarLinkRegistro(empresa.getUsuario()));
        empresa.getUsuario().setPrimeraSesion(TRUE);
        empresa.getUsuario().setEnable(FALSE);
        empresa.setAccesoPorSucursales(FALSE);
        empresa.setIlimitados(FALSE);
        empresa.setConfiguracionInicial(0);
        empresa.setFolios(0);
        if (usuarioRepositorio.agregar(empresa.getUsuario())) {
            if (empresaRepositorio.agregar(empresa)) {
                EnviarCorreo enviarCorreo = new EnviarCorreo();
                return enviarCorreo.enviarLinkCornfirmacion(empresa.getUsuario().getUserName(), empresa.getUsuario().getLink());
            }
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(Empresa empresa) {
        if (empresaRepositorio.actualizar(empresa)) {
            return UPDATE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(Empresa empresa) {
        if (empresaRepositorio.eliminar(empresa)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<Empresa> buscarTodos() {
        return empresaRepositorio.buscarTodos(Empresa.class);
    }

    @Override
    public String eliminar(Integer id) {
        Empresa empresa = empresaRepositorio.buscarPorId(Empresa.class, id);
        if (empresaRepositorio.eliminar(empresa)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public Empresa buscarPorId(Integer id) {
        return empresaRepositorio.buscarPorId(Empresa.class, id);
    }

    @Override
    public boolean confirmaLink(String id, String confirmacion, String opcion) {
        Usuario u = usuarioRepositorio.buscarPorId(Usuario.class, id);
        if (u != null) {
            if (u.getLink() != null) {
                if (u.getLink().equalsIgnoreCase(reconstruirLinkRegistro(id, confirmacion, opcion))) {
                    u.setEnable(TRUE);
                    u.setLink(null);
                    if (usuarioRepositorio.actualizar(u)) {
                        Rol rol = rolRepositorio.buscarPorId(Rol.class, "ROL_EMPRESA");
                        RolUsuarioId rolUsuarioId = new RolUsuarioId(rol.getRol(), u.getUserName());
                        RolUsuario rolUsuario = new RolUsuario(rolUsuarioId, rol, u);
                        rolUsuarioRepositorio.agregar(rolUsuario);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public Empresa buscarPorUsuario(String usuario) {
        return empresaRepositorio.buscarPorUsuario(usuario);
    }

    @Override
    public String regresaVista(Empresa empresa) {
        if (empresa.getUsuario().isPrimeraSesion()) {
            switch (empresa.getConfiguracionInicial()) {
                case 0:
                    return "empresaPrimeraSesion/sucursal";
                case 1:
                    return "empresaPrimeraSesion/domicilioFiscal";
                case 2:
                    return "empresaPrimeraSesion/percepciones";
                case 3:
                    return "empresaPrimeraSesion/deducciones";
                case 4:
                    return "empresaPrimeraSesion/logo";
            }
        }
        return "empresaTemplates/inicio";

    }

    @Override
    public String actualizarPerfil(Empresa empresa, Empresa antigua) {
        RegimenFiscal regimenFiscal = regimenFiscalServico.buscarPorId(empresa.getRegimenFiscal().getId());
        if(antigua == null){
            return ERROR_DATOS;
        }
        if(regimenFiscal == null){
            return ERROR_DATOS;
        }
        antigua.setRegimenFiscal(regimenFiscal);
        antigua.getUsuario().setNombre(empresa.getUsuario().getNombre());
        return actualizar(antigua);
    }

}
