package Repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import Context.IWriteDbContext;
import Fourteam.db.DbSet;
import Model.Aeronaves.Aeronave;

public class AeronaveRepositoryTest {
	IWriteDbContext database = Mockito.mock(IWriteDbContext.class);
	DbSet<Aeronave> aeronaves = Mockito.mock(DbSet.class);

	@Test
	public void constructor_accept() {
		AeronaveRepository repository = new AeronaveRepository(database);
		Assert.assertNotNull(repository);
	}

	@Test
	public void FindByKey_accept() throws Exception {
		// Mockito.verify(_aeronaves).Single(obj -> obj.key.equals(UUID.randomUUID()));
		Aeronave a = new Aeronave();
		when(aeronaves.Single(any())).thenReturn(a);
		AeronaveRepository repository = new AeronaveRepository(database);
		// ArgumentCaptor<Aeronave> captor = ArgumentCaptor.forClass(Aeronave.class);
		repository.FindByKey(UUID.randomUUID());
		Assert.assertNotNull(repository);
	}

	@Test
	public void GetAll_accept() throws Exception {
		AeronaveRepository repository = new AeronaveRepository(database);
		repository.GetAll();
		Assert.assertNotNull(repository);
	}

	@Test
	public void Create_accept() throws Exception {
		AeronaveRepository repository = new AeronaveRepository(database);
		repository.Create(new Aeronave());
		Assert.assertNotNull(repository);
	}

	@Test
	public void Delete_accept() throws Exception {
		AeronaveRepository repository = new AeronaveRepository(database);
		repository.Delete(new Aeronave());
		Assert.assertNotNull(repository);
	}

	@Test
	public void Update_accept() throws Exception {
		AeronaveRepository repository = new AeronaveRepository(database);
		repository.Update(new Aeronave());
		Assert.assertNotNull(repository);
	}
	// @Test
	// public void HandlePersonalRegistrado_Ok() throws HttpException {

	// final UUID keyAeronave = UUID.randomUUID();
	// final String matricula = "xyz-1990";
	// final List<Asiento> listdaAsientos = new ArrayList<>();
	// final String estado = "0";
	// // IWriteDbContext database = new WriteDbContext();
	// AeronaveRepository aeronaveRepository = new AeronaveRepository(database);
	// Aeronave aeronave = new Aeronave(keyAeronave, matricula, estado);
	// try {

	// aeronaveRepository.GetAll();
	// aeronaveRepository.FindByKey(keyAeronave);
	// aeronaveRepository.Create(aeronave);
	// aeronaveRepository.Update(aeronave);
	// aeronaveRepository.Delete(aeronave);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
}
