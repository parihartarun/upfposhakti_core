package com.upfpo.app.upagri;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import com.upfpo.app.dto.UpAgriDataDto;

public interface UpAgriService {

	//UpAgriDataDto getUpAgriData(String _anydist, String _blck, String _vill);

	public UpAgriDataDto upagri(String reg_no) throws MalformedURLException, RemoteException;

	public String upagri_area(String reg_no) throws MalformedURLException, RemoteException;
	
}
