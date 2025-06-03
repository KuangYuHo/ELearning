package tw.ELS.addpost.controller;

import java.sql.SQLException;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.ELS.addpost.model.AddPost;
import tw.ELS.addpost.model.AddPostService;
import tw.ELS.addpost.validator.PostValidator;
import tw.ELS.elsmessage.model.ELSMessage;
import tw.ELS.elsmessage.model.ELSMessageService;
import tw.ELS.member.model.Member;
import tw.ELS.member.model.MemberService;




@Controller
@RequestMapping("/addpost")
@SessionAttributes(names = { "memberId","postId","totalPages", "totalElements" ,"searchtext","loginID"})
public class AddPostController {

	@Autowired
	private AddPostService postService;
	
	@Autowired
	private ELSMessageService msgService;

	
	@GetMapping("/login.controller")
	public String login() {
		return "login";		
	}
	
	@PostMapping("/login.controller")
	public String loginAction(@RequestParam("login")Integer memberId,Model m) {
		m.addAttribute("memberId",memberId);	
		System.out.println(memberId);
		return "/addpost/addpostAllFormTest";		
	}
	
	//所有功能顯示
	@GetMapping("/allaction.controller")
	public String showallAction() {
		return "index";
	}
	
	//測試1
	@GetMapping("/allaction1.controller")
	public String showallAction1() {
		return "/addpost/postAllFormTest";
	}

	//測試2
	@GetMapping("/allaction2.controller")
	public String showallAction2() {
		return "/addpost/addpostAllFormTest";
	}
	
	//管理
	@GetMapping("/allaction3.controller")
	public String showallAction3() {
		return "/addpost/addpostAllFormUser";
	}
	
	//所有貼文
	@GetMapping("/allpost.controller")
	public String processAddPostMainAction() {
		return "/addpost/addpostAllForm";

	}


	//找貼文
	@PostMapping("/querybyid/{postId}")
	@ResponseBody
	public AddPost processFindByIdAction(@PathVariable("postId") int postId) {
		
		return postService.findById(postId);
	}
	
	//關鍵字查詢1
	@PostMapping("/searchqueryByPage")
	public String gosearchList(@RequestParam String searchtext ,Model m) throws SQLException {
		//m.addAttribute("searchoption",searchoption);
		m.addAttribute("searchtext",searchtext);

		return "addpost/searchResult";
	}
	
	//關鍵字查詢2
	@PostMapping("/searchqueryByPage/{pageNo}")
	@ResponseBody
	public List<AddPost> searchQueryByPage(@PathVariable("pageNo") int pageNo, Model m){
		int pageSize = 3;
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);

		//String searchOption = (String) m.getAttribute("searchoption");
		String searchText = (String) m.getAttribute("searchtext");

		
			Page<AddPost> page = postService.searchfindAllByPostTitlePage(searchText,pageable);
			
			System.out.println(page.getTotalPages());
			System.out.println(page.getTotalElements());

