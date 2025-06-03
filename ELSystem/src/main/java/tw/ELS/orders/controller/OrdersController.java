package tw.ELS.orders.controller;

import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.ELS.mylesson.model.MyLesson;
import tw.ELS.mylesson.model.MyLessonService;
import tw.ELS.orders.model.Orders;
import tw.ELS.orders.model.OrdersService;
import tw.ELS.ordersdetail.model.OrdersDetail;
import tw.ELS.ordersdetail.model.OrdersDetailService;
import tw.ELS.shoppingcart.model.ShoppingCartBean;
import tw.ELS.shoppingcart.model.ShoppingCartService;

@Controller
@RequestMapping("/orders")
@SessionAttributes(names = {"oTotalPages","oTotalElements"})
public class OrdersController {
	
	@Autowired
	private OrdersService oService;
	
	@Autowired
	private ShoppingCartService sService;
	
	@Autowired
	private MyLessonService mService;
	
	@Autowired
	private OrdersDetailService odService;
	
	@GetMapping("/ordersmain.controller")
	public String processOrdersMainAction(Model m,HttpSession session) {
		int memberId = (int)session.getAttribute("loginID");
		List<Orders> ods = oService.findByMemberId(memberId);
		m.addAttribute("ods", ods);
		return "orders/ordersQueryAll";
	}
	
	@PostMapping("/ordersinsert.controller")
	public String processInsertAction(Model m,HttpSession session) {
		int memberId = (int)session.getAttribute("loginID");
		List<ShoppingCartBean> bean = sService.findAllByMemberId(memberId);
		int total = 0;
		for(ShoppingCartBean i:bean) {
			total += i.getLesson().getLessonPrice();
		}
		System.out.println(total);
		Orders orders = new Orders();
		orders.setMemberId(memberId);
		orders.setPayPrice(total);
		orders.setPayDate(new Date());
		Set<OrdersDetail> sosd = new LinkedHashSet<OrdersDetail>();
		
		orders.setOrdersDetail(sosd);
		Orders ods = oService.insertOrders(orders);
		for(ShoppingCartBean i:bean) {
			OrdersDetail osd = new OrdersDetail();
			osd.setOrderId(ods.getOrderId());
			osd.setLessonId(i.getLessonId());
			osd.setLesson(i.getLesson());
			sosd.add(osd);
		}
		List<MyLesson> lml = new ArrayList<MyLesson>();
		for(ShoppingCartBean i:bean) {
			MyLesson ml = new MyLesson();
			ml.setLessonId(i.getLessonId());
			ml.setMemberId(memberId);
			ml.setLesson(i.getLesson());
			lml.add(ml);
		}
		mService.insertAllMyLesson(lml);
		oService.insertOrders(ods);
//		System.out.println("============"+ods.getOrderId());
		sService.deleteAllShoppingCartBean(memberId);
		return "shoppingcart/shoppingCartQueryAll";
	}
	
	@GetMapping("/payPage")
	public String payPrice(Model m) {
		return "orders/payPage";
	}
	
	@GetMapping("/orderspage")
	public String processOrdersPage(Model m) {
		return "orders/ordersPage";
	}
	
	@PostMapping("/shoppingrecord/{pageNo}")
	@ResponseBody
	public List<Orders> processOrdersFind(@PathVariable("pageNo") int pageNo,Model m,HttpSession session) {
		int memberId = (int)session.getAttribute("loginID");
		int pageSize = 10;
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		Page<Orders> page = oService.findAllByMemberId(memberId,pageable);
		for(Orders od:page) {
			int orderId = od.getOrderId();
			od.setOrdersDetail(odService.findByOrderId(orderId));
		}
		m.addAttribute("oTotalPages",page.getTotalPages());
		m.addAttribute("oTotalElements", page.getTotalElements());
		return page.getContent();
	}

}
