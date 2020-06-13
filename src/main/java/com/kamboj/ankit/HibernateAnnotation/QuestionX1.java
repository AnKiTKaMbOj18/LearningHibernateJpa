package com.kamboj.ankit.HibernateAnnotation;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "questionX1")
public class QuestionX1 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "qname")
	private String qname;

	@ManyToMany(targetEntity = AnswerX1.class, cascade = { CascadeType.ALL })
	@JoinTable(name = "question_answer_X1", joinColumns = { @JoinColumn(name = "ques_id") }, inverseJoinColumns = {
			@JoinColumn(name = "ans_id") })
	private List<AnswerX1> answers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQname() {
		return qname;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}

	public List<AnswerX1> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerX1> answers) {
		this.answers = answers;
	}
	
}
