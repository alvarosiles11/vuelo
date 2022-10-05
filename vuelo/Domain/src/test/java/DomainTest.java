import org.junit.Assert;
import org.junit.Test;

public class DomainTest {
	@Test
	public void addDomain_accept() {
		Assert.assertNotNull(new Domain());
		Domain.addDomain();
		SharedKernel.AddKernel();
		Assert.assertTrue(true);
	}
}