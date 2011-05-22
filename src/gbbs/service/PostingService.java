package gbbs.service;

import gbbs.meta.PostingMeta;
import gbbs.model.Posting;

import java.util.Date;
import java.util.List;

import org.slim3.datastore.Datastore;

public class PostingService {

	private PostingMeta pm = new PostingMeta();

	public Posting addNewPosting(String content, Date postingDate) {
		Posting post = new Posting();
		post.setKey(Datastore.allocateId(Posting.class));
		post.setContent(content);
		post.setPostingDate(postingDate);

		Datastore.put(post);

		return post;
	}

	public Posting addNewPosting(String content) {
		return addNewPosting(content, new Date());
	}
	
	public List<Posting> getPostingList() {
		return Datastore.query(pm).sort(pm.postingDate.desc).asList();
	}
}
