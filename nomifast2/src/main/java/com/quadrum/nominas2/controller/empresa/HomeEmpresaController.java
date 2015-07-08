/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.controller.empresa;

import com.quadrum.nominas2.servicios.util.LoginEmpresa;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author vcisneros
 */
@Controller
public class HomeEmpresaController {
    @RequestMapping(value = "/")
    public String homeController(HttpSession session, Model model) {
        return "index";
    }
    
    @ResponseBody
    @RequestMapping(value = "loginEmpresa", method = RequestMethod.POST)
    public String loginEmpresa(@Valid @ModelAttribute LoginEmpresa loginEmpresa, BindingResult result, HttpSession session, Model model) {
        
        return "index";
    }

    @RequestMapping(value = "*")
    public String error404(HttpSession session, Model model) {
       
        return "templates/404";
    }

    @RequestMapping(value = "inicio")
    public String inicio(HttpSession session, Model model) {
       
        return "empresaTemplates/inicio";
    }
    
    @RequestMapping(value = "empleados")
    public String empleados(HttpSession session, Model model) {
       
        return "empresa/empleados";
    }
    @RequestMapping(value = "sucursales")
    public String sucursales(HttpSession session, Model model) {
       
        return "empresa/sucursales";
    }
    @RequestMapping(value = "recibos")
    public String recibos(HttpSession session, Model model) {
       
        return "empresa/recibos";
    }
    @RequestMapping(value = "timbrar")
    public String timbrar(HttpSession session, Model model) {
       
        return "empresa/timbrar";
    }
    @RequestMapping(value = "cancelar")
    public String cancelar(HttpSession session, Model model) {
       
        return "empresa/cancelar";
    }
    @RequestMapping(value = "logo")
    public String logo(HttpSession session, Model model) {
       
        return "empresa/logo";
    }
    @RequestMapping(value = "percepciones")
    public String percepciones(HttpSession session, Model model) {
       
        return "empresa/percepciones";
    }
    @RequestMapping(value = "deducciones")
    public String deducciones(HttpSession session, Model model) {
       
        return "empresa/deducciones";
    }

}
