import Factories.ITripulanteFactory;
import Factories.IVueloFactory;
import Factories.TripulanteFactory;
import Factories.VueloFactory;
import UseCases.Command.Tripulantes.Crear.CrearTripulanteHandler;
import UseCases.Command.Tripulantes.Editar.EditarTripulanteHandler;
import UseCases.Command.Tripulantes.Eliminar.EliminarTripulanteHandler;
import UseCases.Command.Tripulantes.UpdateTripulanteWhenVueloCreadoHandler;
import UseCases.Command.Vuelos.Crear.CrearVueloHandler;
import UseCases.Command.Vuelos.Editar.EditarVueloHandler;
import UseCases.Command.Vuelos.Eliminar.EliminarVueloHandler;
import UseCases.Queries.Tripulantes.GetAll.GetAllTripulanteHandler;
import UseCases.Queries.Tripulantes.GetByKey.GetTripulanteByKeyHandler;
import UseCases.Queries.Vuelos.GetAll.GetAllVueloHandler;
import UseCases.Queries.Vuelos.GetByKey.GetVueloByKeyHandler;
import fourteam.extensions.IServiceCollection;
import fourteam.mediator.IMediator;

public class Application {

  public static void AddApplication() {
    // INFO:Usamos el IMediator del kernel en cambio del MediatR de Spring
    IMediator.registerHandler(GetAllVueloHandler.class);
    IMediator.registerHandler(GetVueloByKeyHandler.class);
    IMediator.registerHandler(CrearVueloHandler.class);
    IMediator.registerHandler(EditarVueloHandler.class);
    IMediator.registerHandler(EliminarVueloHandler.class);

    // INFO:Tripulante
    IMediator.registerHandler(GetAllTripulanteHandler.class);
    IMediator.registerHandler(GetTripulanteByKeyHandler.class);
    IMediator.registerHandler(CrearTripulanteHandler.class);
    IMediator.registerHandler(EditarTripulanteHandler.class);
    IMediator.registerHandler(EliminarTripulanteHandler.class);

    IMediator.registerHandler(UpdateTripulanteWhenVueloCreadoHandler.class);
    IServiceCollection.AddTransient(IVueloFactory.class, VueloFactory.class);
    IServiceCollection.AddTransient(
      ITripulanteFactory.class,
      TripulanteFactory.class
    );

    Domain.addDomain();
  }
}
