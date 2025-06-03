package tw.ELS.article.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import tw.ELS.article.model.Article;
import tw.ELS.article.model.ArticleService;
import tw.ELS.article.model.SearchQuery;


@Controller
@RequestMapping("/article")
@SessionAttributes(names={"searchtext","totalPages","totalElements"})
public class ArticleController {
	
	@Autowired
	private ArticleService aService;
	
	@GetMapping("/showarticle.controller")
	public String ArticleManageMainAction() {
		return "article/ArticlesManagement";

	}
	
	//學員端檢視文章列表
	@GetMapping("/articlelist.controller")
	public String ListAction() {
		return "article_user/ArticlesList";
	}
	
	//學員端檢視特定文章
	 @GetMapping("/viewarticle.controller") 
	 public String ViewArticleAction(@RequestParam("id")int id, Model m) {
	  Article vArticle = aService.findById(id);
	  m.addAttribute("vArticle", vArticle);
	  return "article_user/viewArticle";
	  
	 }
	 
	
	/*
	 * //顯示所有文章
	 * 
	 * @GetMapping(path = "/showarticle.controller") public String
	 * processMainAction(Model sam) { List<Article> aList = aService.findAll();
	 * sam.addAttribute("aList", aList); return "article/ArticlesManagement"; }
	 */
	
	//新增文章
	@GetMapping(path = "/insertarticleform.controller")
    public String processMainPageAction() {
    	return "article/insertArticle";
    }
	
	@PostMapping(path = "/insertarticle.controller")
	public String processAction(HttpServletRequest req,
			@RequestParam("aTitle") String title,
			@RequestParam("aAuthor") String author,
			//@RequestParam("aCreateDate") String createDate,
			@RequestParam("aClassification") String classification,
			@RequestParam("aImage") MultipartFile file,
			@RequestParam("aContent") String content,
			@RequestParam("aExpiredDate") String expiredDate, Model am, HttpSession session) throws IllegalStateException, IOException {
		
		Map<String, String> errors = new HashMap<String, String>();
		am.addAttribute("errors", errors);
		
		if(title==null || title.length()==0) {
			errors.put("title", "title is required");
		}
		
		if(author==null || author.length()==0) {
			errors.put("author", "author is required");
		}
		
		if(classification==null || classification.length()==0) {
			errors.put("classification", "classification is required");
		}
		
		if(content==null || content.length()==0) {
			errors.put("content", "content is required");
		}
		
		if(errors!=null && !errors.isEmpty()) {
			return "article/insertArticle";
		}
		
		
		String fileName = System.currentTimeMillis() + file.getOriginalFilename();
		
		
		// 通過req.getServletContext().getRealPath("") 獲取當前專案的真實路徑，然後拼接前面的檔名
		String destFileName = req.getServletContext().getRealPath("") + "postImg" + File.separator + fileName;

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
		String dbpath = "/postImg/"+fileName;
		System.out.println("資料庫檔名:"+dbpath);
		
		java.util.Date createDate = new java.util.Date();
		
		Article article = new Article(title, author, createDate, classification, dbpath, content, expiredDate);
		aService.insert(article);
		am.addAttribute("aTitle", title);
		am.addAttribute("aAuthor", author);
		am.addAttribute("aCreateDate", createDate);
		am.addAttribute("aClassification", classification);
		am.addAttribute("image", dbpath);
		am.addAttribute("aContent", content);
		am.addAttribute("aExpiredDate", expiredDate);
		return "article/insertArticleSuccess";
	}
	
	//編輯文章
	@GetMapping(path = "/getarticle.controller")
	public String getArticleAction(@RequestParam("id")int id, Model m, HttpSession session) {
		Article upArticle = aService.findById(id);
		
		if(upArticle==null) {
	    	return "ArticlesManagerment";
		}
		System.out.print("看看有沒有upArticle"+upArticle);
		session.setAttribute("upArticle", upArticle);
    	return "article/updateArticle";	
	}
	
