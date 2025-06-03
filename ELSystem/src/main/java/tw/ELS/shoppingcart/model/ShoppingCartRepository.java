package tw.ELS.shoppingcart.model;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.ModelAttribute;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCartBean, Integer> {
	

//	@QueryHints(value = {@QueryHint(name = HINT_COMMENT, value = "a query for pageable")})
//	@Query("select * from shoppingCart s where s.memberId=:memberId")
	Page<ShoppingCartBean> findByMemberId(int memberId,Pageable pageable);
	void deleteAllByMemberId(@Param("memberId") int memberId);
	List<ShoppingCartBean> findAllByMemberId(int memberId);
	ShoppingCartBean findByLessonIdAndMemberId(int lessonId,int memberId);
	

}
