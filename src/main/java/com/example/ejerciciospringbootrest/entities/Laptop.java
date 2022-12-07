
package com.example.ejerciciospringbootrest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "laptops")
public class Laptop {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String procesador;
    private Integer ram;
    private Integer discoDuro;
    private Boolean lectorHuella;
    
    //constructor

    public Laptop( ) {
  
    }

    public Laptop(Long id, String marca, String procesador, Integer ram, Integer discoDuro, Boolean lectorHuella) {
        this.id = id;
        this.marca = marca;
        this.procesador = procesador;
        this.ram = ram;
        this.discoDuro = discoDuro;
        this.lectorHuella = lectorHuella;
    }
    
    //Getter y Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getDiscoDuro() {
        return discoDuro;
    }

    public void setDiscoDuro(Integer discoDuro) {
        this.discoDuro = discoDuro;
    }

    public Boolean getLectorHuella() {
        return lectorHuella;
    }

    public void setLectorHuella(Boolean lectorHuella) {
        this.lectorHuella = lectorHuella;
    }
    
    
}
