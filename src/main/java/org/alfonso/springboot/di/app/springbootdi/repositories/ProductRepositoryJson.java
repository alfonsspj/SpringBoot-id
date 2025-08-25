package org.alfonso.springboot.di.app.springbootdi.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.alfonso.springboot.di.app.springbootdi.models.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

// clase comun y corriente
public class ProductRepositoryJson implements ProductRepository{

    private List<Product> list;

    // forma declarativa
    /*@Value("classpath:json/product.json")
    private Resource resource;*/ // devuelve null ya que value no funciona en un contexto que no este dentro de spring, que no sea un componente spring

    public ProductRepositoryJson() {

        // forma programatica
//        ClassPathResource resource = new ClassPathResource("json/products.json");// classPathResource hereda de Resource
        Resource resource = new ClassPathResource("json/product.json");//
        readValueJson(resource);

        /*// convierte un archivo o inputStream a un objeto de java
        ObjectMapper objectMapper = new ObjectMapper();
        try {
//            list = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class)); // toma como argumento un arreglo de objetos y ese objeto va a ser el resultado de parsear
            list = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Product[].class)); //
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }

    public ProductRepositoryJson(Resource resource) {
        readValueJson(resource);
    }

    private void readValueJson(Resource resource) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Product[].class)); //
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
        return list.stream()
                .filter( p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow();// devuelve una exception sino lo encuentra
    }
}
