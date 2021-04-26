package com.springmvchibernate.dao;

import java.util.List;

import com.springmvchibernate.entity.CreditCard;
import com.springmvchibernate.entity.Person;

public interface IPersonDao {
	List<Person> getAllPerson();
	void saveOrUpdate(Person person);
	List<CreditCard> getCardByPersonId(int id);
	void DeletePerson(int id);
	Person getPersonById(int id);
	void EditPerson(Person person);
}
