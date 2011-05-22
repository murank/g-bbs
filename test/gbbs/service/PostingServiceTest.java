package gbbs.service;

import gbbs.model.Posting;

import java.util.Date;
import java.util.List;

import org.slim3.datastore.Datastore;
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

	@Test
	public void addNewPosting() throws Exception {
		String content = "aaa";
		Date postingDate = new Date();

		Posting posting = service.addNewPosting(content, postingDate);
		assertThat(posting, is(notNullValue()));

		Posting stored = Datastore.get(Posting.class, posting.getKey());
		assertThat(stored, is(notNullValue()));
		assertThat(stored.getContent(), is(content));
		assertThat(stored.getPostingDate(), is(postingDate));
	}

	@Test
	public void getPostingList() throws Exception {
		String content = "aaa";
		Date postingDate = new Date();

		Posting post = new Posting();
		post.setContent(content);
		post.setPostingDate(postingDate);
		Datastore.put(post);

		List<Posting> postList = service.getPostingList();
		assertThat(postList.size(), is(1));
		assertThat(postList.get(0).getContent(), is(content));
		assertThat(postList.get(0).getPostingDate(), is(postingDate));
	}
}
