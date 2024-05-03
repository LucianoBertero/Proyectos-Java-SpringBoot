package com.todotic.contacttilstapi;

import com.todotic.contacttilstapi.entity.Contact;
import com.todotic.contacttilstapi.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ContacttilstapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContacttilstapiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ContactRepository contactRepository) {
		return args ->{

				List<Contact> contacts = Arrays.asList(
						new Contact("Carlos", "carlos@gmail.com", LocalDateTime.now()),
						new Contact("Miguel", "Miguel@gmail.com", LocalDateTime.now()),
						new Contact("Samuel", "samuel@gmail.com", LocalDateTime.now()),
						new Contact("Luciano", "Luciano@gmail.com", LocalDateTime.now()),
						new Contact("Joaquin", "Joaquin@gmail.com", LocalDateTime.now())
				);
				contactRepository.saveAll(contacts);

		};


	}
}