			m.addAttribute("totalPages", page.getTotalPages());
			m.addAttribute("totalElements", page.getTotalElements());
			return page.getContent();
		
								
	}

	//所有貼文
	@PostMapping("/queryByPage/{pageNo}")
	@ResponseBody
	public List<AddPost> processQueryByPage(@PathVariable("pageNo") int pageNo, Model m) {
		int pageSize = 6;
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		
		Page<AddPost> page = postService.findAllByPage(pageable);
		m.addAttribute("totalPages", page.getTotalPages());
		m.addAttribute("totalElements", page.getTotalElements());
		return page.getContent();

	}

	//刪除貼文
	@GetMapping("/delete")
	public String processDeleteByIdAction(int postId) {
		postService.deleteById(postId);
		return "/addpost/addpostAllForm";

	}

	//會員刪除貼文
	@GetMapping("/delete2")
	public String processDeleteByIdAction2(Integer postId) {
		postService.deleteById(postId);
		return "/addpost/addpostAllFormTest";
		
	}
	
	//更新貼文步驟1
	@GetMapping("/updatepost")
	public String Update(Model m, Integer postId) {
		AddPost addPost = postService.findById(postId);
		m.addAttribute(addPost);
		return "/addpost/Updatepost2";
	}

	//更新貼文步驟2
	@PostMapping("/updatepost")
	public String UpdateAction(Model m, AddPost addPost, BindingResult result) {
		PostValidator postValidator = new PostValidator();
		postValidator.validate(addPost, result);
		
		Integer mid = (Integer)m.getAttribute("loginID");
		Member mem = mService.findById(mid);
		addPost.setmName(mem.getmName());
		addPost.setPhoto(mem.getPhoto());
		addPost.setMemberId(5);
		addPost.setPostDate(new Date());
		addPost.setPostLikeQty(6);
		addPost.setPostViews(6);
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "/addpost/Updatepost2";
		}

		postService.update(addPost);
		return "/addpost/addpostAllForm";
	}
	
	
	//會員更新貼文步驟1
		@GetMapping("/updatepost2")
		public String Update2(Model m, Integer postId) {
			AddPost addPost = postService.findById(postId);
			m.addAttribute(addPost);
			return "/addpost/Updatepost2";
		}

		//會員更新貼文步驟2
		@PostMapping("/updatepost2")
		public String UpdateAction2(Model m,AddPost addPost, BindingResult result) {
			PostValidator postValidator = new PostValidator();
			AddPost addpost = (AddPost) m.getAttribute("addPost");
			postValidator.validate(addPost, result);

			Integer mid = (Integer)m.getAttribute("loginID");
			Member mem = mService.findById(mid);
			addPost.setmName(mem.getmName());
			addPost.setPhoto(mem.getPhoto());
			addPost.setMemberId(mid);
			addPost.setmName(addpost.getmName());
			addPost.setPhoto(addPost.getPhoto());
			addPost.setPostDate(new Date());
			addPost.setPostLikeQty(6);
			addPost.setPostViews(6);
			if (result.hasErrors()) {
				System.out.println(result.getAllErrors());
				return "/addpost/Updatepost2";
			}
			
			postService.update(addPost);
			System.out.println(addPost.getPostId());
			AddPost aP =  postService.findById(addPost.getPostId());
			for(ELSMessage a : aP.getMessages()) {
				System.out.println("aaaa");
				System.out.println(a);

			}
			m.addAttribute("addPost", aP);

			return "/addpost/PostAndMessagesTest";
		}
	
	

	//新增貼文步驟1
	@GetMapping("/insertpost")
	public String InsertPost(Model m) {
		AddPost addposts = new AddPost();
		m.addAttribute("addpost", addposts);
		return "/addpost/Insertpost";
	}

	@Autowired
	private MemberService mService;
	
	//新增貼文步驟2
	@PostMapping("/insertpost.controller")
	public String InsertPostAction(
			Model m,@RequestParam("mPostType") String mPostType,
			@RequestParam("mPostTitle") String mPostTitle,
			@RequestParam("mPostInformation") String mPostInformation) {
		AddPost ap1 = new AddPost();
		Integer mid = (Integer)m.getAttribute("loginID");
		Member mem = mService.findById(mid);
		ap1.setmName(mem.getmName());
		ap1.setPhoto(mem.getPhoto());
		
		ap1.setMemberId(mid);
		ap1.setPostType(mPostType);
		ap1.setPostTitle(mPostTitle);
		ap1.setPostInformation(mPostInformation);
		ap1.setPostDate(new Date());
		ap1.setPostLikeQty(6);
		ap1.setPostViews(6);

		System.out.println("######"+ap1);
		postService.insert(ap1);

		m.addAttribute("mPostType", ap1.getPostType());
		m.addAttribute("mPostTitle", ap1.getPostTitle());
		m.addAttribute("mPostInformation", ap1.getPostInformation());
//		m.addAttribute("mPostLikeQty", 5);
//		m.addAttribute("mPostLikeQty", 5);

		return "/addpost/addpostAllFormTest";
	}

	//查詢貼文步驟1
	@GetMapping("/selectonepost")
	public String SelectOnePost() {
		return "/addpost/Selectonepost";
	}

	//查詢貼文步驟2
	@PostMapping("/selectonepost.controller")
	public String SelectOnePostAction(@RequestParam("postId") int postId, Model m) {

		AddPost selectone = postService.findById(postId);
		m.addAttribute("selectone", selectone);
		if(selectone == null ) {
			return"/addpost/noinformation";
		};
		
		return "/addpost/SelectonepostSuccess";
	}

	@GetMapping("/elsmessagefindbyid2.controller")	
	public String processFindMsgById2(@RequestParam("postId") Integer postId, Model m) {
//		System.out.println("postId = " + postId);
		m.addAttribute("postId", postId);
		AddPost addPost = postService.findById(postId);
		m.addAttribute("addPost", addPost);
		return "/addpost/PostAndMessagesTest";
		
	}

	//新增留言的方法
		@PostMapping("/elsmessageinsert.controller")
		@ResponseBody
		public ELSMessage processMsgInsert(@RequestBody ELSMessage Msg,HttpSession session,Model m) {
			Integer mid = (Integer)session.getAttribute("loginID");
			Member mem = mService.findById(mid);
			Msg.setmName(mem.getmName());
			Msg.setPhoto(mem.getPhoto());
			Msg.setMessageDate(new Date());
			Msg.setMemberId(mid);
			return msgService.insert(Msg);
		}
}
