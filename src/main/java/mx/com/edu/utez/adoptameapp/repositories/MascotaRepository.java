package mx.com.edu.utez.adoptameapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.edu.utez.adoptameapp.models.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {

}
