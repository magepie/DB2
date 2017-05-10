package de.dis2013.editor;

import java.util.Set;

import de.dis2013.core.ImmoService;
import de.dis2013.data.Estate;
import de.dis2013.data.House;
import de.dis2013.data.Makler;
import de.dis2013.data.Apartment;
import de.dis2013.menu.AppartmentSelectionMenu;
import de.dis2013.menu.HouseSelectionMenu;
import de.dis2013.menu.Menu;
import de.dis2013.util.FormUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Klasse für die Menüs zur Verwaltung von Immobilien
 */
public class ImmobilienEditor {

	private SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

	private Session session = sessionFactory.openSession();
	///Immobilienservice, der genutzt werden soll
	private ImmoService service;
	
	///Wird als Verwalter für die Immobilien eingetragen
	private Makler agent;
	
	public ImmobilienEditor(ImmoService service, Makler agent) {
		this.service = service;
		this.agent = agent;
	}
	
	/**
	 * Zeigt das Immobilien-Hauptmenü
	 */
	public void showImmoMenu() {
		//Menüoptionen
		final int NEW_HOUSE = 0;
		final int EDIT_HOUSE = 1;
		final int DELETE_HOUSE = 2;
		final int NEW_APPARTMENT = 3;
		final int EDIT_APPARTMENT = 4;
		final int DELETE_APPARTMENT = 5;
		final int BACK = 6;
		
		//Immobilienverwaltungsmenü
		Menu maklerMenu = new Menu("Real Estate management");
		maklerMenu.addEntry("Add a new House", NEW_HOUSE);
		maklerMenu.addEntry("Edit a House", EDIT_HOUSE);
		maklerMenu.addEntry("Delete House", DELETE_HOUSE);
		
		maklerMenu.addEntry("Add new Apartment", NEW_APPARTMENT);
		maklerMenu.addEntry("Edit Apartment", EDIT_APPARTMENT);
		maklerMenu.addEntry("Delete Apartment", DELETE_APPARTMENT);
		
		maklerMenu.addEntry("Return to Main Menu", BACK);
		
		//Verarbeite Eingabe
		while(true) {
			int response = maklerMenu.show();
			
			switch(response) {
				case NEW_HOUSE:
					newHouse();
					break;
				case EDIT_HOUSE:
					editHouse();
					break;
				case DELETE_HOUSE:
					deleteHouse();
					break;
				case NEW_APPARTMENT:
					newAppartment();
					break;
				case EDIT_APPARTMENT:
					editAppartment();
					break;
				case DELETE_APPARTMENT:
					deleteAppartment();
					break;
				case BACK:
					return;
			}
		}
	}
	
	/**
	 * Abfrage der Daten für ein neues Haus
	 */
	public void newHouse() {
		session.beginTransaction();
		Estate e= new Estate();
		House h = new House();
		
		e.setEstateaddress(FormUtil.readString("Address"));
		e.setSquare_area(FormUtil.readInt("Square area"));
		h.setFloors(FormUtil.readInt("Floors"));
		h.setPrice(FormUtil.readInt("Price"));
		h.setGarden(FormUtil.readInt("Garden"));
		e.setAgent(this.agent);

		e.setHouse(h);
		h.setEstate(e);
		session.save(e);
		session.getTransaction().commit();

		service.addHouse(h);
		service.addEstate(e);
	}
	
	/**
	 * Lässt den Benutzer ein Haus zum bearbeiten auswählen
	 * und fragt anschließend die neuen Daten ab.
	 */
	public void editHouse() {
		//Alle Häuser suchen, die vom Makler verwaltet werden
		Set<Estate> estates = service.getAllEstatesForMakler(agent);
		
		//Auswahlmenü für das zu bearbeitende Haus
		HouseSelectionMenu hsm = new HouseSelectionMenu("Liste der verwalteten Häuser", estates);
		int id = hsm.show();
		
		//Falls nicht der Eintrag "zurück" gewählt wurde, Haus bearbeiten
		if(id != HouseSelectionMenu.BACK) {
			//Gewähltes Haus laden
			House h = service.getHouseById(id);
			Estate e= service.getEstateById(id);
			
			System.out.println("House "+e.getEstateaddress()+" is currently being processed. Empty entries leave the fields unchanged.");
			
			//Neue Daten abfragen
			String newOrt = FormUtil.readString("Address ("+e.getEstateaddress()+")");
			int newFlaeche = FormUtil.readInt("Square Area ("+e.getSquare_area()+")");
			int newStockwerke = FormUtil.readInt("Floors ("+h.getFloors()+")");
			int newKaufpreis = FormUtil.readInt("Price ("+h.getPrice()+")");
			int newGarten = FormUtil.readInt("Garden ("+h.getGarden()+")");
			
			//Neue Daten setzen
			if(!newOrt.equals(""))
				e.setEstateaddress(newOrt);
			
			if(newFlaeche != 0)
				e.setSquare_area(newFlaeche);
			
			if(newStockwerke != 0)
				h.setFloors(newStockwerke);
			
			if(newKaufpreis != 0)
				h.setPrice(newKaufpreis);
			if(newGarten!=0)
				h.setGarden(newGarten);
		}
	}
	
