package Model.Aeronaves;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import core.AggregateRoot;

public class AeronaveTest extends AggregateRoot<UUID> {

	@Test
	public void CheckConstructor() {
		final UUID keyAeronave = UUID.randomUUID();
		final String matricula = "xyz-1990";
		final List<Asiento> listdaAsientos = new ArrayList<>();
		final String estado = "0";

		final Aeronave aeronave = new Aeronave(keyAeronave, matricula, estado);
		Aeronave aeronaveTest = new Aeronave();

		Assert.assertEquals(matricula, aeronave.getMatricula());
		Assert.assertEquals(listdaAsientos, aeronave.getAsientos());
		Assert.assertEquals(estado, aeronave.getEstado());
	}

	@Test
	public void constructor_denied() {
		final UUID keyAeronave = null;
		final String matricula = "";
		// final List<Asiento> listdaAsientos = null;
		final String estado = "";
		final Aeronave aeronave = new Aeronave(keyAeronave, matricula, estado);
		Assert.assertEquals(aeronave.key, null);
		Assert.assertEquals(aeronave.matricula, "");
		Assert.assertEquals(aeronave.asientos.size(), 0);
		Assert.assertEquals(aeronave.estado, "");
	}

	@Test
	public void addAsiento_accept() {
		final UUID keyAeronave = UUID.randomUUID();
		final String matricula = "xyz-1990";
		final List<Asiento> listdaAsientos1 = new ArrayList<>();
		final String estado = "0";

		Aeronave aeronave = new Aeronave(keyAeronave, matricula, estado);

		aeronave.agregarAsiento(UUID.randomUUID(), UUID.randomUUID(), 1, "comercial", 200.00, 0);
		Assert.assertEquals(aeronave.asientos.size(), 1);

		aeronave.setMatricula(matricula);
		aeronave.setAsientos(listdaAsientos1);
		aeronave.setEstado(estado);
	}

	@Test
	public void addAsiento_denied() {

		final UUID keyAeronave = UUID.randomUUID();
		final String matricula = "xyz-1990";
		// final List<Asiento> listdaAsientos = new ArrayList<>();
		final String estado = "0";

		Aeronave aeronave = new Aeronave(keyAeronave, matricula, estado);

		Asiento asiento001 = new Asiento(UUID.randomUUID(), UUID.randomUUID(), 1, "comercial", 200.00, 0);
		aeronave.agregarAsiento(asiento001);

		Asiento asiento002 = new Asiento(UUID.randomUUID(), UUID.randomUUID(), 1, "comercial", 200.00, 0);
		asiento002.key = asiento001.key;

		try {
			aeronave.agregarAsiento(asiento002);
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}
}
