package com.espada.BS41;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:miconfiguracion.properties")
@ConfigurationProperties
public class MiConfiguracionProperties {


    private String valor1, valor2;

    public String getValor1(){
        return valor1;
    }

    public String getValor2(){
        return valor2;
    }

    public void setValor1(String valor1) {
        this.valor1 = valor1;
    }

    public void setValor2(String valor2) {
        this.valor2 = valor2;
    }

    @Override
    public String toString() {
        return "MiConfiguracionProperties{" +
                "valor1='" + valor1 + '\'' +
                ", valor2='" + valor2 + '\'' +
                '}';
    }
}
