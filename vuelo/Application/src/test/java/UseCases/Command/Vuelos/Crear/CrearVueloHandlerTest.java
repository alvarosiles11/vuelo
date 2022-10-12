package UseCases.Command.Vuelos.Crear;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Dto.VueloDto;
import Factories.IVueloFactory;
import Model.Aeronaves.Asiento;
import Model.Tripulacion.Tripulante;
import Model.Vuelos.Vuelo;
import Repositories.IAeronaveRepository;
import Repositories.ITripulacionRepository;
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;

public class CrearVueloHandlerTest {
	IVueloFactory iVueloFactory = Mockito.mock(IVueloFactory.class);
	IVueloRepository iVueloRepository = Mockito.mock(IVueloRepository.class);
	IUnitOfWork iUnitOfWork = Mockito.mock(IUnitOfWork.class);

	IAeronaveRepository iAeronaveRepository = Mockito.mock(IAeronaveRepository.class);
	ITripulacionRepository iTripulacionRepository = Mockito.mock(ITripulacionRepository.class);

	@Before
	public void setUp() {
	}

	@Test
	public void HandleCorrectly() throws Exception {
		final UUID key = UUID.randomUUID();
		final String nroVuelo = "scz-cba-513184";
		final UUID keyAeronave = UUID.randomUUID();
		final String origen = "Scz-ViruViru";
		final String destino = "CBA-CBA";
		final Date fechaSalida = new Date();
		final Date fechaArribe = new Date();
		final UUID keyTripulacion = UUID.randomUUID();
		final String observacion = "En horario";
		final String estado = "1";
		final List<Asiento> asientos = getListAsiento();
		final List<Tripulante> tripulantes = getListdaTripulantes();

		final Vuelo vuelo = new Vuelo(nroVuelo, keyAeronave, origen, destino, fechaSalida, fechaArribe, keyTripulacion,
				observacion, estado, asientos, tripulantes);
		when(iVueloFactory.Create(nroVuelo, keyAeronave, origen, destino, fechaSalida, fechaArribe, keyTripulacion,
				observacion, estado, asientos, tripulantes));

		final CrearVueloHandler handler = new CrearVueloHandler(iVueloFactory, iVueloRepository, iAeronaveRepository,
				iTripulacionRepository, iUnitOfWork);
		final VueloDto vueloDto = new VueloDto();
		vueloDto.setKey(key);
		vueloDto.setNroVuelo(nroVuelo);
		vueloDto.setKeyAeronave(keyAeronave);
		vueloDto.setAsientos(new ArrayList<>());
		vueloDto.setOrigen(origen);
		vueloDto.setDestino(destino);
		vueloDto.setFechaSalida(fechaSalida);
		vueloDto.setFechaArribe(fechaArribe);
		vueloDto.setKeyTripulacion(keyTripulacion);
		vueloDto.setTripulantes(new ArrayList<>());
		vueloDto.setObservacion(observacion);
		vueloDto.setEstado(estado);

		final CrearVueloCommand command = new CrearVueloCommand(vueloDto);
		// TDO coman crear vuelos handler en fourteam o sharekernel
		// final Vuelo response = handler.handle(command);
		// UUID response = handler.handle(command);

		// verify(iVueloRepository).Create(response);
		// verify(iUnitOfWork).commit();
		// Assert.assertNotNull(response);

		// Assert.assertEquals(
		// Event.VueloCreado.class,
		// response.domainEvents.get(0).getClass());

		// Assert.assertEquals(key, response.getKey());
		// Assert.assertEquals(nroVuelo, response.getNroVuelo());
		// Assert.assertEquals(keyAeronave, response.getKeyAeronave());
		// Assert.assertEquals(asientos, response.getAsientos());
		// Assert.assertEquals(origen, response.getOrigen());
		// Assert.assertEquals(destino, response.getDestino());
		// Assert.assertEquals(fechaSalida, response.getFechaSalida());
		// Assert.assertEquals(fechaArribe, response.getFechaArribe());
		// Assert.assertEquals(keyTripulacion, response.getKeyTripulacion());
		// Assert.assertEquals(tripulantes, response.getTripulantes());

	}

	private List<Asiento> getListAsiento() {
		return new ArrayList<>();
	}

	private List<Tripulante> getListdaTripulantes() {
		return new ArrayList<>();
	}
}
