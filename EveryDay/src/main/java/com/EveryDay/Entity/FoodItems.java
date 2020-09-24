package com.EveryDay.Entity;

public class FoodItems extends CommonEntities{
	
	private String veg;
	
//GETTERS AND SETTERS FOR THE VARIABLES
	
	public String getVeg() {
		return veg;
	}
	public void setVeg(String veg) {
		this.veg = veg;
	}
	
	
//HASH CODE AND EQUALS FOR THE VARIABLES

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((veg == null) ? 0 : veg.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoodItems other = (FoodItems) obj;
		if (veg == null) {
			if (other.veg != null)
				return false;
		} else if (!veg.equals(other.veg))
			return false;
		return true;
	}
	
	

}
