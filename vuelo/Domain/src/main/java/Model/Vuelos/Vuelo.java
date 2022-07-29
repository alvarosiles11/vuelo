package Model.Vuelos;

import Event.VueloCreado;
import Model.Vuelos.ValueObjects.NumeroVuelo;
import core.AggregateRoot;
import core.BussinessRuleValidateExeption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Vuelo extends AggregateRoot<UUID> {

  private String nroVuelo;
  private String keyAeronave;
  private String keyAeropuertoOrigen;
  private String keyAeropuertoDestino;
  private Date fechaSalida;
  private Date fechaArribe;
  public List<Tripulante> listaTripulante;

  public Vuelo() {}

  public Vuelo(
    String _nroVuelo,
    String _keyAeronave,
    String _keyAeropuertoOrigen,
    String _keyAeropuertoDestino,
    Date _fechaSalida,
    Date _fechaArribe
  ) {
    key = UUID.randomUUID();

    // validaciones value objects y reglas de negocio
    try {
      this.nroVuelo = new NumeroVuelo(_nroVuelo).toString();
    } catch (BussinessRuleValidateExeption e) {
      e.printStackTrace();
      return;
    }

    nroVuelo = _nroVuelo;
    keyAeronave = _keyAeronave;
    keyAeropuertoOrigen = _keyAeropuertoOrigen;
    keyAeropuertoDestino = _keyAeropuertoDestino;
    fechaSalida = _fechaSalida;
    fechaArribe = _fechaArribe;
    listaTripulante = new ArrayList<Tripulante>();
    System.out.println("Se a creado un nuevo vuelo");
  }

  public void eventCreado() {
    addDomainEvent(
      new VueloCreado(
        key,
        nroVuelo,
        keyAeronave,
        keyAeropuertoOrigen,
        keyAeropuertoDestino,
        fechaSalida,
        fechaArribe,
        listaTripulante
      )
    );
  }

  public void AgregarTripulante(Tripulante tripulante) {
    listaTripulante
      .parallelStream()
      .filter(p -> p.getKey() == tripulante.getKey())
      .findFirst()
      .ifPresent(p -> {
        throw new RuntimeException("El tripulante ya existe");
      });
    listaTripulante.add(tripulante);
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
