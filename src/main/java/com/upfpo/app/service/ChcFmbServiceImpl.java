package com.upfpo.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.upfpo.app.dto.ChcFmbDTO;
import com.upfpo.app.dto.ChcFmbMachineryDTO;
import com.upfpo.app.dto.InputSupplierDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.ChcFmbMaster;
import com.upfpo.app.repository.ChcFmbMasterRepository;

import javax.persistence.EntityManager;

@Service
public class ChcFmbServiceImpl implements ChcFmbService
{
	@Autowired
	ChcFmbMasterRepository chcFmbRepository;

	@Autowired
	private EntityManager entityManager;


	@Override
	public ChcFmbDTO getChcFmbDetail(int masterId){
		ChcFmbDTO chcFmb= getChcFmbProfileById(masterId);
		return chcFmb;
	}

	@Override
	public List<ChcFmbMachineryDTO> getAllChcFmbMachinery(Integer masterId) {

		List<ChcFmbMachineryDTO> cfm = getMachineryDetail(masterId);
		return cfm;
	}


	@Override
	public ChcFmbMaster updateChcFmb(ChcFmbMaster chcFmbMaster, int chcFmbId)
	{
		Optional<ChcFmbMaster> chcFmb = chcFmbRepository.findById(chcFmbId);
		if(chcFmb.isPresent())
		{
			ChcFmbMaster newchcFmb = chcFmb.get();
			newchcFmb.setChcFmbName(chcFmbMaster.getChcFmbName());
			newchcFmb.setDistRefId(chcFmbMaster.getDistRefId());
			newchcFmb.setVillageRefId(chcFmbMaster.getVillageRefId());
			newchcFmb.setBlockRefId(chcFmbMaster.getBlockRefId());
			newchcFmb.setPincode(chcFmbMaster.getPincode());
			newchcFmb.setAllotmentNo(chcFmbMaster.getAllotmentNo());
			newchcFmb.setFirmRegistraionNumber(chcFmbMaster.getFirmRegistraionNumber());
			newchcFmb.setShopEstablishmentNumber(chcFmbMaster.getShopEstablishmentNumber());
			newchcFmb.setMobileNumber(chcFmbMaster.getMobileNumber());
			newchcFmb.setEmail(chcFmbMaster.getEmail());
			
			newchcFmb = chcFmbRepository.save(newchcFmb);
			return newchcFmb;
		}
		else
		{
			chcFmbMaster = chcFmbRepository.save(chcFmbMaster);
			return chcFmbMaster;
		}
	}
	
	@Override
	public void deleteChcFmbMaster(int chcFmbId) 
	{ 
		chcFmbRepository.deleteChcFmb(chcFmbId);
	}
	
	@Override
	public List<ChcFmbMaster> getChcFmbMaster() 
	{
		List<ChcFmbMaster> chcFmbList = new ArrayList<ChcFmbMaster>();
		chcFmbRepository.findAll().forEach(chcFmbList1->chcFmbList.add(chcFmbList1));
		return chcFmbList;
	}


	public List<ChcFmbMachineryDTO> getMachineryDetail(Integer masterId) {
		List<ChcFmbMachineryDTO> list = null;
		try {
			String sql = "Select  cfm.id, cfm.equipment_type_id, etm.type, cfm.equipment_name_id, em.equpment_name, cfm.company, cfm.equipment_capacity, cfm.equip_purchase_year,\n" +
					"\t\t\tcfm.quantity_avail, cfm.rent_per_day, cfm.company, cfm.govt_scheme_assistant, cfm.file_path\n" +
					"            from chc_fmb_machinery cfm\n" +
					"            left join equipment_type_master etm on etm.id=cfm.equipment_type_id\n" +
					"            left join equip_master em on em.id=cfm.equipment_name_id\n" +
					"            where cfm.chc_fmb_id=:masterId and  cfm.is_deleted = false order by id desc";

			List<ChcFmbMachineryDTO> obj = (List<ChcFmbMachineryDTO>) entityManager.createNativeQuery(sql, "ChcFmbMachineryDTO").setParameter("masterId", masterId).getResultList();
			return obj;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	public ChcFmbDTO getChcFmbProfileById(Integer masterId) {
		ChcFmbDTO list = null;
		try {
			String sql = "select chc_fmb_id, chc_fmb_name, u.user_name, dst.district_id, dst.district_name, blk.block_id,\n" +
					"blk.block_name, vill.village_id, vill.village_name, pincode, email, \n" +
					"mobile_number, firm_registraion_number, shop_establishment_number, allotment_no from chc_fmb chc\n" +
					"                    left join districts dst on dst.district_id=chc.chc_fmb_id \n" +
					"                    left join block blk on blk.block_id=chc.chc_fmb_id\n" +
					"\t\t\t\t\tleft join villages vill on vill.block_id=chc.chc_fmb_id\n" +
					"\t\t\t\t\tleft join users u on u.user_id=chc.user_id\n" +
					"\t\t\t\t\t where chc.chc_fmb_id=:masterId and  chc.is_deleted = false;";

			ChcFmbDTO obj = (ChcFmbDTO) entityManager.createNativeQuery(sql, "ChcFmbDTO").setParameter("masterId", masterId).getSingleResult();
			return obj;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
