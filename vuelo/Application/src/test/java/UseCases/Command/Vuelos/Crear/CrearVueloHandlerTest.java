package UseCases.Command.Vuelos.Crear;

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

		VueloDto data = new VueloDto();
		CrearVueloCommand command = new CrearVueloCommand(data);

	}

	@Test
	public void HandleCorrectly() throws Exception {
		UUID key = UUID.randomUUID();
		String nroVuelo = "scz-cba-513184";
		UUID keyAeronave = UUID.randomUUID();
		String origen = "Scz-ViruViru";
		String destino = "CBA-CBA";
		Date fechaSalida = new Date();
		Date fechaArribe = new Date();
		UUID keyTripulacion = UUID.randomUUID();
		String observacion = "Abordando";
		String estado = "1";
		List<Asiento> asientos = new ArrayList<>();
		List<Tripulante> tripulantes = new ArrayList<>();

		CrearVueloHandler handler = new CrearVueloHandler(iVueloFactory, iVueloRepository, iAeronaveRepository,
				iTripulacionRepository, iUnitOfWork);

		VueloDto vueloDto = new VueloDto();
		vueloDto.setKey(key);
		vueloDto.setNroVuelo(nroVuelo);
		vueloDto.setKeyAeronave(keyAeronave);
		// vueloDto.setAsientos(asientos);
		vueloDto.setOrigen(origen);
		vueloDto.setDestino(destino);
		vueloDto.setFechaSalida(fechaSalida);
		vueloDto.setFechaArribe(fechaArribe);
		vueloDto.setKeyTripulacion(keyTripulacion);
		// vueloDto.setTripulantes(tripulantes);
		vueloDto.setObservacion(observacion);
		vueloDto.setEstado(estado);

		// Vuelo nroVuelo87 = iVueloRepository.findNroVuelo(anyString());
		// Aeronave aeronave = iAeronaveRepository.FindByKey(any());
		// Aeronave nroVuelo = iVueloRepository.findNroVuelo(anyString());

		CrearVueloCommand command = new CrearVueloCommand(vueloDto);
		// Vuelo response = handler.handle(command);
		// verify(iVueloRepository).Create(response);
		// verify(iUnitOfWork).commit();

		// Assert.assertEquals(any(), response.getKey());
		// Assert.assertEquals(anyString(), response.getNroVuelo());
		// Assert.assertEquals(any(), response.getKeyAeronave());
		// Assert.assertEquals(anyList(), response.getAsientos());
		// Assert.assertEquals(anyString(), response.getOrigen());
		// Assert.assertEquals(anyString(), response.getDestino());
		// Assert.assertEquals(any(), response.getFechaSalida());
		// Assert.assertEquals(any(), response.getFechaArribe());
		// Assert.assertEquals(any(), response.getKeyTripulacion());
		// Assert.assertEquals(anyList(), response.getTripulantes());

	}
}
