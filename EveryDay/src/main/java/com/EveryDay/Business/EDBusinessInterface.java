package com.EveryDay.Business;

public interface EDBusinessInterface {
	
// Methods to add data into each category	
	void addApparel() throws Exception;
	void addFood() throws Exception;
	void addElectronics() throws Exception;

// Methods to retrieve data from each category	
	void retApparel() throws Exception;
	void retFood() throws Exception;
	void retElectronics() throws Exception;

}
