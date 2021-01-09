package com.upfpo.app.web_controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.upfpo.app.entity.DashBoardData;
import com.upfpo.app.service.MasterService;
import com.upfpo.app.service.MiniTransServices;


@Controller
public class UtilController {
	
	@Autowired
	private MasterService  masterServices;
	
	@Autowired
	private MiniTransServices  miniTransServices;
	
	private ModelAndView mav;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView goIndex() {
		try {
			 mav = new ModelAndView(); 
			 mav.setViewName("index.def");
			List <DashBoardData> list = masterServices.homePageData();
			mav.addObject("land",list.get(0).getLand());
			mav.addObject("farmers",list.get(0).getFarmers());
			mav.addObject("smallfarmers",list.get(0).getSmallFarmers());
			mav.addObject("marginalfarmers",list.get(0).getMarginalFarmers());
			mav.addObject("otherfarmers",list.get(0).getOtherFarmers());
		    mav.addObject("fpcs",list.get(0).getFpcs());
		    mav.addObject("fmbs",list.get(0).getFmbs());
			mav.addObject("storagecenters",list.get(0).getStoragecenters());
			mav.addObject("production_rabi",list.get(0).getProduction_rabi());
			mav.addObject("production_kharif",list.get(0).getProduction_kharif());
			mav.addObject("production_zayad",list.get(0).getProduction_zayad());
			mav.addObject("circulars",miniTransServices.getCirculars());
//			logger.info("Successfully Logged");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
		
}
}