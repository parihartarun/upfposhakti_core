package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.entity.InputSupplierMaster;

public interface InputSupplierService 
{
	public InputSupplierMaster updateInputSupplier(InputSupplierMaster chcFmbMaster,int inputSupplierId);
	public List<InputSupplierMaster> getInputSupplierDetails();
	public void deleteInputSupplier(int inputSupplierId);
}
