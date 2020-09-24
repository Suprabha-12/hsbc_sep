package com.EveryDay.Business;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import com.EveryDay.Data.EDData;
import com.EveryDay.Data.EDDataInterface;
import com.EveryDay.Entity.Apparel;
import com.EveryDay.utility.SortByQuantity;

public class EDBusiness implements EDBusinessInterface{
	
	private EDDataInterface ed;
	
	public EDBusiness() {
		
		ed=new EDData();
		
	}

	
//ADDING DATA INTO EACH CATEGORY
	
	@Override
	public void addApparel() throws Exception {

		BufferedReader a =new BufferedReader(new InputStreamReader(System.in));
		Apparel ea=null;
		int i=0;
        
        System.out.println("Enter item code: ");
		String itemcode=a.readLine();
		
		System.out.println("Enter item name: ");
		String itemname=a.readLine();
		
		System.out.println("Enter quantity sold: ");
		String quantity=a.readLine();
		
		System.out.println("Enter size: ");
		String size=a.readLine();
		
		System.out.println("Enter material: ");
		String material=a.readLine();
		
		ea=new Apparel();
		
		ea.setItemcode(itemcode);
		ea.setItemname(itemname);
		ea.setQuantity(quantity);
		ea.setSize(size);
		ea.setMaterial(material);
		
		i=ed.addApparelData(ea);
		
		if(i>0) {
			System.out.println("Data added");
		}
		else {
			System.out.println("Data could not be added!");
		}
		
	}

	@Override
	public void addFood() throws Exception {
		// Similar to the above method
		
	}

	@Override
	public void addElectronics() throws Exception {
		// Similar to the above method
		
	}

	

	
//RETRIEVING DATA FROM EACH CATEGORY

	@Override
	public void retApparel() throws Exception {
		
		ArrayList<Apparel> ll=null;
		
		ll=ed.retApparelData();
		
		Collections.sort(ll,new SortByQuantity());
			
		System.out.println(ll.size()+" apparel data found");
			
		for(Apparel oo:ll) {
			System.out.println("Item code is: "+oo.getItemcode());
			System.out.println("Item name is: "+oo.getItemname());
			System.out.println("Quantity is: "+oo.getQuantity());
			System.out.println("Size is: "+oo.getSize());
			System.out.println("Material is: "+oo.getMaterial());

		}		
	}

	@Override
	public void retFood() throws Exception {
		// Similar to the above method
		
	}

	@Override
	public void retElectronics() throws Exception {
		// Similar to the above method
		
	}
	
	

}
