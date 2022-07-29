package Dto;

import java.util.UUID;

public class TripulanteDto {

  private UUID key; // key del tripulante
  private UUID keyVuelo; // key del vuelo
  private String keyTripulante; // tripulante
  private String cargo; // cargo

  public TripulanteDto() {}

  public TripulanteDto(UUID keyVuelo, String keyTripulante, String cargo) {
    this.keyVuelo = keyVuelo;
    this.keyTripulante = keyTripulante;
    this.cargo = cargo;
  }

  public UUID getKeyVuelo() {
    return keyVuelo;
  }

  public UUID getKey() {
    return key;
  }

  public void setKey(UUID key) {
    this.key = key;
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
