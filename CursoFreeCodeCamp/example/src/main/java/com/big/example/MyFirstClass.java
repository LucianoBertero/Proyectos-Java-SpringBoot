package com.big.example;

import org.springframework.stereotype.Component;


public class MyFirstClass {

    private String myVar;

    public MyFirstClass(String myVar) {
        this.myVar = myVar;
    }


    public String sayHello(){
        return "Hello From the MyFirstClass ==> myVar = + "+myVar;
    }

}
