package UseCases.DomainEventHandler.Vuelo;

import IntegrationEvents.VueloCreado;
import core.ConfirmedDomainEvent;
import fourteam.massTransit.IPublishEndpoint;
import fourteam.mediator.Notification;
import fourteam.mediator.NotificationHandler;

public class PublishIntegrationEventWhenVueloCreadoHandler implements NotificationHandler<ConfirmedDomainEvent<VueloCreado>> {

	private IPublishEndpoint publishEndpoint;

  public PublishIntegrationEventWhenVueloCreadoHandler(IPublishEndpoint publishEndpoint) {
    this.publishEndpoint = publishEndpoint;
  }

  @Override
  public void handle(Notification notification) {
    ConfirmedDomainEvent event = (ConfirmedDomainEvent) notification;
    VueloCreado vuelo = (VueloCreado) event.DomainEvent;
    IntegrationEvents.VueloCreado evento = new IntegrationEvents.VueloCreado();
		evento.setKey(vuelo.getKey());
		evento.setNroVuelo(vuelo.getNroVuelo());
		evento.setKeyAeronave(vuelo.getKeyAeronave());
		evento.setKeyAeropuertoOrigen(vuelo.getKeyAeropuertoOrigen());
		evento.setKeyAeropuertoDestino(vuelo.getKeyAeropuertoDestino());
		evento.setFechaSalida(vuelo.getFechaSalida());
		evento.setFechaArribe(vuelo.getFechaArribe());
    this.publishEndpoint.Publish(evento);
  }
}
