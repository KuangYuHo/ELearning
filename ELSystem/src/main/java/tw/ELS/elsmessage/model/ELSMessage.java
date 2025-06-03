package tw.ELS.elsmessage.model;

import java.util.Date;

import javax.persistence.CascadeType;
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
import com.fasterxml.jackson.annotation.JsonFormat;

import tw.ELS.addpost.model.AddPost;



@Entity
@Table(name = "elsmessage")
@Component
public class ELSMessage {

	@Id
	@Column(name = "MESSAGEID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer messageId; //留言id

	//@JoinColumn(name="POSTID", referencedColumnName="POSTID") FK 為POSTID ，關聯至AddPost 的POSTID
	@JsonBackReference  //子
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
	@JoinColumn(name="POSTID",insertable=false,updatable=false)
	private AddPost addpost;
	
	@Column(name = "POSTID")
	private Integer postId; //貼文id

	@Column(name = "MESSAGEINFORMATION")
	private String messageinformation; //留言內容

	@Column(name = "MESSAGEDATE")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date messageDate; //留言日期

	@Column(name = "MESSAGELIKEQTY")
	private Integer messageLikeQty; //留言按讚數

	@Column(name = "MEMBERID")
	private Integer memberId;//會員id
	
	
	@Column(name = "MNAME")
	private String mName;//會員名字

	@Column(name = "PHOTO")
	private String photo;//會員照片

	public AddPost getAddpost() {
		return addpost;
	}

	public void setAddpost(AddPost addpost) {
		this.addpost = addpost;
	}

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getMessageinformation() {
		return messageinformation;
	}

	public void setMessageinformation(String messageinformation) {
		this.messageinformation = messageinformation;
	}

	public Date getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}

	public Integer getMessageLikeQty() {
		return messageLikeQty;
	}

	public void setMessageLikeQty(Integer messageLikeQty) {
		this.messageLikeQty = messageLikeQty;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	
}