	@PostMapping(path = "/updatearticle.controller")
	public String updateArticleAction(HttpServletRequest req,
			@RequestParam("aId") int id,
			@RequestParam("aTitle") String title,
			@RequestParam("aAuthor") String author,
			//@RequestParam("aCreateDate") String createDate,
			@RequestParam("aClassification") String classification,
			@RequestParam("aImage") MultipartFile file,
			@RequestParam("aContent") String content,
			@RequestParam("aExpiredDate") String expiredDate, Model uam, HttpSession session) throws IllegalStateException, IOException {
		
		//拿杯子（容器）
		Article d = (Article) session.getAttribute("upArticle");
		
		//拿咖啡裡面的糖
		Date createDate = (Date) d.getCreateDate();
		System.out.print("看看有沒有拿到日期"+createDate);
		
		if(file.getOriginalFilename().indexOf(".") == -1) {
			Article article = new Article(id, title, author, createDate, classification, d.getImage(), content, expiredDate);
			Article upaid = aService.update(article);
			uam.addAttribute("updateSuccess", article);

			return "article/updateArticleSuccess";
		}
		
		
		String fileName = System.currentTimeMillis() + file.getOriginalFilename();

		// 通過req.getServletContext().getRealPath("") 獲取當前專案的真實路徑，然後拼接前面的檔名
		String destFileName = req.getServletContext().getRealPath("") + "postImg" + File.separator + fileName;
		// 建立目錄（webapp下upload資料夾下）
		File destFile = new File(destFileName);
		destFile.getParentFile().mkdirs();
		// 把瀏覽器上傳的檔案複製到希望的位置
		file.transferTo(destFile);
		// 6.把檔名放在model裡，以便後續顯示用
		uam.addAttribute("fileName", fileName);
		// 記錄在資料庫
		System.out.println("覆蓋圖片檔名" + fileName);
		
		String dbpath = "/postImg/"+fileName;

		
		Article article = new Article(id, title, author, createDate, classification, dbpath, content, expiredDate);
		Article upaid = aService.update(article);
		uam.addAttribute("updateSuccess", article);
		
		
		return "article/updateArticleSuccess";
	}
	
	//刪除文章
	@GetMapping(path = "/deletearticle.controller")
	@ResponseBody
	public Boolean deleteAction(int id, Model dam) {
		
		System.out.println(id);
		aService.deleteById(id);
		dam.addAttribute("deleteAction", id);
		return true;
	}
	

    @PostMapping("/searchByQuery")
    @ResponseBody
    public Page<Article> searchByQuery(@RequestBody SearchQuery query) {
        Pageable pageable = PageRequest.of(query.getOffset(), query.getLimit());
        Page<Article> results;

        if (query.getKeywords() != null && query.getKeywords() != "") {
            results = aService.findAllByTitlePage(query.getKeywords(), pageable);
        } else {
            results = aService.findAllByPage(pageable);
        }

        return results;
    }
	
	//分頁
	@PostMapping("/queryByPage/{pageNo}")
	@ResponseBody
	public List<Article> processQueryByPage(@PathVariable("pageNo") int pageNo, Model m){
		int pageSize = 10;
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		Page<Article> page = aService.findAllByPage(pageable);
		m.addAttribute("totalPages", page.getTotalPages());
		m.addAttribute("totalElements", page.getTotalElements());
		return page.getContent();
	}
	
	// 關鍵字搜尋
	@PostMapping("/searchqueryByPage")
	public String gosearchList(@RequestParam String searchtext, Model m) throws SQLException {
		m.addAttribute("searchtext", searchtext);

		return "article/searchArticleResult";
	}

	@PostMapping("/searchqueryByPage/{pageNo}")
	@ResponseBody
	public List<Article> searchQueryByPage(@PathVariable("pageNo") int pageNo, Model m) {
		int pageSize = 10;
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);

		String searchText = (String) m.getAttribute("searchtext");

		Page<Article> page = aService.findAllByTitlePage(searchText,pageable);
		
		System.out.println(page.getPageable());
		System.out.println(page.getTotalElements());

		m.addAttribute("totalPages", page.getTotalPages());
		m.addAttribute("totalElements", page.getTotalElements());
		return page.getContent();
	}

}
