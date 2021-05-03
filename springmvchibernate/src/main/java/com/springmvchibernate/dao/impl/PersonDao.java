package com.springmvchibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.springmvchibernate.dao.IPersonDao;
import com.springmvchibernate.entity.CreditCard;
import com.springmvchibernate.entity.Person;
import com.springmvchibernate.util.hibernateConfig;

public class PersonDao implements IPersonDao {

	@Override
	public List<Person> getAllPerson() {
		Transaction transaction = null;
		List<Person> list = new ArrayList<Person>();
		try (Session session = hibernateConfig.getFactory().openSession()) {
			transaction = session.beginTransaction();
			Query<Person> query = session.createQuery("FROM Person", Person.class);
			list = query.getResultList();
		} catch (Exception e) {
			transaction.rollback();
		}
		return list;
	}

	@Override
	public void saveOrUpdate(Person person) {
		Transaction transaction = null;

		try (Session session = hibernateConfig.getFactory().openSession()) {
			transaction = session.beginTransaction();
			session.saveOrUpdate(person);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

	}

	@Override
	public List<CreditCard> getCardByPersonId(int id) {
		List<CreditCard> list = null;
		Transaction transaction = null;
		try (Session session = hibernateConfig.getFactory().openSession()) {
			transaction = session.beginTransaction();
			Query<CreditCard> query = session.createQuery("From CreditCard Where person_id = " + id + "",
					CreditCard.class);
			list = query.getResultList();
		} catch (Exception e) {
			transaction.rollback();
		}
		return list;
	}

	public static void main(String[] args) {
		new PersonDao().saveOrUpdate(new Person(6, "Tuan", "Tuan", 10000));

	}

	@Override
	public void DeletePerson(int id) {
		Transaction transaction = null;
		try (Session session = hibernateConfig.getFactory().openSession()) {
			transaction = session.beginTransaction();
			Person ps = session.find(Person.class, id);
			session.remove(ps);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}

	}

	@Override
	public Person getPersonById(int id) {

		Transaction transaction =null;
		try (Session session = hibernateConfig.getFactory().openSession()) {
			transaction = session.beginTransaction();
			Person ps = session.find(Person.class, id);
			return ps;
		} catch (Exception e) {
			transaction.rollback();
		}
		return null;
	}

	@Override
	public void EditPerson(Person person) {
		Transaction transaction =null;
		try (Session session = hibernateConfig.getFactory().openSession()) {
			transaction = session.beginTransaction();
			Person ps = session.find(Person.class, person.getId());
			 ps.setLastName(person.getLastName());
			 ps.setFirstName(person.getFirstName());
			 ps.setMoney(person.getMoney());
			 session.saveOrUpdate(ps);
			 transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
		
	}
}
