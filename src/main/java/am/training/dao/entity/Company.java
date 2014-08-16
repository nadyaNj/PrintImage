package am.training.dao.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Table(name = "company")
public class Company implements Serializable {
	
	@Id
	@Generated(GenerationTime.ALWAYS)
	private Long id;
	
	@Column(nullable = false, length = 50, unique = true)
	private String name;
	
	@JoinColumn(name = "addrId")
	@OneToMany(mappedBy="company", cascade = CascadeType.REFRESH)
	private Address address;

	@JoinColumn(name = "user", referencedColumnName="comp_id")
	@ManyToMany(mappedBy="company", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<User> user;	
	
	public Company() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}


}
