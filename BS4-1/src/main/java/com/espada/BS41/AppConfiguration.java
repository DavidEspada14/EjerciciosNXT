package com.espada.BS41;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class AppConfiguration {

    private String url, password;

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "AppConfiguration{" +
                "url='" + url + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
