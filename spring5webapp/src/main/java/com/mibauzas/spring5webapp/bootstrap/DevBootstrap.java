package com.mibauzas.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.mibauzas.spring5webapp.model.Author;
import com.mibauzas.spring5webapp.model.Book;
import com.mibauzas.spring5webapp.model.Publisher;
import com.mibauzas.spring5webapp.repositories.AuthorRespository;
import com.mibauzas.spring5webapp.repositories.BookRepository;
import com.mibauzas.spring5webapp.repositories.PublisherRepository;

/*
 * Created by jt on 5/16/17
 * Modified by mbs on 1/21/20.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRespository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRespository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository; 
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
		
	}
	private void initData() {

		//Harper Collins
		Publisher harper = new Publisher("Harper Collins","123, Publication Street, NY");
		
	    //Eric
	    Author eric = new Author("Eric", "Evans");
	    Book  ddd = new Book("Domain Driven Design", "1234", harper);
	    eric.getBooks().add(ddd);
	    ddd.getAuthors().add(eric);
	
	    publisherRepository.save(harper);
	    authorRepository.save(eric);
	    bookRepository.save(ddd);
	
	    //Wrox
	    Publisher wrox = new Publisher("Wrox","456, Release Road, CA");
	    //Rod
	    Author rod = new Author("Rod", "Johnson");
	    Book noEJB = new Book("J2EE Development without EJB", "23444", wrox);
	    rod.getBooks().add(noEJB);
	    
	    publisherRepository.save(wrox);
	    authorRepository.save(rod);
	    bookRepository.save(noEJB);
	
	}
}
