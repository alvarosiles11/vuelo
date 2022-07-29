package Factories;

import Model.Vuelos.Vuelo;
import java.util.Date;
import java.util.UUID;
import org.junit.Test;

public class VueloFactoryTest {

  @Test
  public void dataValid() {
    VueloFactory vueloFactory = new VueloFactory();
    Vuelo vuelo = vueloFactory.Create(
      "xyz-1990",
      UUID.randomUUID().toString(),
      UUID.randomUUID().toString(),
      UUID.randomUUID().toString(),
      new Date(),
      new Date()
    );
    System.out.println(vuelo);
  }
}
