package com.nxt.BS2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateBean {
    @Bean("bean1")
    public Persona beanPersona1(){
        PersonaService personaService = new PersonaServiceImpl();
        personaService.setNombre("bean1");
        personaService.setEdad(23);
        personaService.setPoblacion("Madrid");
        return personaService.getPersona();
    }

    @Bean("bean2")
    public Persona beanPersona2(){
        PersonaService personaService = new PersonaServiceImpl();
        personaService.setNombre("bean2");
        personaService.setEdad(38);
        personaService.setPoblacion("Zaragoza");
        return personaService.getPersona();
    }

    @Bean("bean3")
    public Persona beanPersona3(){
        PersonaService personaService = new PersonaServiceImpl();
        personaService.setNombre("bean3");
        personaService.setEdad(42);
        personaService.setPoblacion("Galicia");
        return personaService.getPersona();
    }
}
