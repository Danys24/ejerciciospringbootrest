package com.example.ejerciciospringbootrest;

import com.example.ejerciciospringbootrest.Repositories.LaptopRepository;
import com.example.ejerciciospringbootrest.entities.Laptop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class EjerciciospringbootrestApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EjerciciospringbootrestApplication.class, args);
                LaptopRepository repository = context.getBean(LaptopRepository.class);
                
                //Agregar laptops a la base de datos
                Laptop laptop1 = new Laptop(null,"LENOVO","AMD",8,512,true);
                Laptop laptop2 = new Laptop(null,"ACER","Intel",4,128,false);
                
                repository.save(laptop1);
                repository.save(laptop2);
                
                System.out.println(repository.findAll().size());
	}

}
