package com.naked.interview.appointments.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "appointment")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="description")
	private String description;
	@Column(name="date")
	private String date;
	@Column(name="time")
	private String time;
	
	
	public Appointment() {
		
	}
	
	public Appointment(long id, String description, String date, String time) {
		this.id = id;
		this.description = description;
		this.date = date;
		this.time = time;
		
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", description=" + description + ", date=" + date + ", time=" + time + "]";
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
	
}
