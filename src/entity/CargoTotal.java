package entity;

import java.util.List;

public class CargoTotal {
	private int flightId;
	private List<Baggage> baggage;
	private List<Cargo> cargo;
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public List<Baggage> getBaggage() {
		return baggage;
	}
	public void setBaggage(List<Baggage> baggages) {
		this.baggage = baggages;
	}
	public List<Cargo> getCargo() {
		return cargo;
	}
	public void setCargo(List<Cargo> cargos) {
		this.cargo = cargos;
	}
	public CargoTotal(int flightId, List<Baggage> baggage, List<Cargo> cargos) {
		super();
		this.flightId = flightId;
		this.baggage = baggage;
		this.cargo = cargos;
	}
	public CargoTotal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// get Cargo Weight for requested Flight
	public double getTotalCargoWeight() {
		// calculate sum of kg of cargos
		double sum = 0;
		for (int i = 0; i < cargo.size(); i++) {
			sum += cargo.get(i).getWeightKg();
		}
		return sum;
	}

	// get Baggage Weight for requested Flight
	public double getTotalBaggageWeight() {

		// calculate sum of kg of baggages
		double sum = 0;
		for (int i = 0; i < baggage.size(); i++) {
			sum += baggage.get(i).getWeightKg();
		}
		return sum;
	}

	// get Baggage pieces for requested Flight
	public int getTotalBaggagePieces() {

		// calculate sum of pieces of baggage
		int sum = 0;
		for (int i = 0; i < baggage.size(); i++) {
			sum += baggage.get(i).getPieces();
		}
		return sum;
	}
	
}
