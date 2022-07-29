package Dto;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class TripulanteDtoTest {

  private UUID key = UUID.randomUUID();
  private UUID keyVuelo = UUID.randomUUID();
  private String keyTripulante = "12345";
  private String cargo = "Piloto";

  @Test
  public void CheckPropertiesValid() {
    TripulanteDto tripulanteDto = new TripulanteDto(); // dto
    Assert.assertEquals(null, tripulanteDto.getKey());
    Assert.assertEquals(null, tripulanteDto.getKeyVuelo());
    Assert.assertEquals(null, tripulanteDto.getKeyTripulante());
    Assert.assertEquals(null, tripulanteDto.getCargo());

    tripulanteDto.setKey(key); // getters and setters
    tripulanteDto.setKeyVuelo(keyVuelo);
    tripulanteDto.setKeyTripulante(keyTripulante);
    tripulanteDto.setCargo(cargo);
    Assert.assertEquals(key, tripulanteDto.getKey());
    Assert.assertEquals(keyVuelo, tripulanteDto.getKeyVuelo());
    Assert.assertEquals(keyTripulante, tripulanteDto.getKeyTripulante());
    Assert.assertEquals(cargo, tripulanteDto.getCargo());
  }

  @Test
  public void CheckConstructor() {
    TripulanteDto tripulanteDto = new TripulanteDto(
      keyVuelo,
      keyTripulante,
      cargo
    );
    tripulanteDto.setKey(key);
    tripulanteDto.setKeyVuelo(keyVuelo);
    tripulanteDto.setKeyTripulante(keyTripulante);
    tripulanteDto.setCargo(cargo);
    Assert.assertEquals(key, tripulanteDto.getKey());
    Assert.assertEquals(keyVuelo, tripulanteDto.getKeyVuelo());
    Assert.assertEquals(keyTripulante, tripulanteDto.getKeyTripulante());
    Assert.assertEquals(cargo, tripulanteDto.getCargo());
  }
}
