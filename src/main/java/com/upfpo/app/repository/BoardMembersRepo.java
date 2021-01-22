package com.upfpo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.upfpo.app.entity.BoardMember;

public interface BoardMembersRepo extends JpaRepository<BoardMember, Long>{

}
