package com.upfpo.app.service;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.dto.CropListOfFarmersDTO;
import com.upfpo.app.dto.FarmerCropSowingDTO;
import com.upfpo.app.dto.FarmerLandDetailDto;
import com.upfpo.app.entity.BoardMember;
import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.entity.LandDetails;
import com.upfpo.app.repository.BoardMembersRepo;
import com.upfpo.app.repository.FPORegisterRepository;
import com.upfpo.app.repository.FarmerMasterRepository;
import com.upfpo.app.repository.LandDetailsRepo;
import com.upfpo.app.repository.UserRepository;
import com.upfpo.app.util.GetCurrentDate;

@Service
public class FPOServiceImpl implements FPOService {

	@Autowired
	private FPORegisterRepository fpoRepository;

	@Autowired
	private UserRepository userRepository;

	
	@Autowired
	private  EntityManager entityManager;
	
	@Resource
	private BoardMembersRepo boardMembersRepo;
	
	@Resource
	private LandDetailsRepo landDetailsRepo;
	
	@Resource
	private FarmerMasterRepository farmerMasterRepository;
	
	@Override
	public FPORegister insertFpo(FPORegister e) {

		e.setDeleted(false);
		return fpoRepository.save(e);
	}

	@Override
	public FPORegister updateFpo(Integer id, FPORegister e) {
		
		
		if(fpoRepository.existsById(id))
		{
			FPORegister newFpo = fpoRepository.findById(id).get();	
			newFpo.setDeleted(false);
			newFpo.setAgency(e.getAgency());
			newFpo.setBlockRef(e.getBlockRef());
			newFpo.setDateOfRegistration(e.getDateOfRegistration());
			newFpo.setDistRefId(e.getDistRefId());
			newFpo.setFmbno(e.getFmbno());
			newFpo.setFpoAddress(e.getFpoAddress());
			newFpo.setFpoBankAccNo(e.getFpoBankAccNo());
			newFpo.setFpoBankName(e.getFpoBankName());
			newFpo.setFpoEmail(e.getFpoEmail());
			newFpo.setFpoIFSC(e.getFpoIFSC());
			newFpo.setFpolandLine(e.getFpolandLine());
			newFpo.setFpoName(e.getFpoName());
			newFpo.setUserName(e.getUserName());
		    newFpo.getUserFpo().setUserName(e.getUserName());
		   // newFpo.setUserFpo(userRepository.save(newFpo.getUserFpo())); 
			
			newFpo.setDeleted(false);
			return fpoRepository.save(newFpo);
		}else {
	throw new NotFoundException();
		}
	}

	@Override
	public FPORegister insertOrUpdateFpo(FPORegister e) {

		e.setDeleted(false);
		return fpoRepository.save(e);
	}

	@Override
	public Boolean deleteFpo(Integer id) {

		 fpoRepository.deleteById(id);
		try {
		FPORegister fpoRegister = fpoRepository.getOne(id);
		fpoRegister.setDeleted(true);
		fpoRepository.save(fpoRegister);

		return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new NotFoundException();
		}
	}

	@Override
	public List<FPORegister> selectFpos() {

		return fpoRepository.findByIsDeleted(false);
	}

	@Override
	public FPORegister selectFpoById(Integer id) {

		return fpoRepository.findById(id).get();
	}
	
	@Override
	public BoardMember addBoardMember(BoardMember bm) {
		return boardMembersRepo.save(bm); 
	}

	@Override
	public List<BoardMember> getBoardMembers(){
		//return boardMembersRepo.findAll();
		return boardMembersRepo.findAllByOrderByIdDesc(false);
	}

	@Override
	public BoardMember getBoardMembersById(Long id) {
		
		return  boardMembersRepo.findById(id).get();
	}
	
	@Override
	public BoardMember updateBoardMember(BoardMember boardMemberMaster, long id) 
	{
		Optional<BoardMember> boardMember = boardMembersRepo.findById(id);
		if(boardMember.isPresent())
		{
			BoardMember newBoardMember = boardMember.get();
			newBoardMember.setName(boardMemberMaster.getName());
			newBoardMember.setDesignation(boardMemberMaster.getDesignation());
			newBoardMember.setContactNo(boardMemberMaster.getContactNo());
			newBoardMember.setEmail(boardMemberMaster.getEmail());
			newBoardMember.setBlockId(boardMemberMaster.getBlockId());
			newBoardMember.setDistId(boardMemberMaster.getDistId());
			newBoardMember.setGender(boardMemberMaster.getGender());
			newBoardMember.setGuardianName(boardMemberMaster.getGuardianName());
			newBoardMember.setMasterId(boardMemberMaster.getMasterId());
			newBoardMember.setUpdatedBy(boardMemberMaster.getUpdatedBy());
			newBoardMember.setPanchayatId(boardMemberMaster.getPanchayatId());
			newBoardMember.setVillageId(boardMemberMaster.getVillageId());
			newBoardMember.setCreateDate(boardMemberMaster.getCreateDate());
			newBoardMember.setUpdateDate(boardMemberMaster.getUpdateDate());
			
			newBoardMember = boardMembersRepo.save(newBoardMember);
			
			return newBoardMember;
		}
		else
		{
			boardMemberMaster = boardMembersRepo.save(boardMemberMaster);
			return boardMemberMaster;
		}
	}

