package com.ass.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ass.entity.enumarate.TypeQuestionName;
import com.ass.entity.enumarate.TypeQuestionNameConvert;

@Entity
@Table(name = "TypeQuestion", catalog = "TestingSystem")
public class TypeQuestion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "TypeID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "TypeName", nullable = false, unique = true)
	@Convert(converter = TypeQuestionNameConvert.class)
	private TypeQuestionName name;
	
	@OneToMany(mappedBy = "typeQuestion")
	private List<Question> questions;

	public TypeQuestion() {
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public TypeQuestionName getName() {
		return name;
	}

	public void setName(TypeQuestionName name) {
		this.name = name;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "TypeQuestion [id=" + id + ", name=" + name + ", questions=" + questions + "]";
	}

	

	
}
