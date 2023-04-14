package mx.com.edu.utez.adoptameapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import mx.com.edu.utez.adoptameapp.models.Color;
import mx.com.edu.utez.adoptameapp.repositories.ColorRepository;

@Service
public class ColorServiceImpl implements IColorService {

	@Autowired
	private ColorRepository colorRepository;

	@Override
	public List<Color> listar() {

		return colorRepository.findAll(Sort.by("nombre").ascending());
	}

}
