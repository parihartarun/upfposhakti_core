package com.upfpo.app.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.SearchRequestDto;

@Service
public interface NewSearchService {

	ResponseEntity<?> newHomeSearch(SearchRequestDto searchRequestDto);
	
	
}
