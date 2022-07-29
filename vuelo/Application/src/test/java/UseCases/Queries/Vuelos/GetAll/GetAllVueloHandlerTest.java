package UseCases.Queries.Vuelos.GetAll;

import Model.Vuelos.Vuelo;
import Repositories.IVueloRepository;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;

public class GetAllVueloHandlerTest {

  IVueloRepository _IVueloRepository = Mockito.mock(IVueloRepository.class);

  @Test
  public void dataValid() {
    GetAllVueloHandler handler = new GetAllVueloHandler(_IVueloRepository);
    GetAllVueloQuery query = new GetAllVueloQuery();
    List<Vuelo> listaVuelos = handler.handle(query);
    System.out.println(listaVuelos);
  }
}
