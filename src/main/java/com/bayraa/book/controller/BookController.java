package com.bayraa.book.controller;

import com.bayraa.book.model.Book;
import com.bayraa.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getAll")
    public List<Book> getAllBook(){
        return bookService.getAllBook();
    }
    @GetMapping("/getId/{ids}")
    public Book getIdBook(@PathVariable(name = "ids") Long id){
        return bookService.getBookById(id);
    }

    @PostMapping("/post")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        return new ResponseEntity<Book>(bookService.saveBook(book), HttpStatus.OK);
    }

    @PutMapping("/putId/{ids}")
    public ResponseEntity<Book> updateBookById(@RequestBody Book book ,@PathVariable("ids") Long id){
        return new ResponseEntity<Book>(bookService.updateBook(book, id), HttpStatus.OK);
    }

    @DeleteMapping("/deleteId/{ids}")
    public ResponseEntity<String> DeleteBookById(@PathVariable("ids") Long id){
        bookService.deleteBookById(id);
        return new ResponseEntity<String>("Book delete Succesfully", HttpStatus.OK);
    }
}
