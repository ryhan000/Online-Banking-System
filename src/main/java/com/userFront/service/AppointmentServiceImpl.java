package com.userFront.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userFront.dao.AppointmentDao;
import com.userFront.domain.Appointment;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	
	 @Autowired
	 private AppointmentDao appointmentDao;

	@Override
	public Appointment createAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return appointmentDao.save(appointment);
	}

	@Override
	public List<Appointment> findAll() {
		// TODO Auto-generated method stub
		return appointmentDao.findAll();
	}

	@Override
	public  Appointment findAppointment(Long id) {
		// TODO Auto-generated method stub
		 return null;
	}

	@Override
	public void confirmAppointment(Long id) {
		// TODO Auto-generated method stub
		 Appointment appointment = findAppointment(id);
	     appointment.setConfirmed(true);
	     appointmentDao.save(appointment);
	}

	  
	
}
