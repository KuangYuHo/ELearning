package tw.ELS.ordersdetail.model;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersDetailRepository extends JpaRepository<OrdersDetail, Integer> {
	Set<OrdersDetail> findByOrderId(int orderId);
	Page<OrdersDetail> findAllByOrderId(int orderId,Pageable pageable);
	Page<OrdersDetail> findAll(Pageable pageable);

}
