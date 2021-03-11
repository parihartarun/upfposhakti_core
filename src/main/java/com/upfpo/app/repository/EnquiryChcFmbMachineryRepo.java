package com.upfpo.app.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.dto.EnquiryChcFmbDTO;
import com.upfpo.app.entity.EnquiryChcFmbMachinery;
import com.upfpo.app.entity.EnquiryInputSupplierSeed;

@Repository
public interface EnquiryChcFmbMachineryRepo extends JpaRepository<EnquiryChcFmbMachinery, BigInteger>
{
	/*@Query("select new com.upfpo.app.dto.EnquiryChcFmbDTO(e.enqid, e.createdBy, eq.machineTypeId , eq.equipType,"
			+ " em.id, em.equpmentname) from EnquiryChcFmbMachinery e join e.machineryTypId eq join e.machineryNameId em where "
			+ "e.masterId=:masterId")
	public List<EnquiryChcFmbDTO> getChcFmbMachineryData(Integer masterId);*/
	
	@Query("select e from EnquiryChcFmbMachinery e where e.masterId=:masterId")
	public List<EnquiryChcFmbMachinery> getChcFmbMachineryDatad(Integer masterId);
	
	List<EnquiryChcFmbMachinery> findByMasterId(Integer masterId);
}
