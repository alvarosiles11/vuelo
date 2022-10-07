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
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;

public class EliminarVueloHandlerTest {

	IVueloFactory iVueloFactory = Mockito.mock(IVueloFactory.class);
	IVueloRepository iVueloRepository = Mockito.mock(IVueloRepository.class);
	IUnitOfWork iUnitOfWork = Mockito.mock(IUnitOfWork.class);

	// IAeronaveRepository iAeronaveRepository =
	// Mockito.mock(IAeronaveRepository.class);
	// ITripulacionRepository iTripulacionRepository =
	// Mockito.mock(ITripulacionRepository.class);

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
		final String observacion = "Abordando";
		final String estado = "1";
		final List<Asiento> asientos = new ArrayList<>();
		final List<Tripulante> tripulantes = new ArrayList<>();

		final Vuelo vuelo = new Vuelo(nroVuelo, keyAeronave, origen, destino, fechaSalida, fechaArribe, keyTripulacion,
				observacion, estado, asientos, tripulantes);
		vuelo.key = key;

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
		// UUID res = handler.handle(command);

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
		UUID response = handler.handle(command);
		Assert.assertEquals(vuelo.key, response);
	}

	// private List<Asiento> getListAsiento() {
	// return new ArrayList<>();
	// }

	// private List<Tripulante> getListdaTripulantes() {
	// return new ArrayList<>();
	// }

	@Test
  public void HandleFailed() throws Exception {
    when(iVueloRepository.FindByKey(any())).thenReturn(null);
    EliminarVueloHandler  handler = new EliminarVueloHandler(iVueloFactory, iVueloRepository, iUnitOfWork);


		// final UUID key = UUID.randomUUID();
		// final String nroVuelo = "scz-cba-513184";
		// final UUID keyAeronave = UUID.randomUUID();
		// final String origen = "Scz-ViruViru";
		// final String destino = "CBA-CBA";
		// final Date fechaSalida = new Date();
		// final Date fechaArribe = new Date();
		// final UUID keyTripulacion = UUID.randomUUID();


		VueloDto vueloDto = new VueloDto();

		vueloDto.setKey(UUID.randomUUID());
		vueloDto.setNroVuelo("scz-cba-513184");
		vueloDto.setKeyAeronave(UUID.randomUUID());
		vueloDto.setAsientos(new ArrayList<>());
		vueloDto.setOrigen("Scz-ViruViru");
		vueloDto.setDestino("CBA-CBA");
		vueloDto.setFechaSalida(new Date());
		vueloDto.setFechaArribe(new Date());
		vueloDto.setKeyTripulacion(UUID.randomUUID());
		vueloDto.setTripulantes(new ArrayList<>());

    EliminarVueloCommand command = new EliminarVueloCommand(vueloDto.getKey());
    try {
		UUID resp = handler.handle(command);
      } catch (HttpException e) {
      Assert.assertEquals(400, e.getCode());
    }
  }
}
