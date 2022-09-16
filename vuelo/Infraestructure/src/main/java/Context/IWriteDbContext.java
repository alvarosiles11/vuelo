package Context;

import Model.Aeronaves.Aeronave;
import Model.Vuelos.Tripulante;
import Model.Vuelos.Vuelo;
import fourteam.db.DbContext;
import fourteam.db.DbSet;
import fourteam.db.Exception.DataBaseException;

public abstract class IWriteDbContext extends DbContext {

  public IWriteDbContext(Class dbContextClass)throws DataBaseException {
    super(dbContextClass);
  }

  public DbSet<Vuelo> Vuelo;
  public DbSet<Tripulante> Tripulante;
  public DbSet<Aeronave> Aeronave;
}
