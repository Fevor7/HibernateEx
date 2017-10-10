package by.it.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQuery(name = "Person.getAll", query = "SELECT p FROM Person p")
public class Person implements Serializable{

	private static final long serialVersionUID = -7744114628094995728L;
	@Id
	@GeneratedValue
	private Integer id;
	@Column
	private Integer age;
	@Column
	private String name;
	@Column
	private String surname;
	
}
