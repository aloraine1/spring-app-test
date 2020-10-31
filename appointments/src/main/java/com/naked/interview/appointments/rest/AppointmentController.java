package com.naked.interview.appointments.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.naked.interview.appointments.entity.Appointment;
import com.naked.interview.appointments.service.AppointmentService;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@GetMapping("")
	public String getAppointments(Model theModel) {
//		List<jdbcTemplate.query("SELECT * FROM customers");
		// get list of Appointments
		List<Appointment> list = appointmentService.findAll();
		
		// add to model
		theModel.addAttribute("appointments", list);
		theModel.addAttribute("appointment", new Appointment());
		// load thymeleaf template with model
		return "appointments";
	}

	@PostMapping("/create")
	public String createAppointment( @ModelAttribute("appointment") Appointment theAppointment) {
		
		// save to db
		appointmentService.save(theAppointment);
		
		return "redirect:/appointments";
	}
	
	@PostMapping("/delete")
	public String deleteAppointment(@RequestParam("appointmentId") long theId) {
		appointmentService.deleteById(theId);
		return "redirect:/appointments";
	}
	
	// full crud api
	// form validation
	// look at security
	
	
	
	

}