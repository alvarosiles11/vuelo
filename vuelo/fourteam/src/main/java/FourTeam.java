public class FourTeam {

  public static Class[] classes = {
    // http
    fourteam.http.Rest.class,
    // mediator
    fourteam.mediator.AggregateException.class,
    fourteam.mediator.IMediator.class,
    fourteam.mediator.NotificationHandler.class,
    fourteam.mediator.Notification.class,
    fourteam.mediator.Request.class,
    fourteam.mediator.Response.class,
    // Class
    fourteam.extensions.IServiceCollection.class,
    // DB
    fourteam.db.DbContext.class,
    fourteam.db.DbSet.class,
    fourteam.db.ModelBuilder.class,
  };

  public static void AddFourTeam() {
    int i = 0;
    int l = classes.length;
    for (Class clas : classes) {
      i++;
      System.out.print("Add kerel class: (" + i + "/" + l + ")\r");
    }
    System.out.println("\n");
  }
}
