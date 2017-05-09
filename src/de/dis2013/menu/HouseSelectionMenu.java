package de.dis2013.menu;

import java.util.Iterator;
import java.util.Set;

import de.dis2013.data.House;

/**
 * Ein kleines Menü, dass alle Häuser aus einem Set zur Auswahl anzeigt
 */
public class HouseSelectionMenu extends Menu {
	public static final int BACK = -1;
	
	public HouseSelectionMenu(String title, Set<House> houses) {
		super(title);
		
		Iterator<House> it = houses.iterator();
		while(it.hasNext()) {
			House h = it.next();
			addEntry(h.getEstateaddress(), h.getEstateid());
		}
		addEntry("Back", BACK);
	}
}