	/**
	 * Zeigt die Liste von verwalteten Häusern und löscht das
	 * entsprechende Haus nach Auswahl
	 */
	public void deleteHouse() {
		//Alle Häuser suchen, die vom Makler verwaltet werden
		Set<Estate> estates = service.getAllEstatesForMakler(agent);
		
		//Auswahlmenü für das zu bearbeitende Haus
		HouseSelectionMenu hsm = new HouseSelectionMenu("List of managed houses", estates);
		int id = hsm.show();
		
		//Falls nicht der Eintrag "zurück" gewählt wurde, Haus löschen
		if(id != HouseSelectionMenu.BACK) {
			House h = service.getHouseById(id);
			Estate e = service.getEstateById(id);
			service.deleteHouse(h);
			service.deleteEstate(e);
		}
	}
	
	/**
	 * Abfrage der Daten für eine neue Wohnung
	 */
	public void newAppartment() {
		session.beginTransaction();
		Estate e= new Estate();
		Apartment w = new Apartment();
		
		e.setEstateaddress(FormUtil.readString("Address"));
		e.setSquare_area(FormUtil.readInt("Square Area"));
		w.setFloor(FormUtil.readInt("Floors"));
		w.setRent(FormUtil.readInt("Rent Price"));
		w.setKitchen(FormUtil.readInt("Kitchen"));
		w.setBalcony(FormUtil.readInt("Balcony"));
		e.setAgent(this.agent);

		service.addApartment(w);
		service.addEstate(e);

		e.setApartment(w);
		w.setEstate(e);
		session.save(e);
		session.getTransaction().commit();


	}
	
	/**
	 * Lässt den Benutzer eine Wohnung zum bearbeiten auswählen
	 * und fragt anschließend die neuen Daten ab.
	 */
	public void editAppartment() {
		session.beginTransaction();

		//Alle Wohnungen suchen, die vom Makler verwaltet werden
		Set<Estate> estates = service.getAllEstatesForMakler(agent);

		//Auswahlmenü für die zu bearbeitende Wohnung
		AppartmentSelectionMenu asm = new AppartmentSelectionMenu("List of managed Apartments", estates);
		int id = asm.show();
		
		//Falls nicht der Eintrag "zurück" gewählt wurde, Wohnung bearbeiten
		if(id != AppartmentSelectionMenu.BACK) {
			//Wohnung laden
			Apartment w = service.getApartmentById(id);
			Estate e= service.getEstateById(id);
			
			System.out.println("Apartment "+e.getEstateaddress()+" is currently being processed. Empty entries can leave fields unchanged.");
			
			//Neue Daten abfragen
			String newOrt = FormUtil.readString("Address ("+e.getEstateaddress()+")");
			int newFlaeche = FormUtil.readInt("Square Area ("+e.getSquare_area()+")");
			int newStockwerk = FormUtil.readInt("Floor ("+w.getFloor()+")");
			int newMietpreis = FormUtil.readInt("Rent Price ("+w.getRent()+")");
			int newEbk = FormUtil.readInt("Kitchen ("+w.getKitchen() +")");
			int newBalkon = FormUtil.readInt("Balcony ("+w.getBalcony() +")");
			
			//Neue Daten setzen
			if(!newOrt.equals(""))
				e.setEstateaddress(newOrt);

			if(newFlaeche != 0)
				e.setSquare_area(newFlaeche);
			
			if(newStockwerk != 0)
				w.setFloor(newStockwerk);
			
			if(newMietpreis != 0)
				w.setRent(newMietpreis);
			if(newEbk != 0)
				w.setKitchen(newEbk);
			if(newBalkon != 0)
				w.setBalcony(newBalkon);
		}
	}
	
	/**
	 * Zeigt die Liste von verwalteten Wohnungen und löscht die
	 * entsprechende Wohnung nach Auswahl
	 */
	public void deleteAppartment() {
		//Alle Wohnungen suchen, die vom Makler verwaltet werden
		Set<Estate> estates = service.getAllEstatesForMakler(agent);
		
		//Auswahlmenü für die zu bearbeitende Wohnung
		AppartmentSelectionMenu asm = new AppartmentSelectionMenu("List of managed apartments", estates);
		int id = asm.show();
		
		//Falls nicht der Eintrag "zurück" gewählt wurde, Wohnung löschen
		if(id != HouseSelectionMenu.BACK) {
			Apartment w = service.getApartmentById(id);
			Estate e = service.getEstateById(id);

			service.deleteApartment(w);
			service.deleteEstate(e);
		}
	}
}
