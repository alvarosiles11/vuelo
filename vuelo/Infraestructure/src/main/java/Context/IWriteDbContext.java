package Context;

import Fourteam.db.DbContext;
import Fourteam.db.DbSet;
import Fourteam.db.Exception.DataBaseException;
import Model.Aeronaves.Aeronave;
import Model.Vuelos.Tripulante;
import Model.Vuelos.Vuelo;

public abstract class IWriteDbContext extends DbContext {

  public IWriteDbContext(Class dbContextClass)throws DataBaseException {
    super(dbContextClass);
  }

  public DbSet<Vuelo> Vuelo;
  public DbSet<Tripulante> Tripulante;
  public DbSet<Aeronave> Aeronave;
}
