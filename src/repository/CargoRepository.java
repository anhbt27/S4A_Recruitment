package repository;

import java.util.List;

import entity.CargoTotal;

public class CargoRepository {
	private List<CargoTotal> cargos;
	public CargoRepository(List<CargoTotal> cargos) {
		super();
		this.cargos = cargos;
	}
	
	// get cargo by flight id
	public CargoTotal getCargoTotalByFlightId(int flightId) {
		CargoTotal cargoTotal = new CargoTotal();
		for (int i = 0; i < this.cargos.size(); i++) {
			if (this.cargos.get(i).getFlightId() == flightId) {
				cargoTotal = this.cargos.get(i);
				break;
			}
		}
		return cargoTotal;
	}
}
