/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.controller.quadrum;

import static com.quadrum.nominas2.servicios.util.Rutas.QUADRUM_PATH;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author vcisneros
 */
@Controller
@RequestMapping(QUADRUM_PATH)
public class HomeAdministradorController {
    
    

    @RequestMapping(value = "inicio")
    public String inicio(Model model) {
        return "empresaTemplates/inicio";
    }
}
