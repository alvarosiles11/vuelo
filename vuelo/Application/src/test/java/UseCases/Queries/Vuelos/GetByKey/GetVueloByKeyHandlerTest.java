package UseCases.Queries.Vuelos.GetByKey;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import Dto.TripulanteDto;
import Dto.VueloDto;
import Model.Vuelos.Tripulante;
import Model.Vuelos.Vuelo;
import Repositories.IVueloRepository;
import fourteam.http.Exception.HttpException;
import java.util.Date;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GetVueloByKeyHandlerTest {

  IVueloRepository _IVueloRep = Mockito.mock(IVueloRepository.class);

  @Test
  public void HandleCorrectly() throws HttpException {
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
    vuelo.AgregarTripulante(
      new Tripulante(UUID.randomUUID(), UUID.randomUUID().toString(), "Piloto")
    );
    when(_IVueloRep.FindByKey(any())).thenReturn(vuelo);

    VueloDto vueloDto = new VueloDto();
    vueloDto.setKey(key);
    vueloDto.setNroVuelo(nroVuelo);
    vueloDto.setKeyAeronave(keyAeronave);
    vueloDto.setKeyAeropuertoOrigen(keyAeropuertoOrigen);
    vueloDto.setKeyAeropuertoDestino(keyAeropuertoDestino);
    vueloDto.setfechaSalida(fecha_salida);
    vueloDto.setfechaArribe(fecha_arribe);

    GetVueloByKeyHandler handler = new GetVueloByKeyHandler(_IVueloRep);
    GetVueloByKeyQuery command = new GetVueloByKeyQuery(key);

    TripulanteDto tripulanteDto = new TripulanteDto();
    tripulanteDto.setKey(UUID.randomUUID());
    tripulanteDto.setKeyVuelo(UUID.randomUUID());
    tripulanteDto.setKeyTripulante("12345");
    tripulanteDto.setCargo("Piloto");

    vuelo.listaTripulante
      .iterator()
      .forEachRemaining(obj -> {
        vueloDto.listaTripulante.add(
          new TripulanteDto(UUID.randomUUID(), "12345", "Piloto")
        );
      });

    VueloDto result = handler.handle(command);
    System.out.println(result);
  }

  @Test
  public void testAsIterable() {
    UUID key = UUID.randomUUID();
    String nroVuelo = "A12345";
    String keyAeronave = "xyz-1990";
    String keyAeropuertoOrigen = "aeropuerto100";
    String keyAeropuertoDestino = "aeropuerto200";
    Date fecha_salida = new Date();
    Date fecha_arribe = new Date();

    VueloDto vueloDto = new VueloDto();
    vueloDto.setKey(key);
    vueloDto.setNroVuelo(nroVuelo);
    vueloDto.setKeyAeronave(keyAeronave);
    vueloDto.setKeyAeropuertoOrigen(keyAeropuertoOrigen);
    vueloDto.setKeyAeropuertoDestino(keyAeropuertoDestino);
    vueloDto.setfechaSalida(fecha_salida);
    vueloDto.setfechaArribe(fecha_arribe);

    TripulanteDto tripulanteDto = new TripulanteDto();
    tripulanteDto.setKey(UUID.randomUUID());
    tripulanteDto.setKeyVuelo(UUID.randomUUID());
    tripulanteDto.setKeyTripulante("12345");
    tripulanteDto.setCargo("Piloto");

    Vuelo vuelo = new Vuelo(
      nroVuelo,
      keyAeronave,
      keyAeropuertoOrigen,
      keyAeropuertoDestino,
      fecha_salida,
      fecha_arribe
    );

    vuelo.listaTripulante
      .iterator()
      .forEachRemaining(obj -> {
        vueloDto.listaTripulante.add(
          new TripulanteDto(UUID.randomUUID(), "12345", "Piloto")
        );
      });
  }

  @Test
  public void HandleFailed() throws HttpException {
    Vuelo vuelo = new Vuelo();
    when(_IVueloRep.FindByKey(any())).thenReturn(any());

    UUID key = UUID.randomUUID();
    GetVueloByKeyHandler handler = new GetVueloByKeyHandler(_IVueloRep);
    GetVueloByKeyQuery command = new GetVueloByKeyQuery(key);

    try {
      VueloDto resp = handler.handle(command);
      System.out.println(vuelo + "" + resp);
    } catch (HttpException e) {
      Assert.assertEquals(400, e.getCode());
    }
  }
}
