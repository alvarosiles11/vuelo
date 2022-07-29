package core;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class AggregateRoot_Test {

  @Test
  public void constructor_accert() {
    AggregateRoot<UUID> sharedKernel = new AggregateRoot<UUID>() {};
    Assert.assertNotNull(sharedKernel);
  }
}
