
package com.example.ejerciciospringbootrest.controllers;

import com.example.ejerciciospringbootrest.Repositories.LaptopRepository;
import com.example.ejerciciospringbootrest.entities.Laptop;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author ACER
 */
@RestController
public class LaptopController {
    
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);
    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }
    
    //Buscar Laptops
    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }
    
    //Buscar una laptop en la base de datos
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> lapopt = laptopRepository.findById(id);
        
        //Opcion 1
        if(lapopt.isPresent())
            return ResponseEntity.ok(lapopt.get());
        else
            return ResponseEntity.notFound().build();
    }

    //Agregar una laptop en la base de datos
    @PostMapping("/api/laptops")
    public Laptop crear(@RequestBody Laptop laptop){
        return laptopRepository.save(laptop);
    }
    
    // Actualizar un laptop EXISTENTE en la base de datos
    
    @PutMapping("api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(laptop.getId() == null){
            log.warn("trying to update a non existent laptop");
            return ResponseEntity.badRequest().build();
        }
        if(!laptopRepository.existsById(laptop.getId())){
            log.warn("trying to update a non existent laptop");
            return ResponseEntity.notFound().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }
    

    // Borrar un libro de la base de datos
    @DeleteMapping("api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        if(!laptopRepository.existsById(id)){
            log.warn("trying to update a non existent laptop");
            return ResponseEntity.notFound().build();
        }
        
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    //Borrar todos los libros de la base de datos 
    @DeleteMapping("api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        log.info("REST Request for deleting all laptops");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
    
}
