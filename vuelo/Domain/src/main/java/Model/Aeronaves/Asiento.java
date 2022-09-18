package Model.Aeronaves;

import core.Entity;
import java.util.UUID;

public class Asiento extends Entity<UUID> {

	public UUID keyAeronave;
	public int numero;
	public String clase;
	public Double precio;

	public Asiento(UUID keyAeronave, int numero, String clase, Double precio) {
		key = UUID.randomUUID();
		this.keyAeronave = keyAeronave;
		this.numero = numero;
		this.clase = clase;
		this.precio = precio;
	}

	public UUID getKeyAeronave() {
		return keyAeronave;
	}

	public void setKeyAeronave(UUID keyAeronave) {
		this.keyAeronave = keyAeronave;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}




}