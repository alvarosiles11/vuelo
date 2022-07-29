package Factories;

import Model.Vuelos.Tripulante;
import java.util.UUID;

public class TripulanteFactory implements ITripulanteFactory {

  public TripulanteFactory() {}

  @Override
  public Tripulante Create(
    UUID _keyVuelo,
    String _keyTripulante,
    String _cargo
  ) {
    return new Tripulante(_keyVuelo, _keyTripulante, _cargo);
  }
}
