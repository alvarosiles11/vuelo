
import Context.IWriteDbContext;
import Context.MongoDB.WriteDbContext;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;
import Repository.TripulanteRepository;
import Repository.VueloRepository;
import UseCases.Consumers.AeronaveCreadoConsumer;
import UseCases.Consumers.TripulacionCreadoConsumer;
import fourteam.config.Config;
import fourteam.extensions.IServiceCollection;

public class Infraestructure {

	public static void AddInfraestructure() {
		IServiceCollection.AddMediator();
		IServiceCollection.AddScoped(IWriteDbContext.class, WriteDbContext.class);
		IServiceCollection.AddScoped(IUnitOfWork.class, UnitOfWork.class);
		IServiceCollection.AddScoped(IVueloRepository.class, VueloRepository.class);
		IServiceCollection.AddScoped(ITripulanteRepository.class, TripulanteRepository.class);
		Application.AddApplication();
		AddRabbitMq();
	}

	private static void AddRabbitMq() {
		IServiceCollection.AddMassTransit(config -> {
			config.AddConsumer(AeronaveCreadoConsumer.class);
			config.AddConsumer(TripulacionCreadoConsumer.class);

			config.UsingRabbitMq((context, cfg) -> {
				cfg.Host = Config.getProperty("rabit.host");
				cfg.User = Config.getProperty("rabit.user");
				cfg.Password = Config.getProperty("rabit.pass");
			});
		});
	}

}
