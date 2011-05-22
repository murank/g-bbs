package gbbs.service;

import gbbs.model.Posting;

import java.util.Date;

import org.slim3.datastore.Datastore;

public class PostingService {

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
	
}
