package Factories;

import Model.Vuelos.Vuelo;
import java.util.Date;

public interface IVueloFactory {
  public Vuelo Create(
    String _nroVuelo,
    String _keyAeronave,
    String _keyAeropuertoOrigen,
    String _keyAeropuertoDestino,
    Date _fecha_salida,
    Date _fecha_arribe
  );
}
