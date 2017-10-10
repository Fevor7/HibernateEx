package by.it.entity.joined;

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
public class PassengerCarV4 extends CarV4{
	private String model;
	private String series;

	public PassengerCarV4(Integer id, int maxSpeed, Byte numberSeats, String model, String series) {
		super(id, maxSpeed, numberSeats);
		this.model = model;
		this.series = series;
	}
}