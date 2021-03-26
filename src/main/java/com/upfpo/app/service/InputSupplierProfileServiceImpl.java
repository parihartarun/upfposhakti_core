
package com.upfpo.app.service;


import com.upfpo.app.dto.*;
import com.upfpo.app.repository.InputSupplierMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class InputSupplierProfileServiceImpl implements InputSupplierProfileService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private InputSupplierMasterRepository supplierMasterRepository;



    @Override
    public InputSupplierDTO getInputSupplierDetails(Integer masterId){
        InputSupplierDTO is = getInputSupplierDetailById(masterId);
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
            String sql = "Select  ism.id,etm.id as type_id, etm.type, em.id as name_id, em.equpment_name, ism.technical_specs,  " +
                    "ism.quantity, ism.manufacturer_name, ism.file_path \r\n" +
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
            String sql = "Select  isi.id, itm.id as type_id, itm.insecticide_type, isi.quantity, isi.manufacturer_name, isi.cib_rc_no, isi.cib_rc_issuedate \r\n" +
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
            String sql = "Select  isf.id, ftm.id as type_id, ftm.fertilizer_type, fnm.id as name_id, fnm.fertilizer_name,  isf.fertilizer_grade, isf.manufacturer_name, isf.file_path \r\n" +
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

    public InputSupplierDTO getInputSupplierDetailById(Integer masterId) {
        InputSupplierDTO obj = null;
        try {
            String sql = "Select input_supplier_id, input_supplier_name, u.user_name, input_supplier_type, dst.district_id, dst.district_name, blk.block_id,\r\n"
            		+ "                    blk.block_name, vill.village_id, vill.village_name, pincode, \r\n"
            		+ "                     email, mobile_number, contact_person, license_number, gst_number, equipment, fertilizer, \r\n"
            		+ "                     cide, category_deal from input_supplier isup\r\n"
            		+ "                                        inner join districts dst on dst.district_id=isup.dist_ref_id\r\n"
            		+ "                                        inner join block blk on blk.block_id=isup.block_ref_id\r\n"
            		+ "                    inner join villages vill on vill.village_id=isup.village_ref_id\r\n"
            		+ "                    inner join users u on u.user_id=isup.user_id\r\n"
            		+ "                                        where isup.input_supplier_id=:masterId and  isup.is_deleted = false";

            obj = (InputSupplierDTO) entityManager.createNativeQuery(sql, "InputSupplierDTO").setParameter("masterId", masterId).getSingleResult();
            return obj;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
