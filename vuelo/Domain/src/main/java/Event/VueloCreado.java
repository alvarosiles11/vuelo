package Event;

import Model.Vuelos.Tripulante;
import core.DomainEvent;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class VueloCreado extends DomainEvent {

  protected UUID keyVuelo;
  protected String nroVuelo;
  protected String keyAeronave;
  protected String keyAeropuertoOrigen;
  protected String keyAeropuertoDestino;
  protected Date fechaSalida;
  protected Date fechaArribe;
  protected List<Tripulante> listaTripulante;

  public VueloCreado() {
    super();
  }

  public VueloCreado(
    UUID keyVuelo,
    String nroVuelo,
    String keyAeronave,
    String keyAeropuertoOrigen,
    String keyAeropuertoDestino,
    Date fechaSalida,
    Date fechaArribe,
    List<Tripulante> listaTripulante
  ) {
    super(LocalDateTime.now());
    this.keyVuelo = keyVuelo;
    this.nroVuelo = nroVuelo;
    this.keyAeronave = keyAeronave;
    this.keyAeropuertoOrigen = keyAeropuertoOrigen;
    this.keyAeropuertoDestino = keyAeropuertoDestino;
    this.fechaSalida = fechaSalida;
    this.fechaArribe = fechaArribe;
    this.listaTripulante = listaTripulante;
  }

  public UUID getKeyVuelo() {
    return keyVuelo;
  }

  public void setKeyVuelo(UUID keyVuelo) {
    this.keyVuelo = keyVuelo;
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

  public List<Tripulante> getListaTripulante() {
    return listaTripulante;
  }

  public void setListaTripulante(List<Tripulante> listaTripulante) {
    this.listaTripulante = listaTripulante;
  }
}
