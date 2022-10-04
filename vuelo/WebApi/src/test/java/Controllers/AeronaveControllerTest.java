package Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Dto.AeronaveDto;
import Fourteam.mediator.Mediator;
import Model.Aeronaves.Aeronave;
import Model.Aeronaves.Asiento;
import UseCases.Queries.Aeronave.GetAll.GetAllAeronaveQuery;
import UseCases.Queries.Aeronave.GetByKey.GetAeronaveByKeyQuery;

public class AeronaveControllerTest {
	Mediator mediator = Mockito.mock(Mediator.class);

	@Before
	public void setup() {
	}

	@Test
	public void HandleVueloController_Ok() throws Exception {
		AeronaveController aeronaveController = new AeronaveController(mediator);

		final UUID keyAeronave = UUID.randomUUID();
		final String matricula = "xyz-1990";
		final List<Asiento> listdaAsientos = new ArrayList<>();
		final String estado = "0";

		Aeronave aeronave = new Aeronave(keyAeronave, matricula, estado);
		AeronaveDto aeronaveDto = new AeronaveDto();

		GetAllAeronaveQuery getAllAeronaveQuery = new GetAllAeronaveQuery();
		aeronaveController.getAll();

		GetAeronaveByKeyQuery getAeronaveByKeyQuery = new GetAeronaveByKeyQuery(keyAeronave);
		aeronaveController.getByKey(getAeronaveByKeyQuery);
	}
}