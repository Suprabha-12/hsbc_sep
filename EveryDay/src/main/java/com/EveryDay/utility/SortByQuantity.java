package com.EveryDay.utility;

import java.util.Comparator;

import com.EveryDay.Entity.CommonEntities;

public class SortByQuantity implements Comparator<CommonEntities>{
	
	@Override
	public int compare(CommonEntities f1, CommonEntities f2) {
		
		return f1.getQuantity().compareTo(f2.getQuantity());
	}


}
