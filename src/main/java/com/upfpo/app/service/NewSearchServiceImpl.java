package com.upfpo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.upfpo.app.repository.NewSearchRepository;
import com.upfpo.app.dto.SearchRequestDto;

@Service
public class NewSearchServiceImpl implements NewSearchService {

	
	private static final String CROP = "crop";
	private static final String FERTILIZER = "fertilizer";
	private static final String INSECTICIDE = "insecticide";
	private static final String SEED = "seed";
	private static final String MACHINERY = "fmb";
	private static final String INPUTSUPPLIER = "inputsupplier";
	private static final String SERVICES = "service";
	
	@Autowired
	private NewSearchRepository newSearchRepository;
	
	@Override
	public ResponseEntity<?> newHomeSearch(SearchRequestDto searchRequestDto) {
		// TODO Auto-generated method stub
		
		searchRequestDto.setVal(searchRequestDto.getVal().trim());
		if(searchRequestDto.getIn().equalsIgnoreCase(NewSearchServiceImpl.CROP))
		{
			return searchInCrop(searchRequestDto);
		}else if(searchRequestDto.getIn().equalsIgnoreCase(NewSearchServiceImpl.INPUTSUPPLIER))
		{
       	return searchInInputSuppliers(searchRequestDto);
		}else if(searchRequestDto.getIn().equalsIgnoreCase(NewSearchServiceImpl.FERTILIZER))
		{
			return searchInInputSuppliersFertilizers(searchRequestDto);
		}else if(searchRequestDto.getIn().equalsIgnoreCase(NewSearchServiceImpl.INSECTICIDE))
		{
			return searchInInputSuppliersInsecticides(searchRequestDto);
		}else if(searchRequestDto.getIn().equalsIgnoreCase(NewSearchServiceImpl.MACHINERY))
		{
			return searchInFmb(searchRequestDto);
		}else if(searchRequestDto.getIn().equalsIgnoreCase(NewSearchServiceImpl.SEED))
		{
			return searchInInputSuppliersSeeds(searchRequestDto);
		}
		else if(searchRequestDto.getIn().equalsIgnoreCase(NewSearchServiceImpl.SERVICES))
		{
			
			return searchInFpoServices(searchRequestDto);
		
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
		return newSearchRepository.newSeedsSearch(searchRequestDto);	
	}
	
	private ResponseEntity<?> searchInInputSuppliersFertilizers(SearchRequestDto searchRequestDto)
	{
		return newSearchRepository.newFertilizersSearch(searchRequestDto);	
	}
	
	private ResponseEntity<?> searchInInputSuppliersInsecticides(SearchRequestDto searchRequestDto)
	{
		return newSearchRepository.newInsecticidesSearch(searchRequestDto);	
	}
	
	private ResponseEntity<?> searchInFpoServices(SearchRequestDto searchRequestDto)
	{
		return newSearchRepository.newFpoServicesSearch(searchRequestDto);	
	}
}
