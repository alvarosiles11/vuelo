package UseCases.Command.Tripulantes;

import Event.VueloCreado;
import Repositories.ITripulanteRepository;
import fourteam.mediator.Notification;
import fourteam.mediator.NotificationHandler;

public class UpdateTripulanteWhenVueloCreadoHandler
  implements NotificationHandler<VueloCreado> {

  protected ITripulanteRepository iTripulanteRepository;

  public UpdateTripulanteWhenVueloCreadoHandler(
    ITripulanteRepository _iTripulanteRepository
  ) {
    this.iTripulanteRepository = _iTripulanteRepository;
  }

  @Override
  public void handle(Notification notification) {
    System.out.println(notification);
  }
}
