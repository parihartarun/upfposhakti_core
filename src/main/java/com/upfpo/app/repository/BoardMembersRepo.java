package com.upfpo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.upfpo.app.entity.BoardMember;

public interface BoardMembersRepo extends JpaRepository<BoardMember, Long>{
	
	@Query("select b from BoardMember b where b.isDeleted = :val order by b.id desc")
	public List<BoardMember> findAllByOrderByIdDesc(boolean val);

}
