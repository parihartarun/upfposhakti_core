package com.upfpo.app.util;

public class CropFilterItem {

	private String CropName;
	public CropFilterItem() {
		super();
	}
	public CropFilterItem(String cropName, String cropVerietyName) {
		super();
		CropName = cropName;
		CropVerietyName = cropVerietyName;
	}
	public String getCropName() {
		return CropName;
	}
	public void setCropName(String cropName) {
		CropName = cropName;
	}
	public String getCropVerietyName() {
		return CropVerietyName;
	}
	public void setCropVerietyName(String cropVerietyName) {
		CropVerietyName = cropVerietyName;
	}
	private String CropVerietyName;
	
}
