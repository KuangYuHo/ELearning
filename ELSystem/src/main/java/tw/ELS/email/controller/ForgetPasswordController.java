package tw.ELS.email.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.ELS.email.model.EmailSenderService;
import tw.ELS.member.model.Member;
import tw.ELS.member.model.MemberService;
import tw.ELS.model.RandomString;

@Controller
public class ForgetPasswordController {

	String contextPath ;
	final String requestPath = "/forgetpwd";
	                             
	@Autowired
	EmailSenderService senderService;
	
	@Autowired
	ServletContext  context	;
	
	@Autowired
	private MemberService mService;
	
	@Autowired
	public ForgetPasswordController(EmailSenderService senderService, ServletContext context) {
		this.senderService = senderService;
		this.context = context;
		contextPath = context.getContextPath();
	}
	
	@GetMapping("/forgetpwd")
	public String forgetPwd(Model model) {
		return "forgetpwd";
	}
	
	@PostMapping("/forgetpwd")
	public String forgetPwd(@RequestParam String account,@RequestParam String emailAddress,Model model,HttpSession session) {
		
		Member changePwdMem = mService.findByAccount(account);
		if(changePwdMem!=null) {
			if(emailAddress.equals(changePwdMem.getEmail())) {
				Map<String, String> map = (Map<String, String>) session.getAttribute("randomCode");
				if (map == null) {
					map = new HashMap<>();
					session.setAttribute("randomCode", map);
				}
				RandomString rs = new RandomString(50);
				String random = rs.nextString();
				map.put(random, random);
				System.out.println("random=" + random);
				String link = "http://localhost:8082" + contextPath + requestPath + "/" + random;
				System.out.println("link=" + link);

				senderService.sendEmail(emailAddress, "是否忘記密碼", "請於30分鐘內按下列超連結: " + 
				        link + "<br>");
				session.setAttribute("cpwdEmailAddress", emailAddress);
				session.setAttribute("cpwdAccount", account);

				return "sendpwdemailsuccess";
			}
		}

		return "forgetpwd";
	}
	
	@GetMapping("/forgetpwd/{random}")
	public String confirm(Model model, HttpSession session, 
			@PathVariable String random) {
		String result = null;
		Map<String, String> map = (Map<String, String>) session.getAttribute("randomCode");
		if (map == null) {
			result = "電子郵件地址認證失敗，Session不存在";
		} else {
			String value = map.get(random);
			if (value != null && value.equals(random) ) {
				result = "電子郵件地址認證成功，random=" + random ;
				return "changepwdbyemail";
			}
		}
		System.out.println("result=" + result);
		return "/index";
	}
	
	@PostMapping("/changepwdbyemail.controller")
	private String changepwdbyemail(@RequestParam String newpassword ,@RequestParam String checknewpassword,Model model, HttpSession session) {
		if(newpassword.equals(checknewpassword)) {
		String cpwdAccount = (String) session.getAttribute("cpwdAccount");
		Member changePwdMem = mService.findByAccount(cpwdAccount);
		
		String encodePwd = new BCryptPasswordEncoder().encode(newpassword);
		changePwdMem.setmPassword(encodePwd);
		mService.updateMember(changePwdMem);

		
		return "updatesuccess";
		}
		
		return "updatefail";
	}
	
}
