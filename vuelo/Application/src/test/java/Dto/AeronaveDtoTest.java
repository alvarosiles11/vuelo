package Dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class AeronaveDtoTest {

	@Test
	public void CheckPropertiesValid() {

		final UUID keyAeronave = UUID.randomUUID();
		final String matricula = "xyz-1990";
		final List<AsientoDto> listdaAsientos = getListdaAsientos();
		final String estado = "0";

		final AeronaveDto aeronaveDto = new AeronaveDto();

		Assert.assertEquals(null, aeronaveDto.getKeyAeronave());
		Assert.assertNull(aeronaveDto.getMatricula());
		Assert.assertEquals(0, listdaAsientos.size());
		Assert.assertNull(null, aeronaveDto.getEstado());

		aeronaveDto.setKeyAeronave(keyAeronave);
		aeronaveDto.setMatricula(matricula);
		aeronaveDto.setListaAsientos(listdaAsientos);
		aeronaveDto.setEstado(estado);

		Assert.assertEquals(keyAeronave, aeronaveDto.getKeyAeronave());
		Assert.assertEquals(matricula, aeronaveDto.getMatricula());
		Assert.assertEquals(listdaAsientos, aeronaveDto.getListaAsientos());
		Assert.assertEquals(estado, aeronaveDto.getEstado());
	}

	private List<AsientoDto> getListdaAsientos() {
		return new ArrayList();
	}
}