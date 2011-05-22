package gbbs.controller;

import gbbs.PostConstants;
import gbbs.model.Posting;

import java.util.Date;

import org.slim3.datastore.Datastore;
import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PostControllerTest extends ControllerTestCase {

	@Test
	public void run() throws Exception {
		tester.param("content", "aaa");
		tester.start("/post");
		PostController controller = tester.getController();
		assertThat(controller, is(notNullValue()));
		assertThat(tester.isRedirect(), is(false));
		assertThat(tester.getDestinationPath(), is("/post.jsp"));

		Posting stored = Datastore.query(Posting.class).asSingle();
		assertThat(stored, is(nullValue()));

		assertThat(tester.sessionScope(PostConstants.IS_POSTED), is(nullValue()));
	}

	@Test
	public void addNewPost() throws Exception {
		String content = "aaa";

		tester.request.setMethod("POST");
		tester.param("content", content);
		tester.start("/post");
		PostController controller = tester.getController();
		assertThat(controller, is(notNullValue()));
		assertThat(tester.isRedirect(), is(true));
		assertThat(tester.getDestinationPath(), is("/"));

		Posting stored = Datastore.query(Posting.class).asSingle();
		assertThat(stored, is(notNullValue()));
		assertThat(stored.getContent(), is(content));
		assertThat((new Date().getTime() - stored.getPostingDate().getTime()) <= 1 * 1000, is(true));

		assertThat((Boolean) tester.sessionScope(PostConstants.IS_POSTED), is(true));
	}
}
