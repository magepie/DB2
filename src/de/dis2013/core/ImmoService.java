package de.dis2013.core;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import de.dis2013.data.House;
import de.dis2013.data.Estate;
import de.dis2013.data.PurchaseContract;
import de.dis2013.data.Makler;
import de.dis2013.data.TenancyContract;
import de.dis2013.data.Owner;
import de.dis2013.data.Apartment;

/**
 * Klasse zur Verwaltung aller Datenbank-Entitäten.
 * 
 * TODO: Aktuell werden alle Daten im Speicher gehalten. Ziel der Übung
 * ist es, schrittweise die Datenverwaltung in die Datenbank auszulagern.
 * Wenn die Arbeit erledigt ist, werden alle Sets dieser Klasse überflüssig.
 */
public class ImmoService {
	//Datensätze im Speicher
	private Set<Makler> makler = new HashSet<>();
	private Set<Owner> owners = new HashSet<>();
	private Set<House> houses = new HashSet<>();
	private Set<Apartment> apartments = new HashSet<>();
	private Set<TenancyContract> tenancyContracts = new HashSet<>();
	private Set<PurchaseContract> purchaseContracts = new HashSet<>();


	//Hibernate Session
	private SessionFactory sessionFactory;
	
	public ImmoService() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	/**
	 * Finde einen Makler mit gegebener Id
	 * @param id Die ID des Maklers
	 * @return Makler mit der ID oder null
	 */
	public Makler getMaklerById(int id) {
		Iterator<Makler> it = makler.iterator();
		
		while(it.hasNext()) {
			Makler m = it.next();
			
			if(m.getId() == id)
				return m;
		}
		
		return null;
	}
	
	/**
	 * Finde einen Makler mit gegebenem Login
	 * @param login Der Login des Maklers
	 * @return Makler mit der ID oder null
	 */
	public Makler getMaklerByLogin(String login) {
		Iterator<Makler> it = makler.iterator();
		
		while(it.hasNext()) {
			Makler m = it.next();
			
			if(m.getLogin().equals(login))
				return m;
		}
		
		return null;
	}
	
	/**
	 * Gibt alle Makler zurück
	 */
	public Set<Makler> getAllMakler() {
		return makler;
	}
	
	/**
	 * Finde eine Person mit gegebener Id
	 * @param id Die ID der Person
	 * @return Person mit der ID oder null
	 */
	public Owner getOwnerById(int id) {
		Iterator<Owner> it = owners.iterator();
		
		while(it.hasNext()) {
			Owner p = it.next();
			
			if(p.getOwnerid() == id)
				return p;
		}
		
		return null;
	}
	
	/**
	 * Fügt einen Makler hinzu
	 * @param m Der Makler
	 */
	public void addMakler(Makler m) {
		makler.add(m);
	}
	
	/**
	 * Löscht einen Makler
	 * @param m Der Makler
	 */
	public void deleteMakler(Makler m) {
		makler.remove(m);
	}
	
	/**
	 * Fügt eine Person hinzu
	 * @param p Die Person
	 */
	public void addOwner(Owner p) {
		owners.add(p);
	}
	
	/**
	 * Gibt alle Personen zurück
	 */
	public Set<Owner> getAllOwners() {
		return owners;
	}
	
	/**
	 * Löscht eine Person
	 * @param p Die Person
	 */
	public void deleteOwner(Owner p) {
		owners.remove(p);
	}
	
	/**
	 * Fügt ein Haus hinzu
	 * @param h Das Haus
	 */
	public void addHouse(House h) {
		houses.add(h);
	}
	
	/**
	 * Gibt alle Häuser eines Maklers zurück
	 * @param m Der Makler
	 * @return Alle Häuser, die vom Makler verwaltet werden
	 */
	public Set<House> getAllHaeuserForMakler(Makler m) {
		Set<House> ret = new HashSet<>();
		Iterator<House> it = houses.iterator();
		
		while(it.hasNext()) {
			House h = it.next();
			
			if(h.getAgent().equals(m))
				ret.add(h);
		}
		
		return ret;
	}
	
	/**
	 * Findet ein Haus mit gegebener ID
	 * @param m Der Makler
	 * @return Das Haus oder null, falls nicht gefunden
	 */
	public House getHouseById(int id) {
		Iterator<House> it = houses.iterator();
		
		while(it.hasNext()) {
			House h = it.next();
			
			if(h.getEstateid() == id)
				return h;
		}
		
		return null;
	}
	
