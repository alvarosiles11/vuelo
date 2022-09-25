import Factories.AeronaveFactory;
import Factories.IAeronaveFactory;
import Factories.ITripulacionFactory;
import Factories.IVueloFactory;
import Factories.TripulacionFactory;
import Factories.VueloFactory;
import Fourteam.extensions.IServiceCollection;
import Fourteam.mediator.IMediator;
import UseCases.Command.Aeronaves.Crear.CrearAeronaveHandler;
import UseCases.Command.Aeronaves.Editar.EditarAeronaveHandler;
import UseCases.Command.Aeronaves.Eliminar.EliminarAeronaveHandler;
import UseCases.Command.Asiento.Editar.EditarAsientoHandler;
import UseCases.Command.Tripulacion.Crear.CrearTripulacionHandler;
import UseCases.Command.Tripulacion.Editar.EditarTripulacionHandler;
import UseCases.Command.Tripulacion.Eliminar.EliminarTripulacionHandler;
import UseCases.Command.Vuelos.Crear.CrearVueloHandler;
import UseCases.Command.Vuelos.Editar.EditarVueloHandler;
import UseCases.Command.Vuelos.Eliminar.EliminarVueloHandler;
import UseCases.DomainEventHandler.Vuelo.PublishIntegrationEventWhenVueloCreadoHandler;
import UseCases.Queries.Aeronave.GetAll.GetAllAeronaveHandler;
import UseCases.Queries.Aeronave.GetByKey.GetAeronaveByKeyHandler;
import UseCases.Queries.Tripulacion.GetAll.GetAllTripulacionHandler;
import UseCases.Queries.Tripulacion.GetByKey.GetTripulacionByKeyHandler;
import UseCases.Queries.Vuelos.GetAll.GetAllVueloHandler;
import UseCases.Queries.Vuelos.GetByKey.GetVueloByKeyHandler;

public class Application {

	public static void AddApplication() {
		// USE CASE: VUELO
		IMediator.registerHandler(GetAllVueloHandler.class);
		IMediator.registerHandler(GetVueloByKeyHandler.class);
		IMediator.registerHandler(CrearVueloHandler.class);
		IMediator.registerHandler(EditarVueloHandler.class);
		IMediator.registerHandler(EliminarVueloHandler.class);

		// USE CASE:Tripulacion
		IMediator.registerHandler(GetAllTripulacionHandler.class);
		IMediator.registerHandler(GetTripulacionByKeyHandler.class);
		IMediator.registerHandler(CrearTripulacionHandler.class);
		IMediator.registerHandler(EditarTripulacionHandler.class);
		IMediator.registerHandler(EliminarTripulacionHandler.class);

		// USE CASE:Aeronave
		IMediator.registerHandler(GetAllAeronaveHandler.class);
		IMediator.registerHandler(GetAeronaveByKeyHandler.class);
		IMediator.registerHandler(CrearAeronaveHandler.class);
		IMediator.registerHandler(EditarAeronaveHandler.class);
		IMediator.registerHandler(EliminarAeronaveHandler.class);

		// USE CASE:Asiento
		IMediator.registerHandler(EditarAsientoHandler.class);

		// publish
		IMediator.registerHandler(PublishIntegrationEventWhenVueloCreadoHandler.class);

		// Transient
		IServiceCollection.AddTransient(IVueloFactory.class, VueloFactory.class);
		IServiceCollection.AddTransient(IAeronaveFactory.class, AeronaveFactory.class);
		IServiceCollection.AddTransient(ITripulacionFactory.class, TripulacionFactory.class);
		Domain.addDomain();
	}
}
