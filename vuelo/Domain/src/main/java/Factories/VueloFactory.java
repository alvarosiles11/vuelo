package Factories;

import Model.Vuelos.Vuelo;
import java.util.Date;

public class VueloFactory implements IVueloFactory {

  public VueloFactory() {}

  @Override
  public Vuelo Create(
    String nroVuelo,
    String keyAeronave,
    String keyAeropuertoOrigen,
    String keyAeropuertoDestino,
    Date fecha_salida,
    Date fecha_arribe
  ) {
    return new Vuelo(
      nroVuelo,
      keyAeronave,
      keyAeropuertoOrigen,
      keyAeropuertoDestino,
      fecha_salida,
      fecha_arribe
    );
  }
}
