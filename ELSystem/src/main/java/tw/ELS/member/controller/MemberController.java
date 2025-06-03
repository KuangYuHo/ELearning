package tw.ELS.member.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.text.SimpleDateFormat;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.ELS.member.model.Member;
import tw.ELS.member.model.MemberService;

@Controller
@RequestMapping("/member")
@SessionAttributes({"LoginOK","loginID"}) 
public class MemberController {

	@Autowired
	private MemberService mService;
	

	
	
	@GetMapping("/getLoginInf")
	public String logininf(Principal p) {
		
		String account = p.getName();
		System.out.println("登入帳號為: " + account);
		return account;
	}
	
	//前往管理個人資料
	@GetMapping("/goupdateme")
	public String goUpdate(Model m) {
		
		//拿取目前登入的個人資料
		Integer me= (Integer)m.getAttribute("loginID");
		Member uMem = mService.findById(me);
		
		//處理日期
		
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		String sdf1 = f.format(uMem.getBirth());
		String[] split = sdf1.split("-");
		int year = Integer.valueOf(split[0]);
		int month = Integer.valueOf(split[1]);
		int day = Integer.valueOf(split[2]);

		System.out.println("年:"+ year+"月:"+month+"日:"+day);
		//存入request
		m.addAttribute("uMem",uMem);
		m.addAttribute("year",year);
		m.addAttribute("month",month);
		m.addAttribute("day",day);

		
		//顯示目前個人圖片路徑
		String fileName = "memberImg/" + me.toString()+".jpg";
		
		//顯示目前個人圖片
		m.addAttribute("filepath",fileName);
		return "member/updateme";
	}
	
	//前往更改密碼
	@GetMapping("/goupdatepwd")
	public String goupdatepwd() {	
		return "member/updatepwd";
	}
	
	@PostMapping("/updatepwd.controller")
	public String updatepwd(@RequestParam("nowpwd") String nowpwd,@RequestParam("newpwd") String newpwd,
			@RequestParam("checknewpwd") String checknewpwd,Model m) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Integer loginID = (Integer) m.getAttribute("loginID");
		Member updateMem = mService.findById(loginID);
		System.out.println("修改的帳號為: " + updateMem.getMemberID());

		//比對輸入密碼與資料庫密碼
		if(!encoder.matches(nowpwd, updateMem.getmPassword()) || !newpwd.equals(checknewpwd)) {
			System.out.println("密碼錯誤" + encoder.matches(nowpwd, updateMem.getmPassword()));
			return "updatefail";
		}
		else {
			//更新新密碼
			String newEncodePwd = new BCryptPasswordEncoder().encode(newpwd);
			updateMem.setmPassword(newEncodePwd);
			mService.updateMember(updateMem);
			return "updatesuccess";
		}
		
	}
		
	
	//更新個人資料
	@PostMapping("/updateOne.controller")
	public String updateone(@RequestParam("byear") String byear,@RequestParam("bmonth") String bmonth,
			@RequestParam("bday") String bday,@ModelAttribute("uMem") Member mb1,Model m) {
		
		Integer me= (Integer)m.getAttribute("loginID");
		Member loginMem = mService.findById(me);

		System.out.println("修改的帳號為: " + loginMem.getMemberID());
		
		String saveBirth = byear + "-" + bmonth + "-" + bday;
		System.out.println("存的生日為:   " + saveBirth);
		loginMem.setBirth(strToDate(saveBirth));
		
		loginMem.setEmail(mb1.getEmail());

		loginMem.setmName(mb1.getmName());
		loginMem.setIdentityID(mb1.getIdentityID());
		loginMem.setPhone(mb1.getPhone());
		loginMem.setmAddress(mb1.getmAddress());
		loginMem.setGender(mb1.getGender());

		
		Member savedMem = mService.updateMember(loginMem);
		
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		String sdf1 = f.format(savedMem.getBirth());
		String[] split = sdf1.split("-");
		int year = Integer.valueOf(split[0]);
		int month = Integer.valueOf(split[1]);
		int day = Integer.valueOf(split[2]);

		//存入request
		m.addAttribute("year",year);
		m.addAttribute("month",month);
		m.addAttribute("day",day);
		m.addAttribute("uMem",savedMem);

		return "updatesuccess";
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