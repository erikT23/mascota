package mx.com.edu.utez.adoptameapp.services;

import mx.com.edu.utez.adoptameapp.models.Caracter;
import mx.com.edu.utez.adoptameapp.repositories.CaracterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaracterServiceImpl implements ICaracterService{
    @Autowired
    private CaracterRepository caracterRepository;

    @Override
    public List<Caracter> listar(){
        return caracterRepository.findAll(Sort.by("nombre").ascending());
    }
}
