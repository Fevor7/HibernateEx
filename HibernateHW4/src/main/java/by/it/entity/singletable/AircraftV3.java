package by.it.entity.singletable;

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
public class AircraftV3 extends VehicleV3{

	private int rangeFlight;

	public AircraftV3(Integer id, int maxSpeed, int rangeFlight) {
		super(id, maxSpeed);
		this.rangeFlight = rangeFlight;
	}
}