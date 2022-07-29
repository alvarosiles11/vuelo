package Controllers;

import Dto.TripulanteDto;
import Model.Vuelos.Tripulante;
import UseCases.Command.Tripulantes.Crear.CrearTripulanteCommand;
import UseCases.Command.Tripulantes.Editar.EditarTripulanteCommand;
import UseCases.Command.Tripulantes.Eliminar.EliminarTripulanteCommand;
import UseCases.Queries.Tripulantes.GetByKey.GetTripulanteByKeyQuery;
import fourteam.http.Exception.HttpException;
import fourteam.mediator.Mediator;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TripulanteControllerTest {

  Mediator mediator = Mockito.mock(Mediator.class);

  @Before
  public void setup() {}

  @Test
  public void HandleTripulanteController_Ok() throws HttpException {
    TripulanteController tripulanteController = new TripulanteController(
      mediator
    );

    UUID key = UUID.randomUUID();
    UUID keyVuelo = UUID.randomUUID();
    String keyTripulante = UUID.randomUUID().toString();
    String cargo = "Piloto";

    Tripulante tripulante = new Tripulante(keyVuelo, keyTripulante, cargo);
    TripulanteDto tripulanteDto = new TripulanteDto();

    // GetAllTripulanteQuery getAllTripulanteQuery = new GetAllTripulanteQuery();
    // List<Tripulante> listaTripulante = new ArrayList<>();

    tripulanteController.getAll();

    CrearTripulanteCommand crearTripulanteCommand = new CrearTripulanteCommand(
      tripulanteDto
    );
    tripulanteController.register(crearTripulanteCommand);

    EditarTripulanteCommand editarTripulanteCommand = new EditarTripulanteCommand(
      key
    );
    tripulanteController.edit(tripulante, editarTripulanteCommand);

    EliminarTripulanteCommand eliminarTripulanteCommand = new EliminarTripulanteCommand(
      key
    );
    tripulanteController.delete(eliminarTripulanteCommand);

    GetTripulanteByKeyQuery getTripulanteByKeyQuery = new GetTripulanteByKeyQuery(
      key
    );
    tripulanteController.getByKey(getTripulanteByKeyQuery);
  }
}
