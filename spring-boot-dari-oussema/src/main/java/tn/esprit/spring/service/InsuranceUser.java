package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entity.Insurance;
import tn.esprit.spring.interfaces.IInsuranceUser;
import tn.esprit.spring.repository.InsuranceRepository;
import tn.esprit.spring.repository.UserRepository;

@Component
public class InsuranceUser implements  IInsuranceUser {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private InsuranceRepository insuranceRepository;

	
	@Override
	public void addInsurance(Insurance insurance) {
		insuranceRepository.save(insurance);
	}
}
