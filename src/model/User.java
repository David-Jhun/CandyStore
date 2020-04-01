package model;

public class User extends Person{
	
	private boolean joined;
	
	private User father;
	private User leftSon;
	private User rightSon;

	public User(String name, String lastName, int age, String id, String document) {
		super(name, lastName, age, id, document);
		joined = false;
		father = null;
		leftSon = null;
		rightSon = null;
	}
	
	public boolean isJoined() {
		return joined;
	}

	public User getFather() {
		return father;
	}

	public User getLeftSon() {
		return leftSon;
	}

	public User getRightSon() {
		return rightSon;
	}

	public void setFather(User father) {
		this.father = father;
	}

	public void setLeftSon(User leftSon) {
		this.leftSon = leftSon;
	}

	public void setRightSon(User rightSon) {
		this.rightSon = rightSon;
	}

}
