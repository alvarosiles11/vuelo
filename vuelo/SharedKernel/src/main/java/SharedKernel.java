public class SharedKernel {

  public static Class[] classes = {
    core.AggregateRoot.class,
    core.DomainEvent.class,
    core.Entity.class,
    core.ValueObject.class,
    core.BussinessRuleValidateExeption.class,
    core.IRepository.class,
    // http

    // rule
    rule.NotNullRule.class,
    rule.StringNotNullOrEmptyRule.class
    // mediator

  };

  public static void AddKernel() {
    int i = 0;
    int l = classes.length;
    for (Class clas : classes) {
      i++;
      System.out.print("Add kerel class: (" + i + "/" + l + ")\r");
    }
    System.out.println("\n");
  }
}
