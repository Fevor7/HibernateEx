package by.it.entity.mappedsuperclass;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Entity
public class PassengerCar extends Car {
	
	private String model;
	private String series;

	public PassengerCar(Integer id, int maxSpeed, Byte numberSeats, String model, String series) {
		super(id, maxSpeed, numberSeats);
		this.model = model;
		this.series = series;
	}

}
