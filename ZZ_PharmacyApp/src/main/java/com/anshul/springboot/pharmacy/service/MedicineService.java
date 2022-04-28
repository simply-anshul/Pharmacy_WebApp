package com.anshul.springboot.pharmacy.service;

import java.util.List;

import com.anshul.springboot.pharmacy.entity.Medicine;

public interface MedicineService {

	public List<Medicine> findAll();
	
	public Medicine findById(int theId);
	
	public void save(Medicine theEmployee);
	
	public void deleteById(int theId);
	
	public List<Medicine> findByKeyword(String keyword);


	
	
}



//This is the service layer