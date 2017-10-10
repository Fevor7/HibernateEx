package by.it;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import org.junit.Test;

import by.it.entity.Employee;
import by.it.entity.Meeting;
import by.it.util.EMUtil;

public class ManyToMany {
	
	@Test
	public void createAndRead() {
		Set<Employee> list = new HashSet<Employee>();
		Set<Meeting> list2 = new HashSet<Meeting>();
		Employee employee = new Employee(null, "AAA", null);
		Employee employee2 = new Employee(null, "BBB", null);
		Meeting meeting = new Meeting(null, "Meeting1", new Date(1284125), null);
		Meeting meeting2 = new Meeting(null, "Meeting2", new Date(1284325), null);
		list.add(employee);
		list.add(employee2);
		list2.add(meeting);
		list2.add(meeting2);
		employee.setMeeting(list2);
		employee2.setMeeting(list2);
		meeting.setEmployees(list);
		meeting2.setEmployees(list);
		EntityManager em = EMUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
	}

}
