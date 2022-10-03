package UseCases.Command.Vuelos.Eliminar;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Dto.VueloDto;
import Factories.IVueloFactory;
import Fourteam.http.Exception.HttpException;
import Model.Aeronaves.Asiento;
import Model.Tripulacion.Tripulante;
import Model.Vuelos.Vuelo;
import Repositories.IAeronaveRepository;
import Repositories.ITripulacionRepository;
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;

public class EliminarVueloHandlerTest {

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
		final List<Asiento> asientos = getListAsiento();
		final List<Tripulante> tripulantes = getListdaTripulantes();

		final Vuelo vuelo = new Vuelo(nroVuelo, keyAeronave, origen, destino, fechaSalida, fechaArribe, keyTripulacion,
				asientos,
				tripulantes);
		when(iVueloRepository.FindByKey(any())).thenReturn(vuelo);
		when(iVueloRepository.Delete(any())).thenReturn(vuelo);

		final EliminarVueloHandler handler = new EliminarVueloHandler(iVueloFactory, iVueloRepository, iUnitOfWork);
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

		final EliminarVueloCommand command = new EliminarVueloCommand(vueloDto.key);

		// command.vueloDto.setKey(key);
		// command.vueloDto.setNroVuelo(nroVuelo);
		// command.vueloDto.setKeyAeronave(keyAeronave);
		// command.vueloDto.setAsientos(new ArrayList<>());
		// command.vueloDto.setOrigen(origen);
		// command.vueloDto.setDestino(destino);
		// command.vueloDto.setFechaSalida(fechaSalida);
		// command.vueloDto.setFechaArribe(fechaArribe);
		// command.vueloDto.setKeyTripulacion(keyTripulacion);
		// command.vueloDto.setTripulantes(new ArrayList<>());

		// TDO coman editarvuelo handler en fourteam o sharekernel
		final Vuelo response = handler.handle(command);
		Assert.assertEquals(vuelo.key, response.getKey());
	}

	private List<Asiento> getListAsiento() {
		return new ArrayList();
	}

	private List<Tripulante> getListdaTripulantes() {
		return new ArrayList();
	}

	@Test
  public void HandleFailed() throws Exception {
    when(iVueloRepository.FindByKey(any())).thenReturn(null);
    EliminarVueloHandler  handler = new EliminarVueloHandler(iVueloFactory, iVueloRepository, iUnitOfWork);


		final UUID key = UUID.randomUUID();
		final String nroVuelo = "scz-cba-513184";
		final UUID keyAeronave = UUID.randomUUID();
		final String origen = "Scz-ViruViru";
		final String destino = "CBA-CBA";
		final Date fechaSalida = new Date();
		final Date fechaArribe = new Date();
		final UUID keyTripulacion = UUID.randomUUID();


		VueloDto vueloDto = new VueloDto();

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

    EliminarVueloCommand  command = new EliminarVueloCommand(vueloDto.getKey());
    try {
      Vuelo resp = handler.handle(command);
      // System.out.println(resp);
     } catch (HttpException e) {
      Assert.assertEquals(400, e.getCode());
    }
  }
}
