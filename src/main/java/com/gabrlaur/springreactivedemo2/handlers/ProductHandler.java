package com.gabrlaur.springreactivedemo2.handlers;

import com.gabrlaur.springreactivedemo2.model.Product;
import com.gabrlaur.springreactivedemo2.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@AllArgsConstructor
public class ProductHandler {

    private final ProductService productService;

    public Mono<ServerResponse> getAllProducts(ServerRequest req) {
        //could extract path variables or body from the req etc.
        return ok().contentType(MediaType.TEXT_EVENT_STREAM)
                .body(productService.getAllProducts(), Product.class);
    }
}
