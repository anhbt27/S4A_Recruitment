import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import entity.CargoTotal;
import entity.Flight;
import repository.CargoRepository;
import repository.FlightRepository;
import service.AirportService;
import service.FlightService;

public class Application {
	public static void main(String[] args) {
		try {
			// Read data from json file
			Gson gson = new Gson();
			Reader reader = Files.newBufferedReader(Paths.get("flight.json"));
			List<Flight> flights = Arrays.asList(gson.fromJson(reader, Flight[].class));
			
			reader = Files.newBufferedReader(Paths.get("cargo.json"));
			List<CargoTotal> cargos = Arrays.asList(gson.fromJson(reader, CargoTotal[].class));
			reader.close();
			
			// Initialize services and repositories
			CargoRepository cargoRepository = new CargoRepository(cargos);
			FlightRepository flightRepository = new FlightRepository(flights);
			
			AirportService airportService = new AirportService(flightRepository, cargoRepository);
			FlightService flightService = new FlightService(flightRepository, cargoRepository);
			
			System.out.println("1. For requested Flight Number and date will respond with following :\n" 
				+ "a. Cargo Weight for requested Flight\n"
				+ "b. Baggage Weight for requested Flight\n"
				+ "c. Total Weight for requested Flight\n");
			System.out.println(flightService.getFlightDetailForRequest1(4041, "2021-02-27"));
			
			System.out.println();
			
			System.out.println("2. For requested IATA Airport Code and date will respond with following :\n" 
				+ "a. Number of flights departing from this airport,\n"
				+ "b. Number of flights arriving to this airport,\n"
				+ "c. Total number (pieces) of baggage arriving to this airport,\n"
				+ "d. Total number (pieces) of baggage departing from this airport.\n");
			System.out.println(airportService.getAirportDetailForRequest2("LAX", "2021-02-27"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
