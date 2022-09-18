package UseCases.Command.Vuelos.Crear;

import Factories.IVueloFactory;
import Model.Vuelos.Vuelo;
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;
import Fourteam.mediator.RequestHandler;

public class CrearVueloHandler
		implements RequestHandler<CrearVueloCommand, Vuelo> {

	private IVueloFactory iVueloFactory;
	private IVueloRepository iVueloRepository;
	private IUnitOfWork unitOfWor;

	public CrearVueloHandler(
			IVueloFactory iVueloFactory,
			IVueloRepository iVueloRepository,
			IUnitOfWork unitOfWork) {
		this.iVueloFactory = iVueloFactory;
		this.iVueloRepository = iVueloRepository;
		this.unitOfWor = unitOfWork;
	}

	@Override
	public Vuelo handle(CrearVueloCommand arg0) throws Exception {
		Vuelo vuelo = iVueloFactory.Create(
				arg0.nroVuelo,
				arg0.keyAeronave,
				arg0.keyAeropuertoOrigen,
				arg0.keyAeropuertoDestino,
				arg0.fechaSalida,
				arg0.fechaArribe,
				arg0.keyTripulacion

		);
		vuelo.eventCreado();
		iVueloRepository.Create(vuelo);
		unitOfWor.commit();
		return vuelo;
	}
}
