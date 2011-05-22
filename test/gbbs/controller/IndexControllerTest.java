package gbbs.controller;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class IndexControllerTest extends ControllerTestCase {

	@Test
	public void run() throws Exception {
		tester.start("/");
		IndexController controller = tester.getController();
		assertThat(controller, is(notNullValue()));
		assertThat(tester.isRedirect(), is(false));
		assertThat(tester.getDestinationPath(), is("/index.jsp"));
	}
	
	@Test
	public void afterPosting() throws Exception {
		String message = "aaa";

		tester.sessionScope("message", message);
		tester.start("/");
		
		IndexController controller = tester.getController();
		assertThat(controller, is(notNullValue()));
		assertThat(tester.isRedirect(), is(false));
		assertThat(tester.getDestinationPath(), is("/index.jsp"));

		assertThat(tester.requestScope("postingList"), is(notNullValue()));
	}
}
