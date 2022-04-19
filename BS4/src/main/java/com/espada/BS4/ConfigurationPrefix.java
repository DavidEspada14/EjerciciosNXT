package com.espada.BS4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "my")
public class ConfigurationPrefix {
    private int var2;

    public int getVar2(){
        return var2;
    }

    public void setVar2(int var2){
        this.var2 = var2;
    }

}
