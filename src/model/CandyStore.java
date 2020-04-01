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
	
	public User searchUser( String name ) {
		User user = null;
		if( root.getName().equalsIgnoreCase(name) ) {
			user = root;
		}else if( root.getName().compareToIgnoreCase(name) < 0 ) {
			if( root.getLeftSon() != null ) {
				if( root.getLeftSon().getName().equalsIgnoreCase(name) ) {
					user = root.getLeftSon();
				}else {
					user = searchUser(root.getLeftSon(), name);
				}
			}
		}else {
			if( root.getRightSon() != null ) {
				if( root.getRightSon().getName().equalsIgnoreCase(name) ) {
					user = root.getRightSon();
				}else {
					user = searchUser(root.getRightSon(), name);
				}
			}
		}
		return user;
	}
	
	private User searchUser( User current, String name ) {
		User user = null;
		if( current.getName().equalsIgnoreCase(name) ) {
			user = current;
		}else if( current.getName().compareToIgnoreCase(name) < 0 ) {
			if( current.getLeftSon() != null ) {
				if( current.getLeftSon().getName().equalsIgnoreCase(name) ) {
					user = current.getLeftSon();
				}else {
					user = searchUser(current.getLeftSon(), name);
				}
			}
		}else {
			if( current.getRightSon() != null ) {
				if( current.getRightSon().getName().equalsIgnoreCase(name) ) {
					user = current.getLeftSon();
				}else {
					user = searchUser(current.getRightSon(), name);
				}
			}
		}
		return user;
	}
	
	public User searchMinimum() {
		User user = null;
		if( root.getLeftSon() == null ) {
			user = root;
		}else {
			user = searchMinimum(root.getLeftSon());
		}
		return user;
	}
	
	private User searchMinimum( User user ) {
		User user1 = null;
		if( user.getLeftSon() == null ) {
			user1 = user;
		}else {
			user1 = searchMinimum(user.getLeftSon());
		}
		return user1;
	}
	
	public User searchMaximum() {
		User user = null;
		if( root.getRightSon() == null ) {
			user = root;
		}else {
			user = searchMaximum(root.getRightSon());
		}
		return user;
	}
	
	private User searchMaximum( User aUser ) {
		User user = null;
		if( aUser.getRightSon() == null ) {
			user = aUser;
		}else {
			user = searchMaximum(aUser.getRightSon());
		}
		return user;
	}

}
