package rule;

import org.junit.Assert;
import org.junit.Test;

public class StringNotNullOrEmptyRule_Test {

  @Test
  public void constructor_accept() {
    StringNotNullOrEmptyRule rule = new StringNotNullOrEmptyRule(null);
    rule.IsValid();
    rule.Message();
    Assert.assertNotNull(rule);
  }

  @Test
  public void constructor_denied() {
    StringNotNullOrEmptyRule rule = new StringNotNullOrEmptyRule("sadas");
    rule.IsValid();
    rule.Message();
    Assert.assertNotNull(rule);
  }
}
