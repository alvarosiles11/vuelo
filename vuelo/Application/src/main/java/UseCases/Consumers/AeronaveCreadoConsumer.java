package UseCases.Consumers;

import fourteam.massTransit.IConsumer;
import fourteam.mediator.IMediator;

public class AeronaveCreadoConsumer extends IConsumer<IntegrationEvents.VueloCreado> {

	public static String QueueName = "vuelo-creado-vuelo-aeronave";

	public AeronaveCreadoConsumer(IMediator mediator) {
		System.out.println("Entro al constructor del consumer");
	}

	@Override
	public void Consume(IntegrationEvents.VueloCreado object) {
		System.out.println("Entro al consumers aeronave chaval");
	}
}
