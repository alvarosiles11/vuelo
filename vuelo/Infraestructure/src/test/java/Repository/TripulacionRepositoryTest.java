package Repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import Context.IWriteDbContext;
import Fourteam.db.DbSet;
import Model.Tripulacion.Tripulacion;

public class TripulacionRepositoryTest {
	IWriteDbContext database = Mockito.mock(IWriteDbContext.class);
	DbSet<Tripulacion> Tripulacions = Mockito.mock(DbSet.class);

	@Test
	public void constructor_accept() {
		TripulacionRepository repository = new TripulacionRepository(database);
		Assert.assertNotNull(repository);
	}

	@Test
	public void FindByKey_accept() throws Exception {
		// Mockito.verify(_Tripulacions).Single(obj ->
		// obj.key.equals(UUID.randomUUID()));
		Tripulacion a = new Tripulacion();
		when(Tripulacions.Single(any())).thenReturn(a);
		TripulacionRepository repository = new TripulacionRepository(database);
		// ArgumentCaptor<Tripulacion> captor =
		// ArgumentCaptor.forClass(Tripulacion.class);
		repository.FindByKey(UUID.randomUUID());
		Assert.assertNotNull(repository);
	}

	@Test
	public void GetAll_accept() throws Exception {
		TripulacionRepository repository = new TripulacionRepository(database);
		repository.GetAll();
		Assert.assertNotNull(repository);
	}

	@Test
	public void Create_accept() throws Exception {
		TripulacionRepository repository = new TripulacionRepository(database);
		repository.Create(new Tripulacion());
		Assert.assertNotNull(repository);
	}

	@Test
	public void Delete_accept() throws Exception {
		TripulacionRepository repository = new TripulacionRepository(database);
		repository.Delete(new Tripulacion());
		Assert.assertNotNull(repository);
	}

	@Test
	public void Update_accept() throws Exception {
		TripulacionRepository repository = new TripulacionRepository(database);
		repository.Update(new Tripulacion());
		Assert.assertNotNull(repository);
	}
	// @Test
	// public void HandlePersonalRegistrado_Ok() throws HttpException {
	// final UUID keyTripulacion = UUID.randomUUID();
	// final String descripcion = "Grupo-A";
	// final String estado = "0";
	// final List<Tripulante> tripulantes = new ArrayList<>();

	// TripulacionRepository tripulacionRepository = new
	// TripulacionRepository(database);
	// Tripulacion tripulacion = new Tripulacion(keyTripulacion, descripcion,
	// estado);
	// try {

	// tripulacionRepository.GetAll();
	// tripulacionRepository.FindByKey(keyTripulacion);
	// tripulacionRepository.Create(tripulacion);
	// tripulacionRepository.Update(tripulacion);
	// tripulacionRepository.Delete(tripulacion);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
}
