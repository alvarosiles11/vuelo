package Dto;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class AeronaveDtoTest {

  @Test
  public void CheckPropertiesValid() {
    UUID keyAeronave = UUID.randomUUID();
    String matricula = "xyz-1990";
    AeronaveDto aeronaveDto = new AeronaveDto(); // dto
    Assert.assertEquals(null, aeronaveDto.getKeyAeronave());
    Assert.assertEquals(null, aeronaveDto.getMatricula());
    aeronaveDto.setKeyAeronave(keyAeronave); // getters and setters
    aeronaveDto.setMatricula(matricula);
    Assert.assertEquals(keyAeronave, aeronaveDto.getKeyAeronave());
    Assert.assertEquals(matricula, aeronaveDto.getMatricula());
  }
}
