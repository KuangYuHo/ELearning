package tw.ELS.article.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArticleService {
	
	@Autowired
	private ArticleRepository aResp;
	
	//新增
	public Article insert(Article article) {
		return aResp.save(article);
	}
	
	//修改
	public Article update(Article article) {
		return aResp.save(article);	
	}
	
	//刪除
	public void deleteById(Integer id) {
		aResp.deleteById(id);
	}
	
	//查詢
	public List<Article> findAll() {
		return aResp.findAll();
	}
	
	//取得欲修改的文章
	public Article findById(Integer id) {
		Optional<Article> op1 = aResp.findById(id);
		return op1.get();
	}
	
	//加上分頁
	public Page<Article> findAllByPage(Pageable pageable){
		return aResp.findAll(pageable);
	}
	
	//輸入關鍵字搜尋文章標題
	public Article findByTitle(String title) {
		Optional<Article> op1 = aResp.findByTitle(title);
		
		if(op1.isEmpty()) {
			return null;
		}
		return op1.get();
	}
	
	public Page<Article> findAllByTitlePage(String title, Pageable pageable){
		return aResp.findArticleTitlePage(title, pageable);
	}
	 
}
