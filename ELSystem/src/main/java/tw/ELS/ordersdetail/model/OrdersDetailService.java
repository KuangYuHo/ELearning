package tw.ELS.ordersdetail.model;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrdersDetailService {
	@Autowired
	private OrdersDetailRepository odResp;
	
	public Set<OrdersDetail> findByOrderId(int orderId){
		return odResp.findByOrderId(orderId);
	}
	
	public Page<OrdersDetail> findAllByOrderId(int orderId,Pageable pageable){
		return odResp.findAllByOrderId(orderId, pageable);
	}
	
	public Page<OrdersDetail> findAll(Pageable pageable){
		return odResp.findAll(pageable);
	}

}
