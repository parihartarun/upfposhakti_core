package com.upfpo.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upfpo.app.dto.FarmerCropSowingDTO;
import com.upfpo.app.dto.FarmerLandDetailDto;
import com.upfpo.app.entity.BoardMember;
import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.entity.FarmerMaster;
import com.upfpo.app.entity.LandDetails;
import com.upfpo.app.entity.User;

@Service
public interface FPOService {

	public FPORegister insertFpo(FPORegister e);
	public FPORegister updateFpo(Integer id,FPORegister e);
	public FPORegister insertOrUpdateFpo(FPORegister e);
	public Boolean deleteFpo(Integer id);
	public List<FPORegister> selectFpos();
	public FPORegister selectFpoById(Integer id);
	public FPORegister selectFpoByUserName(String username);
	public BoardMember addBoardMember(BoardMember bm);
	public List <BoardMember> getBoardMembers();
	public BoardMember getBoardMembersById(Long id);
	public BoardMember deleteBoardMembersById(Long id);
	public LandDetails addLand(LandDetails ld);
	public List<FarmerLandDetailDto> getAllLandDetail(Integer masterId);
	public LandDetails getLandDetailById(Integer id);
	public FarmerCropSowingDTO getFarmerDetailsForCropSowing(int farmerId);
	public boolean deleteLandDetailById(Integer id);
}
