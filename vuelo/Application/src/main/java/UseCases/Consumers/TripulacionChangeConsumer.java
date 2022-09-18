package UseCases.Consumers;

import Fourteam.massTransit.IConsumer;
import Fourteam.mediator.IMediator;

public class TripulacionChangeConsumer extends IConsumer<IntegrationEvents.TripulacionChange> {

	public static String QueueName = "vuelo-creado-vuelo-Tripulacion";

	public TripulacionChangeConsumer(IMediator mediator) {
		System.out.println("Entro al constructor del consumer");
	}

	@Override
	public void Consume(IntegrationEvents.TripulacionChange object) {
		System.out.println("Entro al consumers tripulacion chaval");
	}
}