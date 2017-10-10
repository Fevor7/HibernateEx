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
public class CarV3 extends VehicleV3 {
	
	private Byte numberSeats;

	public CarV3(Integer id, int maxSpeed, Byte numberSeats) {
		super(id, maxSpeed);
		this.numberSeats = numberSeats;
	}

}
