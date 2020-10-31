package com.naked.interview.appointments.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naked.interview.appointments.entity.Appointment;

@Repository
public class AppointmentDAO {

	private EntityManager entityManager;
	
	@Autowired
	public AppointmentDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	public List<Appointment> findAll() {
		// get hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Appointment> theQuery = currentSession.createQuery("from Appointment", Appointment.class);
		
		List<Appointment> appointments = theQuery.getResultList();
		
		return appointments;
	}
	
	public void save(Appointment theAppointment) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theAppointment);
	}
	
	public void deleteById(long theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("delete from Appointment where id=:appointmentId");
		theQuery.setParameter("appointmentId", theId);
		theQuery.executeUpdate();
	}
	
}
