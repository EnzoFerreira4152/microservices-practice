package com.dh.cajams;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/info")
public class CajaController {

    @Value("${denominations}")
    private String[] denominaciones;

    @Value("${max_cash}")
    private Integer cantidad_maxima;

    @GetMapping
    public Map<String, Object> consultaDatos(){
        Map<String, Object> result = new HashMap<>();
        result.put("Denominaciones disponibles", denominaciones);
        result.put("Cantidad máxima de billetes", cantidad_maxima);
        return result;
    }
}
