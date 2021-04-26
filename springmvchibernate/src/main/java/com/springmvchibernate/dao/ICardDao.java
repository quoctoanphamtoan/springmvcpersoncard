package com.springmvchibernate.dao;

import com.springmvchibernate.entity.CreditCard;

public interface ICardDao {
	void addCard(int personId,CreditCard card);
	void deleteCard(int id);
	CreditCard getCardById(int id);
	void editCard(CreditCard card);
}
