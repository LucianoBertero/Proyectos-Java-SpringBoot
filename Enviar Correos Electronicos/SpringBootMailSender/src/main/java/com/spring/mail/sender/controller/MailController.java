package com.spring.mail.sender.controller;

import com.spring.mail.sender.domain.EmailDTO;
import com.spring.mail.sender.domain.EmailFileDTO;
import com.spring.mail.sender.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class MailController {

    @Autowired
    private IEmailService emailService;

    @PostMapping("/sendMessage")
    public ResponseEntity<?> receiveRequestEmail(@RequestBody EmailDTO emailDTO){
        System.out.println("Mensaje recibido "+ emailDTO.toString());
        emailService.sendEmail(emailDTO.getToUser(), emailDTO.getSubject(), emailDTO.getBody());
        Map<String,String> response=new HashMap<>();
        response.put("estado","Enviado");
        return ResponseEntity.ok(response);
    }


    @PostMapping("/sendMessageFile")
    public ResponseEntity<?> reciveRequestEmailWithFile(@ModelAttribute EmailFileDTO emailFileDTO){ //model atribute para tratar la info que viene

        try {
            String fileName = emailFileDTO.getFile().getOriginalFilename();
            Path path= Paths.get("src/mail/resources/files/"+fileName);
            Files.createDirectories(path.getParent());
            Files.copy(emailFileDTO.getFile().getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
            File file=path.toFile();
            emailService.sendEmailWidthFile(emailFileDTO.getToUser(),emailFileDTO.getSubject(),emailFileDTO.getBody(),file);
            Map<String,String> response=new HashMap<>();
            response.put("estado","Enviado");

            response.put("archivo","filename");
            return  ResponseEntity.ok(response);
        }catch (Exception e){
                throw  new RuntimeException("Error al enviar email con el archivo "+ e.getMessage());
        }



    }



}
