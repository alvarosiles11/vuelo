import static org.mockito.Mockito.when;

import Context.IWriteDbContext;
import core.DomainEvent;
import fourteam.http.Exception.HttpException;
import fourteam.mediator.Mediator;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class UnitOfWorkTest {

  IWriteDbContext context = Mockito.mock(IWriteDbContext.class);
  Mediator mediator = Mockito.mock(Mediator.class);

  @Test
  public void constructorVoid_accept() {
    UnitOfWork unitOfWork = new UnitOfWork(context, mediator);
    Assert.assertNotNull(unitOfWork);
  }

  @Test
  public void commit_accept() {
    UnitOfWork unitOfWork = new UnitOfWork(context, mediator);
    List<Object> list = new ArrayList<Object>();
    list.add(new DomainEvent());
    when(context.getDomainEvents()).thenReturn(list);
    try {
      unitOfWork.commit();
    } catch (HttpException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void commit_denied() {
    UnitOfWork unitOfWork = new UnitOfWork(context, mediator);
    try {
      unitOfWork.commit();
    } catch (HttpException e) {
      e.printStackTrace();
    }
  }
}
