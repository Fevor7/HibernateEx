package by.it.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student implements Serializable {

	private static final long serialVersionUID = -7744114628094995728L;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;
	@Column
	private Integer age;
	@Column
	private String name;
	@Column
	private String surname;

}