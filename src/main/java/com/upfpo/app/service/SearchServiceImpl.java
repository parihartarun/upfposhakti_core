package com.upfpo.app.service;

import org.springframework.stereotype.Service;

import com.upfpo.app.dto.SearchRequestDto;
import com.upfpo.app.util.FiltersSelectedByUser;

@Service
public class SearchServiceImpl implements SearchService {

	public FiltersSelectedByUser getFilterStrategyOption(SearchRequestDto searchRequestDto) {

		// If no filters selected;
		if ((searchRequestDto.getCropIds() == null || searchRequestDto.getCropIds().isEmpty())
				&& (searchRequestDto.getCropverietyIds() == null || searchRequestDto.getCropverietyIds().isEmpty())
				&& (searchRequestDto.getDistrictIds() == null || searchRequestDto.getDistrictIds().isEmpty())
				&& (searchRequestDto.getFpoIds() == null || searchRequestDto.getFpoIds().isEmpty())
				&& (searchRequestDto.getQtymax() == null && searchRequestDto.getQtymin() == null)) {
			return FiltersSelectedByUser.NONESELECTED;
		} else if ( // If all filters selected;
		           searchRequestDto.getCropIds() != null && !searchRequestDto.getCropIds().isEmpty()
				&& searchRequestDto.getCropverietyIds() != null && !searchRequestDto.getCropverietyIds().isEmpty()
				&& searchRequestDto.getDistrictIds() != null && !searchRequestDto.getDistrictIds().isEmpty()
				&& searchRequestDto.getFpoIds() != null && !searchRequestDto.getFpoIds().isEmpty()
				&& searchRequestDto.getQtymax() != null && searchRequestDto.getQtymin() != null) {
			return FiltersSelectedByUser.ALLSELECTED;
		} else if ( // If only Crop filters selected;
		searchRequestDto.getCropIds() != null && !searchRequestDto.getCropIds().isEmpty()
				&& (searchRequestDto.getCropverietyIds() == null || searchRequestDto.getCropverietyIds().isEmpty())
				&& (searchRequestDto.getDistrictIds() == null || searchRequestDto.getDistrictIds().isEmpty())
				&& (searchRequestDto.getFpoIds() == null || searchRequestDto.getFpoIds().isEmpty())
				&& (searchRequestDto.getQtymax() == null || searchRequestDto.getQtymin() == null)) {
			return FiltersSelectedByUser.CROPS;
		} else if ( // If only Crop ,districts and fpo filters selected;
		searchRequestDto.getCropIds() != null && !searchRequestDto.getCropIds().isEmpty()
				&& (searchRequestDto.getCropverietyIds() == null || searchRequestDto.getCropverietyIds().isEmpty())
				&& searchRequestDto.getDistrictIds() != null && !searchRequestDto.getDistrictIds().isEmpty()
				&& searchRequestDto.getFpoIds() != null && !searchRequestDto.getFpoIds().isEmpty()
				&& (searchRequestDto.getQtymax() == null || searchRequestDto.getQtymin() == null)) {
			return FiltersSelectedByUser.CROPS_DISTRICTS_FPOS;
		} else if ( // If only Crop ,districts and range filters selected;
		searchRequestDto.getCropIds() != null && !searchRequestDto.getCropIds().isEmpty()
				&& (searchRequestDto.getCropverietyIds() == null || searchRequestDto.getCropverietyIds().isEmpty())
				&& searchRequestDto.getDistrictIds() != null && !searchRequestDto.getDistrictIds().isEmpty()
				&& (searchRequestDto.getFpoIds() == null || searchRequestDto.getFpoIds().isEmpty())
				&& searchRequestDto.getQtymax() != null && searchRequestDto.getQtymin() != null) {
			return FiltersSelectedByUser.CROPS_DISTRICTS_RANGE;
		} else if ( // If only Crop and fpo filters selected;
		searchRequestDto.getCropIds() != null && !searchRequestDto.getCropIds().isEmpty()
				&& (searchRequestDto.getCropverietyIds() == null || searchRequestDto.getCropverietyIds().isEmpty())
				&& (searchRequestDto.getDistrictIds() == null || searchRequestDto.getDistrictIds().isEmpty())
				&& searchRequestDto.getFpoIds() != null && !searchRequestDto.getFpoIds().isEmpty()
				&& (searchRequestDto.getQtymax() == null || searchRequestDto.getQtymin() == null)) {
			return FiltersSelectedByUser.CROPS_FPOS;
		} else if ( // If only Crop and range filters selected;
		searchRequestDto.getCropIds() != null && !searchRequestDto.getCropIds().isEmpty()
				&& (searchRequestDto.getCropverietyIds() == null || searchRequestDto.getCropverietyIds().isEmpty())
				&& (searchRequestDto.getDistrictIds() == null || searchRequestDto.getDistrictIds().isEmpty())
				&& (searchRequestDto.getFpoIds() == null || searchRequestDto.getFpoIds().isEmpty())
				&& searchRequestDto.getQtymax() != null && searchRequestDto.getQtymin() != null) {
			return FiltersSelectedByUser.CROPS_RANGE;
		}

		else if ( // If only Crop fpo,and range filters selected;
		searchRequestDto.getCropIds() != null && !searchRequestDto.getCropIds().isEmpty()
				&& (searchRequestDto.getCropverietyIds() == null || searchRequestDto.getCropverietyIds().isEmpty())
				&& (searchRequestDto.getDistrictIds() == null || searchRequestDto.getDistrictIds().isEmpty())
				&& searchRequestDto.getFpoIds() != null && !searchRequestDto.getFpoIds().isEmpty()
				&& searchRequestDto.getQtymax() != null && searchRequestDto.getQtymin() != null) {
			return FiltersSelectedByUser.CROPS_RANGE_FPOS;
		} else if (
		// If only Crop fpo,and veriety filters selected;
		searchRequestDto.getCropIds() != null && !searchRequestDto.getCropIds().isEmpty()
				&& searchRequestDto.getCropverietyIds() != null && !searchRequestDto.getCropverietyIds().isEmpty()
				&& (searchRequestDto.getDistrictIds() == null || searchRequestDto.getDistrictIds().isEmpty())
				&& searchRequestDto.getFpoIds() != null && !searchRequestDto.getFpoIds().isEmpty()
				&& (searchRequestDto.getQtymax() == null || searchRequestDto.getQtymin() == null)) {
			return FiltersSelectedByUser.CROPS_VERIETY_FPOS;
		} else if (
		// If only Crop range,and veriety filters selected;
		searchRequestDto.getCropIds() != null && !searchRequestDto.getCropIds().isEmpty()
				&& searchRequestDto.getCropverietyIds() != null && !searchRequestDto.getCropverietyIds().isEmpty()
				&& (searchRequestDto.getDistrictIds() == null || searchRequestDto.getDistrictIds().isEmpty())
				&& (searchRequestDto.getFpoIds() == null || searchRequestDto.getFpoIds().isEmpty())
				&& searchRequestDto.getQtymax() != null && searchRequestDto.getQtymin() != null) {
			return FiltersSelectedByUser.CROPS_VERIETY_RANGE;
		} else if (
		// If only district filters selected;
		(searchRequestDto.getCropIds() == null || searchRequestDto.getCropIds().isEmpty())
				&& (searchRequestDto.getCropverietyIds() == null || searchRequestDto.getCropverietyIds().isEmpty())
				&& searchRequestDto.getDistrictIds() != null && !searchRequestDto.getDistrictIds().isEmpty()
				&& (searchRequestDto.getFpoIds() == null || searchRequestDto.getFpoIds().isEmpty())
				&& (searchRequestDto.getQtymax() == null || searchRequestDto.getQtymin() == null)) {
			return FiltersSelectedByUser.DISTRICTS;
		} else if (
		// If only district filters selected;
		(searchRequestDto.getCropIds() == null || searchRequestDto.getCropIds().isEmpty())
				&& (searchRequestDto.getCropverietyIds() == null || searchRequestDto.getCropverietyIds().isEmpty())
				&& searchRequestDto.getDistrictIds() != null && !searchRequestDto.getDistrictIds().isEmpty()
				&& (searchRequestDto.getFpoIds() == null || searchRequestDto.getFpoIds().isEmpty())
				&& (searchRequestDto.getQtymax() == null || searchRequestDto.getQtymin() == null)) {
			return FiltersSelectedByUser.DISTRICTS;
		}

		else if (
		// If only district and crop filters selected;
		searchRequestDto.getCropIds() != null && !searchRequestDto.getCropIds().isEmpty()
				&& (searchRequestDto.getCropverietyIds() == null || searchRequestDto.getCropverietyIds().isEmpty())
				&& searchRequestDto.getDistrictIds() != null && !searchRequestDto.getDistrictIds().isEmpty()
				&& (searchRequestDto.getFpoIds() == null || searchRequestDto.getFpoIds().isEmpty())
				&& (searchRequestDto.getQtymax() == null || searchRequestDto.getQtymin() == null)) {
			return FiltersSelectedByUser.DISTRICTS_CROPS;
		} else if (
		// If only district and fpos filters selected;
		(searchRequestDto.getCropIds() == null || searchRequestDto.getCropIds().isEmpty())
				&& (searchRequestDto.getCropverietyIds() == null || searchRequestDto.getCropverietyIds().isEmpty())
				&& searchRequestDto.getDistrictIds() != null && !searchRequestDto.getDistrictIds().isEmpty()
				&& searchRequestDto.getFpoIds() != null && !searchRequestDto.getFpoIds().isEmpty()
				&& (searchRequestDto.getQtymax() == null || searchRequestDto.getQtymin() == null)) {
			return FiltersSelectedByUser.DISTRICTS_FPOS;
		} else if (
		// If only district and range filters selected;
		(searchRequestDto.getCropIds() == null || searchRequestDto.getCropIds().isEmpty())
				&& (searchRequestDto.getCropverietyIds() == null || searchRequestDto.getCropverietyIds().isEmpty())
				&& searchRequestDto.getDistrictIds() != null && !searchRequestDto.getDistrictIds().isEmpty()
				&& (searchRequestDto.getFpoIds() == null || searchRequestDto.getFpoIds().isEmpty())
				&& searchRequestDto.getQtymax() != null && searchRequestDto.getQtymin() != null) {
			return FiltersSelectedByUser.DISTRICTS_RANGE;
		} else if (
		// If only district crops,fpos, and range filters selected;
		searchRequestDto.getCropIds() != null && !searchRequestDto.getCropIds().isEmpty()
				&& (searchRequestDto.getCropverietyIds() == null || searchRequestDto.getCropverietyIds().isEmpty())
				&& searchRequestDto.getDistrictIds() != null && !searchRequestDto.getDistrictIds().isEmpty()
				&& searchRequestDto.getFpoIds() != null && !searchRequestDto.getFpoIds().isEmpty()
				&& searchRequestDto.getQtymax() != null && searchRequestDto.getQtymin() != null) {
			return FiltersSelectedByUser.DISTRICTS_RANGE_CROPS_FPOS;
		} else if (
		// If only district veriety,fpos, and range filters selected;
		(searchRequestDto.getCropIds() == null || searchRequestDto.getCropIds().isEmpty())
				&& searchRequestDto.getCropverietyIds() != null && !searchRequestDto.getCropverietyIds().isEmpty()
				&& searchRequestDto.getDistrictIds() != null && !searchRequestDto.getDistrictIds().isEmpty()
				&& searchRequestDto.getFpoIds() != null && !searchRequestDto.getFpoIds().isEmpty()
				&& searchRequestDto.getQtymax() != null && searchRequestDto.getQtymin() != null) {
			return FiltersSelectedByUser.DISTRICTS_RANGE_VERIETY_FPOS;
		} else if (
		// If only district and veriety filters selected;
		(searchRequestDto.getCropIds() == null || searchRequestDto.getCropIds().isEmpty())
				&& searchRequestDto.getCropverietyIds() != null && !searchRequestDto.getCropverietyIds().isEmpty()
				&& searchRequestDto.getDistrictIds() != null && !searchRequestDto.getDistrictIds().isEmpty()
				&& (searchRequestDto.getFpoIds() == null || searchRequestDto.getFpoIds().isEmpty())
				&& (searchRequestDto.getQtymax() == null || searchRequestDto.getQtymin() == null)) {
			return FiltersSelectedByUser.DISTRICTS_VERIETY;
		}

		else if (
		// If only district , crops and veriety filters selected;
		searchRequestDto.getCropIds() != null && !searchRequestDto.getCropIds().isEmpty()
				&& searchRequestDto.getCropverietyIds() != null && !searchRequestDto.getCropverietyIds().isEmpty()
				&& searchRequestDto.getDistrictIds() != null && !searchRequestDto.getDistrictIds().isEmpty()
				&& (searchRequestDto.getFpoIds() == null || searchRequestDto.getFpoIds().isEmpty())
				&& (searchRequestDto.getQtymax() == null || searchRequestDto.getQtymin() == null)) {
			return FiltersSelectedByUser.DISTRICTS_VERIETY_CROPS;
		} else if (
		// If only district , fpos, crops and veriety filters selected;
		searchRequestDto.getCropIds() != null && !searchRequestDto.getCropIds().isEmpty()
				&& searchRequestDto.getCropverietyIds() != null && !searchRequestDto.getCropverietyIds().isEmpty()
				&& searchRequestDto.getDistrictIds() != null && !searchRequestDto.getDistrictIds().isEmpty()
				&& searchRequestDto.getFpoIds() != null && !searchRequestDto.getFpoIds().isEmpty()
				&& (searchRequestDto.getQtymax() == null || searchRequestDto.getQtymin() == null)) {
			return FiltersSelectedByUser.DISTRICTS_VERIETY_CROPS_FPOS;
		}

		else if (
		// If only district , range, crops and veriety filters selected;
		searchRequestDto.getCropIds() != null && !searchRequestDto.getCropIds().isEmpty()
				&& searchRequestDto.getCropverietyIds() != null && !searchRequestDto.getCropverietyIds().isEmpty()
				&& searchRequestDto.getDistrictIds() != null && !searchRequestDto.getDistrictIds().isEmpty()
				&& (searchRequestDto.getFpoIds() == null || searchRequestDto.getFpoIds().isEmpty())
				&& searchRequestDto.getQtymax() != null && searchRequestDto.getQtymin() != null) {
			return FiltersSelectedByUser.DISTRICTS_VERIETY_CROPS_RANGE;
		} else if (
		// If only district , fpo and veriety filters selected;
		(searchRequestDto.getCropIds() == null || searchRequestDto.getCropIds().isEmpty())
				&& searchRequestDto.getCropverietyIds() != null && !searchRequestDto.getCropverietyIds().isEmpty()
				&& searchRequestDto.getDistrictIds() != null && !searchRequestDto.getDistrictIds().isEmpty()
				&& searchRequestDto.getFpoIds() != null && !searchRequestDto.getFpoIds().isEmpty()
				&& (searchRequestDto.getQtymax() == null || searchRequestDto.getQtymin() == null)) {
			return FiltersSelectedByUser.DISTRICTS_VERIETY_FPOS;
		} else if (
		// If only district , range and veriety filters selected;
		(searchRequestDto.getCropIds() == null || searchRequestDto.getCropIds().isEmpty())
				&& searchRequestDto.getCropverietyIds() != null && !searchRequestDto.getCropverietyIds().isEmpty()
				&& searchRequestDto.getDistrictIds() != null && !searchRequestDto.getDistrictIds().isEmpty()
				&& (searchRequestDto.getFpoIds() != null || searchRequestDto.getFpoIds().isEmpty())
				&& searchRequestDto.getQtymax() != null && searchRequestDto.getQtymin() != null) {
			return FiltersSelectedByUser.DISTRICTS_VERIETY_RANGE;
		} else if (
		// If only fpo filters selected;
		(searchRequestDto.getCropIds() == null || searchRequestDto.getCropIds().isEmpty())
				&& (searchRequestDto.getCropverietyIds() == null || searchRequestDto.getCropverietyIds().isEmpty())
				&& (searchRequestDto.getDistrictIds() == null || searchRequestDto.getDistrictIds().isEmpty())
				&& searchRequestDto.getFpoIds() != null && !searchRequestDto.getFpoIds().isEmpty()
				&& (searchRequestDto.getQtymax() == null || searchRequestDto.getQtymin() == null)) {
			return FiltersSelectedByUser.FPOS;
		} else if (
		// If only range filters selected;
		(searchRequestDto.getCropIds() == null || searchRequestDto.getCropIds().isEmpty())
				&& (searchRequestDto.getCropverietyIds() == null || searchRequestDto.getCropverietyIds().isEmpty())
				&& (searchRequestDto.getDistrictIds() == null || searchRequestDto.getDistrictIds().isEmpty())
				&& (searchRequestDto.getFpoIds() == null || searchRequestDto.getFpoIds().isEmpty())
				&& searchRequestDto.getQtymax() != null && searchRequestDto.getQtymin() != null) {
			return FiltersSelectedByUser.RANGE;
		} else if (
		// If only range,districts and fpos filters selected;
		(searchRequestDto.getCropIds() == null || searchRequestDto.getCropIds().isEmpty())
				&& (searchRequestDto.getCropverietyIds() == null || searchRequestDto.getCropverietyIds().isEmpty())
				&& searchRequestDto.getDistrictIds() != null && !searchRequestDto.getDistrictIds().isEmpty()
				&& searchRequestDto.getFpoIds() != null && !searchRequestDto.getFpoIds().isEmpty()
				&& searchRequestDto.getQtymax() != null && searchRequestDto.getQtymin() != null) {
			return FiltersSelectedByUser.RANGE_DISTRICTS_FPOS;
		} else if (
		// If only range and fpos filters selected;
		(searchRequestDto.getCropIds() == null || searchRequestDto.getCropIds().isEmpty())
				&& (searchRequestDto.getCropverietyIds() == null || searchRequestDto.getCropverietyIds().isEmpty())
				&& (searchRequestDto.getDistrictIds() == null || searchRequestDto.getDistrictIds().isEmpty())
				&& searchRequestDto.getFpoIds() != null && !searchRequestDto.getFpoIds().isEmpty()
				&& searchRequestDto.getQtymax() != null && searchRequestDto.getQtymin() != null) {
			return FiltersSelectedByUser.RANGE_FPOS;
		} else if (
		// If only range,veriety and fpos filters selected;
		(searchRequestDto.getCropIds() == null || searchRequestDto.getCropIds().isEmpty())
				&& searchRequestDto.getCropverietyIds() != null && !searchRequestDto.getCropverietyIds().isEmpty()
				&& (searchRequestDto.getDistrictIds() == null || searchRequestDto.getDistrictIds().isEmpty())
				&& searchRequestDto.getFpoIds() != null && !searchRequestDto.getFpoIds().isEmpty()
				&& searchRequestDto.getQtymax() != null && searchRequestDto.getQtymin() != null) {
			return FiltersSelectedByUser.RANGE_VERIETY_FPOS;
		} else if (
		// If only veriety filters selected;
		(searchRequestDto.getCropIds() == null || searchRequestDto.getCropIds().isEmpty())
				&& searchRequestDto.getCropverietyIds() != null && !searchRequestDto.getCropverietyIds().isEmpty()
				&& (searchRequestDto.getDistrictIds() == null || searchRequestDto.getDistrictIds().isEmpty())
				&& (searchRequestDto.getFpoIds() == null || searchRequestDto.getFpoIds().isEmpty())
				&& (searchRequestDto.getQtymax() == null || searchRequestDto.getQtymin() == null)) {
			return FiltersSelectedByUser.VERIETIES;
		} else if (
		// If only veriety and crops filters selected;
		searchRequestDto.getCropIds() != null && !searchRequestDto.getCropIds().isEmpty()
				&& searchRequestDto.getCropverietyIds() != null && !searchRequestDto.getCropverietyIds().isEmpty()
				&& (searchRequestDto.getDistrictIds() == null || searchRequestDto.getDistrictIds().isEmpty())
				&& (searchRequestDto.getFpoIds() == null || searchRequestDto.getFpoIds().isEmpty())
				&& (searchRequestDto.getQtymax() == null || searchRequestDto.getQtymin() == null)) {
			return FiltersSelectedByUser.VERIETY_CROPS;
		}else if (
				// If only veriety and fpos filters selected;
				(searchRequestDto.getCropIds() == null || searchRequestDto.getCropIds().isEmpty())
						&& searchRequestDto.getCropverietyIds() != null && !searchRequestDto.getCropverietyIds().isEmpty()
						&& (searchRequestDto.getDistrictIds() == null || searchRequestDto.getDistrictIds().isEmpty())
						&& searchRequestDto.getFpoIds() != null && !searchRequestDto.getFpoIds().isEmpty()
						&& (searchRequestDto.getQtymax() == null || searchRequestDto.getQtymin() == null)) {
					return FiltersSelectedByUser.VERIETY_FPOS;
				}else if (
						// If only veriety and range filters selected;
						(searchRequestDto.getCropIds() == null || searchRequestDto.getCropIds().isEmpty())
								&& searchRequestDto.getCropverietyIds() != null && !searchRequestDto.getCropverietyIds().isEmpty()
								&& (searchRequestDto.getDistrictIds() == null || searchRequestDto.getDistrictIds().isEmpty())
								&& (searchRequestDto.getFpoIds() == null || searchRequestDto.getFpoIds().isEmpty())
								&& searchRequestDto.getQtymax() != null && searchRequestDto.getQtymin() != null) {
							return FiltersSelectedByUser.VERIETY_RANGE;
						}


		


		return null;

	}

}
