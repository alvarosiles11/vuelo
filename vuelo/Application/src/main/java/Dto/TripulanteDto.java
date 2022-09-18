package Dto;

import java.util.UUID;

public class TripulanteDto {
	public UUID keyTripulacion;
	public UUID keyTripulante;
	public String nombre;
	public String apellido;
	public String tipo;
	public String estado;

	public TripulanteDto() {
	}

	public TripulanteDto(UUID keyTripulacion, UUID keyTripulante, String nombre, String apellido, String tipo,
			String estado) {
		this.keyTripulacion = keyTripulacion;
		this.keyTripulante = keyTripulante;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipo = tipo;
		this.estado = estado;
	}

	public UUID getKeyTripulacion() {
		return keyTripulacion;
	}

	public void setKeyTripulacion(UUID keyTripulacion) {
		this.keyTripulacion = keyTripulacion;
	}

	public UUID getKeyTripulante() {
		return keyTripulante;
	}

	public void setKeyTripulante(UUID keyTripulante) {
		this.keyTripulante = keyTripulante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
