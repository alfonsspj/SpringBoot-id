package org.alfonso.springboot.di.app.springbootdi.controllers;

import org.alfonso.springboot.di.app.springbootdi.models.Product;
import org.alfonso.springboot.di.app.springbootdi.services.ProductService;
//import org.alfonso.springboot.di.app.springbootdi.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/api")
public class SomeController { // una instancia que es compartida por toda la aplicacion y por muchos usuarios

//    private ProductServiceImpl service = new ProductServiceImpl();
    @Autowired
    //con clase concreta
//    private ProductServiceImpl service; // no tenemos que instanciar sino que spring la crea por nosotros, la inyecta
    // con la interfaz
    private ProductService service; //

    // los metodos handler son por request, se ejecutan por cada usuario, por cada peticion, por cada request
    @GetMapping
    public List<Product> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id){
        return service.findById(id);
    }
}
