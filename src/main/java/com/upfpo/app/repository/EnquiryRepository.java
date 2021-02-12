package com.upfpo.app.repository;

import com.upfpo.app.entity.Enquiry;
import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.entity.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {

	List<Enquiry> findByUser(User user);
	List<Enquiry> findByFpo(FPORegister fpo);
	
}
