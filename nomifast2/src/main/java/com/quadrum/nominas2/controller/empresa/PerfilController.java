/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.controller.empresa;


import com.quadrum.nominas2.entidades.Empresa;
import com.quadrum.nominas2.servicios.EmpresaServicio;
import com.quadrum.nominas2.servicios.RegimenFiscalServicio;
import static com.quadrum.nominas2.servicios.util.Llave.EMPRESA;
import static com.quadrum.nominas2.servicios.util.Llave.P_EMPRESA;
import static com.quadrum.nominas2.servicios.util.MensajesCrud.ERROR_DATOS;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author vcisneros
 */
@Controller
@RequestMapping(value = P_EMPRESA)
public class PerfilController {
    
    @Autowired
    EmpresaServicio empresaServicio;
    
    @Autowired
    RegimenFiscalServicio regimenFiscalServicio;    
    
    @RequestMapping(value = "perfil")
    public String perfil(HttpSession session, Model model) {
        Empresa empresa = (Empresa) session.getAttribute(EMPRESA);
        model.addAttribute("empresa", empresa);
        model.addAttribute("regimenes", regimenFiscalServicio.buscarTodos());
        return P_EMPRESA + "perfil";
    }
    
    @ResponseBody
    @RequestMapping(value = "editarPerfil", method = RequestMethod.POST)
    public String editarPerfil(@Valid Empresa empresa, BindingResult result, HttpSession session) {
        if(result.hasErrors()){
            return ERROR_DATOS;
        }
        return empresaServicio.actualizarPerfil(empresa, (Empresa) session.getAttribute(EMPRESA));
    }
}
