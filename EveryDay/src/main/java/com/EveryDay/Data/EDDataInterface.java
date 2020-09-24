package com.EveryDay.Data;

import java.util.ArrayList;

import com.EveryDay.Entity.Apparel;
import com.EveryDay.Entity.Electronics;
import com.EveryDay.Entity.FoodItems;

public interface EDDataInterface {
	
	int addApparelData(Apparel ea) throws Exception;
	int addFoodData(FoodItems ef) throws Exception;
	int addElectronicsData(Electronics ee) throws Exception;
	
	ArrayList<Apparel> retApparelData() throws Exception;
	ArrayList<FoodItems> retFoodData() throws Exception;
	ArrayList<Electronics> retElectronicsData() throws Exception;

}
