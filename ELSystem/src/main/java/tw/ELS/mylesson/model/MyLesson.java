package tw.ELS.mylesson.model;

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

import tw.ELS.lesson.model.Lesson;

@Entity @Table(name="mylesson")
@Component
public class MyLesson {
	
	public MyLesson() {};
	
	public MyLesson(int myLessonId,int memberId,int lessonId,Lesson lesson) {
		this.myLessonId = myLessonId;
		this.memberId = memberId;
		this.lessonId = lessonId;
		this.lesson = lesson;
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MYLESSONID")
	private int myLessonId;
	
	@Column(name="MEMBERID")
	private int memberId;
	
	@Column(name="LESSONID")
	private int lessonId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="LESSONID",insertable=false,updatable=false)
	private Lesson lesson;

	public int getMyLessonId() {
		return myLessonId;
	}

	public void setMyLessonId(int myLessonId) {
		this.myLessonId = myLessonId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getLessonId() {
		return lessonId;
	}

	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}


	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
	
	

}
