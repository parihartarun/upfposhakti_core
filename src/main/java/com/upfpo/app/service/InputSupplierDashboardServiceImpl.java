<<<<<<< HEAD
package com.upfpo.app.service;


import com.upfpo.app.dto.*;
import com.upfpo.app.repository.InputSupplierMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class InputSupplierDashboardServiceImpl implements InputSupplierDashboardService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private InputSupplierMasterRepository supplierMasterRepository;



    @Override
    public InputSupplierDTO getInputSupplierDetails(Integer masterId){
        InputSupplierDTO is = supplierMasterRepository.getInputSupplierDetail(masterId);
        return is;
    }


    @Override
    public List<InputSupplierFertilizerDTO> getAllInputSupplierFertilizer(Integer masterId){
        List<InputSupplierFertilizerDTO> fertilizer = getFertilizerDetail(masterId);
        return fertilizer;
    }

    @Override
    public List<InputSupplierSeedDTO> getAllInputSupplierSeed(Integer masterId){
        List<InputSupplierSeedDTO> seed = getSeedDetail(masterId);
        return seed;
    }

    @Override
    public List<InputSupplierMachineryDTO> getAllInputSupplierMachinery(Integer masterId) {
        List<InputSupplierMachineryDTO> ism= getMachineryDetail(masterId);
        return ism;
    }

    @Override
    public List<InputSupplierInsecticideDTO> getAllInputSupplierInsecticide(Integer masterId){
        List<InputSupplierInsecticideDTO> isi = getInsecticideDetail(masterId);
        return isi;
    }


    public List<InputSupplierMachineryDTO> getMachineryDetail(Integer masterId) {
        List<InputSupplierMachineryDTO> list = null;
        try {
            String sql = "Select  ism.id, etm.type, em.equpment_name, ism.quantity, ism.manufacturer_name, ism.file_path \r\n" +
                    "from input_supplier_machinery ism \r\n" +
                    "left join equipment_type_master etm on etm.id=ism.machinery_type_id \r\n" +
                    "left join equip_master em on em.id=ism.machinery_name_id \r\n" +
                    "inner join input_supplier isup on ism.input_supplier_id=isup.input_supplier_id\r\n" +
                    "where ism.input_supplier_id=:masterId and  ism.is_deleted = false";

            List<InputSupplierMachineryDTO> obj = (List<InputSupplierMachineryDTO>) entityManager.createNativeQuery(sql, "InputSupplierMachineryDTO").setParameter("masterId", masterId).getResultList();
            return obj;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<InputSupplierInsecticideDTO> getInsecticideDetail(Integer masterId) {
        List<InputSupplierInsecticideDTO> list = null;
        try {
            String sql = "Select  isi.id, itm.insecticide_type, isi.quantity, isi.manufacturer_name, isi.cib_rc_no, isi.cib_rc_issuedate \r\n" +
                    ", isi.file_path \r\n" +
                    "from input_supplier_insecticide isi \r\n" +
                    "left join insecticide_type_master itm on itm.id=isi.insecticide_type_id \r\n" +
                    "inner join input_supplier isup on isi.input_supplier_id=isup.input_supplier_id \r\n" +
                    "where isi.input_supplier_id= :masterId and  isi.is_deleted = false";

            List<InputSupplierInsecticideDTO> obj = (List<InputSupplierInsecticideDTO>) entityManager.createNativeQuery(sql, "InputSupplierInsecticideDTO").setParameter("masterId", masterId).getResultList();
            return obj;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<InputSupplierSeedDTO> getSeedDetail(Integer masterId) {
        List<InputSupplierSeedDTO> list = null;
        try {
            String sql = "Select  iss.id, cm.id as crop_id, cm.crop_name, cvm.veriety_id, cvm.crop_veriety, iss.company_brand, iss.quantity, iss.certification_number \r\n" +
                    ", iss.certification_valid_from, iss.certification_valid_to, iss.file_path \r\n" +
                    "from input_supplier_seed iss \r\n" +
                    "left join  crop_master cm on cm.id=iss.crop_id \r\n" +
                    "left join crop_veriety_master cvm on cvm.veriety_id=iss.variety_id \r\n" +
                    "inner join input_supplier isup on iss.input_supplier_id=isup.input_supplier_id \r\n" +
                    "where iss.input_supplier_id=:masterId and  iss.is_deleted = false";

            List<InputSupplierSeedDTO> obj = (List<InputSupplierSeedDTO>) entityManager.createNativeQuery(sql, "InputSupplierSeedDTO").setParameter("masterId", masterId).getResultList();
            return obj;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<InputSupplierFertilizerDTO> getFertilizerDetail(Integer masterId) {
        List<InputSupplierFertilizerDTO> list = null;
        try {
            String sql = "Select  isf.id, ftm.fertilizer_type, fnm.fertilizer_name,  isf.fertilizer_grade, isf.manufacturer_name, isf.file_path \r\n" +
                    "from input_supplier_fertilizer isf \r\n" +
                    "left join fertilizer_type_master ftm on ftm.id=isf.fertilizer_type_id \r\n" +
                    "left join fertilizer_name_master fnm on fnm.id=isf.fertilizer_name_id \r\n" +
                    "inner join input_supplier isup on isf.input_supplier_id=isup.input_supplier_id \r\n" +
                    "where isf.input_supplier_id=:masterId and  isf.is_deleted = false";

            List<InputSupplierFertilizerDTO> obj = (List<InputSupplierFertilizerDTO>) entityManager.createNativeQuery(sql, "InputSupplierFertilizerDTO").setParameter("masterId", masterId).getResultList();
            return obj;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
||||||| b0b2f1b
=======
package com.upfpo.app.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.InputSupplierDashBoardSeedDTO;
import com.upfpo.app.dto.InputSupplierDashboardBarchartDTO;
import com.upfpo.app.dto.InputSupplierDashboardDTO;
import com.upfpo.app.dto.InputSupplierDashboardFertilizerDTO;
import com.upfpo.app.dto.InputSupplierDashboardMachineryDTO;

@Service
public class InputSupplierDashboardServiceImpl implements InputSupplierDashboardService
{
	@Autowired
	EntityManager entityManager;
	
	String sql = "";
	
	@Override
	public InputSupplierDashboardBarchartDTO getBarchartData(Integer masterId) 
	{
		InputSupplierDashboardBarchartDTO barChart = new InputSupplierDashboardBarchartDTO();
		
		sql = "select i.insecticide_type_id as insecticideTypeId, it.insecticide_type as insecticideType, sum(i.quantity) as quantity from input_supplier_insecticide i join insecticide_type_master it\r\n"
				+ "on i.insecticide_type_id = it.id\r\n"
				+ "where i.input_supplier_id = :masterId and i.is_deleted = false group by i.insecticide_type_id, it.insecticide_type";
		
		List<InputSupplierDashboardDTO> obj =  (List<InputSupplierDashboardDTO>) entityManager.createNativeQuery(sql,"InputSupplierDashboardDTO").setParameter("masterId", masterId).getResultList();
		
		sql = "select i.crop_id as cropId, c.crop_name as cropName, i.variety_id as varietyId, cv. crop_veriety as varietyName, sum(i.quantity) as seedQuantity from input_supplier_seed i join crop_master c on c.id = i.crop_id\r\n"
				+ "			join crop_veriety_master cv on cv.veriety_id = i.variety_id \r\n"
				+ "			where i.input_supplier_id = :masterId and i.is_deleted = false group by i.crop_id , c.crop_name , i.variety_id, cv. crop_veriety order by seedQuantity desc";
		
		List<InputSupplierDashBoardSeedDTO> objseed =  (List<InputSupplierDashBoardSeedDTO>) entityManager.createNativeQuery(sql,"InputSupplierDashBoardSeedDTO").setParameter("masterId", masterId).getResultList();
		
		sql = "select  distinct i.fertilizer_name_id as fertilizerNameId , f.fertilizer_name as fertilizerName, i.fertilizer_grade as fertilizerGrade, \r\n"
				+ "sum(i.quantity) as fertilizerQty from input_supplier_fertilizer i\r\n"
				+ "join fertilizer_name_master f on f.id = i.fertilizer_name_id \r\n"
				+ "where i.input_supplier_id = :masterId and i.is_deleted = false group by i.fertilizer_name_id, f.fertilizer_name, i.fertilizer_grade order by fertilizerQty desc";
		
		List<InputSupplierDashboardFertilizerDTO> objFertilizer =  (List<InputSupplierDashboardFertilizerDTO>) entityManager.createNativeQuery(sql,"InputSupplierDashboardFertilizerDTO").setParameter("masterId", masterId).getResultList();
		
		sql = "select i.machinery_name_id as machineryNameId, e.equpment_name as machinerytName, sum(i.quantity) as machineryQty from input_supplier_machinery i\r\n"
				+ "join equip_master e on e.id = i.machinery_name_id\r\n"
				+ "where i.input_supplier_id = :masterId and i.is_deleted = false group by i.machinery_name_id, e.equpment_name order by machineryQty desc;";
		
		List<InputSupplierDashboardMachineryDTO> objMachinery =  (List<InputSupplierDashboardMachineryDTO>) entityManager.createNativeQuery(sql,"InputSupplierDashboardMachineryDTO").setParameter("masterId", masterId).getResultList();
		
		barChart.setInsecticidesBarChart(obj);
		barChart.setSeedsBarChart(objseed);
		barChart.setFertilizerBarChart(objFertilizer);
		barChart.setMachineryBarChart(objMachinery);
		
		return barChart;
		
	}
}
>>>>>>> 74f544792d1dde9ee9520a480e56fe5018bd012d
