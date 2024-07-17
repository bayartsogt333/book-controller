package com.bayraa.book.service;

import com.bayraa.book.model.Book;
import com.bayraa.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepo;

    @Autowired
    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBook(){
        return bookRepo.findAll();
    }

    public Book getBookById(Long id){
        Optional<Book> book = bookRepo.findById(id);
        return book.orElse(null) ;
    }

    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }

    public Book updateBook(Book book, Long id){
        Book existingBook = bookRepo.findById(id).orElseThrow(null);

        existingBook.setName(book.getName());
        existingBook.setPrice(book.getPrice());
        existingBook.setTitle(book.getTitle());

        bookRepo.save(existingBook);
        return existingBook;
    }

    public Book deleteBookById(Long id) {
        Book existingBook = bookRepo.findById(id).orElseThrow(null);
        bookRepo.delete(existingBook);
        return existingBook;
    }

}
