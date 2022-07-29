package core;

import org.junit.Assert;
import org.junit.Test;

public class BussinessRulesValidateExption_Test {

  @Test
  public void constructor_accept() {
    BussinessRuleValidateExeption rule = new BussinessRuleValidateExeption(
      "detail"
    );
    Assert.assertNotNull(rule);
    rule.getDetails();
    rule.getBrokenRule();
  }
}
