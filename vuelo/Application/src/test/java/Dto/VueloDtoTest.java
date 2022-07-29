package Dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class VueloDtoTest {

  private UUID key = UUID.randomUUID();
  private String nroVuelo = "A12345";
  private String keyAeronave = "xyz-1990";
  private String keyAeropuertoOrigen = "aeropuerto100";
  private String keyAeropuertoDestino = "aeropuerto200";
  private Date fechaSalida = new Date();
  private Date fechaArribe = new Date();
  private List<TripulanteDto> listaTripulante = getTripulantes();

  @Test
  public void CheckPropertiesValid() {
    VueloDto vueloDto = new VueloDto(); // dto
    Assert.assertEquals(null, vueloDto.getKey());
    Assert.assertNull(vueloDto.getNroVuelo());
    Assert.assertNull(vueloDto.getKeyAeronave());
    Assert.assertNull(vueloDto.getKeyAeropuertoOrigen());
    Assert.assertNull(vueloDto.getKeyAeropuertoDestino());
    Assert.assertNull(vueloDto.getfechaSalida());
    Assert.assertNull(vueloDto.getfechaArribe());
    Assert.assertNotNull(vueloDto.listaTripulante);
    Assert.assertEquals(0, vueloDto.listaTripulante.size());

    vueloDto.setKey(key); // getters and setters
    vueloDto.setNroVuelo(nroVuelo);
    vueloDto.setKeyAeronave(keyAeronave);
    vueloDto.setKeyAeropuertoOrigen(keyAeropuertoOrigen);
    vueloDto.setKeyAeropuertoDestino(keyAeropuertoDestino);
    vueloDto.setfechaSalida(fechaSalida);
    vueloDto.setfechaArribe(fechaArribe);
    vueloDto.setListaTripulante(listaTripulante);

    Assert.assertEquals(key, vueloDto.getKey());
    Assert.assertEquals(nroVuelo, vueloDto.getNroVuelo());
    Assert.assertEquals(keyAeronave, vueloDto.getKeyAeronave());
    Assert.assertEquals(keyAeropuertoOrigen, vueloDto.getKeyAeropuertoOrigen());
    Assert.assertEquals(
      keyAeropuertoDestino,
      vueloDto.getKeyAeropuertoDestino()
    );
    Assert.assertEquals(fechaSalida, vueloDto.getfechaSalida());
    Assert.assertEquals(fechaArribe, vueloDto.getfechaArribe());
    Assert.assertEquals(listaTripulante, vueloDto.getListaTripulante());
  }

  private List<TripulanteDto> getTripulantes() {
    return new ArrayList<>();
  }
}
