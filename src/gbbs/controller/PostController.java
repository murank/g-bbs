package gbbs.controller;

import gbbs.service.PostingService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class PostController extends Controller {
	
	private PostingService service = new PostingService();

	@Override
	public Navigation run() throws Exception {
		
		if(isPost() && doPost()) {
			return redirect("/");
		}
		
		return forward("post.jsp");
	}
	
	private boolean doPost() {
		String content = asString("content");
		service.addNewPosting(content);
		
		return true;
	}
}
