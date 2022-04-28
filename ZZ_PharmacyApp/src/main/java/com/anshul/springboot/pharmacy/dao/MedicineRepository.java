package com.anshul.springboot.pharmacy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.anshul.springboot.pharmacy.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

	
	//This is the completed code. We get all the CRUD operations for free
	//Remember to mention Class and ID type in <___ , ___>
	
	//JPA sorts for us
	// This will be interpreted as "From Medicine order by name asc"
	public List<Medicine> findAllByOrderByNameAsc();
	
	
	
	@Query(value="from Medicine m where m.name like %:keyword% or m.descripton like %:keyword%")
	public List<Medicine> findByKeyword(@Param("keyword") String keyword);
	
}



