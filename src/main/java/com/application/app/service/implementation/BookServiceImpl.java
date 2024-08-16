package com.application.app.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.application.app.model.Book;
import com.application.app.repository.BookRepository;
import com.application.app.service.BookService;

@Service
public class BookServiceImpl implements BookService{
    
    @Autowired 
    BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks(){
        return bookRepository.findAll();

    }
    @Override
    public Book getById(Long id){

        return bookRepository.findById(id).orElse(null);
    }
    @Override
    public Book insert(Book book){
        return bookRepository.save(book);
    }
    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

}
