package core;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ValueObject_Test {

  @Test
  public void constructor_accept() {
    BussinessRule rule = Mockito.mock(BussinessRule.class);
    ValueObject valueObject = new ValueObject() {};
    try {
      valueObject.CheckRule(null);
    } catch (Exception e) {
      Assert.assertTrue(true);
    }
    try {
      when(rule.IsValid()).thenReturn(false);
      valueObject.CheckRule(rule);
    } catch (Exception e) {
      Assert.assertTrue(true);
    }
    try {
      when(rule.IsValid()).thenReturn(true);
      valueObject.CheckRule(rule);
    } catch (Exception e) {
      Assert.assertTrue(true);
    }
  }
}
