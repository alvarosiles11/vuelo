
import Context.IWriteDbContext;
import Context.MongoDB.WriteDbContext;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;
import Repository.TripulanteRepository;
import Repository.VueloRepository;
import UseCases.Consumers.AeronaveCreadoConsumer;
import UseCases.Consumers.TripulacionCreadoConsumer;
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
			// config.AddConsumer(CheckInCreadoConsumer.class).Endpoint(endpoint -> {
			// endpoint.Name = CheckInCreadoConsumer.QueueName;
			// });
			// config.AddConsumer(CheckInCreadoConsumer.class);
			config.AddConsumer(AeronaveCreadoConsumer.class);
			config.AddConsumer(TripulacionCreadoConsumer.class);

			config.UsingRabbitMq((context, cfg) -> {
				cfg.Host = "192.168.3.2";
				// cfg.ReceiveEndpoint(CheckInCreadoConsumer.QueueName, endpoint -> {
				// endpoint.ConfigureConsumer(CheckInCreadoConsumer.class);
				// });
			});
		});
	}

}
