package tw.ELS.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import tw.ELS.lesson.model.Lesson;

@Entity @Table(name="shoppingcart")
@Component
public class ShoppingCartBean {
	
public ShoppingCartBean() {};
	
	public ShoppingCartBean(int shoppingCartId,int memberId,int lessonId,Lesson lesson) {
		this.shoppingCartId = shoppingCartId;
		this.memberId = memberId;
		this.lessonId = lessonId;
		this.lesson = lesson;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SHOPPINGCARTID")
	private int shoppingCartId;
	
	@Column(name="MEMBERID")
	private int memberId;
	
	@Column(name="LESSONID")
	private int lessonId;
	
//	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LESSONID"  ,insertable=false ,updatable=false )
	private Lesson lesson;
	
	

	public int getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(int shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	
	  public int getLessonId() { return lessonId; }
	  
	  public void setLessonId(int lessonId) { this.lessonId = lessonId; }
	 

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	

}
