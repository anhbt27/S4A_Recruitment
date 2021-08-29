package service;

import entity.CargoTotal;
import entity.Flight;
import repository.CargoRepository;
import repository.FlightRepository;

public class FlightService {
	
	private FlightRepository flightRepository;
	private CargoRepository cargoRepository;
	
	
	public FlightService(FlightRepository flightRepository, CargoRepository cargoRepository) {
		super();
		this.flightRepository = flightRepository;
		this.cargoRepository = cargoRepository;
	}


	/*
	 * For requested Flight Number and date will respond with following : 
	 * a. Cargo Weight for requested Flight 
	 * b. Baggage Weight for requested Flight 
	 * c. Total Weight for requested Flight
	 */
	public String getFlightDetailForRequest1(int flightNumber,  String date) {
		Flight flight = flightRepository.getFlightByFlightNumberAndDate(flightNumber, date);
		CargoTotal cargorTotal = cargoRepository.getCargoTotalByFlightId(flight.getFlightId());

		double cargoWeight = cargorTotal.getTotalCargoWeight();
		double baggageWeight = cargorTotal.getTotalBaggageWeight();
		double totalWeight = cargoWeight + baggageWeight;

		String result = "{\"cargoWeight\":\"" + cargoWeight + "\"," + "\"baggageWeight\":\"" + baggageWeight + "\","
				+ "\"totalWeight\":\"" + totalWeight + "\"}";
		return result;
	}
}
