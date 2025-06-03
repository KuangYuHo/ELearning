package tw.ELS.article.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SystemController {
	
	@GetMapping("/index.controller")
	public String ArticleManageMainAction() {
		return "index";
	}
	
	//還沒用
	@GetMapping("/userresearch.controller")
	public String ArticleViewAction() {
		return "userResearch";
	}

}
