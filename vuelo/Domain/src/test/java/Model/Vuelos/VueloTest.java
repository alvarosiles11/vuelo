package Model.Vuelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class VueloTest {

  int cont = 1;
  UUID key = UUID.randomUUID();
  String nroVuelo = "A12345";
  String keyAeronave = "xyz-1990";
  String keyAeropuertoOrigen = UUID.randomUUID().toString();
  String keyAeropuertoDestino = UUID.randomUUID().toString();
  Date fechaSalida = new Date();
  Date fechaArribe = new Date();
  List<Tripulante> listaTripulante = new ArrayList<>();

  @Test
  public void constructorVoid_accept() {
    Assert.assertNotNull(new Vuelo());
  }

  @Test
  public void constructor_accept() {
    Vuelo vuelo = new Vuelo(
      nroVuelo,
      keyAeronave,
      keyAeropuertoOrigen,
      keyAeropuertoDestino,
      fechaSalida,
      fechaArribe
    );
    Assert.assertEquals(key, vuelo.getKey());
    Assert.assertEquals(nroVuelo, vuelo.getNroVuelo());
    Assert.assertEquals(keyAeronave, vuelo.getKeyAeronave());
    Assert.assertEquals(keyAeropuertoOrigen, vuelo.getKeyAeropuertoOrigen());
    Assert.assertEquals(keyAeropuertoDestino, vuelo.getKeyAeropuertoDestino());
    Assert.assertEquals(fechaSalida, vuelo.getfechaSalida());
    Assert.assertEquals(fechaArribe, vuelo.getfechaArribe());
    Assert.assertEquals(listaTripulante, vuelo.getListaTripulante());
  }

  @Test
  public void constructor_denied() {
    String _nroVuelo = null;
    String _keyAeronave = null;
    String _keyAeropuertoOrigen = null;
    String _keyAeropuertoDestino = null;
    // String _keyAeropuertoDestino = "";
    Date _fecha_salida = null;
    Date _fecha_arribe = null;
    // List<Tripulante> listaTripulante = new ArrayList<>();
    Vuelo vuelo = new Vuelo(
      _nroVuelo,
      _keyAeronave,
      _keyAeropuertoOrigen,
      _keyAeropuertoDestino,
      _fecha_salida,
      _fecha_arribe
    );

    Assert.assertEquals(vuelo.getNroVuelo(), _nroVuelo);
    Assert.assertEquals(vuelo.getKeyAeronave(), _keyAeronave);
    Assert.assertEquals(vuelo.getKeyAeropuertoOrigen(), _keyAeropuertoOrigen);
    Assert.assertEquals(vuelo.getKeyAeropuertoDestino(), _keyAeropuertoDestino);
    Assert.assertEquals(vuelo.getfechaSalida(), _fecha_salida);
    Assert.assertEquals(vuelo.getfechaArribe(), _fecha_arribe);
  }

  @Test
  public void addDomainEvent_accept() {
    Vuelo vuelo = new Vuelo(
      nroVuelo,
      keyAeronave,
      keyAeropuertoOrigen,
      keyAeropuertoDestino,
      fechaSalida,
      fechaArribe
    );
    vuelo.eventCreado();
    Assert.assertEquals(vuelo.domainEvents.size(), cont);
  }

  @Test
  public void addTripulante() {
    Vuelo objVuelo = new Vuelo(
      nroVuelo,
      keyAeronave,
      keyAeropuertoOrigen,
      keyAeropuertoDestino,
      fechaSalida,
      fechaArribe
    );
    objVuelo.AgregarTripulante(
      new Tripulante(UUID.randomUUID(), "xyz-1990", "Piloto")
    );
    objVuelo.eventCreado();
    Assert.assertEquals(objVuelo.listaTripulante.size(), cont);
  }

  @Test
  public void addTripulante_denied() {
    Vuelo vuelo = new Vuelo(
      nroVuelo,
      keyAeronave,
      keyAeropuertoOrigen,
      keyAeropuertoDestino,
      fechaSalida,
      fechaArribe
    );

    Tripulante tripulante = new Tripulante(
      UUID.randomUUID(),
      "xyz-1990",
      "Piloto"
    );
    vuelo.AgregarTripulante(tripulante);

    Tripulante tripulante2 = new Tripulante(
      UUID.randomUUID(),
      "xyz-1990",
      "Piloto"
    );
    tripulante2.keyTripulante = tripulante.keyTripulante;

    try {
      vuelo.AgregarTripulante(tripulante2);
    } catch (Exception e) {
      Assert.assertTrue(true);
    }
  }
}
