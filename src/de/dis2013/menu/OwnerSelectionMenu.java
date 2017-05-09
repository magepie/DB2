package de.dis2013.menu;

import java.util.Iterator;
import java.util.Set;

import de.dis2013.data.Owner;

/**
 * Ein kleines Menü, dass alle Personen aus einem Set zur Auswahl anzeigt
 */
public class OwnerSelectionMenu extends Menu {
	public static final int BACK = -1;
	
	public OwnerSelectionMenu(String title, Set<Owner> owners) {
		super(title);
		
		Iterator<Owner> it = owners.iterator();
		while(it.hasNext()) {
			Owner p = it.next();
			addEntry(p.getOwnername()+" "+p.getOwnersurname(), p.getOwnerid());
		}
		addEntry("Back", BACK);
	}
}
