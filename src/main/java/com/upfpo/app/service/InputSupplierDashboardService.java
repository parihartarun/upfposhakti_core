<<<<<<< HEAD
package com.upfpo.app.service;

import com.upfpo.app.dto.*;

import java.util.List;

public interface InputSupplierDashboardService {

    InputSupplierDTO getInputSupplierDetails(Integer masterId);

    List<InputSupplierFertilizerDTO> getAllInputSupplierFertilizer(Integer masterId);

    List<InputSupplierSeedDTO> getAllInputSupplierSeed(Integer masterId);

    List<InputSupplierMachineryDTO> getAllInputSupplierMachinery(Integer masterId);

    List<InputSupplierInsecticideDTO> getAllInputSupplierInsecticide(Integer masterId);
}
||||||| b0b2f1b
=======
package com.upfpo.app.service;

import com.upfpo.app.dto.InputSupplierDashboardBarchartDTO;

public interface InputSupplierDashboardService 
{
	public InputSupplierDashboardBarchartDTO getBarchartData(Integer masterId);
}
>>>>>>> 74f544792d1dde9ee9520a480e56fe5018bd012d
