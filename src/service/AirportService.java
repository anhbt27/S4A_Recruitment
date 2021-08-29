package service;

import java.util.List;

import entity.CargoTotal;
import entity.Flight;
import repository.CargoRepository;
import repository.FlightRepository;

public class AirportService {
	
	private FlightRepository flightRepository;
	private CargoRepository cargoRepository;
	
	
	public AirportService(FlightRepository flightRepository, CargoRepository cargoRepository) {
		super();
		this.flightRepository = flightRepository;
		this.cargoRepository = cargoRepository;
	}
	
	/*
	 * For requested IATA Airport Code and date will respond with following : 
	 * a.Number of flights departing from this airport, 
	 * b. Number of flights arriving to this airport, 
	 * c. Total number (pieces) of baggage arriving to this airport, 
	 * d. Total number (pieces) of baggage departing from this airport.
	 */
	public String getAirportDetailForRequest2(String airportCode, String date) {

		// Initializing the results
		String result = "";
		int arriveBaggagePieces = 0;
		int departBaggagePieces = 0;
		CargoTotal cargoTotal;
		// find arriving and departing flights id
		List<Flight> departFlights = flightRepository.getDepartureFlights(airportCode, date);
		List<Flight> arriveFlights = flightRepository.getArriveFlights(airportCode, date);

		// get total baggage pieces
		for (int i = 0; i < departFlights.size(); i++) {
			cargoTotal = cargoRepository.getCargoTotalByFlightId(departFlights.get(i).getFlightId());
			departBaggagePieces =+ cargoTotal.getTotalBaggagePieces();
		}
		
		for (int i = 0; i < arriveFlights.size(); i++) {
			cargoTotal = cargoRepository.getCargoTotalByFlightId(departFlights.get(i).getFlightId());
			arriveBaggagePieces =+ cargoTotal.getTotalBaggagePieces();
		}
		
		result = "{\"departingFlights\":\"" + departFlights.size() + "\"," 
					+ "\"arrivingFlights\":\"" + arriveFlights.size() + "\","
					+ "\"departingBaggagePieces\":\"" + departBaggagePieces + "\","
					+ "\"arrivingBaggagePieces\":\"" + arriveBaggagePieces + "\"}";
		return result;
	}
}
