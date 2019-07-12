package cmc.intern.main.Input.model;

import java.io.Serializable;
import java.util.ArrayList;

public class InputUserAndScore implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hoTen;
	private String lop;
	private ArrayList<ArrayList<Double>> diem;
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public ArrayList<ArrayList<Double>> getDiem() {
		return diem;
	}
	public void setDiem(ArrayList<ArrayList<Double>> diem) {
		this.diem = diem;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
