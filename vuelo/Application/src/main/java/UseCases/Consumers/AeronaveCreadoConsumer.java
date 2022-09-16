package UseCases.Consumers;

import fourteam.massTransit.IConsumer;
import fourteam.mediator.IMediator;

public class AeronaveCreadoConsumer extends IConsumer<IntegrationEvents.AeronaveCreado> {

	public static String QueueName = "vuelo-creado-vuelo-aeronave";

	public AeronaveCreadoConsumer(IMediator mediator) {
		System.out.println("Entro al constructor del consumer");
	}

	@Override
	public void Consume(IntegrationEvents.AeronaveCreado object) {
		System.out.println("Entro al consumers aeronave chaval");
	}
}
