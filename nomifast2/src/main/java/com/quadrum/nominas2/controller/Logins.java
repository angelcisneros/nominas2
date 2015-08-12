/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.controller;

import com.quadrum.nominas2.entidades.Empresa;
import com.quadrum.nominas2.servicios.EmpresaServicio;
import com.quadrum.nominas2.servicios.RegimenFiscalServicio;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author vcisneros
 */
@Controller
public class Logins {

    @Autowired
    RegimenFiscalServicio regimenFiscalServicio;

    @Autowired
    EmpresaServicio empresaServicio;

    @RequestMapping(value = "{notFound}/")
    public String error404(@PathVariable String notFound, Model model) {
        String url = "/";
        if ("empresa".equalsIgnoreCase(notFound)) {
            url = "empresa/inicio";
        }
        if ("empleado".equalsIgnoreCase(notFound)) {
            url = "empleado/inicio";
        }
        if ("quadrum".equalsIgnoreCase(notFound)) {
            url = "administrador/inicio";
        }
        model.addAttribute("url", url);
        return "util/redireccionador";
    }

    @RequestMapping(value = "/")
    public String homeController(HttpSession session, Model model) {
        model.addAttribute("regimenesFiscales", regimenFiscalServicio.buscarTodos());
        return "index";
    }

    @RequestMapping(value = "failEmpresa")
    public String hola(Model model) {
        model.addAttribute("regimenesFiscales", regimenFiscalServicio.buscarTodos());
        model.addAttribute("errorEmpresa", true);
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "registrarEmpresa")
    public String registrarEmpresa(@Valid Empresa empresa, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("erroresEmpresa", result.getAllErrors());
            return "index";
        }
        return empresaServicio.agregar(empresa);
    }

    @RequestMapping(value = "confirmacion")
    public String confirmacionEmpresa(@RequestParam String usuario, @RequestParam String confirmacion, @RequestParam String opcion, Model model) {
        if (empresaServicio.confirmaLink(usuario, confirmacion, opcion)) {
            model.addAttribute("regimenesFiscales", regimenFiscalServicio.buscarTodos());
            model.addAttribute("popup", "empresa");
            return "index";
        }else{
            return "util/link";
        }
    }
}
