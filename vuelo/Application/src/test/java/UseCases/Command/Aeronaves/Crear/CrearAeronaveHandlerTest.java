package UseCases.Command.Aeronaves.Crear;

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

public class CrearAeronaveHandlerTest {

  IAeronaveFactory _IAeronaveFactory = Mockito.mock(IAeronaveFactory.class);
  IAeronaveRepository _IAeronaveRepository = Mockito.mock(
    IAeronaveRepository.class
  );
  IUnitOfWork _IUnitOfWork = Mockito.mock(IUnitOfWork.class);

  @Before
  public void setUp() {}

  @Test
  public void HandleCorrectly() throws HttpException {
    UUID keyAeronave = UUID.randomUUID();
    String matricula = "xyz-1990";

    Aeronave aeronave = new Aeronave(matricula);
    when(_IAeronaveFactory.Create(matricula)).thenReturn(aeronave);

    CrearAeronaveHandler handler = new CrearAeronaveHandler(
      _IAeronaveFactory,
      _IAeronaveRepository,
      _IUnitOfWork
    );

    AeronaveDto aeronaveDto = new AeronaveDto();
    aeronaveDto.setKeyAeronave(keyAeronave);
    aeronaveDto.setMatricula(matricula);

    CrearAeronaveCommand command = new CrearAeronaveCommand(aeronaveDto);
    Aeronave resp = handler.handle(command);

    verify(_IAeronaveRepository).Create(resp);
    verify(_IUnitOfWork).commit();
    Assert.assertEquals(matricula, resp.matricula);
  }
}
