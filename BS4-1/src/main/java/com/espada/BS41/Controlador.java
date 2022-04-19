package com.espada.BS41;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controlador {
    @Autowired
    AppConfiguration appConfiguration;

    @Autowired
    MiConfiguracionProperties miConfiguracionProperties;

    @Autowired
    Perfiles perfil;

    @GetMapping("/parametros")
    public String getAppConfig(){
        return appConfiguration.toString();
    }

    @GetMapping("/miconfiguracion")
    public String getMiConfiguracion(){
        return miConfiguracionProperties.toString();
    }

    @GetMapping("/perfil")
    public String getPerfil(){
        return perfil.toString();
    }
}
