package tw.ELS.ordersdetail.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import tw.ELS.lesson.model.Lesson;
import tw.ELS.orders.model.Orders;

@Entity @Table(name="ordersdetail")
@Component
public class OrdersDetail {
	
	public OrdersDetail() {};
	
	public OrdersDetail(int orderId,int lessonId) {
		this.orderId = orderId;
		this.lessonId = lessonId;
	}
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ORDERSDETAILID")
	private int ordersDetailId;
	
	@Column(name="ORDERID")
	private int orderId;
	
	@Column(name="LESSONID")
	private int lessonId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ORDERID",insertable=false ,updatable=false)
	@JsonBackReference
//	@JsonIgnore
	private Orders orders;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="LESSONID",insertable=false ,updatable=false)
	
	private Lesson lesson;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getLessonId() {
		return lessonId;
	}

	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public int getOrdersDetailId() {
		return ordersDetailId;
	}

	public void setOrdersDetailId(int ordersDetailId) {
		this.ordersDetailId = ordersDetailId;
	}
	
	

}
