package tw.ELS.manage.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;


import tw.ELS.member.model.Member;
import tw.ELS.member.model.MemberService;


@Controller
@RequestMapping("/manage")
@SessionAttributes({"updateid","totalPages", "totalElements","searchoption","searchtext"})

public class ManageController {

	@Autowired
	private MemberService mService;
	
	
	@GetMapping("/membermanage1")
	public String goMemberList() throws SQLException {
		
		return "manage/memberlist";
	}
	
	@PostMapping("/queryByPage/{pageNo}")
	@ResponseBody
	public List<Member> processQueryByPage(@PathVariable("pageNo") int pageNo, Model m){
		int pageSize = 8;
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);

		Page<Member> page = mService.findAllByPage(pageable);
		System.out.println(page.getTotalPages());
		System.out.println(page.getTotalElements());

		m.addAttribute("totalPages", page.getTotalPages());
		m.addAttribute("totalElements", page.getTotalElements());
		return page.getContent();
	}
	
	@PostMapping("/searchqueryByPage")
	public String gosearchList(@RequestParam String searchoption,@RequestParam String searchtext ,Model m) throws SQLException {
		m.addAttribute("searchoption",searchoption);
		m.addAttribute("searchtext",searchtext);

		return "manage/searchResult";
	}
	
	
	@PostMapping("/searchqueryByPage/{pageNo}")
	@ResponseBody
	public List<Member> searchQueryByPage(@PathVariable("pageNo") int pageNo, Model m){
		int pageSize = 5;
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);

		String searchOption = (String) m.getAttribute("searchoption");
		String searchText = (String) m.getAttribute("searchtext");

		if(searchOption.equals("saccount")) {
			Page<Member> page = mService.searchfindAllByAccountPage(searchText,pageable);
			
			System.out.println(page.getTotalPages());
			System.out.println(page.getTotalElements());

			m.addAttribute("totalPages", page.getTotalPages());
			m.addAttribute("totalElements", page.getTotalElements());
			return page.getContent();
		}
		else {
			Page<Member> page = mService.searchfindAllByEmailPage(searchText,pageable);
			
			System.out.println(page.getTotalPages());
			System.out.println(page.getTotalElements());

			m.addAttribute("totalPages", page.getTotalPages());
			m.addAttribute("totalElements", page.getTotalElements());
			return page.getContent();
		}
		
		
	}
	
	
	@GetMapping("/membermanage")
	public String selectAll(Model m) throws SQLException {
		List<Member> resultList = mService.findAll();
		for(Member mem:resultList) {
			System.out.println(mem.getMemberID() + "   " + mem.getAccount() + "   " + mem.getmPassword());
		}
		m.addAttribute("memberlist",resultList);
		return "manage/membermanage";
	}
	
	@GetMapping("/deleteMember/{id}")
	public String deleteMem(@PathVariable Integer id,Model m) throws SQLException {
		
		//解除關聯
		Member delMem = mService.findById(id);
		
		//刪除會員
		//mService.deleteMember(delMem);
		delMem.setmName("帳號已註銷");
		mService.updateMember(delMem);

		List<Member> resultList = mService.findAll();
		m.addAttribute("memberlist",resultList);

		return "manage/memberlist";
	}
	
	@GetMapping("/updateMember/{id}")
	public String goUpdate(@PathVariable("id") Integer id,Model m) {
		
		Member uMem = mService.findById(id);
		//處理日期
		
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		String sdf1 = f.format(uMem.getBirth());
		String[] split = sdf1.split("-");
		int year = Integer.valueOf(split[0]);
		int month = Integer.valueOf(split[1]);
		int day = Integer.valueOf(split[2]);

		System.out.println("年:"+ year+"月:"+month+"日:"+day);
		//存入request
		m.addAttribute("year",year);
		m.addAttribute("month",month);
		m.addAttribute("day",day);		
		
		m.addAttribute("uMem",uMem);
		m.addAttribute("updateid",id);
		
		return "manage/updatemember";
	}
	
	@PostMapping("/updateMember.controller")
	public String updateone(@RequestParam("byear") String byear,@RequestParam("bmonth") String bmonth,
			@RequestParam("bday") String bday,@ModelAttribute ("uMem") Member mb1,Model m) {
		
		Integer uid = (Integer) m.getAttribute("updateid");
		System.out.println("修改帳號為:  " + uid);
		Member updatemem = mService.findById(uid);

		String saveBirth = byear + "-" + bmonth + "-" + bday;
		System.out.println("存的生日為:   " + saveBirth);
		updatemem.setBirth(strToDate(saveBirth));
		
		updatemem.setmName(mb1.getmName());
		updatemem.setEmail(mb1.getEmail());
		updatemem.setIdentityID(mb1.getIdentityID());
		updatemem.setPhone(mb1.getPhone());
		updatemem.setmAddress(mb1.getmAddress());
		updatemem.setGender(mb1.getGender());
		updatemem.setAuthority(mb1.getAuthority());

		Member savedMem = mService.updateMember(updatemem);
		m.addAttribute("uMem",savedMem);
		m.addAttribute("updateid",savedMem.getMemberID());

		
		return "updatesuccess";
	}
	
	@PostMapping("/managepwd.controller")
	public String updatepwd(@RequestParam("newpwd") String newpwd,@RequestParam("checknewpwd") String checknewpwd,Model m) {
		Integer updateid = (Integer) m.getAttribute("updateid");
		Member updateMem = mService.findById(updateid);
		System.out.println("修改的帳號為: " + updateMem.getMemberID());
		if(newpwd.equals(checknewpwd)) {
			//更新新密碼
			String newEncodePwd = new BCryptPasswordEncoder().encode(newpwd);
			updateMem.setmPassword(newEncodePwd);
			Member savedMem = mService.updateMember(updateMem);
			
			m.addAttribute("uMem",savedMem);
			m.addAttribute("updateid",savedMem.getMemberID());

			return "updatesuccess";
		}
			
		return "updatefail";
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
