package com.ass.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "`Question`", catalog = "TestingSystem")
@Inheritance(strategy = InheritanceType.JOINED)
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "QuestionID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "Content", length = 100, nullable = false)
	private String content;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
	private CategoryQuestion categoryQuestion;
	
	@ManyToOne
	@JoinColumn(name = "TypeID", referencedColumnName = "TypeID")
	private TypeQuestion typeQuestion;
	
	@ManyToOne
	@JoinColumn(name = "CreatorID", referencedColumnName = "AccountID")
	private Account account;

	@Column(name = "CreateDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;

	public Question() {
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CategoryQuestion getCategoryQuestion() {
		return categoryQuestion;
	}

	public void setCategoryQuestion(CategoryQuestion categoryQuestion) {
		this.categoryQuestion = categoryQuestion;
	}

	public TypeQuestion getTypeQuestion() {
		return typeQuestion;
	}

	public void setTypeQuestion(TypeQuestion typeQuestion) {
		this.typeQuestion = typeQuestion;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", content=" + content + ", categoryID=" + categoryQuestion + ", typeID=" + typeQuestion.getName()
				+ ", creatorID=" + account.getFullName() + ", createDate=" + createDate + "]";
	}

	

}
