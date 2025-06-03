package tw.ELS.ordersdetail.controller;

import java.util.ArrayList;
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

import tw.ELS.mylesson.model.MyLessonService;
import tw.ELS.orders.model.Orders;
import tw.ELS.orders.model.OrdersService;
import tw.ELS.ordersdetail.model.OrdersDetail;
import tw.ELS.ordersdetail.model.OrdersDetailService;

@Controller
@RequestMapping("/orders")
@SessionAttributes(names = {"orderId","odTotalPages","odTotalElements","oddTotalPages","oddTotalElements"})
public class OrdersDetailController {
	@Autowired
	private OrdersService oService;
	
	@Autowired
	private OrdersDetailService odService;
	
	@Autowired
	private MyLessonService mService;
	
	@GetMapping("/findbyorderid/{orderId}")
	public String processOrdersDetailPage(@PathVariable("orderId") int orderId,Model m) {
		m.addAttribute("orderId",orderId);
		return "orders/ordersPageDetail";
	}
	
	@PostMapping("/findallbyorderid/{pageNo}")
	@ResponseBody
	public List<OrdersDetail> processOrdersDetailFind(@PathVariable("pageNo") int pageNo,Model m,HttpSession session){
		int orderId = (int)session.getAttribute("orderId");
		int pageSize = 10;
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		Page<OrdersDetail> page = odService.findAllByOrderId(orderId, pageable);
		m.addAttribute("oddTotalPages",page.getTotalPages());
		m.addAttribute("oddTotalElements", page.getTotalElements());
		return page.getContent();
	}
	
	@GetMapping("/findallorders")
	public String processOrdersFindAll(Model m) {
		return "allorders/allOrdersPage";
	}
	
	@PostMapping("/findallorders/{pageNo}")
	@ResponseBody
	public List<Orders> processOrdersDetailFindAll(@PathVariable("pageNo") int pageNo,Model m,HttpSession session){
		int pageSize = 10;
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		Page<Orders> page = oService.findAll(pageable);
		m.addAttribute("odTotalPages",page.getTotalPages());
		m.addAttribute("odTotalElements", page.getTotalElements());
		return page.getContent();
	}
	
	@GetMapping("/delete/{orderId}")
	public String processDeleteAction(@PathVariable int orderId) {
		int memberId = oService.findByOrderId(orderId).getMemberId();
		Set<OrdersDetail> od1 = odService.findByOrderId(orderId);
		List<Integer> lessonIdList = new ArrayList();
		for(OrdersDetail od:od1) {
			Integer i = od.getLessonId();
			lessonIdList.add(i);
		}
		for(Integer lessonId:lessonIdList) {
			mService.deleteByMemberIdAndLessonId(memberId, lessonId);
		}
		oService.deleteOrders(orderId);
		
		
		return "allorders/allOrdersPage";
	}

}
