package Repositories;

import Model.Vuelos.Tripulante;
import core.IRepository;
import java.util.List;
import java.util.UUID;

public interface ITripulanteRepository extends IRepository<Tripulante, UUID> {
  public List<Tripulante> GetAll();

  public Tripulante Delete(Tripulante tripulante);

  public Tripulante Update(Tripulante tripulante);
}
