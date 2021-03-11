package com.upfpo.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.upfpo.app.dto.ChcFmbDTO;
import com.upfpo.app.dto.ChcFmbMachineryDTO;
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
		ChcFmbDTO chcFmb= chcFmbRepository.getChcFmbDetail(masterId);
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
}
