package Factories;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.Test;

import Model.Vuelos.Vuelo;

public class VueloFactoryTest {
	@Test
	public void dataValid() {
		VueloFactory vueloFactory = new VueloFactory();
		Vuelo vuelo = vueloFactory.Create("scz-cba-4654", UUID.randomUUID(), "SCR-VIruViru", "CBBA", new Date(), new Date(),
				UUID.randomUUID(), new ArrayList<>(), new ArrayList<>());
		System.out.println(vuelo);
	}
}