	/**
	 * Löscht ein Haus
	 * @param p Das Haus
	 */
	public void deleteHouse(House h) {
		houses.remove(h);
	}
	
	/**
	 * Fügt eine Wohnung hinzu
	 * @param w die Wohnung
	 */
	public void addApartment(Apartment w) {
		apartments.add(w);
	}
	
	/**
	 * Gibt alle Wohnungen eines Maklers zurück
	 * @param m Der Makler
	 * @return Alle Wohnungen, die vom Makler verwaltet werden
	 */
	public Set<Apartment> getAllApartmentForMakler(Makler m) {
		Set<Apartment> ret = new HashSet<Apartment>();
		Iterator<Apartment> it = apartments.iterator();
		
		while(it.hasNext()) {
			Apartment w = it.next();
			
			if(w.getAgent().equals(m))
				ret.add(w);
		}
		
		return ret;
	}
	
	/**
	 * Findet eine Wohnung mit gegebener ID
	 * @param id Die ID
	 * @return Die Wohnung oder null, falls nicht gefunden
	 */
	public Apartment getApartmentById(int id) {
		Iterator<Apartment> it = apartments.iterator();
		
		while(it.hasNext()) {
			Apartment w = it.next();
			
			if(w.getEstateid() == id)
				return w;
		}
		
		return null;
	}
	
	/**
	 * Löscht eine Wohnung
	 * @param p Die Wohnung
	 */
	public void deleteApartment(Apartment w) {
		apartments.remove(w);
	}
	
	
	/**
	 * Fügt einen Mietvertrag hinzu
	 * @param w Der Mietvertrag
	 */
	public void addTenancyContract(TenancyContract m) {
		tenancyContracts.add(m);
	}
	
	/**
	 * Fügt einen Kaufvertrag hinzu
	 * @param w Der Kaufvertrag
	 */
	public void addPurchaseContract(PurchaseContract k) {
		purchaseContracts.add(k);
	}
	
	/**
	 * Gibt alle Mietverträge zu Wohnungen eines Maklers zurück
	 * @param m Der Makler
	 * @return Alle Mietverträge, die zu Wohnungen gehören, die vom Makler verwaltet werden
	 */
	public Set<TenancyContract> getAllTenancyContractsForMakler(Makler m) {
		Set<TenancyContract> ret = new HashSet<TenancyContract>();
		Iterator<TenancyContract> it = tenancyContracts.iterator();
		
		while(it.hasNext()) {
			TenancyContract v = it.next();
			
			if(v.getAgent().equals(m))
				ret.add(v);
		}
		
		return ret;
	}
	
	/**
	 * Gibt alle Kaufverträge zu Wohnungen eines Maklers zurück
	 * @param m Der Makler
	 * @return Alle Kaufverträge, die zu Häusern gehören, die vom Makler verwaltet werden
	 */
	public Set<PurchaseContract> getAllKaufvertraegeForMakler(Makler m) {
		Set<PurchaseContract> ret = new HashSet<PurchaseContract>();
		Iterator<PurchaseContract> it = purchaseContracts.iterator();
		
		while(it.hasNext()) {
			PurchaseContract k = it.next();
			
			if(k.getHouse().getAgent().equals(m))
				ret.add(k);
		}
		
		return ret;
	}
	
	/**
	 * Findet einen Mietvertrag mit gegebener ID
	 * @param id Die ID
	 * @return Der Mietvertrag oder null, falls nicht gefunden
	 */
	public TenancyContract getTenancyContractById(int id) {
		Iterator<TenancyContract> it = tenancyContracts.iterator();
		
		while(it.hasNext()) {
			TenancyContract m = it.next();
			
			if(m.getContractid() == id)
				return m;
		}
		
		return null;
	}
	
	/**
	 * Findet alle Mietverträge, die Wohnungen eines gegebenen Verwalters betreffen
	 * @return Set aus Mietverträgen
	 */
	public Set<TenancyContract> getTenancyContractByAgent(Makler m) {
		Set<TenancyContract> ret = new HashSet<TenancyContract>();
		Iterator<TenancyContract> it = tenancyContracts.iterator();
		
		while(it.hasNext()) {
			TenancyContract mv = it.next();
			
			if(mv.getApartment().getAgent().getId() == m.getId())
				ret.add(mv);
		}
		
		return ret;
	}
	
