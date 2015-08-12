/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.controller.empresa;

import com.quadrum.nominas2.entidades.Domicilio;
import com.quadrum.nominas2.entidades.Empresa;
import com.quadrum.nominas2.entidades.PercepcionEmpresa;
import com.quadrum.nominas2.entidades.Sucursal;
import com.quadrum.nominas2.servicios.DomicilioServicio;
import com.quadrum.nominas2.servicios.EmpresaServicio;
import com.quadrum.nominas2.servicios.PercepcionEmpresaServicio;
import com.quadrum.nominas2.servicios.SucursalServicio;
import com.quadrum.nominas2.servicios.logs.ZEmpresa;
import static com.quadrum.nominas2.servicios.util.Llave.P_EMPRESA;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author vcisneros
 */
@Controller
@RequestMapping(P_EMPRESA)
public class PrimeraSesionController {

    @Autowired
    SucursalServicio sucursalServicio;

    @Autowired
    EmpresaServicio empresaServicio;

    @Autowired
    DomicilioServicio domicilioServicio;
    
    @Autowired
    PercepcionEmpresaServicio percepcionEmpresaServicio;

    @Autowired
    ZEmpresa zEmpresa;

    @RequestMapping(value = "agregarMatriz", method = RequestMethod.POST)
    public String agregarMatriz(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult result,
            Model model, @RequestParam MultipartFile certificados, @RequestParam MultipartFile llaves, HttpSession session) throws IOException {
        Empresa empresa = zEmpresa.sesion();
        if (empresa == null) {
            model.addAttribute("url", "../");
            return "util/redireccionador";
        }

        if (result.hasErrors()) {
            model.addAttribute("hasErrors", true);
            model.addAttribute("errores", result.getAllErrors());
            model.addAttribute("nombre", sucursal.getNombre());
            model.addAttribute("rfc", sucursal.getRfc());
            return "empresaPrimeraSesion/sucursal";
        }

        List<ObjectError> errors = sucursalServicio.validarCertificados(sucursal, certificados, llaves);
        if (!errors.isEmpty()) {
            model.addAttribute("hasErrors", true);
            model.addAttribute("errores", errors);
            model.addAttribute("nombre", sucursal.getNombre());
            model.addAttribute("rfc", sucursal.getRfc());
            return "empresaPrimeraSesion/sucursal";
        }

        sucursal.setMatriz(true);
        sucursal.setCer(certificados.getBytes());
        sucursal.setKy(llaves.getBytes());
        sucursal.setEmpresa(empresa);
        if (sucursalServicio.agregar(sucursal).contains("Correcto")) {
            empresa.setConfiguracionInicial(1);
            if (empresaServicio.actualizar(empresa).contains("Correcto")) {
                return "empresaPrimeraSesion/domicilioFiscal";
            } else {
                //AQUI ALGO VA MAL
                sucursalServicio.eliminar(sucursal.getId());
                model.addAttribute("nombre", sucursal.getNombre());
                model.addAttribute("rfc", sucursal.getRfc());
                return "empresaPrimeraSesion/sucursal";
            }
        }
        return "error/500";
    }

    @RequestMapping(value = "agregarDomicilio", method = RequestMethod.POST)
    public String agregarDomicilio(@Valid @ModelAttribute("domicilio") Domicilio domicilio, BindingResult result, Model model) {
        Empresa empresa = zEmpresa.sesion();
        if (empresa == null) {
            model.addAttribute("url", "../");
            return "util/redireccionador";
        }

        if (result.hasErrors()) {
            model.addAttribute("hasErrors", true);
            model.addAttribute("errores", result.getAllErrors());
            model.addAttribute("calle", domicilio.getCalle());
            model.addAttribute("estado", domicilio.getEstado());
            model.addAttribute("municipio", domicilio.getMunicipio());
            model.addAttribute("pais", domicilio.getPais());
            model.addAttribute("codigoPostal", domicilio.getCodigoPostal());
            model.addAttribute("numInterior", domicilio.getNumInterior());
            model.addAttribute("numExterior", domicilio.getNumExterior());
            model.addAttribute("colonia", domicilio.getColonia());
            model.addAttribute("localidad", domicilio.getLocalidad());
            model.addAttribute("referencia", domicilio.getReferencia());
            return "empresaPrimeraSesion/domicilioFiscal";
        }
        Sucursal sucursal = sucursalServicio.buscarMatriz(empresa.getId());
        if(sucursal == null){
            return "error/500";
        }
        domicilio.setSucursal(sucursal);
        if (domicilioServicio.agregar(domicilio).contains("Correcto")) {
            empresa.setConfiguracionInicial(2);
            empresaServicio.actualizar(empresa);
            return "empresaPrimeraSesion/percepciones";
        }
        return "error/500";
    }

}
