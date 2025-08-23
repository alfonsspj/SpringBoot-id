package org.alfonso.springboot.di.app.springbootdi.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.alfonso.springboot.di.app.springbootdi.models.Product;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class ProductRepositoryJson implements ProductRepository{

    private List<Product> list;

    public ProductRepositoryJson() {
//        ClassPathResource resource = new ClassPathResource("json/products.json");// classPathResource hereda de Resource
        Resource resource = new ClassPathResource("json/products.json");//
        // convierte un archivo o inputStream a un objeto de java
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class)); // toma como argumento un arreglo de objetos y ese objeto va a ser el resultado de parsear
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }
}