	/**
	 * Findet alle Kaufverträge, die Häuser eines gegebenen Verwalters betreffen
	 * @return Set aus Kaufverträgen
	 */
	public Set<PurchaseContract> getPurchaseContractByAgent(Makler m) {
		Set<PurchaseContract> ret = new HashSet<PurchaseContract>();
		Iterator<PurchaseContract> it =purchaseContracts.iterator();
		
		while(it.hasNext()) {
			PurchaseContract k = it.next();
			
			if(k.getHouse().getAgent().getId() == m.getId())
				ret.add(k);
		}
		
		return ret;
	}
	
	/**
	 * Findet einen Kaufvertrag mit gegebener ID
	 * @param id Die ID
	 * @return Der Kaufvertrag oder null, falls nicht gefunden
	 */
	public PurchaseContract getPurchaseContractById(int id) {
		Iterator<PurchaseContract> it = purchaseContracts.iterator();
		
		while(it.hasNext()) {
			PurchaseContract k = it.next();
			
			if(k.getContractid() == id)
				return k;
		}
		
		return null;
	}
	
	/**
	 * Löscht einen Mietvertrag
	 * @param m Der Mietvertrag
	 */
	public void deleteTenancyContract(TenancyContract m) {
		apartments.remove(m);
	}
	
	/**
	 * Fügt einige Testdaten hinzu
	 */
	public void addTestData() {
		//Hibernate Session erzeugen
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		Makler m = new Makler();
		m.setName("Max Mustermann");
		m.setAddress("Am Informatikum 9");
		m.setLogin("max");
		m.setPassword("max");
		
		//TODO: Dieser Makler wird im Speicher und der DB gehalten
		this.addMakler(m);
		session.save(m);
		session.getTransaction().commit();

		session.beginTransaction();

		Owner p1 = new Owner();
		p1.setAddress("Informatikum");
		p1.setOwnersurname("Mustermann");
		p1.setOwnername("Erika");


		Owner p2 = new Owner();
		p2.setAddress("Reeperbahn 9");
		p2.setOwnersurname("Albers");
		p2.setOwnername("Hans");
		
		session.save(p1);
		session.save(p2);
		
		//TODO: Diese Personen werden im Speicher und der DB gehalten
		this.addOwner(p1);
		this.addOwner(p2);
		session.beginTransaction();

		session.getTransaction().commit();

		session.beginTransaction();

		//Hibernate Session erzeugen
		session.beginTransaction();
		House h = new House();
		h.setEstateaddress("Hamburg, Vogt-Kölln-Straße");
		h.setSquare_area(384);
		h.setFloors(5);
		h.setPrice(10000000);
		h.setGarden(1);
		h.setAgent(m);

		session.save(h);

		//TODO: Dieses Haus wird im Speicher und der DB gehalten
		this.addHouse(h);
		session.getTransaction().commit();

		//Hibernate Session erzeugen
		session = sessionFactory.openSession();
		session.beginTransaction();
		Makler m2 = (Makler)session.get(Makler.class, m.getId());
		Set<Estate> immos = m2.getEstate();
		Iterator<Estate> it = immos.iterator();

		while(it.hasNext()) {
			Estate i = it.next();
			System.out.println("Immo: "+i.getEstateaddress());
		}
		session.close();

		Apartment w = new Apartment();
		w.setEstateaddress("Hamburg");
		w.setRooms(3);
		w.setSquare_area(120);
		w.setFloor(4);
		w.setRent(790);
		w.setKitchen(1);
		w.setBalcony(0);
		w.setAgent(m);
		this.addApartment(w);
		
		w = new Apartment();
		w.setEstateaddress("Berlin");
		w.setSquare_area(120);
		w.setFloor(4);
		w.setRent(790);
		w.setKitchen(1);
		w.setBalcony(1);
		w.setAgent(m);
		this.addApartment(w);

		PurchaseContract kv = new PurchaseContract();
		kv.setHouse(h);
		kv.setOwner(p1);
		kv.setContractid(9234);
		kv.setContractdate("12/5/2016");
		kv.setSettelmentplace("Hamburg");
		kv.setNumberofinstallments(5);
		kv.setInterestrate(4);
		this.addPurchaseContract(kv);

		TenancyContract mv = new TenancyContract();
		mv.setApartment(w);
		mv.setOwner(p2);
		mv.setContractid(23112);
		mv.setContractdate("12/5/2006");
		mv.setSettelmentplace("Berlin");
		mv.setStartDate("20/5/2006");
		mv.setExtracharges(65);
		mv.setDuration(36);
		this.addTenancyContract(mv);
	}
}
