package org.alfonso.springboot.di.app.springbootdi.repositories;

import org.alfonso.springboot.di.app.springbootdi.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;
//import org.springframework.web.context.annotation.SessionScope;
import java.util.Arrays;
import java.util.List;


// maneja el contexto de la sesion -- se usa para carro de compras, login
//@SessionScope // para aplicaciones web -- una sesion dura varios request, cuando cerramos la pestaña se destruye la sesion y se reinician los datos
//@RequestScope // el cliclo de vida, soloamente va a existir durante un request, una peticion
//@Primary
@Repository("productList")//  por defecto es del contexto singleton: una sola instancia para toda la aplicacion y es compartida por todos los clientes
public class ProductRepositoryImpl implements ProductRepository{

    private List<Product> data;

    public ProductRepositoryImpl(){
        // en contexto del request los datos son por usuarios
        this.data = Arrays.asList(
                new Product(1L, "Memoria corsair 32", 300L),
                new Product(2L, "Cpu Intel Core i9", 850L),
                new Product(3L, "Teclado Razer Mini 60%", 180L),
                new Product(4L, "Motherboar Gigabyte", 490L)
        );
    }

    @Override
    public List<Product> findAll(){
        return data;
    }

    @Override
    public Product findById(Long id){
        return data.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
