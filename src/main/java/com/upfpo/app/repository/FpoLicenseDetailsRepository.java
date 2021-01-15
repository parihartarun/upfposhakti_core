package com.upfpo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.upfpo.app.entity.FpoLicenceDetails;
import com.upfpo.app.entity.CollectionCenter;
import com.upfpo.app.entity.FIGRegister;


@Repository
public interface FpoLicenseDetailsRepository extends JpaRepository<FpoLicenceDetails, Integer> {

	List<FpoLicenceDetails> findByIsDeleted(boolean b);
}
