package model;

import java.util.Comparator;

public class ComparatorOfCandies implements Comparator<Candy>{

	@Override
	public int compare(Candy c1, Candy c2) {
		int comparison = 0;
		if( c1.getName().compareToIgnoreCase(c2.getName()) > 0 ) {
			comparison = 1;
		}else if( c1.getName().compareToIgnoreCase(c2.getName()) < 0 ) {
			comparison = -1;
		}else {
			comparison = (int)(c1.getPrice() - c2.getPrice());
		}
		return comparison;
	}

}
