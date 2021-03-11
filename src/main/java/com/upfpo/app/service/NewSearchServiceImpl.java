package com.upfpo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.upfpo.app.repository.NewSearchRepository;
import com.upfpo.app.dto.SearchRequestDto;

@Service
public class NewSearchServiceImpl implements NewSearchService {

	@Autowired
	private NewSearchRepository newSearchRepository;
	
	@Override
	public ResponseEntity<?> newHomeSearch(SearchRequestDto searchRequestDto) {
		// TODO Auto-generated method stub
		if(searchRequestDto.getIn().equalsIgnoreCase("crop"))
		{
			return searchInCrop(searchRequestDto);
		}else if(searchRequestDto.getIn().equalsIgnoreCase("inputsupplier"))
		{
			return searchInInputSuppliers(searchRequestDto);
		}else if(searchRequestDto.getIn().equalsIgnoreCase("fmb"))
		{
			
			return searchInFmb(searchRequestDto);
		}else {
		return null;
		}
		}

	private ResponseEntity<?> searchInCrop(SearchRequestDto searchRequestDto)
	{
		return newSearchRepository.newCropSearch(searchRequestDto);
	}
	private ResponseEntity<?> searchInFmb(SearchRequestDto searchRequestDto)
	{
		return newSearchRepository.newMachinerySearch(searchRequestDto);	
	}
	private ResponseEntity<?> searchInInputSuppliers(SearchRequestDto searchRequestDto)
	{
		return newSearchRepository.newInputSupplierSearch(searchRequestDto);	
	}
	
	private ResponseEntity<?> searchInInputSuppliersSeeds(SearchRequestDto searchRequestDto)
	{
	return null;	
	}
	private ResponseEntity<?> searchInInputSuppliersFertilizers(SearchRequestDto searchRequestDto)
	{
	return null;	
	}
	private ResponseEntity<?> searchInInputSuppliersInsecticides(SearchRequestDto searchRequestDto)
	{
	return null;	
	}
	
	
	
}
