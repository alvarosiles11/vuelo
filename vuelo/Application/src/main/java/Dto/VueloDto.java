package Dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class VueloDto {

  private UUID key;
  private String nroVuelo;
  private String keyAeronave;
  private String keyAeropuertoOrigen;
  private String keyAeropuertoDestino;
  private Date fechaSalida;
  private Date fechaArribe;
  public List<TripulanteDto> listaTripulante;

  public VueloDto() {
    listaTripulante = new ArrayList<>();
  }

  public UUID getKey() {
    return key;
  }

  public void setKey(UUID key) {
    this.key = key;
  }

  public List<TripulanteDto> getListaTripulante() {
    return listaTripulante;
  }

  public void setListaTripulante(List<TripulanteDto> listaTripulante) {
    this.listaTripulante = listaTripulante;
  }

  public String getNroVuelo() {
    return nroVuelo;
  }

  public void setNroVuelo(String nroVuelo) {
    this.nroVuelo = nroVuelo;
  }

  public String getKeyAeronave() {
    return keyAeronave;
  }

  public void setKeyAeronave(String keyAeronave) {
    this.keyAeronave = keyAeronave;
  }

  public String getKeyAeropuertoOrigen() {
    return keyAeropuertoOrigen;
  }

  public void setKeyAeropuertoOrigen(String keyAeropuertoOrigen) {
    this.keyAeropuertoOrigen = keyAeropuertoOrigen;
  }

  public String getKeyAeropuertoDestino() {
    return keyAeropuertoDestino;
  }

  public void setKeyAeropuertoDestino(String keyAeropuertoDestino) {
    this.keyAeropuertoDestino = keyAeropuertoDestino;
  }

  public Date getfechaSalida() {
    return fechaSalida;
  }

  public void setfechaSalida(Date fechaSalida) {
    this.fechaSalida = fechaSalida;
  }

  public Date getfechaArribe() {
    return fechaArribe;
  }

  public void setfechaArribe(Date fechaArribe) {
    this.fechaArribe = fechaArribe;
  }
}
