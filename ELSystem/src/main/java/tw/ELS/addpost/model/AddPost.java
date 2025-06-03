package tw.ELS.addpost.model;

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

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import tw.ELS.elsmessage.model.ELSMessage;

@Entity
@Table(name = "addpost")
@Component
public class AddPost {

	@Id
	@Column(name = "POSTID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId; // 貼文id

//	@JsonManagedReference與@JsonBackReference
//	為了解決物件中存在雙向引用導致的無限遞迴問題，在處理數據之間的雙向鏈接，
//	一個用於父級角色，另一個用於子級角色。
//	＠JsonManagedReference被序列化的數據，
//	而@JsonBackReference標註，不會被序列化。

	@JsonManagedReference // 父
	// mappedBy的意思是一對多關聯至ELSMessage entity 的addpost上
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "addpost")
	private Set<ELSMessage> messages = new LinkedHashSet<ELSMessage>();

	@Column(name = "POSTTYPE")
	private String postType; // 貼文分類

	@Column(name = "POSTTITLE")
	private String postTitle; // 貼文標題

	@Column(name = "POSTINFORMATION")
	private String postInformation; // 貼文內容

	@Column(name = "POSTDATE")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date postDate; // 貼文日期

	@Column(name = "POSTLIKEQTY")
	private Integer postLikeQty; // 貼文按讚數

	@Column(name = "POSTVIEWS")
	private Integer postViews; // 貼文瀏覽數

	@Column(name = "MEMBERID")
	private Integer memberId;

	@Column(name = "MNAME")
	private String mName;

	@Column(name = "PHOTO")
	private String photo;

	public AddPost() {
	}

	public AddPost(Integer postId, Set<ELSMessage> messages, String postType, String postTitle, String postInformation,
			Date postDate, Integer postLikeQty, Integer postViews, Integer memberId,String mName,String photo) {
		this.postId = postId;
		this.messages = messages;
		this.postType = postType;
		this.postTitle = postTitle;
		this.postInformation = postInformation;
		this.postDate = postDate;
		this.postLikeQty = postLikeQty;
		this.postViews = postViews;
		this.memberId = memberId;
		this.mName = mName;
		this.photo = photo;
	}

	public AddPost(Set<ELSMessage> messages, String postType, String postTitle, String postInformation, Date postDate,
			Integer postLikeQty, Integer postViews, Integer memberId,String mName,String photo) {
		this.messages = messages;
		this.postType = postType;
		this.postTitle = postTitle;
		this.postInformation = postInformation;
		this.postDate = postDate;
		this.postLikeQty = postLikeQty;
		this.postViews = postViews;
		this.memberId = memberId;
		this.mName = mName;
		this.photo = photo;
	}

	public Set<ELSMessage> getMessages() {
		return messages;
	}

	public void setMessages(Set<ELSMessage> messages) {
		this.messages = messages;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostInformation() {
		return postInformation;
	}

	public void setPostInformation(String postInformation) {
		this.postInformation = postInformation;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public Integer getPostLikeQty() {
		return postLikeQty;
	}

	public void setPostLikeQty(Integer postLikeQty) {
		this.postLikeQty = postLikeQty;
	}

	public Integer getPostViews() {
		return postViews;
	}

	public void setPostViews(Integer postViews) {
		this.postViews = postViews;
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
