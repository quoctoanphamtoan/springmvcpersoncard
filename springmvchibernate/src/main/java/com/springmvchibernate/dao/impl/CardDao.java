package com.springmvchibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.springmvchibernate.dao.ICardDao;
import com.springmvchibernate.entity.CreditCard;
import com.springmvchibernate.entity.Person;
import com.springmvchibernate.util.hibernateConfig;

public class CardDao implements ICardDao {

	@Override
	public void addCard(int personId, CreditCard card) {
		Transaction transaction = null;
		try (Session session = hibernateConfig.getFactory().openSession()) {
			transaction = session.beginTransaction(); 
			Person person = session.find(Person.class, personId);
			person.addTocard(card);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	@Override
	public void deleteCard(int id) {
		Transaction transaction = null;
		try (Session session = hibernateConfig.getFactory().openSession()) {
			transaction = session.beginTransaction();
			CreditCard card = session.find(CreditCard.class, id);
			session.remove(card); 
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			
		}

	}
	public static void main(String[] args) {
		CreditCard cr =  new CardDao().getCardById(21);
		System.out.println(cr);
	}


	@Override
	public CreditCard getCardById(int id) {
		Transaction transaction = null;
		try (Session session = hibernateConfig.getFactory().openSession()) {
			transaction = session.beginTransaction();
			CreditCard card = session.find(CreditCard.class, id); 
			return card;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			
		}
		return null;
	}


	@Override
	public void editCard(CreditCard card) {
		Transaction transaction = null;
		try (Session session = hibernateConfig.getFactory().openSession()) {
			transaction = session.beginTransaction();
			session.saveOrUpdate(card);
			transaction.commit();
			 
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			
		}
		 
		
	}


}
