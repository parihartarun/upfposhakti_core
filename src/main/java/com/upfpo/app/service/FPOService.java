package com.upfpo.app.service;

import java.util.List;
import java.util.Optional;

import com.upfpo.app.dto.*;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.BoardMember;
import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.entity.LandDetails;
import com.upfpo.app.entity.NewSowing;

@Service
public interface FPOService {

	public FPORegister insertFpo(FPORegister e);
	public FPORegister updateFpo(Integer id,FPORegister e);
	public FPORegister insertOrUpdateFpo(FPORegister e);
	public Boolean deleteFpo(Integer id);
	public FpoProfileDTO getProfileData(Integer id);
	public List<FPOListDTO> selectFpos();
	public FPORegister selectFpoById(Integer id);
	public MasterDataDto getDistrictByFpoId(int fpoId);
	public FPORegister selectFpoByUserName(String username);
	public BoardMember addBoardMember(BoardMember bm);
	public List <BoardMember> getBoardMembers(Integer masterId);
	public BoardMember getBoardMembersById(Long id);
	public BoardMember updateBoardMember(BoardMember boardMember, long id);
	public BoardMember deleteBoardMembersById(Long id);
	public LandDetails addLand(LandDetails ld);
	public LandDetails updateLand(LandDetails landDetails, int landId);
	public List<FarmerLandDetailDto> getAllLandDetail(Integer masterId);
	public LandDetails getLandDetailById(Integer id);
	public boolean deleteLandDetailById(Integer id);
	public List<CropListOfFarmersDTO> getCropListForFarmersByFpo(int masterId);
	public NewSowing addFarmerCropDetails(NewSowing newSowing);
	public Optional<FPORegister> findById(Integer fpoId);

	List<ProductionDetailsDTO> getProductionDetailAnnual(String finyear, Integer masterId);

    List<ProductionDetailsDTO> getProductionDetailGraph(String finyear, Integer masterId);
    
    List<FpoDTO> getFpoOnDistrict(Integer districtId);
}
