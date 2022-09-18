
// import java.io.IOException;
// import java.net.URISyntaxException;
import Controllers.TripulanteController;
import Controllers.VueloController;
import Fourteam.config.Config;
import Fourteam.http.Rest;

public class WebApi {

  public static void AddControllers() {
    Rest.addController(VueloController.class);
    Rest.addController(TripulanteController.class);
    Rest.start(Integer.parseInt(Config.getProperty("http.port")));
		// Rest.createSwagger();
		// openApi();
  }


	// public static void openApi() {
	// 	if (java.awt.Desktop.isDesktopSupported()) {
	// 		java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
	// 		if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
	// 			try {
	// 				java.net.URI uri = new java.net.URI("http://localhost:"+Integer.parseInt(Config.getProperty("http.port"))+"/swagger.html");
	// 				desktop.browse(uri);
	// 			} catch (URISyntaxException | IOException ex) {
	// 			}
	// 		}
	// 	}
	// }

}
