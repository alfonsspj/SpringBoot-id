package org.alfonso.springboot.di.app.springbootdi;

import org.alfonso.springboot.di.app.springbootdi.repositories.ProductRepository;
import org.alfonso.springboot.di.app.springbootdi.repositories.ProductRepositoryJson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

//    ProductRepository tipo generico
//    public ProductRepository productRepositoryJson(){
//        return new ProductRepositoryJson();// tipo concreto
//    }
//    @Bean // cuando el componente es anotado con Bean podemos omitir el public
    @Bean("productJson") // personalizado con nombre distinto al del metodo -- nombre logico que va a tener el componente
//    @Primary
    ProductRepository productRepositoryJson(){
        return new ProductRepositoryJson();
    }
}
