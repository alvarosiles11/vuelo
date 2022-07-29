package UseCases.Command.Vuelos2.Editar;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import Dto.VueloDto;
import Factories.IVueloFactory;
import Model.Vuelos.Vuelo;
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;
import UseCases.Command.Vuelos.Editar.EditarVueloCommand;
import UseCases.Command.Vuelos.Editar.EditarVueloHandler;
import fourteam.http.Exception.HttpException;
import java.util.Date;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class EditarVueloHandlerTest {

  IVueloFactory _IVueloFact = Mockito.mock(IVueloFactory.class);
  IVueloRepository _IVueloRep = Mockito.mock(IVueloRepository.class);
  IUnitOfWork _IUnitOfWork = Mockito.mock(IUnitOfWork.class);

  private UUID key = UUID.randomUUID();
  private String nroVuelo = "A12345";
  private String keyAeronave = "xyz-1990";
  private String keyAeropuertoOrigen = "aeropuerto100";
  private String keyAeropuertoDestino = "aeropuerto200";
  private Date fecha_salida = new Date();
  private Date fecha_arribe = new Date();

  @Before
  public void setUp() {}

  @Test
  public void HandleCorrectly() throws HttpException {
    Vuelo vuelo = new Vuelo(
      nroVuelo,
      keyAeronave,
      keyAeropuertoOrigen,
      keyAeropuertoDestino,
      fecha_salida,
      fecha_arribe
    );
    when(_IVueloRep.FindByKey(any())).thenReturn(vuelo);

    EditarVueloHandler handler = new EditarVueloHandler(
      _IVueloFact,
      _IVueloRep,
      _IUnitOfWork
    );

    VueloDto vueloDto = new VueloDto();
    vueloDto.setKey(key);
    vueloDto.setNroVuelo(nroVuelo);
    vueloDto.setKeyAeronave(keyAeronave);
    vueloDto.setKeyAeropuertoOrigen(keyAeropuertoOrigen);
    vueloDto.setKeyAeropuertoDestino(keyAeropuertoDestino);
    vueloDto.setfechaSalida(fecha_salida);
    vueloDto.setfechaArribe(fecha_arribe);

    EditarVueloCommand command = new EditarVueloCommand(vueloDto.getKey());

    command.vueloDto.setKey(key);
    command.vueloDto.setNroVuelo(nroVuelo);
    command.vueloDto.setKeyAeronave(keyAeronave);
    command.vueloDto.setKeyAeropuertoOrigen(keyAeropuertoOrigen);
    command.vueloDto.setKeyAeropuertoDestino(keyAeropuertoDestino);
    command.vueloDto.setfechaSalida(fecha_salida);
    command.vueloDto.setfechaArribe(fecha_arribe);

    Vuelo resp = handler.handle(command);
    Assert.assertEquals(nroVuelo, resp.getNroVuelo());
  }

  @Test
  public void HandleFailed() throws HttpException {
    when(_IVueloRep.FindByKey(any())).thenReturn(null);
    EditarVueloHandler handler = new EditarVueloHandler(
      _IVueloFact,
      _IVueloRep,
      _IUnitOfWork
    );
    VueloDto vueloDto = new VueloDto();
    vueloDto.setNroVuelo("A12345");
    vueloDto.setKeyAeronave("xyz-1990");
    vueloDto.setKeyAeropuertoOrigen("aeropuerto100");
    vueloDto.setKeyAeropuertoDestino("aeropuerto200");
    vueloDto.setfechaSalida(new Date());
    vueloDto.setfechaArribe(new Date());

    EditarVueloCommand command = new EditarVueloCommand(vueloDto.getKey());
    try {
      Vuelo resp = handler.handle(command);
      System.out.println(resp);
    } catch (HttpException e) {
      Assert.assertEquals(400, e.getCode());
    }
  }
}
