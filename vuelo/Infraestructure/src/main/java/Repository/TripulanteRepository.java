package Repository;

import Context.IWriteDbContext;
import Model.Vuelos.Tripulante;
import Repositories.ITripulanteRepository;
import Fourteam.db.DbSet;
import java.util.List;
import java.util.UUID;

public class TripulanteRepository implements ITripulanteRepository {

	private DbSet<Tripulante> _tripulante;

	public TripulanteRepository(IWriteDbContext database) {
		_tripulante = database.Tripulante;
	}

	@Override
	public List<Tripulante> GetAll() throws Exception {
		return _tripulante.All();
	}

	@Override
	public Tripulante FindByKey(UUID key) throws Exception {
		return _tripulante.Single(obj -> obj.key.equals(key));
	}

	@Override
	public void Create(Tripulante objTripulante) throws Exception {
		_tripulante.Add(objTripulante);
	}

	@Override
	public Tripulante Update(Tripulante objTripulante) throws Exception {
		_tripulante.Update(objTripulante, (it -> it.key.equals(objTripulante.key)));
		return objTripulante;
	}

	@Override
	public Tripulante Delete(Tripulante objTripulante) throws Exception {
		_tripulante.Delete((it -> it.key.equals(objTripulante.key)));
		return objTripulante;
	}
}
