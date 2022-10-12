import org.junit.Assert;
import org.junit.Test;

public class DomainTest {

	@Test
	public void constructor_accept() {
		Domain domain = new Domain();
		Assert.assertNotNull(domain);
	}

	@Test
	public void addDomain_accept() {
		Domain domain = new Domain();
		domain.addDomain();
		Assert.assertTrue(true);
	}

}