package com.upfpo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.upfpo.app.entity.ChcIsBsComplaints;

public interface ChcIsBsComplaintRepository extends JpaRepository<ChcIsBsComplaints, Integer>{

	List<ChcIsBsComplaints> findByMasterIdOrderByIdDesc(Integer masterId);

	//List<ChcIsBsComplaints> findByChcFmbIdOrderByIdDesc(Integer masterId);

	//List<ChcIsBsComplaints> findByBuyerSellerIdOrderByIdDesc(Integer masterId);

//	@Query("Select cc.*,is.inputSupplierName from ChcIsBsComplaints cc join InputSupplierMaster is on cc.masterId = is.inputSupplierId where cc.role = :role")
//	List<ChcIsBsComplaints> getAllComplaintInputSupplierByRole(String role);
//
//	@Query("Select cc.*,bs.buyersellerName from ChcIsBsComplaints cc join BuyerSellerMaster bs on cc.masterId = bs.buyerSellerId where cc.role = :role")
//	List<ChcIsBsComplaints> getAllComplaintIsBuyerSellerByRole(String role);
//
//	@Query("Select cc.*,cf.chcFmbName from ChcIsBsComplaints cc join ChcFmbMaster cf on cc.masterId = cf.chcFmbId where cc.role = :role")
//	List<ChcIsBsComplaints> getAllComplaintIsChcFmbRole(String role);
}
