package com.anshul.springboot.pharmacy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anshul.springboot.pharmacy.dao.MedicineRepository;
import com.anshul.springboot.pharmacy.entity.Medicine;

@Service
public class MedicineServiceImpl implements MedicineService {

	private MedicineRepository medicineRepository;
	
	@Autowired
	public MedicineServiceImpl(MedicineRepository employeeRepository) {
		this.medicineRepository = employeeRepository;
	}
	
	//NOTE: Remove @Transactional since JpaRepository provides the functionality
 	
	@Override
	
	public List<Medicine> findAll() {
//		return medicineRepository.findAllByOrderByNameAsc();
		return medicineRepository.findAll();
	}

	@Override
	public Medicine findById(int theId) {
		Optional<Medicine> result =  medicineRepository.findById(theId);
		
		Medicine emp = null;
		
		if(result.isPresent()) {
			emp = result.get();
		}
		else {
			throw new RuntimeException("Did not find the ID" + theId);
		}
		return emp;
	}

	@Override
	public void save(Medicine theEmployee) {
		medicineRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		medicineRepository.deleteById(theId);
	}
	
	
	
	public List<Medicine> findByKeyword(String keyword){
		return medicineRepository.findByKeyword(keyword); 
	}


}






