package pe.todotic.agenda;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.todotic.agenda.model.Contacto;
import pe.todotic.agenda.repo.ContactoRepository;

import java.time.LocalDate;

@Slf4j
@SpringBootApplication
public class AgendaApplication {


	@Autowired
	private ContactoRepository contactoRepository;

	@PostConstruct
	void init(){
		Contacto contacto1 = new Contacto();
		contacto1.setNombre("Luciano Bertero");
		contacto1.setEmail("lucianbertero@gmail.com");

		contacto1.setCelular("123123123");
		contacto1.setFechaNacimiento(LocalDate.now());
		contactoRepository.save(contacto1);

		Contacto contacto2 = new Contacto();
		contacto2.setNombre("Luciano Bertero");
		contacto2.setEmail("lucianbertero@gmail.com");

		contacto2.setCelular("123123123");
		contacto2.setFechaNacimiento(LocalDate.now());
		contactoRepository.save(contacto2);


		contactoRepository.findAll().forEach(c-> System.out.println(c.getNombre()));

	}


	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}

}
