import Controllers.TripulanteController;
import Controllers.VueloController;
import fourteam.http.Rest;

public class WebApi {

  public static void AddControllers() {
    Rest.addController(VueloController.class);
    Rest.addController(TripulanteController.class);
    Rest.createSwagger();

    Rest.start(8080);
  }
}
