package gbbs.controller;

import gbbs.PostConstants;
import gbbs.model.Posting;
import gbbs.service.PostingService;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

	private PostingService service = new PostingService();

	@Override
	public Navigation run() throws Exception {
		
		List<Posting> postingList = service.getPostingList();
		requestScope("postingList", postingList);
		
		requestScope(PostConstants.IS_POSTED, sessionScope(PostConstants.IS_POSTED));
		sessionScope(PostConstants.IS_POSTED, null);
		
		return forward("index.jsp");
	}
}
