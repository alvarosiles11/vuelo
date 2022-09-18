package UseCases.Consumers;

import Fourteam.massTransit.IConsumer;

public class AeronaveCreadoConsumer extends IConsumer<IntegrationEvents.AeronaveCreado> {


	public AeronaveCreadoConsumer() {
	}

	@Override
	public void Consume(IntegrationEvents.AeronaveCreado object) {
		System.out.println(object);
		// _AeronaveRepository.Create(arg0);
		// TODO: guardar aeronave en la base

	}
}
