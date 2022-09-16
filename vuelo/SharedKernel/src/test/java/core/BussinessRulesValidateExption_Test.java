package core;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class BussinessRulesValidateExption_Test {

  @Test
  public void constructor_accept() {
    BussinessRuleValidateExeption rule = new BussinessRuleValidateExeption("detail");
    Assert.assertNotNull(rule);
    rule.getDetails();
    rule.getBrokenRule();
  }
}
