package com.upfpo.app.controller;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.upfpo.app.entity.VillageMaster;
import com.upfpo.app.repository.BankMasterRepository;
import com.upfpo.app.repository.BlockMasterRepository;
import com.upfpo.app.repository.DistrictMasterRepository;
import com.upfpo.app.repository.VillageMasterRepository;
import com.upfpo.app.upagri.UpAgriClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.UpAgriDataDto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/upagri")
public class UpAgriClientController {

	@Autowired
	private DistrictMasterRepository districtRepository;

	@Autowired
	private VillageMasterRepository villageRepository;

	@Autowired
	private BlockMasterRepository blockepository;

	@Autowired
	private BankMasterRepository bankRepository;



	@GetMapping(value="/getUpAgri/{reg_no}")
	@ApiOperation(value="Get get up agri by registration no.", code=200, produces = "application/json",notes="Api for get up agri by registration no.",response=UpAgriDataDto.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
	})
	public List<Object> getUpAgriByRegistrationNo(@PathVariable("reg_no") String reg_no) throws MalformedURLException, RemoteException
	{


		String list_resp=UpAgriClient.upagri(reg_no);

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

		List<Object> ls = new ArrayList<>();
		ls.add(_anyname);
		ls.add(_fath);
		ls.add(districtRepository.findByDistrict_name(_anydist.toUpperCase()));
		ls.add(blockepository.findByBlockName(_blck.toUpperCase()));
		if(_vill.contains("&#")) {
				ls.add(new MessageResponse("Invalid village please select village")); }
		else{
			ls.add(villageRepository.findByVillageName(_vill));		}
		ls.add(villageRepository.findByVillageName(_vill));
		ls.add(_cat);
		ls.add(_mob);
		ls.add(bankRepository.findByBankName(_bank_name));
		ls.add(_ifsc);
		ls.add(_accno);
		ls.add(gender);

		System.err.println("  _anyname == "+_anyname +"  _fath == "+_fath +
				"  _anydist == "+_anydist+"  _blck== "+_blck+"  _vill== "+_vill+"  _cat == "+_cat+
				"  _mob == "+_mob+"  _bank_nameb =="+_bank_name+" _ifsc == "+_ifsc+"  _accno =="+_accno);


//        			_anyname 	== SHIV KUMAR  _fath == LAXMIAN  _anydist == Lucknow  _blck==
//        			Bakshi ka Talab  _vill==   _cat
//        			== 4  _mob == 7523941451  _bank_nameb ==UCO
//        			BANK _ifsc == UCBA0001524  _accno ==15240100008860

		return ls;
	}
	


}
