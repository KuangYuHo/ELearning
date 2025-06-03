package tw.ELS.orders.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.ELS.ordersdetail.model.OrdersDetail;

@Service
@Transactional
public class OrdersService {
	@Autowired
	private OrdersRepository oResp;
	
	public Orders findById(Integer id) {
		Optional<Orders> op1 = oResp.findById(id);
		if(op1.isPresent()) {
			return op1.get();
		}
		return null;
	}
	
	public List<Orders> findAll(){
		return oResp.findAll();
	}
	
	public Orders insertOrders(Orders od) {
		return oResp.save(od);
	}
	
	public void deleteOrders(Integer orderId) {
		oResp.deleteById(orderId);
	}
	
	public List<Orders> findByMemberId(int memberId){
		return oResp.findByMemberId(memberId);
	}
	
	public Page<Orders> findAllByMemberId(int memberId,Pageable pageable){
		return oResp.findAllByMemberId(memberId, pageable);
	}
	
	public Page<Orders> findAll(Pageable pageable){
		return oResp.findAll(pageable);
	}
	
	public Orders findByOrderId(int orderId) {
		return oResp.findByOrderId(orderId);
	}

}
