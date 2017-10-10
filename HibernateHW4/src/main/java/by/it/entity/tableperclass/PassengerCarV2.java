package by.it.entity.tableperclass;

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
public class PassengerCarV2 extends CarV2{
	private String model;
	private String series;

	public PassengerCarV2(Integer id, int maxSpeed, Byte numberSeats, String model, String series) {
		super(id, maxSpeed, numberSeats);
		this.model = model;
		this.series = series;
	}
}
