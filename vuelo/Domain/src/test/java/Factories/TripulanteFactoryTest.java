package Factories;

import Model.Vuelos.Tripulante;
import java.util.UUID;
import org.junit.Test;

public class TripulanteFactoryTest {

  @Test
  public void dataValid() {
    TripulanteFactory tripulanteFactory = new TripulanteFactory();
    Tripulante tripulante = tripulanteFactory.Create(
      UUID.randomUUID(),
      UUID.randomUUID().toString(),
      "Piloto"
    );
    System.out.println(tripulante);
  }
}
