package com.upfpo.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.upfpo.app.dto.CropListOfFarmersDTO;
import com.upfpo.app.dto.FarmerCropSowingDTO;
import com.upfpo.app.dto.FarmerLandDetailDto;
import com.upfpo.app.dto.MasterDataDto;
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
	public List<FPORegister> selectFpos();
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
	public FarmerCropSowingDTO getFarmerDetailsForCropSowing(int farmerId);
	public List<CropListOfFarmersDTO> getCropListForFarmersByFpo(int masterId);
	public NewSowing addFarmerCropDetails(NewSowing newSowing);
	public Optional<FPORegister> findById(Integer fpoId);
}
