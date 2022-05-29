package com.ass.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "categoryquestion", catalog = "TestingSystem")
public class CategoryQuestion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CategoryID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "CategoryName", length = 50, nullable = false, unique = true)
	private String name;
	
	@OneToOne(mappedBy = "categoryQuestion")
	private Question question;

	public CategoryQuestion() {
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "CategoryQuestion [id=" + id + ", name=" + name + ", question=" + question.getContent() + "]";
	}

	

	
}
