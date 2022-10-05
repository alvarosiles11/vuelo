package Controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Dto.VueloDto;
import Fourteam.mediator.Mediator;
import Fourteam.mediator.Response;
import Model.Aeronaves.Asiento;
import Model.Tripulacion.Tripulante;
import Model.Vuelos.Vuelo;
import UseCases.Command.Vuelos.Crear.CrearVueloCommand;
import UseCases.Command.Vuelos.Editar.EditarVueloCommand;
import UseCases.Command.Vuelos.Eliminar.EliminarVueloCommand;
import UseCases.Queries.Vuelos.GetAll.GetAllVueloQuery;
import UseCases.Queries.Vuelos.GetByKey.GetVueloByKeyQuery;

public class VueloControllerTest {
	Mediator mediator = Mockito.mock(Mediator.class);

	@Before
	public void setup() {
	}

	@Test
	public void HandleVueloController_Ok() throws Exception {
		VueloController vueloController = new VueloController(mediator);

		final UUID key = UUID.randomUUID();
		final String nroVuelo = "scz-cba-513184";
		final UUID keyAeronave = UUID.randomUUID();
		final List<Asiento> asientos = new ArrayList<>();
		final String origen = "Scz-ViruViru";
		final String destino = "CBA-CBA";
		final Date fechaSalida = new Date();
		final Date fechaArribe = new Date();
		final UUID keyTripulacion = UUID.randomUUID();
		final List<Tripulante> tripulantes = new ArrayList<>();

		Vuelo vuelo = new Vuelo(nroVuelo, keyAeronave, origen, destino, fechaSalida, fechaArribe, keyTripulacion,
				asientos,
				tripulantes);

		VueloDto vueloDto = new VueloDto();

		Response<List<VueloDto>> lista = mediator.send(new GetAllVueloQuery());

		// GetAllVueloQuery getAllVueloQuery = new GetAllVueloQuery();
		// vueloController.getAll();

		CrearVueloCommand crearVueloCommand = new CrearVueloCommand(vueloDto);
		vueloController.register(crearVueloCommand);

		EditarVueloCommand EditarVueloCommand = new EditarVueloCommand(key);
		vueloController.edit(vuelo, EditarVueloCommand);

		EliminarVueloCommand eliminarVueloCommand = new EliminarVueloCommand(key);
		vueloController.delete(eliminarVueloCommand);

		GetVueloByKeyQuery getVueloByKeyQuery = new GetVueloByKeyQuery(key);
		vueloController.getByKey(getVueloByKeyQuery);
	}
}
