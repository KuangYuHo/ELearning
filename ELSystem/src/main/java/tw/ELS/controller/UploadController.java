package tw.ELS.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import tw.ELS.member.model.Member;
import tw.ELS.member.model.MemberService;


@SessionAttributes({"LoginOK","loginID"})
@Controller
public class UploadController {

	private final static String saveDirPath = "C:/memberImg/";
	
	@PostMapping("/upload/{id}")
	public String upload(@RequestParam("file") MultipartFile mf,
			@PathVariable("id") Integer uploadid,Model m,HttpServletRequest request) throws IllegalStateException, IOException {
		if (mf.isEmpty()) {
            return "上傳失敗";
        }
		String fileName = mf.getOriginalFilename();//上傳檔案的原始檔名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));//取副檔名

        String newFileName = uploadid.toString()+ suffixName;//設定想要儲存的檔名
        
        
        String savePath = saveDirPath + newFileName;
		File savePathFile = new File(savePath);
		mf.transferTo(savePathFile);
		
//        System.out.println(fileName);
//        System.out.println(savePath);
//        System.out.println(memberID);

		if(fileName!= null && fileName.length()!=0) {
			saveFile(newFileName,savePath,uploadid);
		}	

		
		Member uMem = mService.findById(uploadid);
		String fName = uMem.getPhoto();

		m.addAttribute("uMem",uMem);
		m.addAttribute("filepath",fName);
		
		
		String rurl = "/updatesuccess";
        return rurl;
    }

	@Autowired
	private MemberService mService;

	private void saveFile(String fileName, String savePath,Integer id) {
		System.out.println(fileName);
        System.out.println(savePath);
		Member me = mService.findById(id);
		
		//   C:/memberImg/1017.jpg to /memberImg/1017.jpg
		int a = savePath.indexOf("memberImg")-1;
		String dbpath = savePath.substring(a);
		me.setPhoto(dbpath);
		
		try {
			FileInputStream is = new FileInputStream(savePath);//從本地端讀照片
			byte[] b = new byte[is.available()];
			is.read(b);
			is.close();
			
			mService.updateMember(me);//存入資料庫
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
}
