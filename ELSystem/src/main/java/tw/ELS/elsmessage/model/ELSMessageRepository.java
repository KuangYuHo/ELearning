package tw.ELS.elsmessage.model;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ELSMessageRepository extends JpaRepository<ELSMessage, Integer> {

	//public List<ELSMessage> findMsgByPostId(Integer postId);
	
	public List<ELSMessage> findAllByPostId(Integer postId);
	
	public Page<ELSMessage> findByPostId(Integer postId,Pageable pageable);
	
	
	
}
