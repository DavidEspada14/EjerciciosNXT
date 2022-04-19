package com.espada.BS4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {
    @Autowired
    Configuracion config;

    @Autowired
    ConfigurationPrefix configPrefix;

    @GetMapping("/valores")
    public String leerValores(){
        return "Valor de var1 es: " + config.getVar1() + " y valor de var2 es: " + configPrefix.getVar2();
    }

    @GetMapping("/var3")
    public String leerVar3(){
        return "Valor de var3 es: " + config.getVar3();
    }
}
