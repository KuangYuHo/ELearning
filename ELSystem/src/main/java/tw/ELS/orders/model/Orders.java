package tw.ELS.orders.model;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import tw.ELS.ordersdetail.model.OrdersDetail;

@Entity @Table(name="orders")
@Component
public class Orders {
	
	public Orders() {};
	
	public Orders(int orderId,int memberId,int payPrice,Date payDate,Set<OrdersDetail> ordersDetail) {
		this.orderId = orderId;
		this.memberId = memberId;
		this.payPrice = payPrice;
		this.payDate = payDate;
		this.ordersDetail = ordersDetail;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ORDERID")
	private int orderId;
	
	@Column(name="MEMBERID")
	private int memberId;
	
	@Column(name="PAYPRICE")
	private int payPrice;
	
	@Column(name="PAYDATE")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date payDate;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "orders",cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<OrdersDetail> ordersDetail = new LinkedHashSet<OrdersDetail>();

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(int payPrice) {
		this.payPrice = payPrice;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Set<OrdersDetail> getOrdersDetail() {
		return ordersDetail;
	}

	public void setOrdersDetail(Set<OrdersDetail> ordersDetail) {
		this.ordersDetail = ordersDetail;
	}
	
	

}
