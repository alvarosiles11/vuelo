package UseCases.Command.Vuelos2.Crear;

import Dto.VueloDto;
import UseCases.Command.Vuelos.Crear.CrearVueloCommand;
import java.util.Date;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class CrearVueloCommandTest {

  @Test
  public void dataValid() {
    UUID key = UUID.randomUUID();
    String nroVuelo = "A12345";
    String keyAeronave = "xyz-1990";
    String keyAeropuertoOrigen = "aeropuerto100";
    String keyAeropuertoDestino = "aeropuerto200";
    Date fecha_salida = new Date();
    Date fecha_arribe = new Date();
    VueloDto vueloDto = new VueloDto();

    vueloDto.setNroVuelo(nroVuelo);
    vueloDto.setKeyAeronave(keyAeronave);
    vueloDto.setKeyAeropuertoOrigen(keyAeropuertoOrigen);
    vueloDto.setKeyAeropuertoDestino(keyAeropuertoDestino);
    vueloDto.setfechaSalida(fecha_salida);
    vueloDto.setfechaArribe(fecha_arribe);

    CrearVueloCommand command = new CrearVueloCommand(vueloDto);
    Assert.assertEquals(nroVuelo, command.nroVuelo);
    Assert.assertEquals(keyAeronave, command.keyAeronave);
    Assert.assertEquals(keyAeropuertoOrigen, command.keyAeropuertoOrigen);
    Assert.assertEquals(keyAeropuertoDestino, command.keyAeropuertoDestino);
    Assert.assertEquals(fecha_salida, command.fechaSalida);
    Assert.assertEquals(fecha_arribe, command.fechaArribe);
    System.out.println(key);
  }

  @Test
  public void constructorIsPrivate() {
    Assert.assertTrue(
      CrearVueloCommand.class.getConstructors()[0].canAccess(null)
    );
  }
}
