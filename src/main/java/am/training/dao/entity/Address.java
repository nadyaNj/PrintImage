package am.training.dao.entity;

import java.io.Serializable;


import javax.persistence.*;

@Entity
@Table(name="address")
public class Address implements Serializable {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 40)
	private String email;
		
	@Column(nullable = false, unique = true, length = 20)
	private String phone;
		
	@Column(length = 50)
	private String streetAddress;

	@Column(length = 50)
	private String city;
	
	@Column(length = 50)
	private String country;

	public Address() {
		super();		
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}	

}
