
package com.example.ejerciciospringbootrest.Repositories;

import com.example.ejerciciospringbootrest.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ACER
 */
@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long>{
    
}
