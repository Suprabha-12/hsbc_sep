package com.EveryDay.Entity;

public class Electronics extends CommonEntities{
	
	private String warranty;
	
	
//GETTERS AND SETTERS FOR THE VARIABLES

	public String getWarranty() {
		return warranty;
	}
	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}
	
	
//HASH CODE AND EQUALS FOR THE VARIABLES

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((warranty == null) ? 0 : warranty.hashCode());
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
		Electronics other = (Electronics) obj;
		if (warranty == null) {
			if (other.warranty != null)
				return false;
		} else if (!warranty.equals(other.warranty))
			return false;
		return true;
	}
	

}
