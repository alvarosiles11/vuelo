package UseCases.Command.Tripulantes.Crear;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Dto.TripulanteDto;
import Factories.ITripulanteFactory;
import Model.Vuelos.Tripulante;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;
import fourteam.http.Exception.HttpException;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CrearTripulanteHandlerTest {

  ITripulanteFactory _ITripulanteFactory = Mockito.mock(
    ITripulanteFactory.class
  );
  ITripulanteRepository _ITripulanteRepository = Mockito.mock(
    ITripulanteRepository.class
  );
  IUnitOfWork _IUnitOfWork = Mockito.mock(IUnitOfWork.class);

  @Before
  public void setUp() {}

  @Test
  public void HandleCorrectly() throws HttpException {
    UUID keyVuelo = UUID.randomUUID();
    String keyTripulante = "12345";
    String cargo = "Piloto";

    Tripulante tripulante = new Tripulante(keyVuelo, keyTripulante, cargo);
    when(_ITripulanteFactory.Create(keyVuelo, keyTripulante, cargo))
      .thenReturn(tripulante);

    CrearTripulanteHandler handler = new CrearTripulanteHandler(
      _ITripulanteFactory,
      _ITripulanteRepository,
      _IUnitOfWork
    );
    TripulanteDto tripulanteDto = new TripulanteDto();

    tripulanteDto.setKeyVuelo(keyVuelo);
    tripulanteDto.setKeyTripulante(keyTripulante);
    tripulanteDto.setCargo(cargo);
    CrearTripulanteCommand command = new CrearTripulanteCommand(tripulanteDto);

    Tripulante resp = handler.handle(command);
    verify(_ITripulanteRepository).Create(resp);

    verify(_IUnitOfWork).commit();
    Assert.assertEquals(keyVuelo, resp.getKeyVuelo());
    Assert.assertEquals(keyTripulante, resp.getKeyTripulante());
    Assert.assertEquals(cargo, resp.getCargo());
  }
}
