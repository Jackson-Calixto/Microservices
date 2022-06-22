package br.com.calixto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.calixto.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {}
