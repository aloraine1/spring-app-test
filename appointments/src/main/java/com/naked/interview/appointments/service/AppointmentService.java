package com.naked.interview.appointments.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naked.interview.appointments.dao.AppointmentDAO;
import com.naked.interview.appointments.entity.Appointment;

@Service
public class AppointmentService {

	private AppointmentDAO appointmentDAO;
	
	@Autowired
	public AppointmentService(AppointmentDAO theAppointmentDAO) {
		appointmentDAO = theAppointmentDAO;
	}
	
	@Transactional
	public List<Appointment> findAll() {
		return appointmentDAO.findAll();
	}
	
	@Transactional
	public void save(Appointment theAppointment) {
		appointmentDAO.save(theAppointment);
	}
	
	@Transactional
	public void deleteById(long theId) {
		appointmentDAO.deleteById(theId);
	}
}
