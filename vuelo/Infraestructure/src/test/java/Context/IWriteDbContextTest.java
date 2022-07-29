package Context;

import fourteam.db.DbSet;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class IWriteDbContextTest {

  public static class Context extends IWriteDbContext {

    public Context() {
      super(Context.class);
    }

    @Override
    public void Transaction() {}

    @Override
    public void Commit() {}

    @Override
    public void Rollback() {}

    @Override
    public boolean isConnected() {
      return false;
    }

    @Override
    public void onModelCreating(List<DbSet> sets) {}

    @Override
    public void Add(Object obj, DbSet dbSet) {}

    @Override
    public void Update(Object obj, BooleanFunction fun, DbSet dbSet) {}

    @Override
    public void Delete(BooleanFunction fun, DbSet dbSet) {}

    @Override
    public List All(DbSet dbSet) {
      return null;
    }

    @Override
    public Object Single(BooleanFunction fun, DbSet dbSet) {
      return null;
    }

    @Override
    public List Filter(BooleanFunction fun, DbSet dbSet) {
      return null;
    }
  }

  @Test
  public void constructor_accept() {
    IWriteDbContext context = new Context();
    Assert.assertNotNull(context);
  }
}
