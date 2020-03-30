package ui;

import java.util.Scanner;

import model.CandyStore;

public class Main {
	
	private Scanner dataReader;
	
	private CandyStore store;
	
	public Main() {
		dataReader = new Scanner(System.in);
		init();
	}
	
	public void userMenu() {
		store.getAddress();
	}
	
	public void init() {
		boolean done = false;
		do {
			try {
				System.out.println("Type the name of the candy store.");
				String name = dataReader.nextLine();
				System.out.println("Type the address of the candy store.");
				String address = dataReader.nextLine();
				System.out.println("Type the phone of the candy store.");
				String phone = dataReader.nextLine();
				if( name.equalsIgnoreCase("") ) {
					throw new Exception();
				}else if( address.equalsIgnoreCase("") ) {
					throw new Exception();
				}else if( phone.equalsIgnoreCase("") ) {
					throw new Exception();
				}
				store = new CandyStore( name, address, phone );
				done = true;
			}catch( Exception e ) {
				System.out.println("Enter a valid option.");
			}
		}while( !done );
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.userMenu();
	}

}
