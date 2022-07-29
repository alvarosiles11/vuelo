package Context;

import Model.Aeronaves.Aeronave;
import Model.Vuelos.Tripulante;
import Model.Vuelos.Vuelo;
import fourteam.db.DbContext;
import fourteam.db.DbSet;

public abstract class IWriteDbContext extends DbContext {

  public IWriteDbContext(Class dbContextClass) {
    super(dbContextClass);
  }

  public DbSet<Vuelo> Vuelo;
  public DbSet<Tripulante> Tripulante;
  public DbSet<Aeronave> Aeronave;
}
