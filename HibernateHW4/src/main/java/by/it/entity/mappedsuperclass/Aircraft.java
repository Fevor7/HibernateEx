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
public class Aircraft extends Vehicle {
	
	private int rangeFlight;

	public Aircraft(Integer id, int maxSpeed, int rangeFlight) {
		super(id, maxSpeed);
		this.rangeFlight = rangeFlight;
	}

}
