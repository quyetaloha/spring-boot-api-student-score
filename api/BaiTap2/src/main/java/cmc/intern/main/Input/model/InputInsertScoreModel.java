package cmc.intern.main.Input.model;

import java.io.Serializable;

public class InputInsertScoreModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_user;
	private int id_subject;
	private double process_score;
	private double exam_score;
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getId_subject() {
		return id_subject;
	}
	public void setId_subject(int id_subject) {
		this.id_subject = id_subject;
	}
	public double getProcess_score() {
		return process_score;
	}
	public void setProcess_score(double process_score) {
		this.process_score = process_score;
	}
	public double getExam_score() {
		return exam_score;
	}
	public void setExam_score(double exam_score) {
		this.exam_score = exam_score;
	}
	
}
