package tw.ELS.addpost.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddPostRepository extends JpaRepository<AddPost, Integer> {

	public Optional<AddPost> findByPostTitle(String postTitle);
	public List<AddPost> findAllByPostTitleContaining(String postTitle);


	@Query(value="select * from AddPost where POSTTITLE like concat('%',:postTitle,'%')",nativeQuery = true)
	public Page<AddPost> findPostTitlePage(String postTitle,Pageable pageable);
	
	
	
	
	
//	@Query(value = "from AddPost where like concat('%',?1,'%')")
//	public List<AddPost> findAddPost(String postTitle);
//	
//	public List<AddPost> findByNameLike(String postTitle);
//	
//	@Query(value = "Select * From AddPost" , nativeQuery = true)
//	public List<AddPost> findAll();
	
}
