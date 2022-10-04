import org.junit.Test;

public class ApplicationTest {

  @Test
  public void AddApplicationAccept() {
    // INFO:Usamos el IMediator del kernel en cambio del MediatR de Spring
    new Application();
    Application.AddApplication();
  }
}
