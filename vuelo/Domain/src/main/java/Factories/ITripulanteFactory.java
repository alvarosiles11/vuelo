package Factories;

import Model.Vuelos.Tripulante;
import java.util.UUID;

public interface ITripulanteFactory {
  public Tripulante Create(
    UUID _keyVuelo,
    String _keyTripulante,
    String _cargo
  );
}
