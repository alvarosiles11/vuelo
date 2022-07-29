import Context.IWriteDbContext;
import Repositories.IUnitOfWork;
import core.DomainEvent;
import fourteam.http.Exception.HttpException;
import fourteam.mediator.Mediator;
import java.util.List;

public class UnitOfWork implements IUnitOfWork {

  private IWriteDbContext _context;
  private Mediator _mediator;

  public UnitOfWork(IWriteDbContext context, Mediator mediator) {
    _context = context;
    _mediator = mediator;
  }

  @Override
  public void commit() throws HttpException {
    List<Object> events = _context.getDomainEvents();
    for (Object domainEvent : events) {
      DomainEvent event = (DomainEvent) domainEvent;
      _mediator.notify(event);
    }
    _context.Commit();
  }
}
