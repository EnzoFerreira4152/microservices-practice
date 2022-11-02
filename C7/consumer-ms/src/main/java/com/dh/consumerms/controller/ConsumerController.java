package com.dh.consumerms.controller;

import com.dh.consumerms.feign.ProductClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ConsumerController {

    private ProductClient pc;

    public ConsumerController(ProductClient pc) {
        this.pc = pc;
    }

    @GetMapping("/consumer/info")
    public ResponseEntity<ArrayList> products() {
        return ResponseEntity.ok(pc.getProducts());
    }
}
