package cmc.intern.main.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the subject database table.
 * 
 */
@Entity
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String subject;
	
	@JsonIgnore
	@OneToMany(mappedBy="subject",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<UserScoreRelate> userScoreRelates;

	public Subject() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<UserScoreRelate> getUserScoreRelates() {
		return this.userScoreRelates;
	}

	public void setUserScoreRelates(List<UserScoreRelate> userScoreRelates) {
		this.userScoreRelates = userScoreRelates;
	}

	public UserScoreRelate addUserScoreRelate(UserScoreRelate userScoreRelate) {
		getUserScoreRelates().add(userScoreRelate);
		userScoreRelate.setSubject(this);

		return userScoreRelate;
	}

	public UserScoreRelate removeUserScoreRelate(UserScoreRelate userScoreRelate) {
		getUserScoreRelates().remove(userScoreRelate);
		userScoreRelate.setSubject(null);

		return userScoreRelate;
	}

}