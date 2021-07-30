package com.mongodb.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book){
        return service.saveBook(book);
    }

    @GetMapping("/findAllBooks")
    public List<Book> showBooks(){
        return service.getBooks();
    }

    @GetMapping("/findBooks/{id}")
    public Optional<Book> getBook(@PathVariable int id){
        return service.getBookbyId(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id){
        return service.deleteBookById(id);
    }

    @PutMapping("/update/{id}")
    public Book updateBook (@PathVariable ("id") int id, @RequestBody final Book book){
        return service.updateBookById(id,book);
    }
}
