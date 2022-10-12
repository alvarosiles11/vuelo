package UseCases.Command.Vuelos.Crear;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Dto.VueloDto;
import Factories.IVueloFactory;
import Model.Aeronaves.Aeronave;
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
	public void testName() {

		VueloDto data = new VueloDto();
		CrearVueloCommand command = new CrearVueloCommand(data);

	}

	@Test
	public void HandleCorrectly() throws Exception {

		CrearVueloHandler handler = new CrearVueloHandler(iVueloFactory, iVueloRepository, iAeronaveRepository,
				iTripulacionRepository, iUnitOfWork);

		VueloDto vueloDto = new VueloDto();
		vueloDto.setKey(any());
		vueloDto.setNroVuelo(anyString());
		vueloDto.setKeyAeronave(any());
		vueloDto.setAsientos(anyList());
		vueloDto.setOrigen(anyString());
		vueloDto.setDestino(anyString());
		vueloDto.setFechaSalida(any());
		vueloDto.setFechaArribe(any());
		vueloDto.setKeyTripulacion(any());
		vueloDto.setTripulantes(anyList());
		vueloDto.setObservacion(anyString());
		vueloDto.setEstado(anyString());

		Vuelo nroVuelo = iVueloRepository.findNroVuelo(anyString());
		Aeronave aeronave = iAeronaveRepository.FindByKey(any());
		// Aeronave nroVuelo = iVueloRepository.findNroVuelo(anyString());

		CrearVueloCommand command = new CrearVueloCommand(vueloDto);
		Vuelo response = handler.handle(command);
		verify(iVueloRepository).Create(response);
		verify(iUnitOfWork).commit();

		Assert.assertEquals(any(), response.getKey());
		Assert.assertEquals(anyString(), response.getNroVuelo());
		Assert.assertEquals(any(), response.getKeyAeronave());
		Assert.assertEquals(anyList(), response.getAsientos());
		Assert.assertEquals(anyString(), response.getOrigen());
		Assert.assertEquals(anyString(), response.getDestino());
		Assert.assertEquals(any(), response.getFechaSalida());
		Assert.assertEquals(any(), response.getFechaArribe());
		Assert.assertEquals(any(), response.getKeyTripulacion());
		Assert.assertEquals(anyList(), response.getTripulantes());

	}
}
