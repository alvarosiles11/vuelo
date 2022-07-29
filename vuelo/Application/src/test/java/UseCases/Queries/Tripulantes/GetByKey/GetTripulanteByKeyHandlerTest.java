package UseCases.Queries.Tripulantes.GetByKey;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import Dto.TripulanteDto;
import Model.Vuelos.Tripulante;
import Repositories.ITripulanteRepository;
import fourteam.http.Exception.HttpException;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GetTripulanteByKeyHandlerTest {

  ITripulanteRepository _ITripRep = Mockito.mock(ITripulanteRepository.class);

  @Test
  public void HandleCorrectly() throws HttpException {
    UUID key = UUID.randomUUID();
    UUID keyVuelo = UUID.randomUUID();
    String keyTripulante = "12345";
    String cargo = "Piloto";

    Tripulante tripulante = new Tripulante(keyVuelo, keyTripulante, cargo);
    when(_ITripRep.FindByKey(any())).thenReturn(tripulante);

    TripulanteDto tripulanteDto = new TripulanteDto();
    tripulanteDto.setKey(key);
    tripulanteDto.setKeyVuelo(keyVuelo);
    tripulanteDto.setKeyTripulante(keyTripulante);
    tripulanteDto.setCargo(cargo);

    GetTripulanteByKeyHandler handler = new GetTripulanteByKeyHandler(
      _ITripRep
    );
    GetTripulanteByKeyQuery command = new GetTripulanteByKeyQuery(
      tripulanteDto.getKey()
    );
    TripulanteDto resp = handler.handle(command);
    System.out.println(resp);
  }

  @Test
  public void HandleFailed() throws HttpException {
    UUID key = UUID.randomUUID();

    Tripulante tripulante = new Tripulante(
      UUID.randomUUID(),
      "12345",
      "Piloto"
    );
    when(_ITripRep.FindByKey(any())).thenReturn(any());

    TripulanteDto tripulanteDto = new TripulanteDto();

    tripulanteDto.setKey(UUID.randomUUID());
    tripulanteDto.setKeyVuelo(UUID.randomUUID());
    tripulanteDto.setKeyTripulante("12345");
    tripulanteDto.setCargo("Piloto");

    GetTripulanteByKeyHandler handler = new GetTripulanteByKeyHandler(
      _ITripRep
    );
    GetTripulanteByKeyQuery command = new GetTripulanteByKeyQuery(
      tripulanteDto.getKey()
    );
    System.out.println(key);
    try {
      TripulanteDto respa = handler.handle(command);
      System.out.println(tripulante + "" + respa);
    } catch (HttpException e) {
      Assert.assertEquals(400, e.getCode());
    }
  }
}
