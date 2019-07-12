package cmc.intern.main.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name = "ho_ten")
	private String hoTen;

	private String lop;

	//bi-directional many-to-one association to UserScoreRelate
	
	@OneToMany(mappedBy="user",fetch=FetchType.EAGER ,cascade=CascadeType.ALL)
	private List<UserScoreRelate> userScoreRelates;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoTen() {
		return this.hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getLop() {
		return this.lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public List<UserScoreRelate> getUserScoreRelates() {
		return this.userScoreRelates;
	}

	public void setUserScoreRelates(List<UserScoreRelate> userScoreRelates) {
		this.userScoreRelates = userScoreRelates;
	}

	public UserScoreRelate addUserScoreRelate(UserScoreRelate userScoreRelate) {
		getUserScoreRelates().add(userScoreRelate);
		userScoreRelate.setUser(this);

		return userScoreRelate;
	}

	public UserScoreRelate removeUserScoreRelate(UserScoreRelate userScoreRelate) {
		getUserScoreRelates().remove(userScoreRelate);
		userScoreRelate.setUser(null);

		return userScoreRelate;
	}

}