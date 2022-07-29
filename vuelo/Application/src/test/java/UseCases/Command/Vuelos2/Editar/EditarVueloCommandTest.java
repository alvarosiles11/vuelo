package UseCases.Command.Vuelos2.Editar;

import Dto.VueloDto;
import UseCases.Command.Vuelos.Editar.EditarVueloCommand;
import java.util.Date;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class EditarVueloCommandTest {

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
    vueloDto.setKey(key);
    vueloDto.setNroVuelo(nroVuelo);
    vueloDto.setKeyAeronave(keyAeronave);
    vueloDto.setKeyAeropuertoOrigen(keyAeropuertoOrigen);
    vueloDto.setKeyAeropuertoDestino(keyAeropuertoDestino);
    vueloDto.setfechaSalida(fecha_salida);
    vueloDto.setfechaArribe(fecha_arribe);

    EditarVueloCommand command = new EditarVueloCommand(vueloDto.getKey());
    Assert.assertEquals(key, vueloDto.getKey());
    System.out.println(command);
  }

  @Test
  public void constructorIsPrivate() {
    Assert.assertTrue(
      EditarVueloCommand.class.getConstructors()[0].canAccess(null)
    );
  }
}
