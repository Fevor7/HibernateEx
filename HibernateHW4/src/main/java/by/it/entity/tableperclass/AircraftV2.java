package by.it.entity.tableperclass;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
public class AircraftV2 extends VehicleV2{

	private int rangeFlight;

	public AircraftV2(Integer id, int maxSpeed, int rangeFlight) {
		super(id, maxSpeed);
		this.rangeFlight = rangeFlight;
	}
}
