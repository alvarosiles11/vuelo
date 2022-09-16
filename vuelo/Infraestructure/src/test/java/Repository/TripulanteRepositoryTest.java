package Repository;

import Context.IWriteDbContext;
import Context.MongoDB.WriteDbContext;
import Model.Vuelos.Tripulante;
import fourteam.http.Exception.HttpException;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;

public class TripulanteRepositoryTest {
	IWriteDbContext database = Mockito.mock(IWriteDbContext.class);

	@Test
	public void HandlePersonalRegistrado_Ok() throws HttpException {
		UUID key = UUID.randomUUID();
		UUID keyVuelo = UUID.randomUUID();
		String keyTripulante = "12345";
		String cargo = "Piloto";

		// IWriteDbContext database = new WriteDbContext();
		TripulanteRepository tripulanteRepository = new TripulanteRepository(database);
		Tripulante tripulante = new Tripulante(keyVuelo, keyTripulante, cargo);
		try {

			tripulanteRepository.GetAll();
			tripulanteRepository.FindByKey(key);
			tripulanteRepository.Create(tripulante);
			tripulanteRepository.Update(tripulante);
			tripulanteRepository.Delete(tripulante);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
