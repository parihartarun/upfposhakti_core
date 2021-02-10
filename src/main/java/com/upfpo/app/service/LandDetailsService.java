package com.upfpo.app.service;

import com.upfpo.app.dto.FarmerLandDTO;
import com.upfpo.app.dto.FarmerLandDetailDto;
import com.upfpo.app.entity.LandDetails;

import java.util.List;

public interface LandDetailsService {


    //List<FarmerLandDetailDto> getAllLandDetail(Integer masterId);

    List<FarmerLandDetailDto> getAllLandDetail(Integer masterId);

    List<FarmerLandDetailDto> getfarmerLandDetailById(Integer farmerId);

    //@Transactional
    LandDetails addLand(LandDetails ld);

    LandDetails updateLand(LandDetails landDetailsMaster, int landId);

    boolean deleteLandDetailById(Integer id);

    //FarmerLandDTO getfarmerLandDetailById(Integer id);
}
