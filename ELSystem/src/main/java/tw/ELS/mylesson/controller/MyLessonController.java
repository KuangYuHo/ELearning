package tw.ELS.mylesson.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.ELS.mylesson.model.MyLesson;
import tw.ELS.mylesson.model.MyLessonService;
import tw.ELS.shoppingcart.model.ShoppingCartBean;

@Controller
@RequestMapping("/mylesson")
@SessionAttributes(names = {"mTotalPages","mTotalElements"})
public class MyLessonController {
	
	@Autowired
	private MyLessonService mService;
	
	@PostMapping("/queryByPage/{pageNo}")
	@ResponseBody
	public List<MyLesson> processQueryByPage(@PathVariable("pageNo") int pageNo,Model m,HttpSession session){
		int pageSize = 10;
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		Page<MyLesson> page = mService.findByMemberId((int)session.getAttribute("loginID"), pageable);
		m.addAttribute("mTotalPages",page.getTotalPages());
		m.addAttribute("mTotalElements", page.getTotalElements());
		return page.getContent();
	}

}
