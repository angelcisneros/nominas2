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
import com.quadrum.nominas2.servicios.util.LinkConfirmacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
        if (this.usuarioRepositorio.buscarPorId(Usuario.class, empresa.getUsuario().getUserName()) != null) {
            return "Ups!...##Lo sentimos el usuario ya esta registrado.";
        }
        empresa.getUsuario().setPassword(new BCryptPasswordEncoder(12).encode(empresa.getUsuario().getPassword()));
        empresa.getUsuario().setLink(LinkConfirmacion.generarLinkRegistro(empresa.getUsuario()));
        empresa.getUsuario().setPrimeraSesion(Boolean.TRUE);
        empresa.getUsuario().setEnable(Boolean.FALSE);
        empresa.setAccesoPorSucursales(Boolean.FALSE);
        empresa.setIlimitados(Boolean.FALSE);
        empresa.setConfiguracionInicial(0);
        empresa.setFolios(0);
        if ((this.usuarioRepositorio.agregar(empresa.getUsuario()))
                && (this.empresaRepositorio.agregar(empresa))) {
            EnviarCorreo enviarCorreo = new EnviarCorreo();
            return enviarCorreo.enviarLinkCornfirmacion(empresa.getUsuario().getUserName(), empresa.getUsuario().getLink());
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String actualizar(Empresa empresa) {
        if (this.empresaRepositorio.actualizar(empresa)) {
            return "Correcto...#Se ha actualizado una empresa.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public String eliminar(Empresa empresa) {
        if (this.empresaRepositorio.eliminar(empresa)) {
            return "Correcto...#Se ha eliminado una empresa.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public List<Empresa> buscarTodos() {
        return this.empresaRepositorio.buscarTodos(Empresa.class);
    }

    @Override
    public String eliminar(Integer id) {
        Empresa empresa = (Empresa) this.empresaRepositorio.buscarPorId(Empresa.class, id);
        if (this.empresaRepositorio.eliminar(empresa)) {
            return "Correcto...#Se ha eliminado una empresa.#";
        }
        return "Ups!...#Estamos teniendo problemas al conectar con el servidor, intente m�s tarde.";
    }

    @Override
    public Empresa buscarPorId(Integer id) {
        return (Empresa) this.empresaRepositorio.buscarPorId(Empresa.class, id);
    }

    @Override
    public boolean confirmaLink(String id, String confirmacion, String opcion) {
        Usuario u = (Usuario) this.usuarioRepositorio.buscarPorId(Usuario.class, id);
        if ((u != null)
                && (u.getLink() != null)
                && (u.getLink().equalsIgnoreCase(LinkConfirmacion.reconstruirLinkRegistro(id, confirmacion, opcion)))) {
            u.setEnable(Boolean.TRUE);
            u.setLink(null);
            if (this.usuarioRepositorio.actualizar(u)) {
                Rol rol = (Rol) this.rolRepositorio.buscarPorId(Rol.class, "ROL_EMPRESA");
                RolUsuarioId rolUsuarioId = new RolUsuarioId(rol.getRol(), u.getUserName());
                RolUsuario rolUsuario = new RolUsuario(rolUsuarioId, rol, u);
                this.rolUsuarioRepositorio.agregar(rolUsuario);
                return true;
            }
        }
        return false;
    }

    @Override
    public Empresa buscarPorUsuario(String usuario) {
        return this.empresaRepositorio.buscarPorUsuario(usuario);
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
        RegimenFiscal regimenFiscal = this.regimenFiscalServico.buscarPorId(empresa.getRegimenFiscal().getId());
        if (antigua == null) {
            return "Ups!...#Los datos que proporciono no son validos";
        }
        if (regimenFiscal == null) {
            return "Ups!...#Los datos que proporciono no son validos";
        }
        antigua.setRegimenFiscal(regimenFiscal);
        antigua.getUsuario().setNombre(empresa.getUsuario().getNombre());
        return actualizar(antigua);
    }
}
