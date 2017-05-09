package de.dis2013.editor;

import java.util.Iterator;
import java.util.Set;

import de.dis2013.core.ImmoService;
import de.dis2013.data.*;
import de.dis2013.menu.AppartmentSelectionMenu;
import de.dis2013.menu.HouseSelectionMenu;
import de.dis2013.menu.Menu;
import de.dis2013.menu.PersonSelectionMenu;
import de.dis2013.util.FormUtil;

/**
 * Klasse für die Menüs zur Verwaltung von Verträgen
 */
public class ContractEditor {
	///Immobilien-Service, der genutzt werden soll
	private ImmoService service;
	
	///Makler, zu dessen Immobilien Verträge geschlossen werden dürfen
	private Makler makler;
	
	public ContractEditor(ImmoService service, Makler makler) {
		this.service = service;
		this.makler = makler;
	}
	
	/**
	 * Contract menu
	 */
	public void showContractMenu() {
		//Menüoptionen
		final int NEW_TENANCY_CONTRACT = 0;
		final int NEW_PURCHASE_CONTRACT = 1;
		final int SHOW_CONTRACTS = 2;
		final int BACK = 3;
		
		//Vertragsverwaltung
		Menu maklerMenu = new Menu("Contract Management");
		maklerMenu.addEntry("New Rent Contract", NEW_TENANCY_CONTRACT);
		maklerMenu.addEntry("New Sale Contract", NEW_PURCHASE_CONTRACT);
		maklerMenu.addEntry("Display Contracts", SHOW_CONTRACTS);
		
		maklerMenu.addEntry("Return to main menu", BACK);
		
		//Verarbeite Eingabe
		while(true) {
			int response = maklerMenu.show();
			
			switch(response) {
				case NEW_TENANCY_CONTRACT:
					newMietvertrag();
					break;
				case NEW_PURCHASE_CONTRACT:
					newKaufvertrag();
					break;
				case SHOW_CONTRACTS:
					displayContracts();
					break;
				case BACK:
					return;
			}
		}
	}
	
	public void displayContracts() {
		//Mietverträge anzeigen
		System.out.println("Rent Contracts\n-----------------");
		Set<TenancyContract> mvs = service.getAllTenancyContractsForMakler(makler);
		Iterator<TenancyContract> itmv = mvs.iterator();
		while(itmv.hasNext()) {
			TenancyContract mv = itmv.next();
			System.out.println("Tenancy Contract "+mv.getContractid()+"\n"+
							"\tSigned on"+mv.getContractdate())+" in "+mv.getSettelmentplace()+"\n"+
							"\tOwner:        "+mv.getOwner().getOwnername()+" "+mv.getOwner().getOwnersurname()+"\n"+
							"\tApartment:       "+mv.getApartment().getEstateaddress()+"\n"+
							"\tContract Start Date:    "+mv.getStartDate()+", Duration: "+mv.getDuration()+" Months\n"+
							"\tMietpreis:     "+mv.getApartment().getRent()+" Euro, Extra costs: "+mv.getExtracharges()+," Euro\n");
		}
		
		System.out.println("");
		
		//Kaufverträge anzeigen
		System.out.println("Kaufverträge\n-----------------");
		Set<PurchaseContract> kvs = service.getAllKaufvertraegeForMakler(makler);
		Iterator<PurchaseContract> itkv = kvs.iterator();
		while(itkv.hasNext()) {
			PurchaseContract kv = itkv.next();
			System.out.println("Purchanse Contract "+kv.getContractid()+"\n"+
							"\tSigned on "+kv.getContractdate())+" in "+kv.getSettelmentplace()+"\n"+
							"\tOnwer:        "+kv.getOwner().getOwnername()+" "+kv.getOwner().getOwnersurname()+"\n"+
							"\tHouse Address:          "+kv.getHouse().getEstateaddress()+"\n"+
							"\tPrice:     "+kv.getHouse().getPrice()+" Euro\n"+
							"\tRate Installments:         "+kv.getNumberofinstallments()+", Interest rate: "+kv.getInterestrate()+,"\n");
		}
	}
	
	
	/**
	 * Menü zum anlegen eines neuen Mietvertrags
	 */
	public void newMietvertrag() {
		//Alle Wohnungen des Maklers finden
		Set<Apartment> apartments = service.getAllApartmentForMakler(makler);
		
		//Auswahlmenü für die Wohnungen 
		AppartmentSelectionMenu asm = new AppartmentSelectionMenu("Choose apartment for Contract" apartments);
		int wid = asm.show();
		
		//Falls kein Abbruch: Auswahl der Person
		if(wid != AppartmentSelectionMenu.BACK) {
			//Alle Personen laden
			Set<Owner> owners = service.getAllOwners();
			
			//Menü zur Auswahl der Person
			PersonSelectionMenu psm = new PersonSelectionMenu("Select an owner" owners);
			int pid = psm.show();
			
			//Falls kein Abbruch: Vertragsdaten abfragen und Vertrag anlegen
			if(pid != PersonSelectionMenu.BACK) {
				TenancyContract m = new TenancyContract();
		
				m.setApartment(service.getApartmentById(wid));
				m.setOwner(service.getOwnerById(pid));
				m.setContractid(FormUtil.readInt("Contract ID"));
				m.setContractdate(FormUtil.readString("Date"));
				m.setSettelmentplace(FormUtil.readString("Settlement Place"));
				m.setStartDate(FormUtil.readString("Start Date"));
				m.setDuration(FormUtil.readInt("Duration in Months"));
				m.setExtracharges(FormUtil.readInt("Extra costs"));
				
				service.addTenancyContract(m);
				
				System.out.println("Tenancy contract with ID "+m.getId()+" has been created.");
			}
		}
	}
	
	/**
	 * Menü zum anlegen eines neuen Kaufvertrags
	 */
	public void newKaufvertrag() {
		//Alle Häuser des Maklers finden
		Set<House> houses = service.getAllHaeuserForMakler(makler);
		
		//Auswahlmenü für das House
		HouseSelectionMenu asm = new HouseSelectionMenu("Select House for Contract", houses);
		int hid = asm.show();
		
		//Falls kein Abbruch: Auswahl der Person
		if(hid != AppartmentSelectionMenu.BACK) {
			//Alle Personen laden
			Set<Owner> owners = service.getAllOwners();
			
			//Menü zur Auswahl der Person
			PersonSelectionMenu psm = new PersonSelectionMenu("Select an Owner for Contract", owners);
			int pid = psm.show();
			
			//Falls kein Abbruch: Vertragsdaten abfragen und Vertrag anlegen
			if(pid != PersonSelectionMenu.BACK) {
				PurchaseContract k = new PurchaseContract();
		
				k.setHouse(service.getHouseById(hid));
				k.setOwner(service.getOwnerById(pid));
				k.setContractid(FormUtil.readInt("Contract ID"));
				k.setContractdate(FormUtil.readString("Date"));
				k.setSettelmentplace(FormUtil.readString("Settlement Place"));
				k.setNumberofinstallments(FormUtil.readInt("Number of Installments"));
				k.setInterestrate(FormUtil.readInt("Interest Rate"));
				
				service.addPurchaseContract(k);
				
				System.out.println("Purchase contract with ID "+k.getId()+" has been created.");
			}
		}
	}
}
