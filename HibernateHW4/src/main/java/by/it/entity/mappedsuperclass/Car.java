package by.it.entity.mappedsuperclass;

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
public class Car extends Vehicle {
	
	private Byte numberSeats;

	public Car(Integer id, int maxSpeed, Byte numberSeats) {
		super(id, maxSpeed);
		this.numberSeats = numberSeats;
	}

}
