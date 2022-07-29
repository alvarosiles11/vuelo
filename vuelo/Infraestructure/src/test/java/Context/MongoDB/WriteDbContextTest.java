package Context.MongoDB;

import Model.Aeronaves.Aeronave;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import fourteam.db.DbSet;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class WriteDbContextTest {

  DbSet dbSet = Mockito.mock(DbSet.class);

  @Test
  public void CheckConstructor() {
    MongoClient client = Mockito.mock(MongoClient.class);
    MongoDatabase db = Mockito.mock(MongoDatabase.class);

    String DB_NAME = "dmsnur_vuelo";
    String DB_USER = "root";
    String DB_PASS = "rootpassword";
    String DB_HOST = "servisofts.com";
    int DB_PORT = 27017;

    WriteDbContext context0 = Mockito.mock(WriteDbContext.class);
    // WriteDbContext context2 = new WriteDbContext();

  }

  @Test
  public void test() {
    WriteDbContext writeDbContext = new WriteDbContext();
    writeDbContext.onModelCreating(new ArrayList<DbSet>());
    writeDbContext.isConnected();
    writeDbContext.Commit();
    writeDbContext.Transaction();
    writeDbContext.Rollback();
    // writeDbContext.Add(Object obj, DbSet dbSet);

    // writeDbContext.All(dbSet);
    // writeDbContext.Delete(any(BooleanFunction.class), dbSet);
  }

  @Test
  public void constructor_accept() {
    WriteDbContext context = new WriteDbContext();
    Assert.assertNotNull(context);
  }

  @Test
  public void FindByKey_accept() {
    // Mockito.verify(_aeronaves).Single(obj -> obj.key.equals(UUID.randomUUID()));
    // Aeronave a = new Aeronave();
    // when(_aeronaves.Single(any())).thenReturn(a);
    WriteDbContext context = new WriteDbContext();
    ArgumentCaptor<Aeronave> captor = ArgumentCaptor.forClass(Aeronave.class);
    Assert.assertNotNull(context);
  }
}
