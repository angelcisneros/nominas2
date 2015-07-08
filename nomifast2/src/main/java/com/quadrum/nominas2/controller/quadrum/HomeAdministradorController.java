/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quadrum.nominas2.controller.quadrum;

import com.quadrum.nominas2.entidades.Administrador;
import static com.quadrum.nominas2.servicios.util.Rutas.QUADRUM_PATH;
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
@RequestMapping(QUADRUM_PATH)
public class HomeAdministradorController {
    
    @ResponseBody
    @RequestMapping(value = "loginQUadrum", method = RequestMethod.GET)
    public String loginQUadrum(@Valid @ModelAttribute("administrador") Administrador administrador, BindingResult result, HttpSession session, Model model){
        if(result.hasErrors()){
            
        }
        return "";
    }
}
