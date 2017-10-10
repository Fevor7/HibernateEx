package by.it.entity.joined;

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
public class AircraftV4 extends VehicleV4{

	private int rangeFlight;

	public AircraftV4(Integer id, int maxSpeed, int rangeFlight) {
		super(id, maxSpeed);
		this.rangeFlight = rangeFlight;
	}
}