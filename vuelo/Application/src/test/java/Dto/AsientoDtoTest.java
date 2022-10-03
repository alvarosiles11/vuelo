package Dto;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class AsientoDtoTest {

	UUID keyAeronave = UUID.randomUUID();
	int numero = 1;
	String clase = "comercial";
	Double precio = 20.20;
	int disponibilidad = 1;

	@Test
	public void CheckPropertiesValid() {

		final AsientoDto asientoDto = new AsientoDto();

		Assert.assertEquals(null, asientoDto.getKeyAeronave());
		Assert.assertEquals(0, asientoDto.getNumero());
		Assert.assertEquals(null, asientoDto.getClase());
		Assert.assertEquals(null, asientoDto.getPrecio());
		Assert.assertEquals(0, asientoDto.getDisponibilidad());

		asientoDto.setKeyAeronave(keyAeronave);
		asientoDto.setNumero(numero);
		asientoDto.setClase(clase);
		asientoDto.setPrecio(precio);
		asientoDto.setDisponibilidad(disponibilidad);

		Assert.assertEquals(keyAeronave, asientoDto.getKeyAeronave());
		Assert.assertEquals(numero, asientoDto.getNumero());
		Assert.assertEquals(clase, asientoDto.getClase());
		Assert.assertEquals(precio, asientoDto.getPrecio());
		Assert.assertEquals(disponibilidad, asientoDto.getDisponibilidad());

	}

	@Test
	public void CheckConstructor() {

		final AsientoDto asientoDto = new AsientoDto(keyAeronave, numero, clase, precio);

		Assert.assertEquals(keyAeronave, asientoDto.getKeyAeronave());
		Assert.assertEquals(numero, asientoDto.getNumero());
		Assert.assertEquals(clase, asientoDto.getClase());
		Assert.assertEquals(precio, asientoDto.getPrecio());
		Assert.assertEquals(disponibilidad, asientoDto.getDisponibilidad());
	}
}
