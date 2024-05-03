package pe.todotic.agenda.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.todotic.agenda.model.Contacto;

@Repository
public interface ContactoRepository  extends JpaRepository<Contacto, Integer> {
}
