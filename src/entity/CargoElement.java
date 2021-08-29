package entity;

import java.util.List;

public abstract class CargoElement {
	private int id;
	private int weight;
	private String weightUnit;
	private int pieces;
	
	public CargoElement() {
		super();
	}
	public CargoElement(int id, int weight, String weightUnit, int pieces) {
		super();
		this.id = id;
		this.weight = weight;
		this.weightUnit = weightUnit;
		this.pieces = pieces;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getWeightUnit() {
		return weightUnit;
	}
	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}
	public int getPieces() {
		return pieces;
	}
	public void setPieces(int pieces) {
		this.pieces = pieces;
	}
	
	public double getWeightKg() {
		if(this.weightUnit.equals("kg")) return this.weight;
		else return this.weight*0.45359237;
	}
}
