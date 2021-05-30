package com.flipkart.service;

import java.util.List;

import com.flipkart.entity.Centre;
import com.flipkart.entity.User;

public interface VaccinationService {
	void registerUser(User user);
	void registerCentre(Centre centre);
	List<Centre> getCentre(String user);
	void bookSlot(String userEmail,Long CentreId);
	void getStats();

}
