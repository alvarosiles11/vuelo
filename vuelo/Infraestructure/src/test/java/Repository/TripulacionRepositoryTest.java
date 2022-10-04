package Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.mockito.Mockito;

import Context.IWriteDbContext;
import Fourteam.http.Exception.HttpException;
import Model.Tripulacion.Tripulacion;
import Model.Tripulacion.Tripulante;

public class TripulacionRepositoryTest {
	IWriteDbContext database = Mockito.mock(IWriteDbContext.class);

	@Test
	public void HandlePersonalRegistrado_Ok() throws HttpException {
		final UUID keyTripulacion = UUID.randomUUID();
		final String descripcion = "Grupo-A";
		final String estado = "0";
		final List<Tripulante> tripulantes = new ArrayList<>();

		TripulacionRepository tripulacionRepository = new TripulacionRepository(database);
		Tripulacion tripulacion = new Tripulacion(keyTripulacion, descripcion, estado);
		try {

			tripulacionRepository.GetAll();
			tripulacionRepository.FindByKey(keyTripulacion);
			tripulacionRepository.Create(tripulacion);
			tripulacionRepository.Update(tripulacion);
			tripulacionRepository.Delete(tripulacion);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
