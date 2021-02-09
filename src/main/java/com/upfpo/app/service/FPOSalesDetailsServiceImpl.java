package com.upfpo.app.service;

import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.dto.FPOSalesDetailsDTO;
import com.upfpo.app.dto.FpoCropProductionDetailsDTO;
import com.upfpo.app.entity.FPOSalesDetails;
import com.upfpo.app.entity.FPOServices;
import com.upfpo.app.repository.FPOSalesDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

@Service
public class FPOSalesDetailsServiceImpl implements FPOSalesDetailsService{

	@Autowired
	EntityManager entityManager;
	
    @Autowired
    private FPOSalesDetailsRepository salesDetailsRepository;


    @Override
    public FPOSalesDetails insertSalesDetails(FPOSalesDetails salesDetails) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        salesDetails.setCreatedDate(Calendar.getInstance());
        salesDetails.setCreatedBy(currentPrincipalName);
        salesDetails.setDeleted(false);
        salesDetailsRepository.save(salesDetails);
        return salesDetails;
    }

    @Override
    public List<FPOSalesDetailsDTO> getSalesDetails(Integer masterId) 
    {
        //return salesDetailsRepository.findByIsDeleted(false);
        
        String  sql =  	"Select m.id,s.season_id, s.season_name,cc.id as category_id, cc.category,cm.id as crop_id,cm.crop_name,m.sold_quantity sold_quantity,\r\n"
        		+ "    				m.financial_year,cvm.veriety_id, case when cast(m.veriety_ref as integer)!=0 then cvm.crop_veriety else 'Other' \r\n"
        		+ "    					end  crop_variety,cast(m.veriety_ref as integer),m.crop_ref_name,cast(m.season_ref as integer) from fpo_saleInfo m\r\n"
        		+ "    					inner join season_master s on CAST ( m.season_ref as integer)=s.season_id\r\n"
        		+ "    					inner join crop_master cm on cm.id=crop_ref_name\r\n"
        		+ "    					inner join crop_category cc on cc.id= cm.crop_cat_ref_id \r\n"
        		+ "    					left join crop_veriety_master cvm on cvm.veriety_id=cast(m.veriety_ref as integer)\r\n"
        		+ "    					where m.master_id = :masterId and m.is_deleted= false order by m.id desc" ;

		  
		  List<FPOSalesDetailsDTO> obj =  (List<FPOSalesDetailsDTO>) entityManager.createNativeQuery(sql,"FPOSalesDetailsDTO").setParameter("masterId", masterId).getResultList();
		  return obj;
    }

    @Override
    public Optional<FPOSalesDetails> getSalesDetailsById(Integer id) {
        if(!salesDetailsRepository.existsById(id)) {
            return null;
        }
        return salesDetailsRepository.findById(id);
    }

    @Override
    public FPOSalesDetails updateSalesDetails(Integer id, FPOSalesDetails salesDetails) {
        Optional<FPOSalesDetails> sd = salesDetailsRepository.findById(id);
        if(!sd.isPresent()) {
            return null;
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        salesDetails.setUpdateDate(Calendar.getInstance());
        salesDetails.setUpdatedBy(currentPrincipalName);
        salesDetails.setDeleted(false);
        salesDetails.setId(id);

        return salesDetailsRepository.save(salesDetails);
    }

    @Override
    public Boolean deleteFPOSalesDetails(Integer id) {
        if(salesDetailsRepository.findById(id) != null)
            try {
                FPOSalesDetails fpoSalesDetails = salesDetailsRepository.findById(id).get();
                fpoSalesDetails.setDeleted(true);
                fpoSalesDetails.setDeleteDate(Calendar.getInstance());
                salesDetailsRepository.save(fpoSalesDetails);
                return true;
            }catch(Exception e)
            {
                throw new NotFoundException();
            }
        else
            return false;
    }
}
