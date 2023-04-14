package mx.com.edu.utez.adoptameapp.services;

import mx.com.edu.utez.adoptameapp.models.Tamano;
import mx.com.edu.utez.adoptameapp.repositories.TamanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TamanoServiceImpl implements ITamanoService {

    @Autowired
    private TamanoRepository tamanoRepository;

    public List<Tamano> lista = null;

    @Override
    public List<Tamano> listar() {
        return tamanoRepository.findAll(Sort.by("nombre").ascending());
    }

    public List<Tamano> TamanoServiceImpl() {

        lista.add(new Tamano(1L, "pequeño"));
        lista.add(new Tamano(2L, "mediano"));
        lista.add(new Tamano(3L, "grande"));

        return lista;
    }
}
