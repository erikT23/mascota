package mx.com.edu.utez.adoptameapp.controllers;

import mx.com.edu.utez.adoptameapp.services.CaracterServiceImpl;
import mx.com.edu.utez.adoptameapp.services.TamanoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.com.edu.utez.adoptameapp.models.Mascota;
import mx.com.edu.utez.adoptameapp.services.ColorServiceImpl;

import mx.com.edu.utez.adoptameapp.services.MascotaServiceImpl;

@Controller
@RequestMapping("mascotas")
public class MascotaController {

	@Autowired
	private MascotaServiceImpl mascotaServiceImpl;

	@Autowired
	private ColorServiceImpl colorServiceImpl;

	@Autowired
	private TamanoServiceImpl tamanoServiceImpl;

	@Autowired
	private CaracterServiceImpl caracterServiceImpl;

	/*
	 * Display a listing of the resource
	 */
	@GetMapping(value = { "/listar", "/listar/{tipoMascota}" })
	public String listarMascotas(@PathVariable(required = false) String tipoMascota, Model modelo) {
		modelo.addAttribute("listaMascotas", mascotaServiceImpl.listar());
		return "voluntario/listarMascotas";
	}

	/*
	 * Show the form for creating a new resource
	 */
	@Autowired
	private TamanoServiceImpl tamanoService;

	@GetMapping("/crear")
	public String crearMascota(Mascota mascota, Model model) {
		model.addAttribute("listaColores", colorServiceImpl.listar());
		model.addAttribute("listaCaracteres", caracterServiceImpl.listar());
		model.addAttribute("listaTamanos", tamanoService.lista);

		return "voluntario/formMascota";
	}

	/*
	 * Store a newly created resource in storage
	 */
	@PostMapping("/guardar")
	public String guardarMascota(Mascota mascota, Model model, RedirectAttributes redirectAttributes) {
		if (mascota.getId() == null) { // Create
			mascota.setValidacion("pendiente");
			mascota.setDisponibleAdopcion(0);
		} else { // Update
			Mascota mascotaExistente = mascotaServiceImpl.mostrar(mascota.getId());
			mascota.setFechaRegistro(mascotaExistente.getFechaRegistro());
			mascota.setDisponibleAdopcion(mascotaExistente.getDisponibleAdopcion());
			mascota.setValidacion(mascotaExistente.getValidacion());
		}
		boolean respuesta = mascotaServiceImpl.guardar(mascota);
		if (respuesta) {
			redirectAttributes.addFlashAttribute("msg_success", "¡Registro exitoso!");
			return "redirect:/mascotas/listar";
		} else {
			redirectAttributes.addFlashAttribute("msg_error", "¡Registro fallido! Por favor intenta de nuevo.");
			return "redirect:/mascotas/crear";
		}
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarMascota(@PathVariable long id, RedirectAttributes redirectAttributes) {
		boolean respuesta = mascotaServiceImpl.eliminar(id);
		if (respuesta) {
			redirectAttributes.addFlashAttribute("msg_success", "¡Eliminación exitosa!");
		} else {
			redirectAttributes.addFlashAttribute("msg_error", "¡Eliminación fallida! Por favor intenta de nuevo.");
		}
		return "redirect:/mascotas/listar";
	}


	/*
	 * Display the specified resource
	 */
	@GetMapping("/mostrar/{id}")
	public String mostrarMascota(@PathVariable long id, Model model, RedirectAttributes redirectAttributes) {
		Mascota mascota = mascotaServiceImpl.mostrar(id);
		if (mascota != null) {
			model.addAttribute("mascota", mascota);
			return "voluntario/mostrarMascota";
		}
		redirectAttributes.addFlashAttribute("msg_error", "Registro no encontrado.");
		return "redirect:/mascotas/listar";
	}

	/*
	 * Show the form for editing the specified resource
	 */
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable long id, Model model, RedirectAttributes redirectAttributes) {
		Mascota mascota = mascotaServiceImpl.mostrar(id);
		if (mascota != null) {
			model.addAttribute("mascota", mascota);
			model.addAttribute("listaColores", colorServiceImpl.listar());
			model.addAttribute("listaCaracteres", caracterServiceImpl.listar());
			model.addAttribute("listaTamanos", tamanoServiceImpl.listar());
			return "voluntario/formMascota";
		}
		redirectAttributes.addFlashAttribute("msg_error", "Registro no encontrado.");
		return "redirect:/mascotas/listar";
	}
}
