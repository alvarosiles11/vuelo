package Controllers;

import Dto.VueloDto;
import Model.Vuelos.Vuelo;
import UseCases.Command.Vuelos.Crear.CrearVueloCommand;
import UseCases.Command.Vuelos.Editar.EditarVueloCommand;
import UseCases.Command.Vuelos.Eliminar.EliminarVueloCommand;
import UseCases.Queries.Vuelos.GetAll.GetAllVueloQuery;
import UseCases.Queries.Vuelos.GetByKey.GetVueloByKeyQuery;
import fourteam.http.Exception.HttpException;
import fourteam.mediator.Mediator;
import java.util.Date;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class VueloControllerTest {

  Mediator mediator = Mockito.mock(Mediator.class);

  @Before
  public void setup() {}

  @Test
  public void HandleVueloController_Ok() throws HttpException {
    VueloController vueloController = new VueloController(mediator);

    UUID key = UUID.randomUUID();
    String nroVuelo = "A12345";
    String keyAeronave = "xyz-1990";
    String keyAeropuertoOrigen = "aeropuerto100";
    String keyAeropuertoDestino = "aeropuerto200";
    Date fecha_salida = new Date();
    Date fecha_arribe = new Date();

    Vuelo vuelo = new Vuelo(
      nroVuelo,
      keyAeronave,
      keyAeropuertoOrigen,
      keyAeropuertoDestino,
      fecha_salida,
      fecha_arribe
    );

    VueloDto vueloDto = new VueloDto();

    GetAllVueloQuery getAllVueloQuery = new GetAllVueloQuery();
    vueloController.getAll();

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
