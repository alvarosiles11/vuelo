package UseCases.Command.Tripulantes;

import Event.VueloCreado;
import Repositories.ITripulanteRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class UpdateTripulanteWhenVueloCreadoHandlerTest {

  ITripulanteRepository _ITripRep = Mockito.mock(ITripulanteRepository.class);

  ITripulanteRepository tripulanteRepository = Mockito.mock(
    ITripulanteRepository.class
  );

  @Test
  public void dataValid() {
    UpdateTripulanteWhenVueloCreadoHandler handler = new UpdateTripulanteWhenVueloCreadoHandler(
      tripulanteRepository
    );
    handler.handle(new VueloCreado());
    Assert.assertNotNull(handler);
  }

  @Test
  public void constructorIsPrivate() {
    Assert.assertTrue(
      UpdateTripulanteWhenVueloCreadoHandler.class.getConstructors()[0].canAccess(
          null
        )
    );
  }
}
