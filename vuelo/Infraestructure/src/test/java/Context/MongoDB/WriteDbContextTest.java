package Context.MongoDB;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import Fourteam.db.Exception.DataBaseException;
import Model.Aeronaves.Aeronave;
import Model.Tripulacion.Tripulacion;
import Model.Vuelos.Vuelo;

public class WriteDbContextTest {
	@Test
	public void constructor_accept() throws DataBaseException {
		WriteDbContext context = new WriteDbContext();
		Assert.assertNotNull(context);
	}

	@Test
	public void FindByKey_accept() throws DataBaseException {
		WriteDbContext context = new WriteDbContext();
		ArgumentCaptor<Aeronave> aeronave = ArgumentCaptor.forClass(Aeronave.class);
		ArgumentCaptor<Tripulacion> tripulacion = ArgumentCaptor.forClass(Tripulacion.class);
		ArgumentCaptor<Vuelo> vuelo = ArgumentCaptor.forClass(Vuelo.class);
		Assert.assertNotNull(context);
	}

}
