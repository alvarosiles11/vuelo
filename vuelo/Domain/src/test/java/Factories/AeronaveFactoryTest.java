package Factories;

import Model.Aeronaves.Aeronave;
import org.junit.Test;

public class AeronaveFactoryTest {

  @Test
  public void dataValid() {
    AeronaveFactory aeronaveFactory = new AeronaveFactory();
    Aeronave aeronave = aeronaveFactory.Create("xyz-1990");
    System.out.println(aeronave);
  }
}
