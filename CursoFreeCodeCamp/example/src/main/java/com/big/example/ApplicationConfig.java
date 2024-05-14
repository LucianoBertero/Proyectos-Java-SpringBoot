package com.big.example;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfig {
    @Bean("bean1")
    public MyFirstClass myFirstBean() {
        return new MyFirstClass("First Bean");
    }

    @Bean
    public MyFirstClass mySecondBean() {
        return new MyFirstClass("second Bean");
    }

    @Bean
//    @Primary
    public MyFirstClass myThirdBean() {
        return new MyFirstClass("Third Bean");
    }

}
