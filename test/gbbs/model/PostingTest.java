package gbbs.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PostingTest extends AppEngineTestCase {

	private Posting model = new Posting();

	@Test
	public void test() throws Exception {
		assertThat(model, is(notNullValue()));
	}
}
