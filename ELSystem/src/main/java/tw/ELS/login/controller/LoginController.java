package tw.ELS.login.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;


import tw.ELS.member.model.Member;
import tw.ELS.member.model.MemberService;

@Controller
@SessionAttributes({"LoginOK"}) 
public class LoginController {

	@Autowired
	private MemberService mService;
	
	
	@GetMapping("/goRegister")
	public String goRegister(Model m) {
		Member mem = new Member();
		m.addAttribute("registerMem",mem);
		
		return "registerpage";
	}
	
	@PostMapping("/memberRegister.controller")//註冊
	public String processInsertAction(@RequestParam("byear") String byear,@RequestParam("bmonth") String bmonth,
			@RequestParam("bday") String bday,@ModelAttribute("registerMem") Member registerMem,Model m) {
		//找資料庫有沒有相同帳號
		if(mService.findByAccount(registerMem.getAccount())==null) {//如果沒有
			
			//加密密碼
			String encodePwd = new BCryptPasswordEncoder().encode(registerMem.getmPassword());
			Member saveMem = registerMem;
			saveMem.setmPassword(encodePwd);
			
			//處理生日
			String saveBirth = byear + "-" + bmonth + "-" + bday;
			System.out.println("存的生日為:   " + saveBirth);
			saveMem.setBirth(strToDate(saveBirth));
			
			//存預設大頭貼
			saveMem.setPhoto("/memberImg/default.jpg");
			
			//存取基本會員權限
			saveMem.setAuthority(1);
			
			//儲存進資料庫
			Member savedMem = mService.insertMember(saveMem);
			
//			if(savedMem!=null) {//設定權限關聯
//				Authority auth = aService.findById(103);
//				Member mem = mService.findById(savedMem.getMemberID());
//				auth.getMembers().add(mem);
//			    aService.saveAuth(auth);
//				
//				return "mainpage";
//			}
//			else {
//				System.out.println("權限設定失敗");
//				return "mainpage";
//			}
			return "index";
		}
		else{
			System.out.println("註冊失敗 已有此這號");
			Member mem = new Member();
			m.addAttribute("registerMem",mem);
			return "registerpage";
		}
		
	}
	
	public java.sql.Date strToDate(String strDate) { 
		String str = strDate; 
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		java.util.Date d = null; 
		try { 
		d = format.parse(str); 
		} catch (Exception e) { 
		e.printStackTrace(); 
		} 
		java.sql.Date date = new java.sql.Date(d.getTime()); 
		return date; 
	}
	

}
