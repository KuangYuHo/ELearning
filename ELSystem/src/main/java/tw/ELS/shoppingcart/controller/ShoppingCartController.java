package tw.ELS.shoppingcart.controller;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.ELS.lesson.model.Lesson;
import tw.ELS.lesson.model.LessonRepository;
import tw.ELS.lesson.model.LessonService;
import tw.ELS.mylesson.model.MyLessonService;
import tw.ELS.shoppingcart.model.ShoppingCartBean;
import tw.ELS.shoppingcart.model.ShoppingCartService;

@Controller
@RequestMapping("/shoppingcart")
@SessionAttributes(names = {"sTotalPages","sTotalElements"})
public class ShoppingCartController {
	@Autowired
	private ShoppingCartService sService;
	
	@Autowired
	private LessonService lService;
	
	@Autowired
	private MyLessonService mService;
	
	@GetMapping("/shoppingcartmain.controller")
	public String processShoppingCartMainAction(Model m) {
		return "shoppingcart/shoppingCartQueryAll";
	}
	
	@PostMapping("/shoppingcartmain.controller2")
	public String processShoppingCartMainAction2(Model m) {
		return "shoppingcart/shoppingCartQueryAll";
	}
	
	
	@PostMapping("/shoppingcartinsert.controller")
	@ResponseBody
	public ShoppingCartBean processInsertAction(@RequestBody ShoppingCartBean shoppingCartBean,HttpSession session) {
		int id = shoppingCartBean.getLessonId();
		int memberId = (int)session.getAttribute("loginID");
		shoppingCartBean.setLesson(lService.findById(id));
//		Set<ShoppingCartBean> scb = new LinkedHashSet<ShoppingCartBean>();
//		scb.add(shoppingCartBean);
		if(sService.findByLessonIdAndMemberId(id,memberId) == null) {
			if(mService.findByMemberIdAndLessonId(memberId, id) == null) {
				return sService.insertShoppingCartBean(shoppingCartBean);
			}else {
				return null;
			}
		}else {
			return null;
		}
		
	}
	
	@PostMapping("/queryById/{shoppingCartId}")
	@ResponseBody
	public ShoppingCartBean processFindById(@PathVariable("shoppingCartId")  int shoppingCartId) {
		return sService.findById(shoppingCartId);
	}
	
	@PostMapping("/queryByPage/{pageNo}")
	@ResponseBody
	public List<ShoppingCartBean> processQueryByPage(@PathVariable("pageNo") int pageNo,Model m,HttpSession session){
		int pageSize = 10;
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		Page<ShoppingCartBean> page = sService.findByMemberId((int)session.getAttribute("loginID"), pageable);
		
//		for(ShoppingCartBean scb:page) {
//			int id = scb.getLessonId();
//			scb.setLesson(lService.findById(id));
//		}
		m.addAttribute("sTotalPages",page.getTotalPages());
		m.addAttribute("sTotalElements", page.getTotalElements());
		return page.getContent();
	}
	
	@GetMapping("/delete/{shoppingCartId}")
	public String processDeleteAction(@PathVariable int shoppingCartId) {
		sService.deleteShoppingCartBean(shoppingCartId);
		return "shoppingcart/shoppingCartQueryAll";
	}
	
	
	
	@GetMapping("/deleteall")
	public String processDeleteAllAction(Model m,HttpSession session) {
		int memberId = (int)session.getAttribute("loginID");
		sService.deleteAllShoppingCartBean(memberId);
		return "shoppingcart/shoppingCartQueryAll";
	}

}
