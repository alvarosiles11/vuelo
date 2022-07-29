package core;

import java.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Test;

public class DomainEvent_Test {

  @Test
  public void constructor_accept() {
    DomainEvent domainEvent = new DomainEvent();
    DomainEvent domainEvent2 = new DomainEvent(LocalDateTime.now());
    Assert.assertNotNull(domainEvent2.getOcurredOn());
    Assert.assertNotNull(domainEvent2.getKey());
  }
}
