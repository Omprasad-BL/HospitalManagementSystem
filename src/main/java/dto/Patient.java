package dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;


@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	int id;
	String name;
	long mobile;
	Date dob;
	int age;
	
	@Lob
	byte[] picture;
	
	@OneToMany
	List<Appointment> appointments;
	
	

}
