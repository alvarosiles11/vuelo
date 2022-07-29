package UseCases.Command.Vuelos2.Eliminar;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Dto.VueloDto;
import Factories.IVueloFactory;
import Model.Vuelos.Vuelo;
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;
import UseCases.Command.Vuelos.Eliminar.EliminarVueloCommand;
import UseCases.Command.Vuelos.Eliminar.EliminarVueloHandler;
import fourteam.http.Exception.HttpException;
import java.util.Date;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class EliminarVueloHandlerTest {

  IVueloFactory _IVueloFact = Mockito.mock(IVueloFactory.class);
  IVueloRepository _IVueloRep = Mockito.mock(IVueloRepository.class);
  IUnitOfWork _IUnitOfWork = Mockito.mock(IUnitOfWork.class);

  @Before
  public void setUp() {}

  @Test
  public void HandleCorrectly() throws HttpException {
    Vuelo vuelo = new Vuelo(
      "A12345",
      "xyz-1990",
      "aeropuerto100",
      "aeropuerto200",
      new Date(),
      new Date()
    );

    VueloDto vueloDto = new VueloDto();
    vueloDto.setNroVuelo("A12345");
    vueloDto.setKeyAeronave("xyz-1990");
    vueloDto.setKeyAeropuertoOrigen("aeropuerto100");
    vueloDto.setKeyAeropuertoDestino("aeropuerto200");
    vueloDto.setfechaSalida(new Date());
    vueloDto.setfechaArribe(new Date());

    EliminarVueloCommand command = new EliminarVueloCommand(vueloDto.getKey());
    EliminarVueloHandler handler = new EliminarVueloHandler(
      _IVueloFact,
      _IVueloRep,
      _IUnitOfWork
    );
    when(_IVueloRep.FindByKey(any())).thenReturn(vuelo);
    Vuelo resp = handler.handle(command);
    System.out.println(resp);
    verify(_IVueloRep).Delete(vuelo);
  }

  @Test
  public void HandleFailed() throws HttpException {
    when(_IVueloRep.FindByKey(any())).thenReturn(null);
    EliminarVueloHandler handler = new EliminarVueloHandler(
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

    EliminarVueloCommand command = new EliminarVueloCommand(vueloDto.getKey());
    try {
      Vuelo resp = handler.handle(command);
      System.out.println(resp);
    } catch (HttpException e) {
      Assert.assertEquals(400, e.getCode());
    }
  }
}
