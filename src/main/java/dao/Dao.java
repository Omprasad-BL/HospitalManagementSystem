package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Doctor;
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

public Doctor fetcDoctor(int id) {
	return em.find(Doctor.class,id);
}
	

		
	
}
