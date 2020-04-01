package model;

public abstract class Person {
	
	private String name;
	private String lastName;
	private int age;
	private String id;
	private String document;
	
	public Person( String name, String lastName, int age, String id, String document ) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.id = id;
		this.document = document;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getId() {
		return id;
	}

	public String getDocument() {
		return document;
	}
	
	

}
