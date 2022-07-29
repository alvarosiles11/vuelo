package Model.Vuelos;

import core.Entity;
import java.util.UUID;

public class Tripulante extends Entity<UUID> {

  protected UUID keyVuelo;
  protected String keyTripulante;
  protected String cargo;

  public Tripulante(UUID keyVuelo, String keyTripulante, String cargo) {
    this.key = UUID.randomUUID();
    this.keyVuelo = keyVuelo;
    this.keyTripulante = keyTripulante;
    this.cargo = cargo;
  }

  public UUID getKeyVuelo() {
    return keyVuelo;
  }

  public void setKeyVuelo(UUID keyVuelo) {
    this.keyVuelo = keyVuelo;
  }

  public String getKeyTripulante() {
    return keyTripulante;
  }

  public void setKeyTripulante(String keyTripulante) {
    this.keyTripulante = keyTripulante;
  }

  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }
}
