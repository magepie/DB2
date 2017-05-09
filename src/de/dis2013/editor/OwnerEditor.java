package de.dis2013.editor;

import de.dis2013.core.ImmoService;
import de.dis2013.data.Owner;
import de.dis2013.menu.Menu;
import de.dis2013.menu.OwnerSelectionMenu;
import de.dis2013.util.FormUtil;

/**
 * Klasse für die Menüs zur Verwaltung von Personen
 */
public class OwnerEditor {
	///Immobilienservice, der genutzt werden soll
	private ImmoService service;
	
	public OwnerEditor(ImmoService service) {
		this.service = service;
	}
	
	/**
	 * Zeigt die Personenverwaltung
	 */
	public void showPersonMenu() {
		//Menüoptionen
		final int NEW_PERSON = 0;
		final int EDIT_PERSON = 1;
		final int DELETE_PERSON = 2;
		final int BACK = 3;
		
		//Personenverwaltungsmenü
		Menu maklerMenu = new Menu("Owner Management");
		maklerMenu.addEntry("Add Owner", NEW_PERSON);
		maklerMenu.addEntry("Edit Owner", EDIT_PERSON);
		maklerMenu.addEntry("Delete Owner", DELETE_PERSON);
		maklerMenu.addEntry("Return to Main Menu", BACK);
		
		//Verarbeite Eingabe
		while(true) {
			int response = maklerMenu.show();
			
			switch(response) {
				case NEW_PERSON:
					newPerson();
					break;
				case EDIT_PERSON:
					editPerson();
					break;
				case DELETE_PERSON:
					deletePerson();
					break;
				case BACK:
					return;
			}
		}
	}
	
	/**
	 * Legt eine neue Person an, nachdem der Benutzer
	 * die entprechenden Daten eingegeben hat.
	 */
	public void newPerson() {
		Owner p = new Owner();
		
		p.setOwnername(FormUtil.readString("Name"));
		p.setOwnersurname(FormUtil.readString("Last name"));
		p.setAddress(FormUtil.readString("Address"));
		service.addOwner(p);
		
		System.out.println("Owner with ID "+p.getOwnerid()+" has been created.");
	}
	
	/**
	 * Editiert eine Person, nachdem der Benutzer sie ausgewählt hat
	 */
	public void editPerson() {
		//Personenauswahlmenü
		Menu personSelectionMenu = new OwnerSelectionMenu("Person bearbeiten", service.getAllOwners());
		int id = personSelectionMenu.show();
		
		//Person barbeiten?
		if(id != OwnerSelectionMenu.BACK) {
			//Person laden
			Owner p = service.getOwnerById(id);
			System.out.println("Owner "+p.getOwnername()+" "+p.getOwnersurname()+" is being processed. Empty entries can leave unchanged fields.");
			
			//Neue Daten einlesen
			String newVorname = FormUtil.readString("Name ("+p.getOwnername()+")");
			String newNachname = FormUtil.readString("Last Name ("+p.getOwnersurname()+")");
			String newAddress = FormUtil.readString("Address ("+p.getAddress()+")");
			
			//Neue Daten setzen
			if(!newVorname.equals(""))
				p.setOwnername(newVorname);
			if(!newNachname.equals(""))
				p.setOwnersurname(newNachname);
			if(!newAddress.equals(""))
				p.setAddress(newAddress);
		}
	}
	
	/**
	 * Löscht eine Person, nachdem der Benutzer
	 * die entprechende ID eingegeben hat.
	 */
	public void deletePerson() {
		//Auswahl der Person
		Menu personSelectionMenu = new OwnerSelectionMenu("Person bearbeiten", service.getAllOwners());
		int id = personSelectionMenu.show();
		
		//Löschen, falls nicht "zurück" gewählt wurde
		if(id != OwnerSelectionMenu.BACK) {
			Owner p = service.getOwnerById(id);
			service.deleteOwner(p);
		}
	}
}
