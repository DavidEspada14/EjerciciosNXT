package com.espada.BS41;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Configuration
@Component
@Profile("perfil2")
public class Perfil2 implements Perfiles{

    @Value("${perfil}")
    private String perfil;

    @Override
    public void miFuncion() {
        System.out.println(perfil);
    }
}
