package Repositories;

import Model.Aeronaves.*;
import core.IRepository;
import java.util.List;
import java.util.UUID;

public interface IAeronaveRepository extends IRepository<Aeronave, UUID> {
  public List<Aeronave> GetAll();

  public Aeronave Delete(Aeronave aeronave);

  public Aeronave Update(Aeronave aeronave);
}
