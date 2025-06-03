package tw.ELS.orders.model;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import tw.ELS.ordersdetail.model.OrdersDetail;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
	List<Orders> findByMemberId(int memberId);
	Page<Orders> findAllByMemberId(int memberId,Pageable pageable);
	Page<Orders> findAll(Pageable pageable);
	Orders findByOrderId(int orderId);

}
