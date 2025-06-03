package tw.ELS.addpost.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddPostService {

	@Autowired
	private AddPostRepository aResp;
	
	

	public AddPost insert(AddPost addPost) {
		return aResp.save(addPost);
	}

	public AddPost update(AddPost addPost) {
		return aResp.save(addPost);
	}

	public void deleteById(Integer postId) {
		aResp.deleteById(postId);
	}

	public void delete(AddPost addPost) {
		aResp.delete(addPost);
	}

	public AddPost findById(Integer postId) {
		Optional<AddPost> op1 = aResp.findById(postId);
		return op1.get();
	}

	public List<AddPost> findAll() {
		return aResp.findAll();

	}

	public Page<AddPost> findAllByPage(Pageable pageable) {
		return aResp.findAll(pageable);

	}
	
	//關鍵字查詢
	public AddPost findByPostTitle(String postTitle) {
		Optional<AddPost> op1 = aResp.findByPostTitle(postTitle);
		if(op1.isEmpty()) {
			return null;
		}		
		return op1.get();
	}
	
	//關鍵字查詢
	public Page<AddPost>searchfindAllByPostTitlePage(String postTitle,Pageable pageable){
		return aResp.findPostTitlePage(postTitle,pageable);
	}
	
	//未成功
//	public Optional<AddPost> getMsgByPostId(Integer postId){
//		Optional<AddPost> Optional = aResp.findById(postId);
//		return Optional;
//	}
	

	// 模糊搜尋
//	public List<AddPost> findAddPost(String postTitle){
//		return aResp.findAddPost(postTitle);		
//	}
//	
//	public List<AddPost> findByNameLike(String postTitle){
//		return aResp.findByNameLike(postTitle);
//		
//	}
}
