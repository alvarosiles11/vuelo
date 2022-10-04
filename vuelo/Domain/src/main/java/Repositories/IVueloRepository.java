package Repositories;

import Model.Vuelos.Vuelo;
import core.IRepository;
import java.util.List;
import java.util.UUID;

public interface IVueloRepository extends IRepository<Vuelo, UUID> {
	public List<Vuelo> GetAll() throws Exception;

	public Vuelo Delete(Vuelo vuelo) throws Exception;

	public Vuelo Update(Vuelo vuelo) throws Exception;

	public Vuelo findNroVuelo(String nro) throws Exception;
}