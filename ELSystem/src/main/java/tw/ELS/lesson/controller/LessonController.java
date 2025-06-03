package tw.ELS.lesson.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.multipart.MultipartFile;

import tw.ELS.article.model.Article;
import tw.ELS.article.model.SearchQuery;
import tw.ELS.lesson.model.Lesson;
import tw.ELS.lesson.model.LessonService;

@Controller
@RequestMapping("/lesson")
@SessionAttributes(names = {"lTotalPages","lTotalElements","upLesson"})
public class LessonController {
	@Autowired
	private LessonService lService;
	
	@GetMapping("/login")
	public String login(Model m) {
//		m.addAttribute("memberId", memberId);
		return "login";
	}
	
//	@PostMapping("/lessonmain.controller")
//	public String processLessonMainAction(int memberId,Model m) {
//		m.addAttribute("memberId", memberId);
//		return "lesson/lessonQueryAll";
//	}
	
	@GetMapping("/lessonmain2.controller")
	public String processLessonMainAction2() {
		return "lesson/lessonQueryAll";
	}
	
	@PostMapping("/add")
	@ResponseBody
	public Lesson processInsertAction(@RequestBody Lesson lesson) {
		return lService.insertLesson(lesson);
	}
	
	@PostMapping("/querybyid/{lessonId}")
	@ResponseBody
	public Lesson processFindByIdAction(@PathVariable("lessonId") int lessonId) {
		return lService.findById(lessonId);
	}
	
	@PostMapping("/queryByPage/{pageNo}")
	@ResponseBody
	public List<Lesson> processQueryByPage(@PathVariable("pageNo") int pageNo,Model m){
		int pageSize = 2;
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		Page<Lesson> page = lService.findAllByPage(pageable);
		m.addAttribute("lTotalPages",page.getTotalPages());
		m.addAttribute("lTotalElements", page.getTotalElements());
		return page.getContent();
	}
	
	//學員端檢視課程列表
	@GetMapping("/lessonlist.controller")
	public String ListAction() {
		return "lesson/LessonList";
	}
		
	@GetMapping("/showlesson.controller")
	public String ArticleManageMainAction() {
		return "lesson/LessonManagement";

	}	
		

	@PostMapping("/searchByQuery")
	@ResponseBody
	public Page<Lesson> searchByQuery(@RequestBody SearchQuery query) {
		Pageable pageable = PageRequest.of(query.getOffset(), query.getLimit());
		Page<Lesson> results;
		if (query.getKeywords() != null && query.getKeywords() != "") {
			results = lService.findAllByLessonName(query.getKeywords(), pageable);
		} 
		else{
			results = lService.findAllByPage(pageable);
		}
		return results;
	}
		
	//新增文章
	@GetMapping(path = "/insertlessonform.controller")
	public String processMainPageAction() {
		return "lesson/insertLesson";
	}
	
	@PostMapping(path = "/insertarticle.controller")
	public String processAction(HttpServletRequest req,
			@RequestParam("lessonName") String lessonName,
			@RequestParam("lessonPrice") String lessonPrice,
			@RequestParam("aImage") MultipartFile file,
			Model am, HttpSession session) throws IllegalStateException, IOException {
		
		Map<String, String> errors = new HashMap<String, String>();
		am.addAttribute("errors", errors);
		
		if(lessonName==null || lessonName.length()==0) {
			errors.put("lessonName", "lessonName is required");
		}
		
		if(lessonPrice==null || lessonPrice.length()==0) {
			errors.put("lessonPrice", "lessonPrice is required");
		}

		if(errors!=null && !errors.isEmpty()) {
			return "lesson/insertLesson";
		}
		
		
		String fileName = System.currentTimeMillis() + file.getOriginalFilename();
		
		
		// 通過req.getServletContext().getRealPath("") 獲取當前專案的真實路徑，然後拼接前面的檔名
		String destFileName = req.getServletContext().getRealPath("") + "lessonImg" + File.separator + fileName;

		// 建立目錄（webapp下upload資料夾下）
		File destFile = new File(destFileName);
		destFile.getParentFile().mkdirs();
		// 把瀏覽器上傳的檔案複製到希望的位置
		file.transferTo(destFile);
		// 6.把檔名放在model裡，以便後續顯示用
		am.addAttribute("fileName", fileName);
		// 記錄在資料庫

		System.out.println("覆蓋圖片檔名:" + fileName);
		System.out.println("圖片的檔名:"+destFileName);
		
		//資料庫儲存的檔名 以利前端秀出圖片
		String dbpath = "/lessonImg/"+fileName;
		System.out.println("資料庫檔名:"+dbpath);
			
		int price = Integer.valueOf(lessonPrice);
		
		Lesson insertLesson = new Lesson(lessonName,price,dbpath);
		
		lService.insertLesson(insertLesson);
		return "lesson/LessonManagement";
	}
		
	//編輯文章
		@GetMapping(path = "/getlesson.controller")
		public String getLessonAction(@RequestParam("id")int id, Model m, HttpSession session) {
			Lesson upLesson = lService.findById(id);
			if(upLesson==null) {
		    	return "LessonManagerment";
			}
			System.out.println("看看有沒有upArticle"+upLesson);
			session.setAttribute("upLesson", upLesson);
	    	return "lesson/updateLesson";	
		}
		
		@PostMapping(path = "/updatelesson.controller")
		public String updateArticleAction(HttpServletRequest req,
				@RequestParam("lessonName") String lessonName,
				@RequestParam("lessonPrice") String lessonPrice,
				@RequestParam("aImage") MultipartFile file, Model uam, HttpSession session) throws IllegalStateException, IOException {
			
			//拿杯子（容器）
			Lesson d = (Lesson) session.getAttribute("upLesson");
			
			System.out.println(file.getOriginalFilename());
			if(file.getOriginalFilename().indexOf(".") == -1) {
				int price = Integer.valueOf(lessonPrice);
				d.setLessonName(lessonName);
				d.setLessonPrice(price);
				lService.updateLesson(d);
						
				return "lesson/LessonManagement";
			}
			
			
			String fileName = System.currentTimeMillis() + file.getOriginalFilename();

			// 通過req.getServletContext().getRealPath("") 獲取當前專案的真實路徑，然後拼接前面的檔名
			String destFileName = req.getServletContext().getRealPath("") + "lessonImg" + File.separator + fileName;
			// 建立目錄（webapp下upload資料夾下）
			File destFile = new File(destFileName);
			destFile.getParentFile().mkdirs();
			// 把瀏覽器上傳的檔案複製到希望的位置
			file.transferTo(destFile);
			// 6.把檔名放在model裡，以便後續顯示用
			uam.addAttribute("fileName", fileName);
			// 記錄在資料庫
			System.out.println("覆蓋圖片檔名" + fileName);
			String dbpath = "/lessonImg/"+fileName;
			d.setImage(dbpath);
			
			int price = Integer.valueOf(lessonPrice);
			d.setLessonName(lessonName);
			d.setLessonPrice(price);						
			lService.updateLesson(d);
					
			return "lesson/LessonManagement";
		}
		

}
