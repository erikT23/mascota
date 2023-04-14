package mx.com.edu.utez.adoptameapp.models;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "mascotas")
public class Mascota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@Column(nullable = false, length = 45)
	private String nombre;


	@Column(nullable = false, length = 1)
	private String sexo;


	@Column(nullable = false, length = 45)
	private String edad;



	@Column(nullable = false, length = 5)
	private String tipo;

	@Column(nullable = true, length = 45)
	private String imagen;

	@Column(name = "disponible_adopcion", columnDefinition = "tinyint not null")
	private Integer disponibleAdopcion;

	@Column(name = "fecha_registro", nullable = false)
	@CreationTimestamp
	private Date fechaRegistro;

	@Column(nullable = false, length = 10)
	private String validacion; // keywords: validado, rechazado, pendiente
	
	@Column(columnDefinition = "longtext null")
	private String detalles;

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	@ManyToOne
	@JoinColumn(name = "tamano_id", nullable = false)
	private Tamano tamano;

	@ManyToOne
	@JoinColumn(name = "color_id", nullable = false)
	private Color color;

	@ManyToOne
	@JoinColumn(name = "caracter_id", nullable = false)
	private Caracter caracter;

	public Mascota() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Integer getDisponibleAdopcion() {
		return disponibleAdopcion;
	}

	public void setDisponibleAdopcion(Integer disponibleAdopcion) {
		this.disponibleAdopcion = disponibleAdopcion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getValidacion() {
		return validacion;
	}

	public void setValidacion(String validacion) {
		this.validacion = validacion;
	}

	public Tamano getTamano() {
		return tamano;
	}

	public void setTamano(Tamano tamano) {
		this.tamano = tamano;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Caracter getCaracter() {
		return caracter;
	}

	public void setCaracter(Caracter caracter) {
		this.caracter = caracter;
	}

}