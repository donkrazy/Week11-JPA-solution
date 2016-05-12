package com.estsoft.guestbook.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estsoft.guestbook.domain.Guestbook;

@Repository
public class GuestbookRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void save( Guestbook guestbook ) {
		em.persist( guestbook );
	}
	
	public Boolean remove( Guestbook guestbook ) {
		return false;
	}
	
	public List<Guestbook> findAll() {
		TypedQuery<Guestbook> query = 
				em.createQuery( "select gb from Guestbook gb", Guestbook.class );
		List<Guestbook> list = query.getResultList();
		return list;
	}
}
