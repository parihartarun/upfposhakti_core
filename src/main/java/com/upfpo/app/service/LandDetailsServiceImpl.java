package com.upfpo.app.service;

import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.dto.FarmerLandDTO;
import com.upfpo.app.dto.FarmerLandDetailDto;
import com.upfpo.app.entity.FarmerMaster;
import com.upfpo.app.entity.LandDetails;
import com.upfpo.app.repository.FarmerMasterRepository;
import com.upfpo.app.repository.LandDetailsRepo;
import com.upfpo.app.upagri.UpAgriClient;
import com.upfpo.app.util.GetCurrentDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;

@Service
public class LandDetailsServiceImpl implements LandDetailsService {




    @Autowired
    private FarmerMasterRepository farmerMasterRepository;

    @Autowired
    private LandDetailsRepo landDetailsRepo;

    @Autowired
    private FPOServiceImpl fpoService;

    @Autowired
    private EntityManager entityManager;




    //public LandDetails getLandDetailById(Integer id) {
        //return landDetailsRepo.findById(id).get();
    //}

    /*public FarmerLandDTO getLandDetailByFarmerId(Integer id) {

        FarmerMaster farmer=farmerMasterRepository.findById(id).get();
        FarmerLandDTO

        return landDetailsRepo.;
    }*/

    public List<FarmerLandDetailDto> getLandDetailWithFarmerByFarmerId(Integer farmerId)
    {
        String  sql = "select l.land_id as landId, l.land_area as landArea,l.master_id as masterId,l.is_organic as isorganc,l.nature_of_ownership as ownership,f.farmer_id as farmerId, f.farmer_name as farmerName, f.farmer_parants as parantsName from land_details l join farmer f\r\n"
                + "on l.farmer_id = f.farmer_id where l.farmer_id = :farmerId and l.is_deleted = false order by l.land_id desc";

        List<FarmerLandDetailDto> obj =  (List<FarmerLandDetailDto>) entityManager.createNativeQuery(sql,"FarmerLandDetailDto").setParameter("farmerId", farmerId).getResultList();
        return obj;

    }

    public List<FarmerLandDetailDto> getLandDetailByFarmerId(Integer farmerId)
    {
        String  sql = "select l.land_id as landId, l.land_area as landArea,l.master_id as masterId,l.is_organic as isorganc,l.nature_of_ownership as ownership,f.farmer_id as farmerId, f.farmer_name as farmerName, f.farmer_parants as parantsName from land_details l join farmer f\r\n"
                + "on l.farmer_id = f.farmer_id where l.farmer_id = :farmerId and l.is_deleted = false order by l.land_id desc";


        List<FarmerLandDetailDto> obj =  (List<FarmerLandDetailDto>) entityManager.createNativeQuery(sql,"FarmerLandDetailDto").setParameter("farmerId", farmerId).getResultList();
        return obj;

    }


    @Override
    public List<FarmerLandDetailDto> getAllLandDetail(Integer farmerId) {
        //return landDetailsRepo.findAll();
        List<FarmerLandDetailDto> landDetail = getLandDetailWithFarmerByFarmerId(farmerId);
        return landDetail;
    }

    @Override
    public List<FarmerLandDetailDto> getfarmerLandDetailById(Integer farmerId) {
        //return landDetailsRepo.findAll();
        List<FarmerLandDetailDto> landDetail = getLandDetailByFarmerId(farmerId);
        return landDetail;
    }

    @Override
    //@Transactional
    public LandDetails addLand(LandDetails ld) {
        return landDetailsRepo.save(ld);
    }

    @Override
    public LandDetails updateLand(LandDetails landDetailsMaster, int landId)
    {
        Optional<LandDetails> landDetails = landDetailsRepo.findById(landId);
        if(landDetails.isPresent())
        {
            LandDetails newLandDetails = landDetailsRepo.findById(landId).get();
            newLandDetails.setGuardianName(landDetailsMaster.getGuardianName());
            newLandDetails.setIsorganc(landDetailsMaster.getIsorganc());
            newLandDetails.setOwnerShip(landDetailsMaster.getOwnerShip());
            newLandDetails.setFarmerProfile(farmerMasterRepository.findById(landDetailsMaster.getFarmerProfile().getFarmerId()).get());
            newLandDetails.setLand_area(landDetailsMaster.getLand_area());
            newLandDetails.setMasterId(landDetailsMaster.getMasterId());
            newLandDetails.setUpdateDate(landDetailsMaster.getUpdateDate());
            newLandDetails.setUpdatedBy(landDetailsMaster.getUpdatedBy());
            newLandDetails = landDetailsRepo.save(newLandDetails);
            return newLandDetails;
        }
        else
        {
            landDetailsMaster = landDetailsRepo.save(landDetailsMaster);
            return landDetailsMaster;
        }
    }

    @Override
    public boolean deleteLandDetailById(Integer id) {
        boolean ss;
        try {
            LandDetails ld = landDetailsRepo.findById(id).get();
            ld.setDeleted(true);
            ld.setDeleteDate(GetCurrentDate.getDate());
            landDetailsRepo.save(ld);
            ss = true;
        } catch (Exception e) {
            throw new NotFoundException();
        }
        return ss;
    }
    /*@Override
    public LandDetails addLandDetails(Integer id, ){

        return farmerMasterReposito

    }*/

    /*@Override
    public FarmerLandDTO getfarmerLandDetailById(Integer id)  {

        FarmerMaster farmer = farmerMasterRepository.findById(id).get();
        FarmerLandDTO farmerland=new FarmerLandDTO();
        LandDetails landDetails=landDetailsRepo.findByFarmerId(id);
        String pardarshiId= farmer.getUpBSMId();

        farmerland.setFarmerName(farmer.getFarmerName());
        farmerland.setGuardianName(farmer.getParantsName());
        farmerland.setOwnership(landDetails.getOwnerShip());
        farmerland.setIsorganc(landDetails.getIsorganc());
        farmerland.setLandArea(String.valueOf(landDetails.getLand_area()));
        return farmerland;

    }*/
}
