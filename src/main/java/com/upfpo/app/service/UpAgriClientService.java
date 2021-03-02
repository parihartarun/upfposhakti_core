package com.upfpo.app.service;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;

public interface UpAgriClientService {

    List<Object> getUpAgriByRegistrationNo(String reg_no) throws MalformedURLException, RemoteException;
}
