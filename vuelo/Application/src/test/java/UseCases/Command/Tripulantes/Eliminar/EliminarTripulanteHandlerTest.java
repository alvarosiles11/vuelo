package UseCases.Command.Tripulantes.Eliminar;

import static org.mockito.ArgumentMatchers.any;
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

public class EliminarTripulanteHandlerTest {

  ITripulanteFactory _ITripFact = Mockito.mock(ITripulanteFactory.class);
  ITripulanteRepository _ITripRep = Mockito.mock(ITripulanteRepository.class);
  IUnitOfWork _IUnitOfWork = Mockito.mock(IUnitOfWork.class);

  private UUID keyVuelo = UUID.randomUUID();
  private String keyTripulante = "12345";
  private String cargo = "Piloto";

  @Before
  public void setUp() {}

  @Test
  public void HandleCorrectly() throws HttpException {
    Tripulante tripulante = new Tripulante(keyVuelo, keyTripulante, cargo);

    TripulanteDto tripulanteDto = new TripulanteDto();
    tripulanteDto.setKeyVuelo(UUID.randomUUID());
    tripulanteDto.setKeyTripulante("12345");
    tripulanteDto.setCargo("Piloto");

    EliminarTripulanteCommand command = new EliminarTripulanteCommand(
      tripulanteDto.getKeyVuelo()
    );

    EliminarTripulanteHandler handler = new EliminarTripulanteHandler(
      _ITripFact,
      _ITripRep,
      _IUnitOfWork
    );

    when(_ITripRep.FindByKey(any())).thenReturn(tripulante);

    Tripulante resp = handler.handle(command);
    System.out.println(resp);
    verify(_ITripRep).Delete(tripulante);
  }

  @Test
  public void HandleFailed() throws HttpException {
    when(_ITripRep.FindByKey(any())).thenReturn(null);

    EliminarTripulanteHandler handler = new EliminarTripulanteHandler(
      _ITripFact,
      _ITripRep,
      _IUnitOfWork
    );

    TripulanteDto tripulanteDto = new TripulanteDto();
    tripulanteDto.setKeyVuelo(UUID.randomUUID());
    tripulanteDto.setKeyTripulante("12345");
    tripulanteDto.setCargo("Piloto");

    EliminarTripulanteCommand command = new EliminarTripulanteCommand(
      tripulanteDto.getKeyVuelo()
    );

    try {
      Tripulante resp = handler.handle(command);
      System.out.println(resp);
    } catch (HttpException e) {
      Assert.assertEquals(400, e.getCode());
    }
  }
}
