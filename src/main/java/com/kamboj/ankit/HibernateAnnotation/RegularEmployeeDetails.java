package com.kamboj.ankit.HibernateAnnotation;

import javax.persistence.Column;
//import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@DiscriminatorValue("regularEmployee")
@PrimaryKeyJoinColumn(name = "ID")
public class RegularEmployeeDetails extends EmployeeDetails {

	@Column(name = "salary")
	private float Salary;

	@Column(name = "bonus")
	private float bonus;

	public float getSalary() {
		return Salary;
	}

	public void setSalary(float salary) {
		Salary = salary;
	}

	public float getBonus() {
		return bonus;
	}

	public void setBonus(float bonus) {
		this.bonus = bonus;
	}

}
