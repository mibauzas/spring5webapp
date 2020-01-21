package com.mibauzas.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.mibauzas.spring5webapp.model.Author;
import com.mibauzas.spring5webapp.model.Book;
import com.mibauzas.spring5webapp.repositories.AuthorRespository;
import com.mibauzas.spring5webapp.repositories.BookRepository;

/*
 * Created by jt on 5/16/17
 * Modified by mbs on 1/21/20.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRespository authorRepository;
	private BookRepository bookRepository;
	
	public DevBootstrap(AuthorRespository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
		
	}
	private void initData() {

	    //Eric
	    Author eric = new Author("Eric", "Evans");
	    Book  ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
	    eric.getBooks().add(ddd);
	    ddd.getAuthors().add(eric);
	
	    authorRepository.save(eric);
	    bookRepository.save(ddd);
	
	    //Rod
	    Author rod = new Author("Rod", "Johnson");
	    Book noEJB = new Book("J2EE Development without EJB", "23444", "Wrox" );
	    rod.getBooks().add(noEJB);
	    
	    authorRepository.save(rod);
	    bookRepository.save(noEJB);
	
	}
}
