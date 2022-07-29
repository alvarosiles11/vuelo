package UseCases.Command.Vuelos2.Crear;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Dto.VueloDto;
import Factories.IVueloFactory;
import Model.Vuelos.Vuelo;
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;
import UseCases.Command.Vuelos.Crear.CrearVueloCommand;
import UseCases.Command.Vuelos.Crear.CrearVueloHandler;
import fourteam.http.Exception.HttpException;
import java.util.Date;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CrearVueloHandlerTest {

  IVueloFactory _IVueloFactory = Mockito.mock(IVueloFactory.class);
  IVueloRepository _IVueloRepository = Mockito.mock(IVueloRepository.class);
  IUnitOfWork _IUnitOfWork = Mockito.mock(IUnitOfWork.class);

  @Before
  public void setUp() {}

  @Test
  public void HandleCorrectly() throws HttpException {
    UUID key = UUID.randomUUID();
    String nroVuelo = "A12345";
    String keyAeronave = "xyz-1990";
    String keyAeropuertoOrigen = "aeropuerto100";
    String keyAeropuertoDestino = "aeropuerto200";
    Date fechaSalida = new Date();
    Date fechaArribe = new Date();
    System.out.println(key);

    Vuelo vuelo = new Vuelo(
      nroVuelo,
      keyAeronave,
      keyAeropuertoOrigen,
      keyAeropuertoDestino,
      fechaSalida,
      fechaArribe
    );
    when(
      _IVueloFactory.Create(
        nroVuelo,
        keyAeronave,
        keyAeropuertoOrigen,
        keyAeropuertoDestino,
        fechaSalida,
        fechaArribe
      )
    )
      .thenReturn(vuelo);

    CrearVueloHandler handler = new CrearVueloHandler(
      _IVueloFactory,
      _IVueloRepository,
      _IUnitOfWork
    );
    VueloDto vueloDto = new VueloDto();
    vueloDto.setNroVuelo(nroVuelo);
    vueloDto.setKeyAeronave(keyAeronave);
    vueloDto.setKeyAeropuertoOrigen(keyAeropuertoOrigen);
    vueloDto.setKeyAeropuertoDestino(keyAeropuertoDestino);
    vueloDto.setfechaSalida(fechaSalida);
    vueloDto.setfechaArribe(fechaArribe);

    CrearVueloCommand command = new CrearVueloCommand(vueloDto);
    Vuelo response = handler.handle(command);
    verify(_IVueloRepository).Create(response);
    verify(_IUnitOfWork).commit();

    Assert.assertEquals(nroVuelo, response.getNroVuelo());
    Assert.assertEquals(keyAeronave, response.getKeyAeronave());
    Assert.assertEquals(keyAeropuertoOrigen, response.getKeyAeropuertoOrigen());
    Assert.assertEquals(
      keyAeropuertoDestino,
      response.getKeyAeropuertoDestino()
    );
    Assert.assertEquals(fechaSalida, response.getfechaSalida());
    Assert.assertEquals(fechaArribe, response.getfechaArribe());
  }
}