	@Override
	public BoardMember deleteBoardMembersById(Long id) {
		
		BoardMember bm = boardMembersRepo.findById(id).get();
		bm.setDeleted(true);
		bm.setDeleteDate(GetCurrentDate.getDate());
		boardMembersRepo.save(bm);
		return bm;
	}

	@Override
	public List<FarmerLandDetailDto> getAllLandDetail(Integer masterId) {
		//return landDetailsRepo.findAll();
		List<FarmerLandDetailDto> landDetail = getLandDetailWithFarmerByFpoId(masterId);
		return landDetail;
	}

	@Override
	public LandDetails getLandDetailById(Integer id) {
		return landDetailsRepo.findById(id).get();
	}

	@Override
	@Transactional
	public LandDetails addLand(LandDetails ld) {
		return landDetailsRepo.save(ld);
	}
	
	@Override
	public LandDetails updateLand(LandDetails landDetailsMaster, int landId) 
	{
		Optional<LandDetails> landDetails = landDetailsRepo.findById(landId);
		if(landDetails.isPresent())
		{
			LandDetails newLandDetails = landDetailsRepo.findById(landId).get();
			newLandDetails.setGuardianName(landDetailsMaster.getGuardianName());
			newLandDetails.setIsorganc(landDetailsMaster.getIsorganc());
			newLandDetails.setOwnerShip(landDetailsMaster.getOwnerShip());
			newLandDetails.setFarmerProfile(farmerMasterRepository.findById(landDetailsMaster.getFarmerProfile().getFarmerId()).get());
			newLandDetails.setLand_area(landDetailsMaster.getLand_area());
			newLandDetails.setMasterId(landDetailsMaster.getMasterId());
			newLandDetails.setUpdateDate(landDetailsMaster.getUpdateDate());
			newLandDetails.setUpdatedBy(landDetailsMaster.getUpdatedBy());
			
			newLandDetails = landDetailsRepo.save(newLandDetails);
			return newLandDetails;
		}
		else
		{
			landDetailsMaster = landDetailsRepo.save(landDetailsMaster);
			return landDetailsMaster;
		}
	}

	@Override
	public boolean deleteLandDetailById(Integer id) {
		boolean ss;
		try {
			LandDetails ld = landDetailsRepo.findById(id).get();
			ld.setDeleted(true);
			ld.setDeleteDate(GetCurrentDate.getDate());
			landDetailsRepo.save(ld);
			ss = true;
		} catch (Exception e) {
			throw new NotFoundException();
		}
		return ss;
	}


	@Override
	public FPORegister selectFpoByUserName(String username) {
		System.out.println("username = "+ username);
		try {
			FPORegister fpoRegister =  fpoRepository.findByUserName(username);
			return fpoRegister;
		}catch(Exception e)
			{
				throw new NotFoundException();
			}
		
		
		
	}
	
	//get land detail of farmer
	public List<FarmerLandDetailDto> getLandDetailWithFarmerByFpoId(Integer masterId)
	{
		String  sql = "select l.land_id as landId, l.land_area as landArea,l.master_id as masterId,l.is_organic as isorganc, f.farmer_id as farmerId, f.farmer_name as farmerName, f.farmer_parants as parantsName from land_details l join farmer f\r\n"
				+ "on l.farmer_id = f.farmer_id where l.master_id = :masterId and l.is_deleted = false order by l.land_id desc";
		  
		List<FarmerLandDetailDto> obj =  (List<FarmerLandDetailDto>) entityManager.createNativeQuery(sql,"FarmerLandDetailDto").setParameter("masterId", masterId).getResultList();
		  return obj;
		    
	}
	
	@Override 
	public FarmerCropSowingDTO getFarmerDetailsForCropSowing(int farmerId) 
	  {
		  return fpoRepository.getFarmerDetailsForCropSowing(farmerId);
	  }
	
	@Override
	public List<CropListOfFarmersDTO> getCropListForFarmersByFpo(int masterId) 
	{
		String  sql =     "Select cd.crop_id id,f.farmer_id,f.farmer_name,f.farmer_parants father_husband_name,\r\n" + 
		        		"cd.financial_year,sm.season_id,sm.season_name,nsi.sowing_id, \r\n" + 
		        		"cm.id crop_id,cm.crop_name,case when cast(cd.veriety_ref as integer)!=0 \r\n" + 
		        		"then cv.crop_veriety else 'Other'end crop_veriety\r\n" + 
		        		",cd.sowing_area,cd.ex_yield,cv.veriety_id from crop_details cd\r\n" + 
		        		"inner join farmer f on f.farmer_id = cd.farmer_id \r\n" + 
		        		"inner join season_master sm on sm.season_id=cd.season_ref \r\n" + 
		        		"inner join crop_master cm on cm.id=cast( crop_ref as integer) \r\n" + 
		        		"left join crop_veriety_master cv on cv.veriety_id = cast (cd.veriety_ref as integer) \r\n" + 
		        		"left join new_sowing_info nsi on nsi.sowing_id = cd.sowing_id\r\n" + 
		        		"where f.fpo_ref_id = :masterId and cd.is_deleted=false";
		  
		List<CropListOfFarmersDTO> obj =  (List<CropListOfFarmersDTO>) entityManager.createNativeQuery(sql,"CropListOfFarmersDTO").setParameter("masterId", masterId).getResultList();
		  return obj;
	}
	 

}
