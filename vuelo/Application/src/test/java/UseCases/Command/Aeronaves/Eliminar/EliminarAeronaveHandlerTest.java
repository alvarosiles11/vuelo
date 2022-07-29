package UseCases.Command.Aeronaves.Eliminar;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Dto.AeronaveDto;
import Factories.IAeronaveFactory;
import Model.Aeronaves.Aeronave;
import Repositories.IAeronaveRepository;
import Repositories.IUnitOfWork;
import fourteam.http.Exception.HttpException;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class EliminarAeronaveHandlerTest {

  IAeronaveFactory _IAeroFact = Mockito.mock(IAeronaveFactory.class);
  IAeronaveRepository _IAeroRep = Mockito.mock(IAeronaveRepository.class);
  IUnitOfWork _IUnitOfWork = Mockito.mock(IUnitOfWork.class);

  @Before
  public void setUp() {}

  @Test
  public void HandleCorrectly() throws HttpException {
    String matricula = "xyz-1990";

    Aeronave aeronave = new Aeronave(matricula);

    AeronaveDto aeronaveDto = new AeronaveDto();
    aeronaveDto.setKeyAeronave(UUID.randomUUID());
    aeronaveDto.setMatricula("ABC");

    EliminarAeronaveCommand commandElin = new EliminarAeronaveCommand(
      aeronaveDto.getKeyAeronave()
    );

    EliminarAeronaveHandler handler = new EliminarAeronaveHandler(
      _IAeroFact,
      _IAeroRep,
      _IUnitOfWork
    );
    when(_IAeroRep.FindByKey(any())).thenReturn(aeronave);
    Aeronave respuestaELimin = handler.handle(commandElin);
    System.out.println(respuestaELimin);
    verify(_IAeroRep).Delete(aeronave);
  }

  @Test
  public void HandleFailed() throws HttpException {
    when(_IAeroRep.FindByKey(any())).thenReturn(null);
    EliminarAeronaveHandler handler = new EliminarAeronaveHandler(
      _IAeroFact,
      _IAeroRep,
      _IUnitOfWork
    );
    AeronaveDto aeronaveDto = new AeronaveDto();
    aeronaveDto.setKeyAeronave(UUID.randomUUID());
    aeronaveDto.setMatricula("ABC");

    EliminarAeronaveCommand command = new EliminarAeronaveCommand(
      aeronaveDto.getKeyAeronave()
    );
    try {
      Aeronave resp = handler.handle(command);
      System.out.println(resp);
    } catch (HttpException e) {
      Assert.assertEquals(400, e.getCode());
    }
  }
}
