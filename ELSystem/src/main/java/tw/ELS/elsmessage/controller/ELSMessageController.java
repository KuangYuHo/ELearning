package tw.ELS.elsmessage.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.ELS.addpost.model.AddPost;
import tw.ELS.addpost.model.AddPostService;
import tw.ELS.elsmessage.model.ELSMessage;
import tw.ELS.elsmessage.model.ELSMessageService;
import tw.ELS.elsmessage.validator.MessageValidator;


@Controller
@RequestMapping("/message")
@SessionAttributes(names = { "totalPages", "totalElements","eLSMessage","postId"})
public class ELSMessageController {

	@Autowired
	private ELSMessageService msgService;
	
	@Autowired
	private AddPostService aService;

	
	//從貼文到留言列表
	@GetMapping("/elsmessageList.controller")
	public String processMsgMainAction() {
		return "/message/elsmessageList";
	}

	//點貼文進到新增留言的地方
	@GetMapping("/elsmessage.controller")
	public String processMsgAction(@RequestParam("postId") int postId, Model m) {
		m.addAttribute("postId", postId);
		return "/message/elsmessage";
	}
	
	//顯示該貼文的留言,可編輯和刪除留言
	@GetMapping("/elsmessagefindbyid.controller")	
	public String processFindMsgById(@RequestParam("postId") Integer postId, Model m) {
//		System.out.println("postId = " + postId);
		AddPost addPost = aService.findById(postId);
		m.addAttribute("addPost", addPost);
		m.addAttribute("postId", postId);

		return "/message/postmessages";
	}

	//同時顯示該貼文和留言,可刪除留言
	@GetMapping("/elsmessagefindbyid2.controller")	
	public String processFindMsgById2(@RequestParam("postId") Integer postId, Model m) {
//		System.out.println("postId = " + postId);
		AddPost addPost = aService.findById(postId);
		m.addAttribute("addPost", addPost);
		return "/message/PostAndMessages";
		
	}
	
	//新增留言的方法
	@PostMapping("/elsmessageinsert.controller")
	@ResponseBody
	public ELSMessage processMsgInsert(@RequestBody ELSMessage Msg,Model m,HttpSession session) {
		Msg.setMessageDate(new Date());
		Msg.setMemberId((Integer)session.getAttribute("memberId"));
		return msgService.insert(Msg);
	}

	//刪除留言的方法
	@GetMapping("/deletemessage")
	public String processDeleteByIdAction(@RequestParam("messageId")Integer messageId,Model m) {
		 ELSMessage msg = msgService.findById(messageId);
		  Integer postid = msg.getPostId();
		  AddPost addPost = aService.findById(postid);
			m.addAttribute("addPost", addPost);
		msgService.deleteById(messageId);
		
		return "/message/PostAndMessages";		
	}
	
	//會員刪除留言的方法
	@GetMapping("/deletemessage2")
	public String processDeleteByIdAction2(@RequestParam("messageId")Integer messageId,Model m) {
		ELSMessage msg = msgService.findById(messageId);
		Integer postid = msg.getPostId();
		AddPost addPost = aService.findById(postid);
		m.addAttribute("addPost", addPost);
		msgService.deleteById(messageId);
		
		return "/addpost/PostAndMessagesTest";		
	}

	//更新留言的方法步驟1
	@GetMapping("/updatemessage")
	public String Update(Model m,@RequestParam("messageId") Integer messageId) {
		ELSMessage eLSMessage = msgService.findById(messageId);
		m.addAttribute("eLSMessage",eLSMessage);

		return "/message/UpdateMessage";		
	}
	
	//更新留言的方法步驟2
	@PostMapping("/updatemessage")
	public String UpdateAction(Model m,ELSMessage eLSMessage,BindingResult result2) {
		System.out.println("11");
		ELSMessage message = (ELSMessage) m.getAttribute("eLSMessage");
		System.out.println(eLSMessage.getPostId());
		System.out.println(message.getPostId());


		MessageValidator messageValidator = new MessageValidator();
		messageValidator.validate(eLSMessage, result2);
		
		eLSMessage.setPostId(message.getPostId());
		eLSMessage.setMemberId(message.getMemberId());
		eLSMessage.setMessageDate(new Date());
		eLSMessage.setMessageLikeQty(8);	
		if(result2.hasErrors()) {
			System.out.println(result2.getAllErrors());
			return "/message/UpdateMessage";
		}
		
		msgService.update(eLSMessage);
		return "/message/postmessages";		
	}
	
	//會員更新留言的方法步驟1
	@GetMapping("/updatemessage2")
	public String Update2(Model m,@RequestParam("messageId") Integer messageId) {
		ELSMessage eLSMessage = msgService.findById(messageId);
		m.addAttribute("eLSMessage",eLSMessage);
		
		return "/message/UpdateMessage";		
	}
	
	//會員更新留言的方法步驟2
	@PostMapping("/updatemessage2")
	public String UpdateAction2(@RequestParam("messageId")Integer messageId,Model m,ELSMessage eLSMessage,BindingResult result2) {
		System.out.println("11");
		ELSMessage message = (ELSMessage) m.getAttribute("eLSMessage");
		System.out.println(eLSMessage.getPostId());
		System.out.println(message.getPostId());		
		ELSMessage msg = msgService.findById(messageId);
		Integer postid = msg.getPostId();
		AddPost addPost = aService.findById(postid); 
		m.addAttribute("addPost", addPost);
		MessageValidator messageValidator = new MessageValidator();
		messageValidator.validate(eLSMessage, result2);
		eLSMessage.setMemberId((Integer)m.getAttribute("loginID"));
		eLSMessage.getMemberId();
		eLSMessage.setMemberId(message.getMemberId());
		
		eLSMessage.setmName(message.getmName());
		eLSMessage.setPhoto(message.getPhoto());
		
		eLSMessage.setPostId(message.getPostId());
		eLSMessage.setMessageDate(new Date());
		eLSMessage.setMessageLikeQty(8);	
		if(result2.hasErrors()) {
			System.out.println(result2.getAllErrors());
			return "/message/UpdateMessage";
		}
		
		msgService.update(eLSMessage);
		return "/addpost/PostAndMessagesTest";		
	}
	

	@PostMapping("/querybyid/{postId}")
	@ResponseBody
	public ELSMessage processFindByIdAction(@PathVariable("postId") int postId) {
		return msgService.findById(postId);
	}

	@PostMapping("/queryByPage/{postId}/{pageNo}")
	@ResponseBody
	public List<ELSMessage> processQueryByPage(@PathVariable("postId") int postId,@PathVariable("pageNo") int pageNo, Model m) {
		int pageSize = 6;
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		Page<ELSMessage> page = msgService.findByPostId(postId,pageable);
		m.addAttribute("totalPages", page.getTotalPages());
		m.addAttribute("totalElements", page.getTotalElements());
		return page.getContent();

	}

}
