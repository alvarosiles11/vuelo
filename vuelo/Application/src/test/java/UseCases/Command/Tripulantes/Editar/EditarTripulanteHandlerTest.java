package UseCases.Command.Tripulantes.Editar;

import static org.mockito.ArgumentMatchers.any;
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

public class EditarTripulanteHandlerTest {

  ITripulanteFactory _ITripFact = Mockito.mock(ITripulanteFactory.class);
  ITripulanteRepository _ITripRep = Mockito.mock(ITripulanteRepository.class);
  IUnitOfWork _IUnitOfWork = Mockito.mock(IUnitOfWork.class);

  private UUID key = UUID.randomUUID();
  private UUID keyVuelo = UUID.randomUUID();
  private String keyTripulante = "12345";
  private String cargo = "Piloto";

  @Before
  public void setUp() {}

  @Test
  public void HandleCorrectly() throws HttpException {
    Tripulante tripulante = new Tripulante(keyVuelo, keyTripulante, cargo);
    when(_ITripRep.FindByKey(any())).thenReturn(tripulante);

    EditarTripulanteHandler handler = new EditarTripulanteHandler(
      _ITripFact,
      _ITripRep,
      _IUnitOfWork
    );

    TripulanteDto tripulanteDto = new TripulanteDto();
    tripulanteDto.setKey(key);
    tripulanteDto.setKeyVuelo(keyVuelo);
    tripulanteDto.setKeyTripulante(keyTripulante);
    tripulanteDto.setCargo(cargo);

    EditarTripulanteCommand command = new EditarTripulanteCommand(
      tripulanteDto.getKey()
    );
    command.tripulanteDto.setKeyVuelo(keyVuelo);
    command.tripulanteDto.setKeyTripulante(keyTripulante);
    command.tripulanteDto.setCargo(cargo);
    Tripulante resp = handler.handle(command);
    System.out.println(resp);
  }

  @Test
  public void HandleFailed() throws HttpException {
    when(_ITripRep.FindByKey(any())).thenReturn(null);

    EditarTripulanteHandler handler = new EditarTripulanteHandler(
      _ITripFact,
      _ITripRep,
      _IUnitOfWork
    );

    TripulanteDto tripulanteDto = new TripulanteDto();

    tripulanteDto.setKey(UUID.randomUUID());
    tripulanteDto.setKeyVuelo(UUID.randomUUID());
    tripulanteDto.setKeyTripulante("12345");
    tripulanteDto.setCargo("Piloto");

    EditarTripulanteCommand command = new EditarTripulanteCommand(
      tripulanteDto.getKey()
    );

    try {
      Tripulante resp = handler.handle(command);
      System.out.println(resp);
    } catch (HttpException e) {
      Assert.assertEquals(400, e.getCode());
    }
  }
}
