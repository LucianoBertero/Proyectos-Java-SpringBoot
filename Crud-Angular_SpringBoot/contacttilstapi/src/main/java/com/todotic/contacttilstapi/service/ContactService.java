package com.todotic.contacttilstapi.service;

import com.todotic.contacttilstapi.dto.ContactDTO;
import com.todotic.contacttilstapi.entity.Contact;
import com.todotic.contacttilstapi.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ContactService {


    private final ContactRepository contactRepository;

    public Iterable<Contact> findAll(){
        return contactRepository.findAll();
    }


    public Contact findById(Integer id){

        return contactRepository
                .findById(id)
                .orElse(null);


    }

    public Contact create(ContactDTO contactDTO){



        Contact contact = new Contact();
        contact.setName(contactDTO.getName());
        contact.setEmail(contactDTO.getEmail());
        contact.setCreateAt(LocalDateTime.now());
        return contactRepository.save(contact);

    }


    public Contact update(Integer id,ContactDTO contactDTO){
        Contact contactFromDb = findById(id);
        contactFromDb.setName(contactDTO.getName());
        contactFromDb.setEmail(contactDTO.getEmail());
        return contactRepository.save(contactFromDb);
    }


    public void delete(Integer id){
        Contact contactFromDb = findById(id);
        contactRepository.delete(contactFromDb);
    }








}
