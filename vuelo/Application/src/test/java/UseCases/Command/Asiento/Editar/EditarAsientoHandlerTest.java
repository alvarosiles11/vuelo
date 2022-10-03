package UseCases.Command.Asiento.Editar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Factories.IVueloFactory;
import Repositories.IAeronaveRepository;
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;

public class EditarAsientoHandlerTest {
	IVueloFactory iVueloFactory = Mockito.mock(IVueloFactory.class);
	IVueloRepository iVueloRepository = Mockito.mock(IVueloRepository.class);
	IAeronaveRepository iAeronaveRepository = Mockito.mock(IAeronaveRepository.class);
	IUnitOfWork iUnitOfWork = Mockito.mock(IUnitOfWork.class);

	@Before
	public void setUp() {
	}

	@Test
	public void HandleCorrectly() throws Exception {
		// UUID keyAeronave = UUID.randomUUID();
		// String matricula = "xyz-1990";
		// String estado = "1";

		// Vuelo vuelo = new Vuelo(keyAeronave, matricula, estado);

		// Aeronave aeronave = new Aeronave(keyAeronave, matricula, estado);
		// when(iAeronaveFactory.Create(keyAeronave, matricula,
		// estado)).thenReturn(aeronave);

		// CrearAeronaveHandler handler = new CrearAeronaveHandler(iAeronaveFactory,
		// iAeronaveRepository, iUnitOfWork);

		// AeronaveDto aeronaveDto = new AeronaveDto();
		// aeronaveDto.setKeyAeronave(keyAeronave);
		// aeronaveDto.setMatricula(matricula);
		// aeronaveDto.setEstado(estado);

		// CrearAeronaveCommand command = new CrearAeronaveCommand(aeronaveDto);
		// Aeronave resp = handler.handle(command);

		// verify(iAeronaveRepository).Create(resp);
		// verify(iUnitOfWork).commit();

		// // Assert.assertEquals(
		// // AeronaveCreado.class,
		// // resp.domainEvents.get(0).getClass());

		// Assert.assertEquals(matricula, resp.matricula);
		// Assert.assertEquals(keyAeronave, resp.key);
		// Assert.assertEquals(matricula, resp.matricula);

	}
}
