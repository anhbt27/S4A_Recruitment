package repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import entity.Flight;

public class FlightRepository {
	private List<Flight> flights;
	
	public FlightRepository(List<Flight> flights) {
		super();
		this.flights = flights;
	}
	
	// get flight by flight number and date
	public Flight getFlightByFlightNumberAndDate(int flightNumber, String date) {
		Flight flight = null;
		try {
			DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
			Date inputDate = formatter.parse(date);
			for (int i = 0; i < this.flights.size(); i++) {
				flight = flights.get(i);
				formatter = new SimpleDateFormat("YYYY-MM-dd'T'hh:mm:ss");
				if (flight.getFlightNumber() == flightNumber
						&& isSameDay(inputDate,formatter.parse(flight.getDepartureDate().split(" ")[0])))
					return flight;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flight;
	}
	
	// find departure flights by airport code and date
	public List<Flight> getDepartureFlights(String airportCode, String date) {
		List<Flight> flights = new ArrayList<Flight>();
		try {
			Flight flight;
			DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
			Date inputDate = formatter.parse(date);
			for (int i = 0; i < this.flights.size(); i++) {
				flight = this.flights.get(i);
				formatter = new SimpleDateFormat("YYYY-MM-dd'T'hh:mm:ss");
				if (flight.getDepartureAirportIATACode().equals(airportCode)
						&& isSameDay(inputDate,formatter.parse(flight.getDepartureDate().split(" ")[0]))) {
					flights.add(flight);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flights;
	}
	
	// find arriving flights by airport code and date
	public List<Flight> getArriveFlights(String airportCode, String date){
		List<Flight> flights = new ArrayList<Flight>();
		try {
			Flight flight;
			DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
			Date inputDate = formatter.parse(date);
			for (int i = 0; i < this.flights.size(); i++) {
				flight = this.flights.get(i);
				formatter = new SimpleDateFormat("YYYY-MM-dd'T'hh:mm:ss");
				if (flight.getArrivalAirportIATACode().equals(airportCode)
						&& isSameDay(inputDate,formatter.parse(flight.getDepartureDate().split(" ")[0]))) {
					flights.add(flight);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flights;
	}
	
	public boolean isSameDay(Date date1, Date date2) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		return fmt.format(date1).equals(fmt.format(date2));
	}
}
