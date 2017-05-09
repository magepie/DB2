package de.dis2013.data;

import java.util.Set;

import de.dis2013.util.Helper;

/**
 * Makler-Bean
 */
public class Makler {
	private int id=-1;
	private String name;
	private String address;
	private String login;
	private String password;
	static int currentId = 0;
	private Set<Estate> estate;
	
	public Makler() {
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Estate> getEstate() {
		return estate;
	}

	public void setEstate(Set<Estate> estate) {
		this.estate = estate;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
		result = prime * result + ((getLogin() == null) ? 0 : getLogin().hashCode());
		result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
		
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null || !(obj instanceof Makler))
			return false;
	
		Makler other = (Makler)obj;
	
		if(other.getId() != getId() ||
				!Helper.compareObjects(getName(), other.getName()) ||
				!Helper.compareObjects(getAddress(), other.getAddress()) ||
				!Helper.compareObjects(getLogin(), other.getLogin()) ||
				!Helper.compareObjects(getPassword(), other.getPassword()))
		{
			return false;
		}
		
		return true;
	}
}
