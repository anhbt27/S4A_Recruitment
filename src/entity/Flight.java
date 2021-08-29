package entity;

public class Flight {
	private int flightId;
	private int flightNumber;
	private String departureAirportIATACode;
	private String arrivalAirportIATACode;
	private String departureDate;
	
	
	public Flight() {
		super();
	}
	public Flight(int flightId, int flightNumber, String departureAirportIATACode, String arrivalAirportIATACode,
			String departureDate) {
		super();
		this.flightId = flightId;
		this.flightNumber = flightNumber;
		this.departureAirportIATACode = departureAirportIATACode;
		this.arrivalAirportIATACode = arrivalAirportIATACode;
		this.departureDate = departureDate;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getDepartureAirportIATACode() {
		return departureAirportIATACode;
	}
	public void setDepartureAirportIATACode(String departureAirportIATACode) {
		this.departureAirportIATACode = departureAirportIATACode;
	}
	public String getArrivalAirportIATACode() {
		return arrivalAirportIATACode;
	}
	public void setArrivalAirportIATACode(String arrivalAirportIATACode) {
		this.arrivalAirportIATACode = arrivalAirportIATACode;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	
	
}
