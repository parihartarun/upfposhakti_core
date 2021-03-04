package com.upfpo.app.service;

import com.upfpo.app.dto.UpAgriAreaDTO;
import com.upfpo.app.dto.UpAgriFarmerDetailDTO;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;

public interface UpAgriClientService {

    UpAgriFarmerDetailDTO getUpAgriByRegistrationNo(String reg_no) throws MalformedURLException, RemoteException;

    UpAgriAreaDTO getUpAgriAreaByRegistrationNo(String reg_no) throws MalformedURLException, RemoteException;
}
