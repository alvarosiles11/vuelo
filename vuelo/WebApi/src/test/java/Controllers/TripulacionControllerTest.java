package Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Dto.TripulacionDto;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.Mediator;
import Model.Tripulacion.Tripulacion;
import Model.Tripulacion.Tripulante;
import UseCases.Queries.Tripulacion.GetAll.GetAllTripulacionQuery;
import UseCases.Queries.Tripulacion.GetByKey.GetTripulacionByKeyQuery;

public class TripulacionControllerTest {
	Mediator mediator = Mockito.mock(Mediator.class);

	@Before
	public void setup() {
	}

	@Test
	public void HandleVueloController_Ok() throws HttpException {
		TripulacionController tripulacionController = new TripulacionController(mediator);

		final UUID keyTripulacion = UUID.randomUUID();
		final String descripcion = "Grupo-A";
		final String estado = "0";
		final List<Tripulante> tripulantes = new ArrayList<>();

		Tripulacion tripulacion = new Tripulacion(keyTripulacion, descripcion, estado);

		TripulacionDto tripulacionDto = new TripulacionDto();

		GetAllTripulacionQuery getAllTripulacionQuery = new GetAllTripulacionQuery();
		tripulacionController.getAll();

		GetTripulacionByKeyQuery getTripulacionByKeyQuery = new GetTripulacionByKeyQuery(keyTripulacion);
		tripulacionController.getByKey(getTripulacionByKeyQuery);

	}
}
