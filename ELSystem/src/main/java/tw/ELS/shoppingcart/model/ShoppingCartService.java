package tw.ELS.shoppingcart.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShoppingCartService {
	@Autowired
	private ShoppingCartRepository sResp;
	
	public ShoppingCartBean findById(Integer id) {
		Optional<ShoppingCartBean> op1 = sResp.findById(id);
		if(op1.isPresent()) {
			return op1.get();
		}
		return null;
	}
	
	public List<ShoppingCartBean> findAll(){
		return sResp.findAll();
	}
	
	public Page<ShoppingCartBean> findAllByPage(Pageable pageable){
		return sResp.findAll(pageable);
	}
	
	public ShoppingCartBean insertShoppingCartBean(ShoppingCartBean scb) {
		return sResp.save(scb);
	}
	
	public void deleteShoppingCartBean(Integer shoppingCartId) {
		sResp.deleteById(shoppingCartId);
	}
	
	public void deleteAllShoppingCartBean(int memberId) {
		sResp.deleteAllByMemberId(memberId);
	}
	
	public Page<ShoppingCartBean> findByMemberId(int memberId,Pageable pageable){
		return sResp.findByMemberId(memberId, pageable);
	}
	
	public List<ShoppingCartBean> findAllByMemberId(int memberId){
		return sResp.findAllByMemberId(memberId);
	}
	
	public ShoppingCartBean findByLessonIdAndMemberId(int lessonId,int memberId) {
		return sResp.findByLessonIdAndMemberId(lessonId,memberId);
	}
	
	

}
