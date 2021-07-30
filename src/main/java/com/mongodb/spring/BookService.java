package com.mongodb.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    //save labour charge log
    public Book saveBook(Book book){
        return repository.save(book);
    }

    public List<Book> getBooks(){
        return repository.findAll();
    }

    public Optional<Book> getBookbyId(int id) {
        boolean exist = repository.existsById(id);
        if(!exist){
            throw new IllegalStateException(
                    "The Book does not exist!"
            );
        }
        return repository.findById(id);
    }

    public String deleteBookById(int id){
        boolean exist = repository.existsById(id);
        if(!exist){
            throw new IllegalStateException(
                    "The Book does not exist!"
            );
        }
        repository.deleteById(id);
        return "Book Deleted Successfully";
    }

    //update petty cash log
    @Transactional
    public Book updateBookById(int id, Book book) {
        Book existingBook = repository.findById(id).get();
        existingBook.setBookName(book.getBookName());
        existingBook.setAuthorName(book.getAuthorName());
        System.out.println("updated successfully!");
        return repository.save(existingBook);


    }


}
