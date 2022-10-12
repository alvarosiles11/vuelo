import org.junit.Test;

public class WebApiTest {

	@Test
	public void webTest() {
		WebApi webApi = new WebApi();
		WebApi.AddControllers();
		WebApi.openApi();
	}
}
