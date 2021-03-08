package com.upfpo.app.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.dto.EnquiryChcFmbDTO;
import com.upfpo.app.entity.EnquiryChcFmbMachinery;

@Repository
public interface EnquiryChcFmbMachineryRepo extends JpaRepository<EnquiryChcFmbMachinery, BigInteger>
{
	/*@Query("select new new com.upfpo.app.dto.FarmerCropSowingDTO(e.enqid as equId, e.createdBy, eq.id as machineTypeId, eq.equipType as machineTypeName, em.id as machineId, em.) "
			+ "from EnquiryChcFmbMachinery e")
	public List<EnquiryChcFmbDTO> getChcFmbMachineryData();*/
	
	@Query("select e from EnquiryChcFmbMachinery e")
	public List<EnquiryChcFmbMachinery> getChcFmbMachineryData();
	
}
