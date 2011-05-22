package gbbs.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PostingServiceTest extends AppEngineTestCase {

	private PostingService service = new PostingService();

	@Test
	public void test() throws Exception {
		assertThat(service, is(notNullValue()));
	}
}
