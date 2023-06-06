package dto;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class Appointment {
	@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
int id;
String problem;
LocalDateTime time;
 @ManyToOne
 Patient patient;
 
 @ManyToOne
 Doctor doctor;
}
