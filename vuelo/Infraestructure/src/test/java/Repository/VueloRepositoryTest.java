package Repository;

import java.util.Date;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import Context.IWriteDbContext;
import Model.Vuelos.Vuelo;

public class VueloRepositoryTest {

	IWriteDbContext database = Mockito.mock(IWriteDbContext.class);
	VueloRepository vueloRepository = new VueloRepository(database);

	@Test
	public void constructor_accept() {
		VueloRepository vueloRepository = new VueloRepository(database);
		Assert.assertNotNull(vueloRepository);
	}

	@Test
	public void dataValid() {
		UUID key = UUID.randomUUID();
		String nroVuelo = "A12345";
		String keyAeronave = "xyz-1990";
		String keyAeropuertoOrigen = "aeropuerto100";
		String keyAeropuertoDestino = "aeropuerto200";
		Date fecha_salida = new Date();
		Date fecha_arribe = new Date();

		// IWriteDbContext database = new IWriteDbContext();

		Vuelo vuelo = new Vuelo(
				nroVuelo,
				keyAeronave,
				keyAeropuertoOrigen,
				keyAeropuertoDestino,
				fecha_salida,
				fecha_arribe);

		try {
			vueloRepository.GetAll();
			vueloRepository.FindByKey(key);
			vueloRepository.Create(vuelo);
			vueloRepository.Update(vuelo);
			vueloRepository.Delete(vuelo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void GetAll_accept() throws Exception {
		VueloRepository repository = new VueloRepository(database);
		repository.GetAll();
		Assert.assertNotNull(repository);
	}
}
