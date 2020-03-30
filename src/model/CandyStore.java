package model;

import java.util.ArrayList;

public class CandyStore {
	
	private String name;
	private String address;
	private String phone;
	
	private ArrayList<Candy> candies;
	
	public CandyStore( String name, String address, String phone ) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		candies = new ArrayList<Candy>();
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public ArrayList<Candy> getCandies() {
		return candies;
	}
	
	public void addCandy( String name, int typeOfCandy, double price, int inventoryQuantity ) {
		Candy candy = new Candy(name, typeOfCandy, price, inventoryQuantity);
		candies.add(candy);
	}
	
	public boolean removeCandy( String name ) {
		boolean removed = false;
		if( !(candies.isEmpty()) ) {
			for( int i = 0 ; i < candies.size() ; i++ ) {
				if( candies.get(i).getName().equalsIgnoreCase( name ) ) {
					candies.remove(i);
					removed = true;
				}
			}
		}
		return removed;
	}

}
