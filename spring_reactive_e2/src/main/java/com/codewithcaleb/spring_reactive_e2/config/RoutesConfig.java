package com.codewithcaleb.spring_reactive_e2.config;

import com.codewithcaleb.spring_reactive_e2.handlers.ProductHandler;
import com.codewithcaleb.spring_reactive_e2.model.Product;
import com.codewithcaleb.spring_reactive_e2.services.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Configuration
public class RoutesConfig {

    //inside the Body when calling a publisher i should also return the type of Publisher/Type of what i am returning
    @Bean
    public RouterFunction<ServerResponse> router(ProductHandler productHandler){
        return route().GET("/products", productHandler::getAll).build();
    }


}
