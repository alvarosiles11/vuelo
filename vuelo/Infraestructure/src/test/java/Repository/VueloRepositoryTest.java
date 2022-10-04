package Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.mockito.Mockito;

import Context.IWriteDbContext;
import Fourteam.http.Exception.HttpException;
import Model.Aeronaves.Asiento;
import Model.Tripulacion.Tripulante;
import Model.Vuelos.Vuelo;

public class VueloRepositoryTest {
	IWriteDbContext database = Mockito.mock(IWriteDbContext.class);

	@Test
	public void HandlePersonalRegistrado_Ok() throws HttpException {
		final UUID key = UUID.randomUUID();
		final String nroVuelo = "scz-cba-513184";
		final UUID keyAeronave = UUID.randomUUID();
		final List<Asiento> asientos = new ArrayList<>();
		final String origen = "Scz-ViruViru";
		final String destino = "CBA-CBA";
		final Date fechaSalida = new Date();
		final Date fechaArribe = new Date();
		final UUID keyTripulacion = UUID.randomUUID();
		final List<Tripulante> tripulantes = new ArrayList<>();

		VueloRepository vueloRepository = new VueloRepository(database);
		Vuelo vuelo = new Vuelo(nroVuelo, keyAeronave, origen, destino, fechaSalida, fechaArribe, keyTripulacion,
				asientos, tripulantes);
		try {

			vueloRepository.GetAll();
			vueloRepository.FindByKey(key);
			vueloRepository.Create(vuelo);
			vueloRepository.Update(vuelo);
			vueloRepository.Delete(vuelo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
