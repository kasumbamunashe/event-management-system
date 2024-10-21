package com.jimmy.zw.event_management.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SwaggerConfigurations {

    @Bean
    public OpenAPI myOpenAPI() {

        Contact contact = new Contact();
        contact.setEmail("jfish4835@gmail.com");
        contact.setName("MunasheKasumba@Software Development");
        contact.setUrl("0717765236");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Event Management Service")
                .version("1.0")
                .contact(contact)
                .description("Event Management Service").termsOfService("https://swagger.io/terms/")
                .license(mitLicense);

        return new OpenAPI().info(info);

    }
}
