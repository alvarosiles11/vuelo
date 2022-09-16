import Controllers.TripulanteController;
import Controllers.VueloController;
import fourteam.http.Rest;

public class WebApi {

  public static void AddControllers() {
    Rest.addController(VueloController.class);
    Rest.addController(TripulanteController.class);
    Rest.start(8080);
		Rest.createSwagger();
  }
}
