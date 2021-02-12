package com.upfpo.app.repository;

import com.upfpo.app.entity.Enquiry;
import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {

	Enquiry findByUser(Optional<User> user);

	Enquiry findByFpo(Optional<FPORegister> fpo);
}
