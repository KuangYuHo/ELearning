package tw.ELS.member.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity @Table(name = "Member")
@Component
public class Member {
	@Id @Column(name = "MEMBERID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberID;
	
	@Column(name = "ACCOUNT")
	private String account;

	@Column(name = "MPASSWORD")
	private String mPassword;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "MNAME")
	private String mName;
	
	@Column(name = "PHONE")
	private String phone;
	
	@Column(name = "IDENTITYID")
	private String identityID;
	
	@Column(name = "MADDRESS")
	private String mAddress;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "BIRTH")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date birth;
	
	@Column(name = "LASTLOGIN")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date lastLogIn ;
	
	@Column(name = "PHOTO")
	private String photo;

	@Column(name = "AUTHORITY")
	private Integer authority;
	
//	@JsonIgnore
//	@ManyToMany(mappedBy = "members",fetch = FetchType.EAGER)
//	private Set<Authority> groups = new HashSet<Authority>();

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdentityID() {
		return identityID;
	}

	public void setIdentityID(String identityID) {
		this.identityID = identityID;
	}

	public String getmAddress() {
		return mAddress;
	}

	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Date getLastLogIn() {
		return lastLogIn;
	}

	public void setLastLogIn(Date lastLogIn) {
		this.lastLogIn = lastLogIn;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getAuthority() {
		return authority;
	}

	public void setAuthority(Integer authority) {
		this.authority = authority;
	}

//	public Set<Authority> getGroups() {
//		return groups;
//	}
//
//	public void setGroups(Set<Authority> groups) {
//		this.groups = groups;
//	}
	
	
	
}
