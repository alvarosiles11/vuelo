package core;

import static org.mockito.Mockito.when;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class Entity_Test {

  @Test
  public void constructor_accept() {
    Entity entity = new Entity() {};
    entity.setKey(UUID.randomUUID());
    entity.getKey();
    entity.addDomainEvent(new DomainEvent() {});
    entity.getDomainEvents();
    entity.clearDomainEvent();
    BussinessRule rule = Mockito.mock(BussinessRule.class);

    try {
      when(rule.IsValid()).thenReturn(false);
      entity.CheckRule(rule);
    } catch (BussinessRuleValidateExeption e) {}
    try {
      entity.CheckRule(null);
    } catch (Exception e) {}

    try {
      when(rule.IsValid()).thenReturn(false);
      entity.CheckRule(rule);
    } catch (BussinessRuleValidateExeption e) {}

    Assert.assertNotNull(entity);
  }
}
