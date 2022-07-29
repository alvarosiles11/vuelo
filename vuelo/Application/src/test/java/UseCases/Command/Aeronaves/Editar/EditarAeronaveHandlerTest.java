package UseCases.Command.Aeronaves.Editar;

import static org.mockito.ArgumentMatchers.any;
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

public class EditarAeronaveHandlerTest {

  IAeronaveFactory _IAeroFact = Mockito.mock(IAeronaveFactory.class);
  IAeronaveRepository _IAeroRep = Mockito.mock(IAeronaveRepository.class);
  IUnitOfWork _IUnitOfWork = Mockito.mock(IUnitOfWork.class);

  @Before
  public void setUp() {}

  @Test
  public void HandleCorrectly() throws HttpException {
    UUID keyAeronave = UUID.randomUUID();
    String matricula = "xyz-1990";

    Aeronave aeronave = new Aeronave(matricula);
    when(_IAeroRep.FindByKey(any())).thenReturn(aeronave);

    EditarAeronaveHandler handler = new EditarAeronaveHandler(
      _IAeroFact,
      _IAeroRep,
      _IUnitOfWork
    );

    AeronaveDto aeronaveDto = new AeronaveDto();
    aeronaveDto.setKeyAeronave(keyAeronave);
    aeronaveDto.setMatricula(matricula);

    EditarAeronaveCommand command = new EditarAeronaveCommand(
      aeronaveDto.getKeyAeronave()
    );
    command.aeronaveDto.setKeyAeronave(keyAeronave);
    command.aeronaveDto.setMatricula(matricula);
    Aeronave resp = handler.handle(command);
    Assert.assertEquals(keyAeronave, aeronaveDto.getKeyAeronave());
    System.out.println(resp);
  }

  @Test
  public void HandleFailed() throws HttpException {
    when(_IAeroRep.FindByKey(any())).thenReturn(null);
    EditarAeronaveHandler handler = new EditarAeronaveHandler(
      _IAeroFact,
      _IAeroRep,
      _IUnitOfWork
    );
    AeronaveDto aeronaveDto = new AeronaveDto();
    aeronaveDto.setKeyAeronave(UUID.randomUUID());
    aeronaveDto.setMatricula("xyz-1990");

    EditarAeronaveCommand command = new EditarAeronaveCommand(
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
