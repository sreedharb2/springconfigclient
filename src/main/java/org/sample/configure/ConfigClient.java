package org.sample.configure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

@ConfigurationProperties
@RefreshScope
public class ConfigClient {
    @Value("${firstname}")
    private String firstname;

    @Value("${lastname}")
    private String lastname;

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient.class, args);
    }

    @GetMapping(value = "/hello/{username}")
    public String whoami(@PathVariable("username") String username) {
        return String.format("Hello User %s's firstname : %s and LastName : %s", username, firstname, lastname);
    }
}