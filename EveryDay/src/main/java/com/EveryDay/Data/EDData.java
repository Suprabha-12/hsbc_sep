package com.EveryDay.Data;

import java.util.ArrayList;

import com.EveryDay.Entity.Apparel;
import com.EveryDay.Entity.Electronics;
import com.EveryDay.Entity.FoodItems;

public class EDData implements EDDataInterface{
	
	
//FOR DATA ADDITION
	
	@Override
	public int addApparelData(Apparel ea) throws Exception {
		
		ArrayList<Apparel> ll = new ArrayList<Apparel>();
		int i = 0;
	
		if (ll.add(ea))
		{
			i = 1;
		}

		return i;
	}

	@Override
	public int addFoodData(FoodItems ef) throws Exception {
		// Similar to the above method
		return 0;
	}

	@Override
	public int addElectronicsData(Electronics ee) throws Exception {
		// Similar to the above method
		return 0;
	}



	
//FOR DATA RETRIEVAL

	@Override
	public ArrayList<Apparel> retApparelData() throws Exception {
		
		ArrayList<Apparel> ll = new ArrayList<Apparel>();

		return ll;
	}

	@Override
	public ArrayList<FoodItems> retFoodData() throws Exception {
		// Similar to the above method
		return null;
	}

	@Override
	public ArrayList<Electronics> retElectronicsData() throws Exception {
		// Similar to the above method
		return null;
	}

}
