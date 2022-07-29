package Repository;

import Context.IWriteDbContext;
import Context.MongoDB.WriteDbContext;
import Model.Vuelos.Tripulante;
import fourteam.http.Exception.HttpException;
import java.util.UUID;
import org.junit.Test;

public class TripulanteRepositoryTest {

  @Test
  public void HandlePersonalRegistrado_Ok() throws HttpException {
    UUID key = UUID.randomUUID();
    UUID keyVuelo = UUID.randomUUID();
    String keyTripulante = "12345";
    String cargo = "Piloto";

    IWriteDbContext database = new WriteDbContext();
    TripulanteRepository tripulanteRepository = new TripulanteRepository(
      database
    );
    Tripulante tripulante = new Tripulante(keyVuelo, keyTripulante, cargo);

    tripulanteRepository.GetAll();
    tripulanteRepository.FindByKey(key);
    tripulanteRepository.Create(tripulante);
    tripulanteRepository.Update(tripulante);
    tripulanteRepository.Delete(tripulante);
  }
}
