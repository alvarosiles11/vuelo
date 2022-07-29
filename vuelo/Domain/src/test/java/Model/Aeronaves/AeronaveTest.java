package Model.Aeronaves;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class AeronaveTest {

  @Test
  public void CheckConstructor() {
    UUID key = UUID.randomUUID();
    String matricula = "A12345";

    Aeronave aeronaveA = new Aeronave();

    Aeronave aeronave = new Aeronave(matricula);
    Assert.assertEquals(matricula, aeronave.matricula);
    System.out.println(key + "" + aeronaveA);
  }
}
