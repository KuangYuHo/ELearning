package tw.ELS.elsmessage.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ELSMessageService {

	@Autowired
	private ELSMessageRepository MsgRep;
	
	public ELSMessage insert(ELSMessage Message) {
		return MsgRep.save(Message);	
	}
	
	public ELSMessage update(ELSMessage Message) {
		return MsgRep.save(Message);		
	}
	
	public void deleteById(Integer messageId) {
		 MsgRep.deleteById(messageId);
	}
	
	public void delete(ELSMessage Message) {
		 MsgRep.delete(Message);
	}
	
	
	public ELSMessage findById(Integer postId) {
		Optional<ELSMessage> op1 = MsgRep.findById(postId);
		if(op1.isPresent()) {
			return op1.get();
		}		
		return null;		
	}
	
	public List<ELSMessage> findAll(){
		return MsgRep.findAll();
	}
	
	public Page<ELSMessage> findAllByPage(Pageable pageable){
		return MsgRep.findAll(pageable);		
	}
	
	public List<ELSMessage> findAllByPostId(Integer postId){
		return MsgRep.findAllByPostId(postId);
		
	}
	
	public Page<ELSMessage> findByPostId(Integer postId,Pageable pageable){
		return MsgRep.findByPostId(postId, pageable);		
	}
}
