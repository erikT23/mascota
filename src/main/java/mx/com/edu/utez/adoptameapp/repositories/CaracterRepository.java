package mx.com.edu.utez.adoptameapp.repositories;

import mx.com.edu.utez.adoptameapp.models.Caracter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaracterRepository extends JpaRepository<Caracter, Long> {
}
