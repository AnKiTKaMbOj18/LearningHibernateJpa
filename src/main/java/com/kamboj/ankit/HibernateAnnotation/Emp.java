package com.kamboj.ankit.HibernateAnnotation;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Emp")
public class Emp {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "empName")
	private String name;

	@Column(name = "empEmail")
	private String email;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "aid")
	private Addr address;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Addr getAddress() {
		return address;
	}

	public void setAddress(Addr address) {
		this.address = address;
	}
}
