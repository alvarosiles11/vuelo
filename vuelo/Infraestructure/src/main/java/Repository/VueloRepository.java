package Repository;

import Context.IWriteDbContext;
import Model.Vuelos.Vuelo;
import Repositories.IVueloRepository;
import fourteam.db.DbSet;
import java.util.List;
import java.util.UUID;

public class VueloRepository implements IVueloRepository {

	private DbSet<Vuelo> _vuelos;

	public VueloRepository(IWriteDbContext database) {
		_vuelos = database.Vuelo;
	}

	@Override
	public List<Vuelo> GetAll() throws Exception {
		return _vuelos.All();
	}

	@Override
	public Vuelo FindByKey(UUID key) throws Exception {
		return _vuelos.Single(obj -> obj.key.equals(key));
	}

	@Override
	public void Create(Vuelo objVuelo) throws Exception {
		_vuelos.Add(objVuelo);
	}

	@Override
	public Vuelo Update(Vuelo objVuelo) throws Exception {
		_vuelos.Update(objVuelo, (it -> it.key.equals(objVuelo.key)));
		return objVuelo;
	}

	@Override
	public Vuelo Delete(Vuelo objVuelo) throws Exception {
		_vuelos.Delete((it -> it.key.equals(objVuelo.key)));
		return objVuelo;
	}

}
