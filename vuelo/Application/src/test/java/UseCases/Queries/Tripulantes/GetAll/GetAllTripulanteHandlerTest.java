package UseCases.Queries.Tripulantes.GetAll;

import Model.Vuelos.Tripulante;
import Repositories.ITripulanteRepository;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;

public class GetAllTripulanteHandlerTest {

  ITripulanteRepository _ITripulanteRepository = Mockito.mock(
    ITripulanteRepository.class
  );

  @Test
  public void dataValid() {
    GetAllTripulanteHandler handler = new GetAllTripulanteHandler(
      _ITripulanteRepository
    );
    GetAllTripulanteQuery query = new GetAllTripulanteQuery();
    List<Tripulante> listaTripulante = handler.handle(query);
    System.out.println(listaTripulante);
  }
}
