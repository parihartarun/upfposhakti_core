package com.upfpo.app.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.dto.FPOSalesDetailsDTO;
import com.upfpo.app.entity.FPOSaleInfo;
import com.upfpo.app.repository.FpoSalesInfoMasterRepository;
import com.upfpo.app.util.GetFinYear;
import com.upfpo.app.util.TotalProductionCalculation;

@Service
public class FPOSalesDetailsServiceImpl implements FPOSalesDetailsService{

	@Autowired
	EntityManager entityManager;
    
	@Autowired
    private FpoSalesInfoMasterRepository fpoSalesInfoMasterRepository;
	
	@Autowired
	private TotalProductionCalculation totalProductionCalculation;
    
    @Override
    public void insertSalesDetails(FPOSaleInfo fPOSaleInfo) 
    {
    	String financialYear = GetFinYear.getCurrentFinYear();
    	fPOSaleInfo.setDeleted(false);
    	fPOSaleInfo.setFinYear(financialYear);
		fpoSalesInfoMasterRepository.save(fPOSaleInfo);
		totalProductionCalculation.updateTotalProductionForSalesDetails(fPOSaleInfo.getSoldQuantity(), fPOSaleInfo.getCropRefName(), fPOSaleInfo.getVerietyId(), fPOSaleInfo.getSeason(), financialYear, fPOSaleInfo.getMasterId());
    }
    
    @Override
    public List<FPOSalesDetailsDTO> getSalesDetails(Integer masterId) 
    {
        //return salesDetailsRepository.findByIsDeleted(false);
        
        String  sql =  	"Select m.id,s.season_id, s.season_name,cc.id as category_id, cc.category,cm.id as crop_id,cm.crop_name,m.sold_quantity sold_quantity,\r\n"
        		+ "    				m.financial_year,cvm.veriety_id, case when cast(m.veriety_ref as integer)!=0 then cvm.crop_veriety else 'Other' \r\n"
        		+ "    					end  crop_variety,cast(m.veriety_ref as integer),m.crop_ref_name,cast(m.season_ref as integer) from fpo_sale_Info m\r\n"
        		+ "    					inner join season_master s on CAST ( m.season_ref as integer)=s.season_id\r\n"
        		+ "    					inner join crop_master cm on cm.id=crop_ref_name\r\n"
        		+ "    					inner join crop_category cc on cc.id= cm.crop_cat_ref_id \r\n"
        		+ "    					left join crop_veriety_master cvm on cvm.veriety_id=cast(m.veriety_ref as integer)\r\n"
        		+ "    					where m.master_id = :masterId and m.is_deleted= false order by m.id desc" ;

		  
		  List<FPOSalesDetailsDTO> obj =  (List<FPOSalesDetailsDTO>) entityManager.createNativeQuery(sql,"FPOSalesDetailsDTO").setParameter("masterId", masterId).getResultList();
		  return obj;
    }

    @Override
    public Optional<FPOSaleInfo> getSalesDetailsById(Integer id) {
        if(!fpoSalesInfoMasterRepository.existsById(id)) {
            return null;
        }
        return fpoSalesInfoMasterRepository.findById(id);
    }

    @Override
    public FPOSaleInfo updateSalesDetails(Integer id, FPOSaleInfo fpoSalesInfoMaster) 
    {
        Optional<FPOSaleInfo> fpoSalesDetails = fpoSalesInfoMasterRepository.findById(id);
		if(fpoSalesDetails.isPresent())
		{
			FPOSaleInfo newFpoSalesDetails = fpoSalesInfoMasterRepository.findById(id).get();
			newFpoSalesDetails.setCropRefName(fpoSalesInfoMaster.getCropRefName());
			newFpoSalesDetails.setVerietyId(fpoSalesInfoMaster.getVerietyId());
			newFpoSalesDetails.setFinYear(GetFinYear.getCurrentFinYear());
			newFpoSalesDetails.setSoldQuantity(fpoSalesInfoMaster.getSoldQuantity());
			newFpoSalesDetails.setDeleted(false);
			newFpoSalesDetails.setMasterId(fpoSalesInfoMaster.getMasterId());
			newFpoSalesDetails.setFpoId(fpoSalesInfoMaster.getMasterId());
			
			newFpoSalesDetails = fpoSalesInfoMasterRepository.save(newFpoSalesDetails);
			return newFpoSalesDetails;
		}
		else
		{
			fpoSalesInfoMaster = fpoSalesInfoMasterRepository.save(fpoSalesInfoMaster);
			return fpoSalesInfoMaster;
		}
    }

    @Override
    public Boolean deleteFPOSalesDetails(Integer id) 
    {
        if(fpoSalesInfoMasterRepository.findById(id) != null)
            try {
                FPOSaleInfo fpoSalesInfo = fpoSalesInfoMasterRepository.findById(id).get();
                fpoSalesInfo.setDeleted(true);
                fpoSalesInfoMasterRepository.save(fpoSalesInfo);
                return true;
            }catch(Exception e)
            {
                throw new NotFoundException();
            }
        else
            return false;
    }
}
