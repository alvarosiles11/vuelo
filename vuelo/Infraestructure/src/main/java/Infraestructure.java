// import Repositories.*;
// import fourteam.extensions.IServiceCollection;
// import Context.IWriteDbContext;
// import Repository.*;

// import Repositories.IAeronaveRepository;
import Context.IWriteDbContext;
import Context.MongoDB.WriteDbContext;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;
// import Repository.AeronaveRepository;
import Repository.TripulanteRepository;
import Repository.VueloRepository;
import fourteam.extensions.IServiceCollection;

public class Infraestructure {

  public static void AddInfraestructure() {
    IServiceCollection.AddMediator();

    IServiceCollection.AddScoped(IWriteDbContext.class, WriteDbContext.class);
    IServiceCollection.AddScoped(IUnitOfWork.class, UnitOfWork.class);
    IServiceCollection.AddScoped(IVueloRepository.class, VueloRepository.class);
    IServiceCollection.AddScoped(
      ITripulanteRepository.class,
      TripulanteRepository.class
    );
    // IServiceCollection.AddScoped(IAeronaveRepository.class,
    // AeronaveRepository.class);

    Application.AddApplication();
  }
}
