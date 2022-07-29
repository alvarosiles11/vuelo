package UseCases.Queries.Tripulantes.GetByKey;

import fourteam.http.Exception.HttpException;
import java.util.UUID;
import org.junit.Test;

public class GetTripulanteByKeyQueryTest {

  @Test
  public void HandleCorrectly() throws HttpException {
    UUID key = UUID.randomUUID();
    GetTripulanteByKeyQuery query = new GetTripulanteByKeyQuery(key);
    System.out.println(query);
  }
}
