package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.print.Doc;

import dto.Appointment;
import dto.Doctor;
import dto.Patient;
import dto.Staff;

public class Dao {
  
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em= emf.createEntityManager();
	EntityTransaction et= em.getTransaction();
	
public	 void saveStaff(Staff staff) {
		// TODO Auto-generated method stub
      et.begin();
      em.persist(staff);
      et.commit();
	}
	
	
	
	public  void saveDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
      et.begin();
      em.persist(doctor);
      et.commit();
	}
	
	
	public void savePatient(Patient patient) {
		et.begin();
		em.persist(patient);
		et.commit();
	}
	
	public Staff searchByMobile(long mobile) {
		
		List<Staff> list= em.createQuery("Select x from Staff x where mobile=?1").setParameter(1,mobile).getResultList();	
	    if(list.isEmpty()) {
	    	return null;
	    }
	    else {
	    	return list.get(0);
	    }
	}
	
	public Staff searchByEmail(String email) {
			
			List<Staff> list= em.createQuery("Select x from Staff x where email=?1").setParameter(1,email).getResultList();
		
		    if(list.isEmpty()) {
		    	return null;
		    }
		    else {
		    	return list.get(0);
		    }
		}

	// FETCHING DOCTOR DETAILS
	public  Doctor searchByDoctorMobile(long mobile) {
		
		List<Doctor> list= em.createQuery("Select x from Doctor x where mobile=?1").setParameter(1,mobile).getResultList();	
	    if(list.isEmpty()) {
	    	return null;
	    }
	    else {
	    	return list.get(0);
	    }
	}

	public Doctor searchByDoctorEmail(String email) {
		
		List<Doctor> list= em.createQuery("Select x from Doctor x where email=?1").setParameter(1,email).getResultList();	
	    if(list.isEmpty()) {
	    	return null;
	    }
	    else {
	    	return list.get(0);
	    }
	}
	// INFORMATION LOGIN STAFF
	
	public Staff fetcStaff(int id) {
		return em.find(Staff.class,id);
	}
	
	public Doctor fetchDoctor(int id) {
		return em.find(Doctor.class,id);
	}
	
	public Patient fetchPatient(int id) {
		return em.find(Patient.class, id);
	}
	



	// UPDATE DOCTOR STATUS
	public void updateDoctor( Doctor doctor) {
		// TODO Auto-generated method stub
	    et.begin();
	    em.merge(doctor);
	    et.commit();
	}
	// UPDATE STAFF STATUS
	public void updateStaff(Staff staff) {
	    et.begin();
	    em.merge(staff);
	    et.commit();
}

	// UPDATE PATIENTS STATUS

	public void updatePatient(Patient patient) {
		et.begin();
		em.merge(patient);
		et.commit();
	}
	
	
	
	
	public List<Doctor> fetcAllDoctor() {
	//	return em.find(Doctor.class,id);
		return em.createQuery("select x from Doctor x").getResultList();
	}
	
	public List<Staff> fetcAllStaff() {
		return em.createQuery("select x from Staff x").getResultList();
	}

	public List<Patient> fetchAllPatient() {
		return em.createQuery("select x from Patient x").getResultList();
	}


	public Staff fetchStaff(long mobile) {
			List<Staff> list =em.createQuery("select x from Staff x where mobile=?1").setParameter(1, mobile)
				.getResultList();
			if (list.isEmpty()) {
				return null;
			} else {
				return list.get(0);
			}
	}

	public Doctor fetchDoctor(long mobile) {
			List<Doctor> list = em.createQuery("select x from Doctor x where mobile=?1").setParameter(1, mobile)
				.getResultList();
			if (list.isEmpty()) {
				return null;
			} else {
				return list.get(0);
			}
	}



	public Staff fetchStaff(String email) {
			List<Staff> list = em.createNativeQuery("select * from staff where email=?1", Staff.class)
				.setParameter(1, email).getResultList();
			if (list.isEmpty()) {
				return null;
			} else {
				return list.get(0);
			}
	}

	public Doctor fetchDoctor(String email) {
			List<Doctor> list =em.createNativeQuery("select * from doctor where email=?1", Doctor.class)
				.setParameter(1, email).getResultList();
			if (list.isEmpty()) {
				return null;
			} else {
				return list.get(0);
			}
	}


	public Patient fetchPatient(long mobile) {
		List<Patient> list = em.createQuery("select x from Patient x where mobile=?1").setParameter(1, mobile)
			.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
		}
	
	
	public List<Doctor> fetchAvailableDoctors()
	{
		return em.createQuery("select x from Doctor x where available=true").getResultList();
	}
	
	public void saveAppointment(Appointment appointment) {
		et.begin();
		em.persist(appointment);
		et.commit();
	}


		
	
}
