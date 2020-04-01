package model;

import java.util.ArrayList;

public class CandyStore {
	
	private String name;
	private String address;
	private String phone;
	
	private ArrayList<Candy> candies;
	
	private User root;
	
	public CandyStore( String name, String address, String phone ) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		candies = new ArrayList<Candy>();
		root = null;
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
	
	public Person getRoot() {
		return root;
	}

	public void setRoot(User root) {
		this.root = root;
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
	
	public Candy classicSearchCandy( String nombre ) {
		Candy searched = null;
		if( !(candies.isEmpty()) ) {
			for( int i = 0 ; i < candies.size() ; i++ ) {
				if( candies.get(i).getName().equalsIgnoreCase(nombre) ) {
					searched = candies.get(i);
				}
			}
		}
		return searched;
	}
	
	public double calculateSales() {
		double total = 0;
		if( !(candies.isEmpty()) ) {
			for( int i = 0 ; i < candies.size() ; i++ ) {
				total += ( candies.get(i).getInventoryQuantity() * candies.get(i).getPrice() );
			}
		}
		return total;
	}
	
	public void addUser(String name, String lastName, int age, String id, String document) {
		User newUser = new User(name, lastName, age, id, document);
		if( root == null ) {
			root = newUser;
		}else if( root.getAge() < newUser.getAge() ) {
			if( root.getLeftSon() == null ) {
				root.setLeftSon(newUser);
				newUser.setFather(root);
			}else {
				addUser(root.getLeftSon(), newUser);
			}
		}else {
			if( root.getRightSon() == null ) {
				root.setRightSon(newUser);
				newUser.setFather(root);
			}else {
				addUser(root.getRightSon(), newUser);
			}
		}
	}
	
	private void addUser( User current, User newUser ) {
		if( current.getAge() < newUser.getAge() ) {
			if( current.getLeftSon() == null ) {
				current.setLeftSon(newUser);
				newUser.setFather(current);
			}else {
				addUser(current.getLeftSon(), newUser);
			}
		}else {
			if( current.getRightSon() == null ) {
				current.setRightSon(newUser);
				newUser.setFather(current);
			}else {
				addUser(current.getRightSon(), newUser);
			}
		}
	}

}
