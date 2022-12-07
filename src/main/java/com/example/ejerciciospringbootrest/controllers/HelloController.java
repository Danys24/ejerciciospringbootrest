
package com.example.ejerciciospringbootrest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@RestController
public class HelloController {
    
    @GetMapping("/saludo")
    public String saludar(){
        return "Hola, ¿Que tal tu dia?";
    }
}
