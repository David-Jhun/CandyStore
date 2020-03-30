package model;

public class Candy {
	
	private String name;
	private int typeOfCandy;
	private double price;
	private int inventoryQuantity;
	
	public Candy( String name, int typeOfCandy, double price, int inventoryQuantity ) {
		this.name = name;
		this.typeOfCandy = typeOfCandy;
		this.price = price;
		this.inventoryQuantity = inventoryQuantity;
	}

	public String getName() {
		return name;
	}

	public int getTypeOfCandy() {
		return typeOfCandy;
	}

	public double getPrice() {
		return price;
	}

	public int getInventoryQuantity() {
		return inventoryQuantity;
	}
	
}
