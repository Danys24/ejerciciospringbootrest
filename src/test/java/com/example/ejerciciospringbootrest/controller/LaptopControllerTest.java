
package com.example.ejerciciospringbootrest.controller;

import com.example.ejerciciospringbootrest.entities.Laptop;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LaptopControllerTest {
     private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @DisplayName("Comprobar un saludo desde controladores Spring REST")
    @Test
    void saludo() {
        ResponseEntity<String> response  =
                testRestTemplate.getForEntity("/saludo", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Hola, ¿Que tal tu dia?", response.getBody());
    }

    @Test
    void findAll() {
        ResponseEntity<Laptop[]> response  =
            testRestTemplate.getForEntity("/api/books", Laptop[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCode().value());

        List<Laptop> laptops = Arrays.asList(response.getBody());
        System.out.println(laptops.size());

    }

    @Test
    void findOneById() {

        ResponseEntity<Laptop> response  =
                testRestTemplate.getForEntity("/api/laptops/1", Laptop.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void create() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                        "marca": "HP",
                        "procesador": "Intel",
                        "ram": 6,
                        "discoDuro": 512,
                        "lectorHuella": false
                    }
                """;

        HttpEntity<String> request = new HttpEntity<>(json,headers);

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);

        Laptop result = response.getBody();

        assertEquals(1L, result.getId());
        assertEquals("HP", result.getMarca());

    }
}
