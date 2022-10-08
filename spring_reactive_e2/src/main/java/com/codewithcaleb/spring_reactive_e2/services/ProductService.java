package com.codewithcaleb.spring_reactive_e2.services;


import com.codewithcaleb.spring_reactive_e2.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@Service
public class ProductService {

    public Flux<Product> getAll(){
        var p1 = new Product();
        p1.setName("chocolate");

        var p2 = new Product();
        p2.setName("fish");

        Flux<Product> products = Flux.fromStream(List.of(p1,p2).stream()).delayElements(Duration.ofSeconds(3));

        return products;
    }
}
