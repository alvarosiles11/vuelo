package core;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class DomainEvent_Test {

  @Test
  public void constructor_accept() {
    DomainEvent domainEvent = new DomainEvent() {};
    DomainEvent domainEvent2 = new DomainEvent(LocalDateTime.now()) {};
    Assert.assertNotNull(domainEvent2.getOcurredOn());
    Assert.assertNotNull(domainEvent2.getKey());
  }
}
