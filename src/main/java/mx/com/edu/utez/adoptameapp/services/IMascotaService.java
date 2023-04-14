package mx.com.edu.utez.adoptameapp.services;

import java.util.List;

import mx.com.edu.utez.adoptameapp.models.Mascota;

public interface IMascotaService {

	List<Mascota> listar();

	boolean guardar(Mascota mascota);
	Mascota mostrar(long id);
	boolean eliminar(long id);

}
