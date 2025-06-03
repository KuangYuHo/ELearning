package tw.ELS.lesson.model;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import tw.ELS.mylesson.model.MyLesson;
import tw.ELS.ordersdetail.model.OrdersDetail;
import tw.ELS.shoppingcart.model.ShoppingCartBean;

@Entity @Table(name="lesson")
@Component
public class Lesson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LESSONID")
	private int lessonId;
	
	@Column(name="LESSONNAME")
	private String lessonName;
	
	@Column(name="LESSONPRICE")
	private int lessonPrice;
	
	@Column(name = "IMAGE")
	private String image;
	
	@JsonIgnore
//	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "lesson",cascade = CascadeType.ALL)
	private Set<ShoppingCartBean> shoppingCartBean = new LinkedHashSet<ShoppingCartBean>();
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "lesson",cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<OrdersDetail> ordersDetail = new LinkedHashSet<OrdersDetail>();
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "lesson",cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<MyLesson> myLesson = new LinkedHashSet<MyLesson>();
	
	public Lesson() {}

	public Lesson(String lessonName,int lessonPrice,String image) {
		this.lessonName = lessonName;
		this.lessonPrice = lessonPrice;
		this.image = image;

	}
	
	public int getLessonId() {
		return lessonId;
	}

	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public int getLessonPrice() {
		return lessonPrice;
	}

	public void setLessonPrice(int lessonPrice) {
		this.lessonPrice = lessonPrice;
	}

	public Set<ShoppingCartBean> getShoppingCartBean() {
		return shoppingCartBean;
	}

	public void setShoppingCartBean(Set<ShoppingCartBean> shoppingCartBean) {
		this.shoppingCartBean = shoppingCartBean;
	}

	public Set<OrdersDetail> getOrdersDetail() {
		return ordersDetail;
	}

	public void setOrdersDetail(Set<OrdersDetail> ordersDetail) {
		this.ordersDetail = ordersDetail;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	

}
