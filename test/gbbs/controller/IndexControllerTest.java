package gbbs.controller;

import gbbs.PostConstants;

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
		tester.sessionScope(PostConstants.IS_POSTED, true);
		tester.start("/");

		IndexController controller = tester.getController();
		assertThat(controller, is(notNullValue()));
		assertThat(tester.isRedirect(), is(false));
		assertThat(tester.getDestinationPath(), is("/index.jsp"));

		assertThat(tester.requestScope("postingList"), is(notNullValue()));
		assertThat((Boolean) tester.requestScope(PostConstants.IS_POSTED), is(true));

		tester.start("/");
		assertThat(tester.requestScope(PostConstants.IS_POSTED), is(nullValue()));
	}
}
