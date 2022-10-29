package Entity;

import java.io.Serializable;


import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="custID",unique=true)
	private int id;
	@Column(name="firstName",nullable=false)
	
	private String firstName;
	@Column(name="lastName",nullable=false)
	private String lastName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	} 
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
