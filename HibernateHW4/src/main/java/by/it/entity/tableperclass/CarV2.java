package by.it.entity.tableperclass;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
public class CarV2 extends VehicleV2{

	private Byte numberSeats;

	public CarV2(Integer id, int maxSpeed, Byte numberSeats) {
		super(id, maxSpeed);
		this.numberSeats = numberSeats;
	}
}
