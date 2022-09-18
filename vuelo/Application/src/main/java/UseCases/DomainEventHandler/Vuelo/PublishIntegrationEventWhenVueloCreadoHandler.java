package UseCases.DomainEventHandler.Vuelo;

import java.util.ArrayList;
import java.util.List;

import Event.VueloCreado;
import Fourteam.massTransit.IPublishEndpoint;
import Fourteam.mediator.Notification;
import Fourteam.mediator.NotificationHandler;
import core.ConfirmedDomainEvent;

public class PublishIntegrationEventWhenVueloCreadoHandler
		implements NotificationHandler<ConfirmedDomainEvent<VueloCreado>> {

	private IPublishEndpoint publishEndpoint;

	public PublishIntegrationEventWhenVueloCreadoHandler(IPublishEndpoint publishEndpoint) {
		this.publishEndpoint = publishEndpoint;
	}

	@Override
	public void handle(Notification notification) {
		ConfirmedDomainEvent event = (ConfirmedDomainEvent) notification;
		VueloCreado vuelo = (VueloCreado) event.DomainEvent;
		IntegrationEvents.VueloCreado evento = new IntegrationEvents.VueloCreado();
		evento.Key = vuelo.getKey();
		evento.setNroVuelo(vuelo.getNroVuelo());
		evento.setKeyAeronave(vuelo.getKeyAeronave());
		evento.setKeyAeropuertoOrigen(vuelo.getKeyAeropuertoOrigen());
		evento.setKeyAeropuertoDestino(vuelo.getKeyAeropuertoDestino());
		evento.setFechaSalida(vuelo.getFechaSalida());
		evento.setFechaArribe(vuelo.getFechaArribe());
		evento.setKeyTripulacion(vuelo.getKeyTripulacion());
		List<IntegrationEvents.dto.AsientoDto> arr = new ArrayList<>();
		vuelo.getListaAsientos().iterator().forEachRemaining(asiento -> {
			IntegrationEvents.dto.AsientoDto asientoDto = new IntegrationEvents.dto.AsientoDto();
			asientoDto.key = asiento.key;
			asientoDto.numero = asiento.numero + "";
			asientoDto.clase = asiento.clase;
			// IntegrationEvents.VueloCreado.Asiento asient = new
			// IntegrationEvents.VueloCreado.Asiento();
			arr.add(asientoDto);
		});

		evento.setListaAsientos(arr);
		// evento.setListaTripulantes(vuelo.getListaTripulantes());

		this.publishEndpoint.Publish(evento);
	}
}
