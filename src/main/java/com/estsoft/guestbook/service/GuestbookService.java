package com.estsoft.guestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estsoft.guestbook.domain.Guestbook;
import com.estsoft.guestbook.repository.GuestbookRepository;

@Service
public class GuestbookService {
	@Autowired
	GuestbookRepository guestbookRepository;

	public List<Guestbook> getMessageList() {
		System.out.println( guestbookRepository );
		return guestbookRepository.getList();
	}
	
	public boolean deleteMessage( Guestbook guestbook ) {
		return guestbookRepository.delete( guestbook ) == 1;
	}
	
	public Guestbook insertMessage( Guestbook guestbook ) {
		Long no = guestbookRepository.insert( guestbook );
		if( no == 0 ) {
			return null;
		}
		
		Guestbook guestbookVo = guestbookRepository.get( no );
		return guestbookVo;
	}
}
