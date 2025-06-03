package tw.ELS.article.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
	
	  public Optional<Article> findByTitle(String title);
	  public List<Article> findAllByTitleContaining(String title);
	  
	  @Query(value="select * from Article where TITLE like concat('%',:title,'%')",nativeQuery = true)
	  public Page<Article> findArticleTitlePage(String title, Pageable pageable);
		
}
