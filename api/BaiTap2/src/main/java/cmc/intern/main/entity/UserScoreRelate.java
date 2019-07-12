package cmc.intern.main.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the user_score_relate database table.
 * 
 */
@Entity
@Table(name = "user_score_relate")

public class UserScoreRelate implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "exam_score")
	private double examScore;

	@Column(name = "process_score")
	private double processScore;

	@ManyToOne
	@JoinColumn(name = "id_subject")
	private Subject subject;

	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;

	public UserScoreRelate() {
	}

	public double getExamScore() {
		return this.examScore;
	}

	public void setExamScore(double examScore) {
		this.examScore = examScore;
	}

	public double getProcessScore() {
		return this.processScore;
	}

	public void setProcessScore(double processScore) {
		this.processScore = processScore;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}