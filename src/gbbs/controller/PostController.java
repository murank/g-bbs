package gbbs.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class PostController extends Controller {

	@Override
	public Navigation run() throws Exception {
		return forward("post.jsp");
	}
}
