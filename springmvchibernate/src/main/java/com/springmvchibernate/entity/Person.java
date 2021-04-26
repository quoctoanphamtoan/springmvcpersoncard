package com.springmvchibernate.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 

@Entity
@Table(name = "person")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "money")
	private float money;
	

	 @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	 @JoinColumn(name="person_id")
	   private List<CreditCard> creditCards;
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
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public List<CreditCard> getCreditCards() {
		return creditCards;
	}
	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}
	public Person(int id, String firstName, String lastName, float money ) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.money = money; 
	}
	
	public Person(String firstName, String lastName, float money) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.money = money;
	}
	public Person() {
		super(); 
	}
	public void	addTocard(CreditCard card) {
		for(CreditCard card2 : creditCards) {
			if(card2.getId()==card.getId()) {
				
			}
		}
		this.creditCards.add(card);
		
		
	}
	
	
	
}
