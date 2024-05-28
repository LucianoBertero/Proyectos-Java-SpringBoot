package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("v1")
public class CustomerController {

    @Autowired
    private SessionRegistry sessionRegistry;
    @Autowired
    private SessionRegistry sesionRegistry;

    @GetMapping("/index")
    public String index(){
        return "Hello World";
    }

    @GetMapping("/index2")
    public String index2(){
        return "Hello World Not SECUDER!!";
    }

    @GetMapping("/session")
    public ResponseEntity<?> getDetailsSession(){
        //declaro el id y el atributo usuario el cual se intenta recuperar
        String sessionId="";
        User userObject=null;
        //traemos todas las sesiones
       List<Object> sessions= sessionRegistry.getAllPrincipals();
       for(Object session:sessions){ //recorremos las sesiones
           if(session instanceof User){ //preguntamos si esta sesion es de un usuario
               userObject = (User) session;
           }
            List<SessionInformation> sessionInformations= sesionRegistry.getAllSessions(session,false); //traemos todas las sesiones que no estan expiradas

           for(SessionInformation sessionInformation:sessionInformations){ //las recorremos

               sessionId=sessionInformation.getSessionId();  //de esa informacion traemos el id
           }
       }
       Map<String,Object> response = new HashMap<>();
       response.put("response","Hello World");
       response.put("sessionId",sessionId);
       response.put("userObject",userObject);
       return ResponseEntity.ok(response);
    }

}
