package tw.ELS.article.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ARTICLE")
@Component
public class Article {

	@Id
	@Column(name = "ARTICLEID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int articleId;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "AUTHOR")
	private String author;
	
	@Column(name = "CREATEDATE")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date createDate;
	
	@Column(name = "CLASSIFICATION")
	private String classification;

	@Column(name = "IMAGE")
	private String image;

	@Column(name = "CONTENTS")
	private String content;
	
	@Column(name = "EXPIREDDATE")
	private String expiredDate;
	
	//@Column(name = "READERSHIP")
	//private int readerShip;
	

	public Article() {
	}
	
	//新增
	public Article(String title, String author, Date createDate, String classification, String content, String expiredDate) {
		this.title = title;	
		this.author = author;
		this.createDate = createDate;
		this.classification = classification;
		this.content = content;
		this.expiredDate = expiredDate;
		//this.readerShip = readerShip;
	}
	
	
	  //新增+上傳圖片
	public Article(String title, String author, Date createDate, String classification, String image, String content, String expiredDate) {
		this.title = title;	
		this.author = author;
		this.createDate = createDate;
		this.classification = classification;
		this.image = image;
		this.content = content;
		this.expiredDate = expiredDate;
		}
	 
	
	//更新
	public Article(int articleId, String title, String author, Date createDate, String classification, String content, String expiredDate) {
		this.articleId = articleId;
		this.title = title;	
		this.author = author;
		this.createDate = createDate;		
		this.classification = classification;
		this.content = content;
		this.expiredDate = expiredDate;
	}
	

	//更新+上傳圖片
	public Article(int articleId, String title, String author, Date createDate, String classification, String image, String content, String expiredDate) {
		this.articleId = articleId;
		this.title = title;
		this.author = author;
		this.createDate = createDate;
		this.classification = classification;
		this.image = image;
		this.content = content;
		this.expiredDate = expiredDate;
	}
	
	
	//取得更新的文章ID
	
	
	/*
	 * //查詢全部 public Article(int articleId, String title, String author, Date
	 * createDate, String classification, String content, String expiredDate) {
	 * this.articleId = articleId; this.title = title; this.author = author;
	 * this.createDate = createDate; this.classification = classification;
	 * this.content = content; this.expiredDate = expiredDate; //this.readerShip =
	 * readerShip; }
	 */
	
	/*
	 * public MultipartFile getFile() { return file; }
	 * 
	 * public void setFile(MultipartFile file) { this.file = file; }
	 */

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public String toString() {
		return "["+title+","+author+","+classification+","+content+","+expiredDate+"]";
	}

	public int getArticleId() {
		return articleId;
	}
	
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}	
	
	
}
