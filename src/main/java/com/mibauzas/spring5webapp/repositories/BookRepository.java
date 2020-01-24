package com.mibauzas.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mibauzas.spring5webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
