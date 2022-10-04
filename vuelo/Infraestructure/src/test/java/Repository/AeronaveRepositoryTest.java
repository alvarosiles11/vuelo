package Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.mockito.Mockito;

import Context.IWriteDbContext;
import Fourteam.http.Exception.HttpException;
import Model.Aeronaves.Aeronave;
import Model.Aeronaves.Asiento;

public class AeronaveRepositoryTest {
	IWriteDbContext database = Mockito.mock(IWriteDbContext.class);

	@Test
	public void HandlePersonalRegistrado_Ok() throws HttpException {

		final UUID keyAeronave = UUID.randomUUID();
		final String matricula = "xyz-1990";
		final List<Asiento> listdaAsientos = new ArrayList<>();
		final String estado = "0";

		// IWriteDbContext database = new WriteDbContext();
		AeronaveRepository aeronaveRepository = new AeronaveRepository(database);
		Aeronave aeronave = new Aeronave(keyAeronave, matricula, estado);
		try {

			aeronaveRepository.GetAll();
			aeronaveRepository.FindByKey(keyAeronave);
			aeronaveRepository.Create(aeronave);
			aeronaveRepository.Update(aeronave);
			aeronaveRepository.Delete(aeronave);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
