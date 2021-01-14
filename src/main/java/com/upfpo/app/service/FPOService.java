package com.upfpo.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upfpo.app.entity.BoardMember;
import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.entity.LandDetails;

@Service
public interface FPOService {

	public FPORegister insertFpo(FPORegister e);
	public FPORegister updateFpo(Integer id,FPORegister e);
	public FPORegister insertOrUpdateFpo(FPORegister e);
	public Boolean deleteFpo(Integer id);
	public List<FPORegister> selectFpos();
	public FPORegister selectFpoById(Integer id);
	
	public BoardMember addBoardMember(BoardMember bm);
	public List <BoardMember> getBoardMembers();
	public BoardMember getBoardMembersById(Long id);
	public BoardMember deleteBoardMembersById(Long id);
	
	public LandDetails addLand(LandDetails ld);
	public List<LandDetails> getAllLandDetail();
	public LandDetails getLandDetailById(Integer id);
	public LandDetails deleteLandDetailById(Integer id);
}
