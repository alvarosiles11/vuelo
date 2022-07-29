package Repository;

import Context.IWriteDbContext;
import Context.MongoDB.WriteDbContext;
import Model.Vuelos.Vuelo;
import java.util.Date;
import java.util.UUID;
import org.junit.Test;

public class VueloRepositoryTest {

  @Test
  public void dataValid() {
    UUID key = UUID.randomUUID();
    String nroVuelo = "A12345";
    String keyAeronave = "xyz-1990";
    String keyAeropuertoOrigen = "aeropuerto100";
    String keyAeropuertoDestino = "aeropuerto200";
    Date fecha_salida = new Date();
    Date fecha_arribe = new Date();

    IWriteDbContext database = new WriteDbContext();
    VueloRepository vueloRepository = new VueloRepository(database);

    Vuelo vuelo = new Vuelo(
      nroVuelo,
      keyAeronave,
      keyAeropuertoOrigen,
      keyAeropuertoDestino,
      fecha_salida,
      fecha_arribe
    );

    vueloRepository.GetAll();
    vueloRepository.FindByKey(key);
    vueloRepository.Create(vuelo);
    vueloRepository.Update(vuelo);
    vueloRepository.Delete(vuelo);
  }
}
