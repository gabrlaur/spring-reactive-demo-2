package com.gabrlaur.springreactivedemo2.services;

import com.gabrlaur.springreactivedemo2.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ProductService {

    public Flux<Product> getAllProducts() {

        var p1 = new Product();
        p1.setName("Beer");
        var p2 = new Product();
        p2.setName("Chocolate");

        return Flux.fromStream(Stream.of(p1, p2)).delayElements(Duration.ofSeconds(5));
        //simulate a delay to see reactive behavior
    }
}
