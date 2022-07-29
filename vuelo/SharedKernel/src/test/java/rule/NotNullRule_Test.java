package rule;

import org.junit.Assert;
import org.junit.Test;

public class NotNullRule_Test {

  @Test
  public void constructor_accept() {
    NotNullRule rule = new NotNullRule(null);
    rule.IsValid();
    rule.Message();
    Assert.assertNotNull(rule);
  }

  @Test
  public void constructor_denied() {
    NotNullRule rule = new NotNullRule("ASdsa");
    rule.IsValid();
    rule.Message();
    Assert.assertNotNull(rule);
  }
}
