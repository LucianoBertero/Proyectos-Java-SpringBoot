package com.big.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {


    private MyFirstClass myFirstClass;

    @Autowired
    public void injectDependencies(
            @Qualifier("bean1") MyFirstClass myFirstClass
    ){
        this.myFirstClass = myFirstClass;
    }


    public String tellAStory(){
        return "the dependency is saying: "+ myFirstClass.sayHello();
    }
}
