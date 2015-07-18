/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.controller.empresa;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author vcisneros
 */
@Controller
@RequestMapping(value = "empresa/")
public class HomeEmpresaController {

    @RequestMapping(value = "*")
    public String error404(Model model) {
        return "templates/404";
    }

    @RequestMapping(value = "inicio")
    public String inicio(Model model) {
        return "empresaTemplates/inicio";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "empleados")
    public String empleados(Model model) {

        return "empresa/empleados";
    }

    @RequestMapping(value = "sucursales")
    public String sucursales(Model model) {

        return "empresa/sucursales";
    }

    @RequestMapping(value = "recibos")
    public String recibos(Model model) {

        return "empresa/recibos";
    }

    @RequestMapping(value = "timbrar")
    public String timbrar(Model model) {

        return "empresa/timbrar";
    }

    @RequestMapping(value = "cancelar")
    public String cancelar(Model model) {

        return "empresa/cancelar";
    }

    @RequestMapping(value = "logo")
    public String logo(Model model) {

        return "empresa/logo";
    }

    @RequestMapping(value = "percepciones")
    public String percepciones(Model model) {

        return "empresa/percepciones";
    }

    @RequestMapping(value = "deducciones")
    public String deducciones(Model model) {

        return "empresa/deducciones";
    }

}
