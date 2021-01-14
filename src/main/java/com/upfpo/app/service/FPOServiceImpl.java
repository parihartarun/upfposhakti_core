package com.upfpo.app.service;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.BoardMember;
import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.entity.LandDetails;
import com.upfpo.app.repository.BoardMembersRepo;
import com.upfpo.app.repository.FPORegisterRepository;
import com.upfpo.app.repository.LandDetailsRepo;
import com.upfpo.app.util.GetCurrentDate;

@Service
public class FPOServiceImpl implements FPOService {

	@Autowired
	private FPORegisterRepository fpoRepository;
	
	@Resource
	private BoardMembersRepo boardMembersRepo;
	
	@Resource
	private LandDetailsRepo landDetailsRepo;
	
	@Override
	public FPORegister insertFpo(FPORegister e) {
		return fpoRepository.save(e);
	}

	@Override
	public FPORegister updateFpo(Integer id, FPORegister e) {
		if(fpoRepository.existsById(id))
		{
			return fpoRepository.save(e);
		}
		else {
			return null;	
		}
		 
	}

	@Override
	public FPORegister insertOrUpdateFpo(FPORegister e) {
		return fpoRepository.save(e);
	}

	@Override
	public Boolean deleteFpo(Integer id) {
		 fpoRepository.deleteById(id);
		return true;
	}

	@Override
	public List<FPORegister> selectFpos() {
		return fpoRepository.findAll();
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
	public List<BoardMember> getBoardMembers() {
		return boardMembersRepo.findAll();
	}

	@Override
	public BoardMember getBoardMembersById(Long id) {
		
		return  boardMembersRepo.findById(id).get();
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
	public List<LandDetails> getAllLandDetail() {
		return landDetailsRepo.findAll();
	}

	@Override
	public LandDetails getLandDetailById(Integer id) {
		return landDetailsRepo.findById(id).get();
	}

	@Override
	public LandDetails addLand(LandDetails ld) {
		return landDetailsRepo.save(ld);
	}

	@Override
	public LandDetails deleteLandDetailById(Integer id) {
		
		LandDetails ld = landDetailsRepo.findById(id).get();
		ld.setDeleted(true);
		ld.setDeleteDate(GetCurrentDate.getDate());
		
		return landDetailsRepo.save(ld);
	}

}
