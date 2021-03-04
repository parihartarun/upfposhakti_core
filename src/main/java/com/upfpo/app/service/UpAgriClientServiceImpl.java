package com.upfpo.app.service;


import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.controller.UpAgriClientController;
import com.upfpo.app.dto.UpAgriFarmerDetailDTO;
import com.upfpo.app.repository.BankMasterRepository;
import com.upfpo.app.repository.BlockMasterRepository;
import com.upfpo.app.repository.DistrictMasterRepository;
import com.upfpo.app.repository.VillageMasterRepository;
import com.upfpo.app.upagri.UpAgriClient;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UpAgriClientServiceImpl implements UpAgriClientService {


    private static final Logger LOG = LoggerFactory.getLogger(UpAgriClientServiceImpl.class);

    @Autowired
    private DistrictMasterRepository districtRepository;

    @Autowired
    private VillageMasterRepository villageRepository;

    @Autowired
    private BlockMasterRepository blockepository;

    @Autowired
    private BankMasterRepository bankRepository;


    @Override
    public UpAgriFarmerDetailDTO getUpAgriByRegistrationNo(String reg_no) throws MalformedURLException, RemoteException {

        String list_resp= UpAgriClient.upagri(reg_no);


        String _anyname = StringUtils.substringBetween(list_resp, "<Farmer_x0027_s_x0020_name>", "</Farmer_x0027_s_x0020_name>");
        String _fath =  StringUtils.substringBetween(list_resp, "<Father_x0020_name>", "</Father_x0020_name>");
        String _anydist = StringUtils.substringBetween(list_resp, "<District>", "</District>");
        String _blck = StringUtils.substringBetween(list_resp, "<Block>", "</Block>");
        String _vill = StringUtils.substringBetween(list_resp, "<Village>", "</Village>");
        String _cat = StringUtils.substringBetween(list_resp, "<Category>", "</Category>");
        String _mob = StringUtils.substringBetween(list_resp, "<Mobile_x0020_No>", "</Mobile_x0020_No>");
        String _bank_name = StringUtils.substringBetween(list_resp, "<Bank_x0020_Name>", "</Bank_x0020_Name>");
        String _ifsc = StringUtils.substringBetween(list_resp, "<IFSC_x0020_Code>", "</IFSC_x0020_Code>");
        String _accno = StringUtils.substringBetween(list_resp, "<Bank_x0020_Account_x0020_NO>", "</Bank_x0020_Account_x0020_NO>");
        String gender = StringUtils.substringBetween(list_resp, "<gender>", "</gender>");
        //UpAgriDataDto obj = upAgriService.getUpAgriData(_anydist,_blck,_vill);


        UpAgriFarmerDetailDTO dto=new UpAgriFarmerDetailDTO();

        dto.setFarmerName(_anyname);
        dto.setFatherName(_fath);
        dto.setDistrictId(districtRepository.findByDistrict_name(_anydist.toUpperCase()));
        dto.setDistrictName(_anydist);
        dto.setBlockId(blockepository.findByBlockName(_blck.toUpperCase()));
        dto.setBlockName(_blck);
        if(_vill.contains("&#")) {
            dto.setVillageName("Invalid vilage name please select village"); }
        else{
            dto.setVillageId(villageRepository.findByVillageName(_vill, dto.getBlockId()) );
            dto.setVillageName(_vill);		}
        dto.setCategory(category(_cat));
        dto.setMobile(_mob);
        dto.setBankId(bankRepository.findByBankName(_bank_name));
        dto.setBankName(_bank_name);
        dto.setIfsc(_ifsc);
        dto.setAccountNo(_accno);
        dto.setGender(gender);

        /*List<Object> ls = new ArrayList<>();
        ls.add(_anyname);
        ls.add(_fath);
        ls.add(districtRepository.findByDistrict_name(_anydist.toUpperCase()));
        ls.add(blockepository.findByBlockName(_blck.toUpperCase()));
        if(_vill.contains("&#")) {
            ls.add(new MessageResponse("Invalid village please select village")); }
        else{
            ls.add(villageRepository.findByVillageName(_vill));		}
        ls.add(_cat);
        ls.add(_mob);
        ls.add(bankRepository.findByBankName(_bank_name));
        ls.add(_ifsc);
        ls.add(_accno);
        ls.add(gender);*/

        System.err.println("  _anyname == "+_anyname +"  _fath == "+_fath +
                "  _anydist == "+_anydist+"  _blck== "+_blck+"  _vill== "+_vill+"  _cat == "+_cat+
                "  _mob == "+_mob+"  _bank_nameb =="+_bank_name+" _ifsc == "+_ifsc+"  _accno =="+_accno);

        return dto;
    }

    public String category (String cat){

        if(cat.equals("1")){
            return "Genral";
        }else  if(cat.equals("2")){
            return "SC";
        }else  if(cat.equals("3")){
            return "NT";
        }else  if(cat.equals("4")){
            return "OBC";
        }else{
            return "Other";
        }
    }
}
