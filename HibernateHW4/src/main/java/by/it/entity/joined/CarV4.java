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
public class CarV4 extends VehicleV4 {
	
	private Byte numberSeats;

	public CarV4(Integer id, int maxSpeed, Byte numberSeats) {
		super(id, maxSpeed);
		this.numberSeats = numberSeats;
	}

}
